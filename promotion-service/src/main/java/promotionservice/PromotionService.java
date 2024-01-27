package promotionservice;

import java.util.ArrayList;
import java.util.List;

public class PromotionService {

    public List<UserMessage> applyPromotionTo(Item item) {
        List<UserMessage> result = new ArrayList<>();
        result.add(new UserMessage("Total before promotion: " +
                item.calculatePriceAfterPromotion()));

        item.setPrice(item.getPrice() - standardDiscount());
        if (item.getPrice() > 122) {
            item.setTax(item.getTax() / 2);
        }

        persist(item);

        UserMessage totalAfterPromotionMessage = new UserMessage("Total after promotion: "
                + item.calculatePriceAfterPromotion());
        result.add(totalAfterPromotionMessage);
        return result;
    }

    // This method can't be moved to another class, used by other code in this class.
    private int standardDiscount() {
        return 2;
    }

    private void persist(Item item) {
        // Item is persisted to storage.
    }

    // ... There is more code in this class.

}

