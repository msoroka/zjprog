package com.gildedrose;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ItemTest {

    private static final String NAME = "Foo";
    private static final int SELL_IN = 20;
    private static final int QUALITY = 30;

    @Test
    public void instanceTest() {
        Item item = new StandardItem(NAME, SELL_IN, QUALITY);

        assertEquals(item.getName(), NAME);
        assertEquals(item.getSellIn(), SELL_IN);
        assertEquals(item.getQuality(), QUALITY);
        assertThat(item, instanceOf(Item.class));
        assertThat(item, instanceOf(StandardItem.class));
    }
}
