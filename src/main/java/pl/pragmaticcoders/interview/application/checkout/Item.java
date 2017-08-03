package pl.pragmaticcoders.interview.application.checkout;

import lombok.Getter;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.isTrue;

@Getter
class Item {

    private final String name;
    private final BigDecimal price;

    private Item(String name, BigDecimal price) {
        hasText(name, "name should not be empty");
        isTrue(ZERO.compareTo(price) < 0, "price should be grater than ZERO");
        this.name = name;
        this.price = price;
    }

    public static Item create(String name, BigDecimal price) {
        return new Item(name, price);
    }
}
