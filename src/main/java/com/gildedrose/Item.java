package com.gildedrose;

import com.gildedrose.enums.ItemCategory;

public class Item {
    private String name;
    private int sellIn;
    private int quality;
    private ItemCategory category;

    public Item(String name, int sellIn, int quality, ItemCategory category) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
