package com.gildedrose;

import com.gildedrose.enums.ItemCategory;
import com.gildedrose.interfaces.ItemStrategy;
import com.gildedrose.strategies.StandardItemStrategy;

import java.util.HashMap;
import java.util.Map;

public class GildedRose {
    Item[] items;

    private static Map<ItemCategory, ItemStrategy> itemStrategyMap = new HashMap<>();

    static {
        itemStrategyMap.put(ItemCategory.Standard, new StandardItemStrategy());
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            ItemStrategy itemStrategy = itemStrategyMap.get(items[i].getCategory());
            items[i] = itemStrategy.updateItem(items[i]);
        }
    }
}
