package it.gdorsi.dao;

import java.util.List;

public record Author(String author, List<Book> books) {
}
