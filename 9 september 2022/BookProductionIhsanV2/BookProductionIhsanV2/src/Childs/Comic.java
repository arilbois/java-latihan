package Childs;
import Parents.Book;
import Parents.Publisher;

public class Comic extends Book{
    private  Boolean isVolumeSeries;

    public Comic(){
        super();
    }
    public Comic(String title, String releaseDate, Mangaka mangaka, Publisher publisher, Boolean isVolumeSeries){
        super(title,releaseDate,mangaka,publisher);
        this.isVolumeSeries = isVolumeSeries;
    }

    public Boolean isVolumeSeries() {
        return isVolumeSeries;
    }

    public void setVolumeSeries(Boolean volumeSeries) {
        isVolumeSeries = volumeSeries;
    }

    public String toString(){
        return  super.toString()+
                "\nvolume series : "+isVolumeSeries;
    }
}
