package promotionservice;

import java.util.ArrayList;
import java.util.List;

public class PromotionService {

    public List<UserMessage> applyPromotionTo(Item item) {
        List<UserMessage> result = new ArrayList<>();
        result.add(new UserMessage("Total before promotion: " +
                item.calculatePriceWithTax()));

        Item itemWithDiscounts = item.applyPriceAndTaxDiscounts();

        persist(itemWithDiscounts);

        UserMessage totalAfterPromotionMessage = new UserMessage("Total after promotion: "
                + itemWithDiscounts.calculatePriceWithTax());
        result.add(totalAfterPromotionMessage);
        return result;
    }

    private void persist(Item item) {
        // Item is persisted to storage.
    }

    // ... There is more code in this class.

}

