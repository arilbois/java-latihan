import java.util.List;
import java.util.Map;

import Childs.*;
import Parent.*;
import Repositories.*;
import Data.*;

public class MainApp {

    public static void main(String[] args) {
        Map<String, Object> allData = BookRepositori.getAllBookAndRating();

        List<RatingBook> listRatingBook = (List<RatingBook>) allData.get("listRatingBook");
        List<Book> listRBook = (List<Book>) allData.get("listBook");
        List<Publisher> listPublisher = (List<Publisher>) allData.get("listPublisher");
        List<Comic> listComic = (List<Comic>) allData.get("listComic");

        // DataBooks.getAllMangaka(listRBook);
        DataBooks.bookLowPrice(listRBook);
        DataBooks.bookHighPrice(listRBook);
        DataBooks.getMangakaGenderMale(listRBook);
        DataBooks.getAllAuthor(listRBook);
        DataBooks.getAuthorFemale(listRBook);
        DataBooks.getAuthorAgeUnder25(listRBook);
        DataBooks.getAuthorFromIndonesia(listRBook);
        DataBooks.expensivePaperPrice(listPublisher);
        DataBooks.cheapPaperPrice(listPublisher);
        DataBooks.getMangakaRatingBest(listRBook);
        DataBooks.getComicWithSeries(listRBook);
        DataBooks.expensiveComicPrice(listRBook);
        DataBooks.getPublisherJapan(listRBook);
    }

}