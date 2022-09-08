import interfaces.Phone;
public class PhoneUser {
    private Phone phone;

    public PhoneUser(Phone phone) {
        this.phone = phone;
    }

    public void turnOnThePhone(){
        this.phone.powerOn();
    }

    public void turnOffThePhone(){
        this.phone.powerOff();
    }

    public void makePhoneLouder(){
        this.phone.volumeUP();
    }

    public void makePhoneSilent(){
        this.phone.volumeDown();
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
