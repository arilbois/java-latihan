import Childs.Reviewer;
import Parent.Book;

public class Rating {
    Book book;
    Childs.Reviewer Reviewer;
    double ratingScore;

    public Rating(Book book, Childs.Reviewer reviewer, double ratingScore) {
        this.book = book;
        Reviewer = reviewer;
        this.ratingScore = ratingScore;
    }
}
