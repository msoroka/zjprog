package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.interfaces.ItemStrategy;

public class StandardItemStrategy implements ItemStrategy {
    @Override
    public Item updateItem(Item item) {
        int newSellIn = this.isSellInPositive(item.getSellIn()) ? item.getSellIn() - 1 : 0;
        int newQuality = this.isSellInPositive(newSellIn) ? item.getQuality() - 1 : item.getQuality() - 2;
        newQuality = this.isQualityPositive(newQuality) ? newQuality : 0;

        item.setSellIn(newSellIn);
        item.setQuality(newQuality);

        return item;
    }

    private boolean isSellInPositive(int sellIn) {
        return sellIn > 0;
    }

    private boolean isQualityPositive(int quality) {
        return quality > 0;
    }
}
