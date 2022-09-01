import java.util.Arrays;

public class Pen {
    String merk, colourCase, nameSeries, codeSeries, ballPenCharacter, inkColur, mechanisme;
    String[] features;
    double penTipThickness, penDimension, inkCapacity;
    boolean isrefillable, isStylus, isOpen;

    Pen() {

    }

    public Pen(String merk, String colourCase, String nameSeries, String codeSeries, String ballPenCharacter, String inkColur, String mechanisme, String[] features, double penTipThickness, double penDimension, double inkCapacity, boolean isrefillable) {
        this.merk = merk;
        this.colourCase = colourCase;
        this.nameSeries = nameSeries;
        this.codeSeries = codeSeries;
        this.ballPenCharacter = ballPenCharacter;
        this.inkColur = inkColur;
        this.mechanisme = mechanisme;
        this.features = features;
        this.penTipThickness = penTipThickness;
        this.penDimension = penDimension;
        this.inkCapacity = inkCapacity;
        this.isrefillable = isrefillable;
    }

    void openPen() {
        if (!isOpen) {
            this.isOpen = true;
            System.out.println("This Pen Is Opened");
        } else {
            this.isOpen = false;
            System.out.println("This pen is closed");
        }
    }

    void stylusPen() {
        if (isStylus) {
            System.out.println("This Pen have Stylus");
        } else {
            System.out.println("This Pen not have Stylus");
        }
    }

    String writing(double word){
        String result = "";
        inkCapacity = inkCapacity - ((word * penTipThickness) / 100);
        if(inkCapacity <0){
            inkCapacity = 0;
        }
        if (inkCapacity <= 10){
            System.out.println("you need refil this pen\nBecause you Writed " + word + " Word");
        }else{
            System.out.println("your remaining ink is "+ inkCapacity +" ml");
        }
        return result;
    }

    void refillPen(String inkColour) {
        if (this.isrefillable) {
            System.out.println("Your pen is refillable with Colour " + inkColour);
        } else {
            System.out.println("Your pen is not refillable.");
        }
    }

        void getDetail() {
            System.out.println("\nMerk                : "+this.merk);
            System.out.println("Name Series         : "+this.nameSeries);
            System.out.println("Code Series         : "+this.codeSeries);
            System.out.println("Colour Pen          : "+this.colourCase);
            System.out.println("Mechanisme          : "+this.mechanisme);
            System.out.println("ink capacity        : "+this.inkCapacity +"ml");
            System.out.println("ink colour          : "+this.inkColur);
            System.out.println("Pen Tip Thinkness   : "+this.penTipThickness);
            System.out.println("Pen Dimension       : "+this.penDimension);
            System.out.println("Feautes             : ");
            for (String feature : this.features) {
                System.out.println( "-" + feature);
            }
            System.out.println();
        }
    }


