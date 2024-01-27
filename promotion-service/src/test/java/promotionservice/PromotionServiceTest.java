package promotionservice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PromotionServiceTest {

    private final PromotionService promotionService = new PromotionService();

    @Test
    void bookPromotion() {
        List<UserMessage> messages = promotionService.applyPromotionTo(
                new Item(
                        "Functional programming with C++",
                        10,
                        0.2
                )
        );

        assertThat(messages).containsExactly(
                new UserMessage("Total before promotion: 12.0"),
                new UserMessage("Total after promotion: 9.6")
        );
    }

    @Test
    void expensiveBookPromotion() {
        List<UserMessage> messages = promotionService.applyPromotionTo(
                new Item(
                        "Functional programming with all languages",
                        210,
                        0.2
                )
        );

        assertThat(messages).containsExactly(
                new UserMessage("Total before promotion: 252.0"),
                new UserMessage("Total after promotion: 228.8")
        );
    }
}
