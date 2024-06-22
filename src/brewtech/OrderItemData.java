package brewtech;
import java.util.List;

public class OrderItemData {
    private String ItemName;
    private String Size;
    private List<String> addons;
    private double totalPrice;

    public OrderItemData(String ItemName, String Size, List<String> addons, double totalPrice) {
        this.ItemName = ItemName;
        this.Size = Size;
        this.addons = addons;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getSize() {
        return Size;
    }

    public void setDrinkSize(String drinkSize) {
        this.Size = drinkSize;
    }

    public List<String> getAddons() {
        return addons;
    }

    public void setAddons(List<String> addons) {
        this.addons = addons;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Method to calculate total price of all customized drinks added
    public static double calculateTotalPrice(List<OrderItemData> orderItems) {
        double total = 0;
        for (OrderItemData item : orderItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // Override toString() to provide a meaningful string representation of the object
    @Override
    public String toString() {
        return  "Drink: " + ItemName +
                "\nSize:" + Size +
                "\nAdd-ons: " + addons +
                "\nPrice: " + totalPrice;
    }
}

