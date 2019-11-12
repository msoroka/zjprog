package com.gildedrose;

import com.gildedrose.enums.ItemCategory;
import com.gildedrose.interfaces.ItemStrategy;
import com.gildedrose.strategies.AgedBrieItemStrategy;
import com.gildedrose.strategies.BackstagePassItemStrategy;
import com.gildedrose.strategies.StandardItemStrategy;
import com.gildedrose.strategies.SulfurasItemStrategy;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {
    private static final String NAME = "Sulfuras";
    private static final int SELL_IN = 10;
    private static final int QUALITY = 20;

    private Item[] items = new Item[]{
            new Item(NAME, SELL_IN, QUALITY, ItemCategory.Standard),
            new Item(NAME, SELL_IN, QUALITY, ItemCategory.Sulfuras),
            new Item(NAME, SELL_IN, QUALITY, ItemCategory.AgedBrie),
            new Item(NAME, SELL_IN, QUALITY, ItemCategory.BackstagePass)
    };
    private GildedRose app = new GildedRose(items);

    @Test
    public void checkGildedRoseInstance() {
        assertThat(this.app, instanceOf(GildedRose.class));
    }

    @Test
    public void checkItemsInstances() {
        assertThat(this.items[0], instanceOf(Item.class));
        assertThat(this.items[1], instanceOf(Item.class));
        assertThat(this.items[2], instanceOf(Item.class));
        assertThat(this.items[3], instanceOf(Item.class));
    }

    @Test
    public void checkStrategies() {
        Map<ItemCategory, ItemStrategy> itemStrategyMap = GildedRose.getItemStrategyMap();

        assertThat(itemStrategyMap.get(this.items[0].getCategory()), instanceOf(StandardItemStrategy.class));
        assertThat(itemStrategyMap.get(this.items[1].getCategory()), instanceOf(SulfurasItemStrategy.class));
        assertThat(itemStrategyMap.get(this.items[2].getCategory()), instanceOf(AgedBrieItemStrategy.class));
        assertThat(itemStrategyMap.get(this.items[3].getCategory()), instanceOf(BackstagePassItemStrategy.class));
    }
}
