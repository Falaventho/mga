public class Temperature {

    private int temp;

    Temperature(int temp) {
        this.temp = temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void alterTemp(int temp) {
        this.temp += temp;
    }

    public int getTemp() {
        return temp;
    }

    public boolean isEthylFreezing() {
        return temp <= -173;
    }

    public boolean isEthylBoiling() {
        return temp >= 172;
    }

    public boolean isOxygenFreezing() {
        return temp <= -362;
    }

    public boolean isOxygenBoiling() {
        return temp >= -306;
    }

    public boolean isWaterFreezing() {
        return temp <= 32;
    }

    public boolean isWaterBoiling() {
        return temp >= 212;
    }

}
