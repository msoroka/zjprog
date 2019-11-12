package com.gildedrose;

import com.gildedrose.enums.ItemCategory;
import com.gildedrose.interfaces.ItemStrategy;
import com.gildedrose.strategies.AgedBrieItemStrategy;
import com.gildedrose.strategies.StandardItemStrategy;
import com.gildedrose.strategies.SulfurasItemStrategy;

import java.util.HashMap;
import java.util.Map;

public class GildedRose {
    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public static Map<ItemCategory, ItemStrategy> getItemStrategyMap() {
        return itemStrategyMap;
    }

    public static void setItemStrategyMap(Map<ItemCategory, ItemStrategy> itemStrategyMap) {
        GildedRose.itemStrategyMap = itemStrategyMap;
    }

    private static Map<ItemCategory, ItemStrategy> itemStrategyMap = new HashMap<>();

    static {
        itemStrategyMap.put(ItemCategory.Standard, new StandardItemStrategy());
        itemStrategyMap.put(ItemCategory.Sulfuras, new SulfurasItemStrategy());
        itemStrategyMap.put(ItemCategory.AgedBrie, new AgedBrieItemStrategy());
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
