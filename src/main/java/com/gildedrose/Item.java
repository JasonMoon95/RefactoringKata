package com.gildedrose;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public void updateQuality() {
        if (isAgedBrie()) {
            updateQualityForAgedBrie();
        } else if (isBackStage()) {
            updateQualityForBackStage();
        } else if (isSulfuras()) {
            // do nothing
        } else {
            updateQualityForNormal();
        }
    }
    private void updateQualityForNormal() {
        updateSellin();
        updateNormalItemQuality();
        if (sellIn < 0) {
            updateNormalItemQuality();
        }
    }

    private void updateQualityForBackStage() {
        updateSellin();
        updateAgedItemQuality();
        if (sellIn < 10) {
            updateAgedItemQuality();
        }
        if (sellIn < 5) {
            updateAgedItemQuality();
        }
        if (sellIn < 0) {
            updateQualityToZero();
        }
    }

    private void updateQualityForAgedBrie() {
        updateSellin();
        updateAgedItemQuality();
        if (sellIn < 0) {
            updateAgedItemQuality();
        }
    }

    private void updateQualityToZero() {
        quality = 0;
    }

    private void updateNormalItemQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private void updateSellin() {
        sellIn = sellIn - 1;
    }

    private void updateAgedItemQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackStage() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
