package Data;

/**
 *
 * @author duyng
 */
public class Motorbike extends Vehicle{
    protected int speed;
    protected String license;

    public Motorbike() {
    }

    public Motorbike(String id, String name, String color, int price, String brand, int speed, String license) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
    
    @Override
    public void showProfile() {
        System.out.printf("|%-10s|%6s|%10s|%7s|%10s|%10s|%6d|%6s|\n", 
                                       "CAR", id, name, color, price + "$", brand, speed, license);
    }
    
    public void makeSound() {
        System.out.println("Tin tin tin");
    }
    
    @Override
    public int compareTo(Vehicle o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
            
    @Override
    public int compare(Vehicle a, Vehicle b) {
        return b.getPrice() - a.getPrice();
    } 
}
