package Parent;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Paper {
    private String qualityName;
    private Double paperPrice;

    public Paper(String qualityName, Double paperPrice) {
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

    @Override
    public String toString() {
        return "quality Name         : " + getQualityName() +
                "\nPaper Price          : " + indonesiaCurrency() + "\n";
    }

    public String indonesiaCurrency() {
        DecimalFormat indonesiaCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        indonesiaCurrency.setDecimalFormatSymbols(formatRp);
        return indonesiaCurrency.format(paperPrice);
    }

}
