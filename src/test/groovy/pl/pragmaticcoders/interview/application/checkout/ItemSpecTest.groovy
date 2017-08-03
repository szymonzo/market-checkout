package pl.pragmaticcoders.interview.application.checkout

import spock.lang.Specification

import static java.math.BigDecimal.*

class ItemSpecTest extends Specification {

    def "Should be able to create item with given price and name"() {
        def itemName = "itemA"
        def itemPrice = TEN

        when:
        def item = Item.create(itemName, itemPrice)

        then:
        item.with {
            it.getName() == itemName
            it.getPrice() == itemPrice
        }
    }

    def "Should not allow to create item without name and price(price <= 0)"() {
        when:
        Item.create(itemName, itemPrice)

        then:
        thrown IllegalArgumentException

        where:
        itemName | itemPrice
        null     | null
        ""       | ZERO
        "test"   | ZERO
        "test"   | valueOf(-1)
    }
}
