public class MainAPP {
    public static void main(String[] args) {
        String[] featfuresPen1 = {"futuristic Stylus Embedded Design","Satin finish body"};
        String[] featfuresPen2 = {"ultra ligth alumunium body","textured body at grip","stylish matt finish"};
        String[] featfuresPen3 = {"Brusesh finish body","texture grip","designer clip"};


        System.out.println("\nPen 1");
        Pen pen1 = new Pen();
        pen1.merk = "Hauser";
        pen1.colourCase = "Silver";
        pen1.nameSeries = "Stylus";
        pen1.codeSeries = "H2005 Series";
        pen1.ballPenCharacter = "Ball Pen";
        pen1.mechanisme = "twist Mechanism";
        pen1.inkColur = "Black";
        pen1.penTipThickness = 1;
        pen1.inkCapacity = 80;
        pen1.penDimension = 2;
        pen1.isrefillable = true;
        pen1.isStylus = true;
        pen1.features = featfuresPen1;
        pen1.getDetail();
        pen1.openPen();
        pen1.writing(10080);
        pen1.stylusPen();
        pen1.refillPen("Black");

        System.out.println("\nPen 2");
        Pen pen2 = new Pen();
        pen2.merk = "Hauser";
        pen2.colourCase = "Peach";
        pen2.nameSeries = "Celbrity";
        pen2.codeSeries = "H66077 Series";
        pen2.ballPenCharacter = "Retractable Ball Pen";
        pen2.mechanisme = "twist Mechanism";
        pen2.inkColur = "Black";
        pen2.penTipThickness = 0.7;
        pen2.inkCapacity = 90;
        pen2.penDimension = 4;
        pen2.isOpen = false;
        pen2.isrefillable = true;
        pen2.isStylus = false;
        pen2.features = featfuresPen2;
        pen2.getDetail();
        pen2.openPen();
        pen2.writing(20000);
        pen2.stylusPen();
        pen2.refillPen("Blue");

        System.out.println("\nPen 3");
        Pen pen3 = new Pen();
        pen3.merk = "Hauser";
        pen3.colourCase = "Grey";
        pen3.nameSeries = "Bryssels";
        pen3.codeSeries = "H6010 Series";
        pen3.ballPenCharacter = "Retractable Ball Pen";
        pen3.inkColur = "Black";
        pen3.mechanisme = "twist Mechanism";
        pen3.penTipThickness = 0.7;
        pen3.inkCapacity = 80;
        pen3.penDimension = 4;
        pen3.isOpen = true;
        pen3.isrefillable = true;
        pen3.isStylus = false;
        pen3.features = featfuresPen3;
        pen3.getDetail();
        pen3.openPen();
        pen3.writing(3000);
        pen3.stylusPen();
        pen3.refillPen("Black");
    }
}
