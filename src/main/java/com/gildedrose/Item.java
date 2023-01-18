package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    public static Item of(String name, int sellIn, int quality) {
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new Backstage(sellIn, quality);
            case "Aged Brie":
                return new AgedBrie(sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }
    void updateQuality() {
        decreaseQuality();
        decreaseSellIn();
        if (isExpired()) {
            decreaseQuality();
        }
    }
    boolean isExpired() {
        return sellIn < 0;
    }

    void decreaseSellIn() {
        sellIn--;
    }

    void decreaseQuality() {
        quality = Math.max(quality - 1, 0);
    }

    void increaseQuality() {
        quality = Math.min(quality + 1, 50);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
