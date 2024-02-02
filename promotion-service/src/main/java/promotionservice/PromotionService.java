package promotionservice;

import java.util.ArrayList;
import java.util.List;

public class PromotionService {

    public List<UserMessage> applyPromotionTo(Item item) {
        List<UserMessage> result = new ArrayList<>();
        result.add(new UserMessage("Total before promotion: " + (item.getPrice() + item.getPrice() * item.getTax())));

        item.setPrice(item.getPrice() - standardDiscount());
        if (item.getPrice() > 122) {
            item.setTax(item.getTax() / 2);
        }

        persist(item);

        result.add(new UserMessage("Total after promotion: " + (item.getPrice() + item.getPrice() * item.getTax())));
        return result;
    }

    private int standardDiscount() {
        return 2;
    }

    private void persist(Item item) {
        // Item is persisted to storage.
    }
}

