package promotionservice;

import java.util.ArrayList;
import java.util.List;

public class PromotionService {

    public List<UserMessage> applyPromotionTo(Item item) {
        List<UserMessage> result = new ArrayList<>();
        result.add(new UserMessage("Total before promotion: " +
                item.calculatePriceAfterPromotion()));

        item.setPrice(item.priceWithStandardDiscount());
        if (item.isPromotional()) {
            item.setTax(item.getTax() / 2);
        }

        persist(item);

        UserMessage totalAfterPromotionMessage = new UserMessage("Total after promotion: "
                + item.calculatePriceAfterPromotion());
        result.add(totalAfterPromotionMessage);
        return result;
    }

    private void persist(Item item) {
        // Item is persisted to storage.
    }

    // ... There is more code in this class.

}

