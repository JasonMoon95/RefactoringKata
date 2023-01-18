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
        if (quality > 0) {
            quality--;
        }
    }

    void increaseQuality() {
        if (quality < 50) {
            quality++;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
