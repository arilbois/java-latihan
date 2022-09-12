package Parents;

public class Paper {
    private String qualityPaper;
    private Double paperPrice;

    public Paper(){
        super();
    }
    public Paper(String qualityPaper, Double paperPrice){
        super();
        this.paperPrice = paperPrice;
        this.qualityPaper = qualityPaper;
    }

    public double getPaperPrice() {
        return paperPrice;
    }

    public void setPaperPrice(double paperPrice) {
        this.paperPrice = paperPrice;
    }

    public String getQualityPaper() {
        return qualityPaper;
    }

    public void setQualityPaper(String qualityPaper) {
        this.qualityPaper = qualityPaper;
    }

    public String toString(){
        return  "==============================="+
                "\nquality paper : "+qualityPaper+
                "\nprice         : "+paperPrice;
    }
}
