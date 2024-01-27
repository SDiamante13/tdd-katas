package promotionservice;

import java.util.ArrayList;
import java.util.List;

public class PromotionService {

    public List<UserMessage> applyPromotionTo(Item item) {
        List<UserMessage> result = new ArrayList<>();
        result.add(new UserMessage("Total before promotion: " +
                calculatePriceAfterPromotion(item)));

        item.price -= standardDiscount();
        if (item.price > 122) {
            item.tax /= 2;
        }

        persist(item);

        UserMessage totalAfterPromotionMessage = new UserMessage("Total after promotion: "
                + calculatePriceAfterPromotion(item));
        result.add(totalAfterPromotionMessage);
        return result;
    }

    private double calculatePriceAfterPromotion(Item item) {
        return item.price + item.price * item.tax;
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

