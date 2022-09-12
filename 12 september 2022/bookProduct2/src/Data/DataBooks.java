package Data;

import java.util.*;
import Parent.*;
import Repositories.*;
import Childs.*;

public class DataBooks extends BookRepositori {

  public static void getAllMangaka(List<Book> listBook) {
    System.out.println("All Mangaka : \n");
    for (Book book : listBook) {
      if (book.getAuthor() instanceof Mangaka) {
        System.out.println(book.getAuthor());
      }
    }
  }

  public static double getBookLowPrice(List<Book> listBook) {
    Double lowPrice = 0.0;
    for (Book book : listBook) {
      if (lowPrice == 0.0) {
        lowPrice = book.getPrice();
      } else {
        if (book.getPrice() < lowPrice) {
          lowPrice = book.getPrice();
        }
      }
    }
    return (lowPrice);
  }

  public static void bookLowPrice(List<Book> listBooks) {
    System.out.println("Harga buku Paling Murah : \n");
    for (Book book : listBooks) {
      if (book.getPrice() == getBookLowPrice(listBooks)) {
        System.out.println(book);
      }
    }
  }

  public static double getBookHighPrice(List<Book> listBook) {
    Double highPrice = 0.0;
    for (Book book : listBook) {
      if (highPrice == 0.0) {
        highPrice = book.getPrice();
      } else {
        if (book.getPrice() > highPrice) {
          highPrice = book.getPrice();
        }
      }
    }
    return (highPrice);
  }

  public static void getMangakaGenderMale(List<Book> listBook) {
    System.out.println("Manggaka With gender Male : \n");
    for (Book book : listBook) {
      if (book.getAuthor() instanceof Mangaka) {
        if (book.getAuthor().getGender().equalsIgnoreCase("Male")
            || book.getAuthor().getGender().equalsIgnoreCase("Laki-laki")) {
          System.out.println(book.getAuthor());
        }
      }
    }
  }

  public static void bookHighPrice(List<Book> listBooks) {
    System.out.println("Harga buku Paling Mahal : \n");
    for (Book book : listBooks) {
      if (book.getPrice() == getBookHighPrice(listBooks)) {
        System.out.println(book);
      }
    }
  }

  public static void getAllAuthor(List<Book> listBook) {
    System.out.println("All Author : \n");
    for (Book book : listBook) {
      System.out.println(book.getAuthor());
    }
  }

  public static void getAuthorFemale(List<Book> listBook) {
    System.out.println("All Author Female : \n");
    for (Book book : listBook) {
      if (book.getAuthor().getGender().equalsIgnoreCase("Female")
          || book.getAuthor().getGender().equalsIgnoreCase("Perempuan")) {
        System.out.println(book.getAuthor());
      }
    }
  }

  public static void getAuthorAgeUnder25(List<Book> listBook) {
    System.out.println("All Author Under 25 Years old : \n");
    int maximalAge = 25;
    for (Book book : listBook) {
      if (book.getAuthor().getAge() < maximalAge) {
        System.out.println(book.getAuthor());
      }
    }
  }

  public static void getAuthorFromIndonesia(List<Book> listBook) {
    System.out.println("All Author From Indonesia : \n");
    for (Book book : listBook) {
      if (book.getAuthor().getCountry().equalsIgnoreCase("indonesia")) {
        System.out.println(book.getAuthor());
      }
    }
  }

  public static double getExpensivePaperPrice(List<Publisher> listPublisher) {
    List<Double> pricePaper = new ArrayList<Double>();
    for (Publisher publisher : listPublisher) {
      pricePaper.add(publisher.getPaper().getPaperPrice());
    }
    return Collections.max(pricePaper);
  }

  public static void expensivePaperPrice(List<Publisher> listPublisher) {
    System.out.println("Harga Kertas Paling Mahal : \n");
    for (Publisher publisher : listPublisher) {
      if (publisher.getPaper().getPaperPrice() == getExpensivePaperPrice(listPublisher)) {
        System.out.println(publisher);
      }
    }
  }

  public static double getCheapPaperPrice(List<Publisher> listPublisher) {
    List<Double> pricePaper = new ArrayList<Double>();
    for (Publisher publisher : listPublisher) {
      pricePaper.add(publisher.getPaper().getPaperPrice());
    }
    return Collections.min(pricePaper);
  }

  public static void cheapPaperPrice(List<Publisher> listPublisher) {
    System.out.println("Harga Kertas Paling Murah : \n");
    for (Publisher publisher : listPublisher) {
      if (publisher.getPaper().getPaperPrice() == getCheapPaperPrice(listPublisher)) {
        System.out.println(publisher);
      }
    }
  }

