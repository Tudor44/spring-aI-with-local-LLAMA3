package it.gdorsi.controller;

import it.gdorsi.dao;import java.util.List;

public record Author(String author, List<dao.Book> books) {
}
