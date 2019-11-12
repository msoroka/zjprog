package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.enums.ItemCategory;

import org.junit.Test;

public class GildedRoseTest {
    private static final String NAME = "Foo";
    private static final int SELL_IN = 10;
    private static final int QUALITY = 20;

    @Test
    public void decreaseSellInAndQualityStandardItem() {
        Item[] items = new Item[]{
                new Item(NAME, SELL_IN, QUALITY, ItemCategory.Standard)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(SELL_IN - 1, app.items[0].getSellIn());
        assertEquals(QUALITY - 1, app.items[0].getQuality());
    }
}
