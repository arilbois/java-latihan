package Parents;


public class Publisher {
    private String companyName;
    private String country;
    private Paper paper;

    public Publisher(){
        super();
    }

    public  Publisher(String companyName, String country, Paper paper){
        super();
        this.companyName = companyName;
        this.country = country;
        this.paper = paper;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }
    public Paper getPaper() {
        return paper;
    }
    public void setPaper(Paper paper) {
        this.paper = paper;
    }


    public String toString(){
        return  "==============================="+
                "\ncompany      : "+companyName+
                "\ncountry      : "+country+
                paper.toString();
    }

}
