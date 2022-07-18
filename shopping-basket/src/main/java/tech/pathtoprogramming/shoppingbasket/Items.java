package tech.pathtoprogramming.shoppingbasket;

import java.util.HashMap;
import java.util.Map;

class Items {
    private final Map<String, Item> itemMap;

    public static Items of(Item... itemList) {
        return new Items(itemList);
    }

    private Items(Item... newItems) {
        itemMap = new HashMap<>();

        for (Item newItem : newItems) {
            this.itemMap.put(newItem.getName(), newItem);
        }
    }

    public float total() {
        return itemMap.values().stream()
                .map(Item::itemSubtotal)
                .reduce(Float::sum)
                .orElse(0.0f);
    }

    public Item get(String itemName) {
        return itemMap.get(itemName);
    }
}
