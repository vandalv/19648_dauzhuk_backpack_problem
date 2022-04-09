public class Item implements Comparable<Item>{
    private String name;
    private String price;
    private String weight;

    public Item(String name, String price, String weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setAuthor(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }
}
