package Childs;

import Parent.Book;
import Publisher;

public class BookProduct extends Book {

    private Author author;

    public BookProduct(String title, String releaseDate, Author author, Publisher publisher, Double price) {
        super(title, releaseDate, author, publisher, price);
    }
    public Author getAuthor(){ return this.author;}
    
}
