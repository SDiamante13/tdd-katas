package cd.warehouse;

public class InsufficientStockException  extends RuntimeException {

    public InsufficientStockException() {
        super("This CD has insufficient stock to process this order.");
    }
}
