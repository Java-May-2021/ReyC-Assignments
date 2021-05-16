package phone;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    public String ring() {
        return "Galaxy device is ringing.";
    }
    public String unlock() {
        return "Galaxy device is unlocked.";
    }
    public void displayInfo() {
        System.out.println("Galaxy Device Details:");
        System.out.println("Version Number: " + getVersionNumber());
        System.out.println("Battery Percentage: " + getBatteryPercentage() + "%");
        System.out.println("Carrier: " + getCarrier());
        System.out.println("Ring Tone: " + getRingTone());
    }
}