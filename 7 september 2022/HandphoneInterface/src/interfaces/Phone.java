package interfaces;

public interface Phone {
    //constant
    int MaX_VOLUME = 100, MIN_VOLUME = 0;

    //abstract method
    void powerOn();
    void powerOff();
    void volumeUP();
    void volumeDown();
}
