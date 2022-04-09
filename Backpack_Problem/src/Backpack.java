import java.util.ArrayList;
import java.util.List;

public class Backpack implements Comparable<Backpack>{
    private int overallPrice = 0;
    private int weightCapacity;
    public List<Item> items = new ArrayList<>();

    public Backpack(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public int getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(int overallPrice) {
        this.overallPrice = overallPrice;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getOverallPrice());
    }

    @Override
    public int compareTo(Backpack o) {
        int compareCost = ((Backpack)o).getOverallPrice();
        //  For Ascending order
        return this.overallPrice - compareCost;
    }

}
