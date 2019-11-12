package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.enums.ItemCategory;
import com.gildedrose.interfaces.ItemStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasItemStrategyTest {
    private static final String NAME = "Sulfuras";
    private static final int SELL_IN = 10;
    private static final int QUALITY = 20;
    private static final ItemCategory CATEGORY = ItemCategory.Sulfuras;
    private ItemStrategy itemStrategy = new SulfurasItemStrategy();

    @Test
    public void sellInAndQualityNotChanging() {
        Item item = new Item(NAME, SELL_IN, QUALITY, CATEGORY);

        item = this.itemStrategy.updateItem(item);

        assertEquals(SELL_IN, item.getSellIn());
        assertEquals(QUALITY, item.getQuality());
    }
}
