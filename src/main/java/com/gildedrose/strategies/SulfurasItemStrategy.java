package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.interfaces.ItemStrategy;

public class SulfurasItemStrategy implements ItemStrategy {
    @Override
    public Item updateItem(Item item) {
        return item;
    }
}
