package phone;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    public String ring() {
        return "Iphone device is ringing.";
    }
    public String unlock() {
        return "Iphone device is unlocked.";
    }
    public void displayInfo() {
        System.out.println("Iphone Device Details:");
        System.out.println("Version Number: " + getVersionNumber());
        System.out.println("Battery Percentage: " + getBatteryPercentage() + "%");
        System.out.println("Carrier: " + getCarrier());
        System.out.println("Ring Tone: " + getRingTone());
    }
}