  public static void getMangakaRatingBest(List<Book> listBooks) {
    System.out.println("Mangaka With Rating Best Seller : \n");
    for (Book book : listBooks) {
      if (book instanceof Comic) {
        if (book.getAuthor() instanceof Mangaka
            && (((Mangaka) book.getAuthor()).getRating().equalsIgnoreCase("best seller"))) {
          System.out.println(book);
        }
      }
    }
  }

  public static void getComicWithSeries(List<Book> listBook) {
    System.out.println("Comic With Series : \n");
    for (Book book : listBook) {
      if (book instanceof Comic) {
        if (((Comic) book).getVolumeSeries()) {
          System.out.println(book);
        }
      }
    }
  }

  public static double getExpensiveComicPrice(List<Book> listBook) {
    List<Double> priceComic = new ArrayList<Double>();
    for (Book book : listBook) {
      if (book instanceof Comic) {
        priceComic.add(book.getPrice());
      }
    }
    return Collections.max(priceComic);
  }

  public static void expensiveComicPrice(List<Book> listBook) {
    System.out.println("Harga Kertas Paling Murah : \n");
    for (Book book : listBook) {
      if (book instanceof Comic) {
        if (((Comic) book).getPrice() == getExpensiveComicPrice(listBook)) {
          System.out.println(book);
        }
      }
    }
  }

  public static void getPublisherJapan(List<Book> listBook) {
    System.out.println("Publisher Japan : \n");
    for (Book book : listBook) {
      if (book.getPublisher().getCountry().equalsIgnoreCase("Japan")
          || book.getPublisher().getCountry().equalsIgnoreCase("Jepang")) {
        System.out.println(book.getPublisher());
      }
    }
  }

  public static void getBookGenreFantasy(List<Book> listBook) {
    System.out.println("Book Genre Fantasy : \n");
    for (Book book : listBook) {
      if (book.getAuthor().getGenre().equalsIgnoreCase("Fantasy")) {
        System.out.println(book);
      }
    }
  }

  public static void getAllPaper(List<Paper> listPaper) {
    for (Paper data : listPaper) {
      System.out.println(data);
    }
  }

  public static void getAllReviewer(List<RatingBook> listRatingBook) {
    System.out.println("All Reviewer : \n");
    for (RatingBook ratingBook : listRatingBook) {
      System.out.println(ratingBook.getReviewer() + "\n");
    }
  }

  public static void getVerifiedReviewer(List<RatingBook> listRatingBook) {
    System.out.println("All Reviewer Verifed : \n");
    for (RatingBook ratingBook : listRatingBook) {
      if (ratingBook.getReviewer().getVerified()) {
        System.out.println(ratingBook.getReviewer() + "\n");
      }
    }
  }

  public static double getLowRatingScore(List<RatingBook> listRatingBook) {
    List<Double> lowRatinglist = new ArrayList<Double>();
    for (RatingBook ratingBook : listRatingBook) {
      lowRatinglist.add(ratingBook.getRatingScore());
    }
    return Collections.min(lowRatinglist);
  }

  public static void lowRatingScore(List<RatingBook> listRatingBook) {
    System.out.println("Low Rating Books : \n");
    for (RatingBook ratingBook : listRatingBook) {
      if (ratingBook.getRatingScore() == getLowRatingScore(listRatingBook)) {
        System.out.println(ratingBook + "\n");
      }
    }
  }

  public static double getAverageRatingScore(List<RatingBook> listRatingBook) {
    List<Double> averageRatinglist = new ArrayList<Double>();
    List<Double> ratings = new ArrayList<Double>();
    for (RatingBook rating : listRatingBook) {
      ratings.add(rating.getRatingScore());
    }
    double average = ratings.stream().mapToDouble(val -> val).average().orElse(0.0);
    return average;
  }

  public static void averageRatingScore(List<RatingBook> listRatingBook) {
    System.out.println("Average Rating Books : \n");
    for (RatingBook ratingBook : listRatingBook) {
      if (ratingBook.getRatingScore() > getAverageRatingScore(listRatingBook)) {
        System.out.println(ratingBook + "\n");
      }
    }
  }

  public static double getHighRatingScore(List<RatingBook> listRatingBook) {
    List<Double> highRatinglist = new ArrayList<Double>();
    for (RatingBook ratingBook : listRatingBook) {
      if (ratingBook.getBook() instanceof Comic) {
        highRatinglist.add(ratingBook.getRatingScore());
      }
    }
    return Collections.max(highRatinglist);
  }

  public static void highRatingScore(List<RatingBook> listRatingBook) {
    System.out.println("High Rating Comic : \n");
    for (RatingBook ratingBook : listRatingBook) {
      if (ratingBook.getRatingScore() == getHighRatingScore(listRatingBook)) {
        System.out.println(ratingBook + "\n");
      }
    }
  }
}