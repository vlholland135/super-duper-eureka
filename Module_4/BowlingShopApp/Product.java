public class Product {
    private String code = "";
    private String description = "";
    private double price = 0;

    public Product() {}

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product code: ").append(code).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append(String.format("Price: $%,6.2f", price));
        return sb.toString();
    }
}
