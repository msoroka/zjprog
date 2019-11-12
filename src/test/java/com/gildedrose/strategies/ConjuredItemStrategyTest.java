package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.enums.ItemCategory;
import com.gildedrose.interfaces.ItemStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredItemStrategyTest {
    private static final String NAME = "Conjured Item";
    private static final int SELL_IN = 10;
    private static final int QUALITY = 20;
    private static final ItemCategory CATEGORY = ItemCategory.Conjured;
    private ItemStrategy itemStrategy = new ConjuredItemStrategy();

    @Test
    public void decreaseSellInAndQuality() {
        Item item = new Item(NAME, SELL_IN, QUALITY, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(SELL_IN - 1, item.getSellIn());
        assertEquals(QUALITY - 2, item.getQuality());
    }

    @Test
    public void sellInAndQualityNotNegative() {
        Item item = new Item(NAME, 0, 0, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(0, item.getSellIn());
        assertEquals(0, item.getQuality());
    }
}
