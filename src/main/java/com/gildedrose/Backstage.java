package com.gildedrose;

public class Backstage extends Item {

    public Backstage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    void updateQuality() {
        increaseQuality();
        if (sellIn < 11) {
            increaseQuality();
        }
        if (sellIn < 6) {
            increaseQuality();
        }
        decreaseSellIn();
        if (isExpired()) {
            this.quality = 0;
        }
    }
}
