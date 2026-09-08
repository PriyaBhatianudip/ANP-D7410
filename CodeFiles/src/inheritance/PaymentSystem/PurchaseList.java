package CodeFiles.src.inheritance.PaymentSystem;

public class PurchaseList
{
//     "Product_ID", "Product_Name","Category", "Sales_Price","Total_Amount"
    private String prouductId;
    private String productName;
    private String category;
    private double salesPrice;
    private int quantity;
    private double total;


    public String getProuductId() {
        return prouductId;
    }

    public void setProuductId(String prouductId) {
        this.prouductId = prouductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
