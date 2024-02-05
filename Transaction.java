import java.util.Date;
import java.util.List;

public class Transaction {
    private List<Producto> purchasedProducts;
    private Date transactionDate;
    // You can add more fields as needed, such as transaction ID, customer details,
    // total amount, etc.

    public Transaction(List<Producto> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
        this.transactionDate = new Date(); // Sets the current date/time as the transaction date
        // Initialize other fields as necessary
    }

    // Getters and setters for each field
    public List<Producto> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<Producto> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Add getters and setters for any additional fields you include

    // Optionally, override the toString() method to print transaction details in a
    // readable format
    @Override
    public String toString() {
        // Implement a string representation of the transaction
        return "Transaction{" +
                "purchasedProducts=" + purchasedProducts +
                ", transactionDate=" + transactionDate +
                '}';
    }
}