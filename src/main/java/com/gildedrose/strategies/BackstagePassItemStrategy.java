package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.interfaces.ItemStrategy;

public class BackstagePassItemStrategy implements ItemStrategy {
    @Override
    public Item updateItem(Item item) {
        int newSellIn = this.isSellInPositive(item.getSellIn()) ? item.getSellIn() - 1 : 0;
        int newQuality = this.isSellInMoreThanTen(newSellIn) ? item.getQuality() + 1 : 0;

        if (this.isSellInFiveOrLess(newSellIn)) {
            newQuality += item.getQuality() + 3;
        }

        if (this.isSellInTenOrLess(newSellIn)) {
            newQuality += item.getQuality() + 2;
        }

        if (this.isQualityMoreThanFifty(newQuality)) {
            newQuality = 50;
        }

        item.setSellIn(newSellIn);
        item.setQuality(newQuality);

        return item;
    }

    private boolean isSellInMoreThanTen(int sellIn) {
        return sellIn > 10;
    }

    private boolean isSellInFiveOrLess(int sellIn) {
        return sellIn > 0 && sellIn <= 5;
    }

    private boolean isSellInTenOrLess(int sellIn) {
        return sellIn > 5 && sellIn <= 10;
    }

    private boolean isSellInPositive(int sellIn) {
        return sellIn > 0;
    }

    private boolean isQualityMoreThanFifty(int quality) {
        return quality > 50;
    }
}
