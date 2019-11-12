package com.gildedrose;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.gildedrose.enums.ItemCategory;

import org.junit.Test;

public class ItemTest {
    private static final String NAME = "Foo";
    private static final int SELL_IN = 10;
    private static final int QUALITY = 20;
    private static final ItemCategory CATEGORY = ItemCategory.Standard;

    @Test
    public void checkItem() {
        Item item = new Item(NAME, SELL_IN, QUALITY, CATEGORY);

        assertEquals(NAME, item.getName());
        assertEquals(SELL_IN, item.getSellIn());
        assertEquals(QUALITY, item.getQuality());
        assertEquals(CATEGORY, item.getCategory());
        assertThat(item, instanceOf(Item.class));
    }
}
