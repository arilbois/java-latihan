package parent;

import childs.Author;
import childs.Publisher;

public class BookProduct {
    String bookCode, title;
    double price;
    Person person;
    Publisher publisher;


    public String getBookCode() {
        return bookCode;
    }


    public BookProduct(String bookCode, String title, double price, Person person, Publisher publisher) {
        this.bookCode = bookCode;
        this.title = title;
        this.price = price;
        this.person = person;
        this.publisher = publisher;
    }

    public void calculatePrice(double productionCost, String rating) {
        bookCode = bookCode.replaceAll("[0-9]", "");
        double bookPrice;
        if (bookCode.equalsIgnoreCase("NVL")) {
            if (rating.equalsIgnoreCase("New Commer")) {
                bookPrice = productionCost * 1.25;
            } else if (rating.equalsIgnoreCase("Good")) {
                bookPrice = productionCost * 1.35;
            } else {
                bookPrice = productionCost * 1.5;
            }
        } else if (bookCode.equalsIgnoreCase("CMK")) {
            if (rating.equalsIgnoreCase("New Commer")) {
                bookPrice = productionCost * 1.35;
            } else {
                bookPrice = productionCost * 1.25;
            }
        }else {
            bookPrice = productionCost * 1.2;

        }
        System.out.println(bookCode);
        System.out.println(bookPrice);


    }

}

