package com.gildedrose.strategies;

import static org.junit.Assert.*;

import com.gildedrose.Item;
import com.gildedrose.enums.ItemCategory;

import com.gildedrose.interfaces.ItemStrategy;
import org.junit.Test;

public class StandardItemStrategyTest {
    private static final String NAME = "Standard Item";
    private static final int SELL_IN = 10;
    private static final int QUALITY = 20;
    private static final ItemCategory CATEGORY = ItemCategory.Standard;
    private ItemStrategy itemStrategy = new StandardItemStrategy();

    @Test
    public void decreaseSellInAndQuality() {
        Item item = new Item(NAME, SELL_IN, QUALITY, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(SELL_IN - 1, item.getSellIn());
        assertEquals(QUALITY - 1, item.getQuality());
    }

    @Test
    public void decreaseQualityTwiceAsNormal() {
        Item item = new Item(NAME, 0, QUALITY, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(0, item.getSellIn());
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
