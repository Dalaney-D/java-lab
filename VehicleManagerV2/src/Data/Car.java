package Data;

/**
 *
 * @author duyng
 */
public class Car extends Vehicle{
    protected String type;
    protected int yom;

    public Car() {
    }

    public Car(String type, int yom) {
        this.type = type;
        this.yom = yom;
    }

    public Car(String id, String name, String color, int price, String brand, String type, int yom) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yom = yom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYom() {
        return yom;
    }

    public void setYom(int yom) {
        this.yom = yom;
    }

    @Override
    public void showProfile() {
        System.out.printf("|%-10s|%6s|%10s|%7s|%10s|%10s|%6s|%6d|\n",
                                        "CAR", id, name, color, price + "$", brand, type, yom);
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
