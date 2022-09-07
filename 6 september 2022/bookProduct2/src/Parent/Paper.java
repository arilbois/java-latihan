package Parent;

public class Paper {
    private String qualityName;
    private Double paperPrice;

    public Paper(String qualityName, double paperPrice) {
        this.qualityName = qualityName;
        this.paperPrice = paperPrice;
    }

    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }

    public Double getPaperPrice() {
        return paperPrice;
    }

    public void setPaperPrice(Double paperPrice) {
        this.paperPrice = paperPrice;
    }
}
