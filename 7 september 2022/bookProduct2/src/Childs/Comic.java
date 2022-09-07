package Childs;

import Parent.Book;
import Parent.Publisher;

public class Comic extends Book{
    private Boolean isVolumeSeries;

    public Comic() {
    }

    public Comic(String title, String releaseDate, Mangaka mangaka, Publisher publisher, Boolean isVolumeSeries) {
        super(title, releaseDate, mangaka, publisher);
        this.isVolumeSeries = isVolumeSeries;
    }

    public Boolean getVolumeSeries() {
        return isVolumeSeries;
    }

    public void setVolumeSeries(Boolean volumeSeries) {
        this.isVolumeSeries = volumeSeries;
    }

    @Override
    public String toString() {
        return super.toString() +
        "Volume Series                : " + getVolumeSeries();
    }
}
