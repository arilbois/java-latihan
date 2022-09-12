package Parent;

public class Publisher {
    private String CompanyName, Country;
    private Paper paper;

    public Publisher(String companyName, String country, Paper paper) {
        CompanyName = companyName;
        Country = country;
        this.paper = paper;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    @Override
    public String toString() {
        return "Publisher [CompanyName=" + CompanyName + ", Country=" + Country + ", paper=" + paper + "]";
    }

}
