package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.interfaces.ItemStrategy;

public class AgedBrieItemStrategy implements ItemStrategy {
    @Override
    public Item updateItem(Item item) {
        int newSellIn = this.isSellInPositive(item.getSellIn()) ? item.getSellIn() - 1 : 0;
        int newQuality = this.isQualityLessThanFifty(item.getQuality()) ? item.getQuality() + 1 : 50;

        item.setSellIn(newSellIn);
        item.setQuality(newQuality);

        return item;
    }

    private boolean isSellInPositive(int sellIn) {
        return sellIn > 0;
    }

    private boolean isQualityLessThanFifty(int quality) {
        return quality < 50;
    }
}
