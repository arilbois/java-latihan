import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
        List<Paper> listPaper = (List<Paper>) allData.get("listPaper");
        char repeat;
        do {
            int choise = inputTypeNumberLimit(TEMPLATECHOICEDATA, 1, 21);

            switch (choise) {
                case 1:
                    DataBooks.bookLowPrice(listRBook);
                    break;
                case 2:
                    DataBooks.bookHighPrice(listRBook);
                    break;
                case 3:
                    DataBooks.getAllMangaka(listRBook);
                    break;
                case 4:
                    DataBooks.getMangakaGenderMale(listRBook);
                    break;
                case 5:
                    DataBooks.getAllAuthor(listRBook);
                    break;
                case 6:
                    DataBooks.getAuthorFemale(listRBook);
                    break;
                case 7:
                    DataBooks.getAuthorAgeUnder25(listRBook);
                    break;
                case 8:
                    DataBooks.getAuthorFromIndonesia(listRBook);
                    break;
                case 9:
                    DataBooks.expensivePaperPrice(listPublisher);
                    break;
                case 10:
                    DataBooks.cheapPaperPrice(listPublisher);
                    break;
                case 11:
                    DataBooks.getMangakaRatingBest(listRBook);
                    break;
                case 12:
                    DataBooks.getComicWithSeries(listRBook);
                    break;
                case 13:
                    DataBooks.expensiveComicPrice(listRBook);
                    break;
                case 14:
                    DataBooks.getPublisherJapan(listRBook);
                    break;
                case 15:
                    DataBooks.getBookGenreFantasy(listRBook);
                    break;
                case 16:
                    DataBooks.getAllPaper(listPaper);
                    break;
                case 17:
                    DataBooks.getAllReviewer(listRatingBook);
                    break;
                case 18:
                    DataBooks.getVerifiedReviewer(listRatingBook);
                    break;
                case 19:
                    DataBooks.lowRatingScore(listRatingBook);
                    break;
                case 20:
                    DataBooks.averageRatingScore(listRatingBook);
                    break;
                case 21:
                    DataBooks.highRatingScore(listRatingBook);
                    break;
            }
            System.out.println("Type YES to continue");
        } while (INPUT.next().equalsIgnoreCase("YES"));
        INPUT.close();
    }

    public static final Scanner INPUT = new Scanner(System.in);

    public static final String TEMPLATECHOICEDATA = "List Book: " + "\n" +
            "1. Menampilkan data book yang memiliki price paling Murah" + "\n" +
            "2. Menampilkan data book yang memiliki price paling Mahal." + "\n" +
            "3. Menampilkan Data semua Mangaka." + "\n" +
            "4. Menampilkan Data semua Mangaka yang berjenis kelamin Laki-Laki atau Male." + "\n" +
            "5. Menampilkan Data semua Author." + "\n" +
            "6. Menampilkan Data semua Author yang berjenis kelamin Perempuan atau Female." + "\n" +
            "7. Menampilkan author yang umur nya dibawah 25 tahun." + "\n" +
            "8. Menampilkan author yang berasal dari Indonesia." + "\n" +
            "9. Menampilkan Publisher dengan paper price paling Mahal." + "\n" +
            "10. Menampilkan Publisher dengan paper price paling Murah." + "\n" +
            "11. Menampilkan Comic dengan Rating mangaka Best Seller." + "\n" +
            "12. Menampilkan Comic Volume Series." + "\n" +
            "13. Menampilkan data Comic yang memiliki price paling Mahal." + "\n" +
            "14. Menampilkan Book yang publishernya berasal dari Jepang." + "\n" +
            "15. Menampilkan Book yang genre nya Fantasy." + "\n" +
            "16. Menampilkan data semua Jenis Paper." + "\n" +
            "List Rating Book:" + "\n" +
            "17. Menampilkan data semua Reviewer" + "\n" +
            "18. Menampilkan data Reviewer yang verified" + "\n" +
            "19. Menampilkan book dengan rating score paling kecil." + "\n" +
            "20. Menampilkan book dengan rating score diatas rata-rata." + "\n" +
            "21. Menampilkan comic dengan rating score paling besar." + "\n" +
            "Masuka Pilihan Anda : (1-21)" + "\n", REGEX = "[0-9]+";

}