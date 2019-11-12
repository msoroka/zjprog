package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.enums.ItemCategory;
import com.gildedrose.interfaces.ItemStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassItemStrategyTest {
    private static final String NAME = "Backstage Pass Item";
    private static final int SELL_IN = 20;
    private static final int QUALITY = 20;
    private static final ItemCategory CATEGORY = ItemCategory.BackstagePass;
    private ItemStrategy itemStrategy = new BackstagePassItemStrategy();

    @Test
    public void decreaseSellInAndIncreaseQuality() {
        Item item = new Item(NAME, SELL_IN, QUALITY, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(SELL_IN - 1, item.getSellIn());
        assertEquals(QUALITY + 1, item.getQuality());
    }

    @Test
    public void qualityNotMoreThanFifty() {
        Item item = new Item(NAME, SELL_IN, 50, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(SELL_IN - 1, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    public void sellInNotNegative() {
        Item item = new Item(NAME, 0, QUALITY, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(0, item.getSellIn());
        assertEquals(0, item.getQuality());
    }

    @Test
    public void sellInLessThanTen() {
        Item item = new Item(NAME, 9, QUALITY, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(8, item.getSellIn());
        assertEquals(QUALITY + 2, item.getQuality());
    }

    @Test
    public void sellInLessThanFive() {
        Item item = new Item(NAME, 4, QUALITY, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(3, item.getSellIn());
        assertEquals(QUALITY + 3, item.getQuality());
    }
}
