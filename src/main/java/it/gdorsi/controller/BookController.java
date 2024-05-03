package dev.danvega.output;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final ChatClient chatClient;

    public BookController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/search-by-author")
    public Author getBooksByAuthor(@RequestParam(value = "author", defaultValue = "Ken Kousen") String author) {
        String promptMessage = """
                Generate a list of books written by the author {author}.
                If the author is not recognized , don't invent it but write null inside author field.
                Each book is constituted by a book's array , each with a title and a year as values to contain.
                If you aren't positive that a book belongs to this author please don't include it.
                {format}
                """;

        var outputParser = new BeanOutputParser<>(Author.class);
        String format = outputParser.getFormat();
        System.out.println("format = " + format);

        PromptTemplate promptTemplate = new PromptTemplate(promptMessage, Map.of("author",author,"format", format));
        Prompt prompt = promptTemplate.create();
        Generation generation = chatClient.call(prompt).getResult();
        return outputParser.parse(generation.getOutput().getContent());
    }
}
