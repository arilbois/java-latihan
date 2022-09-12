package Parent;

import Childs.Reviewer;

public class RatingBook {
    private Book book;
    private Reviewer reviewer;
    private Double ratingScore;

    public RatingBook() {
    }

    public RatingBook(Book book, Reviewer reviewer, Double ratingScore) {
        this.book = book;
        this.reviewer = reviewer;
        this.ratingScore = ratingScore;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Double getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Double ratingScore) {
        this.ratingScore = ratingScore;
    }

    @Override
    public String toString() {
        return book.toString() + reviewer.toString() +
                "\nRating Score          : " + getRatingScore();
    }
}
