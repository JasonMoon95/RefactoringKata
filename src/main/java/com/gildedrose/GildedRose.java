package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityFor(item);
        }
    }

    private static void updateQualityFor(Item item) {
        if (isAgedBrie(item)) {
            updateItemSellin(item);
            updateAgedItemQuality(item);
            if (item.sellIn < 0) {
                updateAgedItemQuality(item);
            }
        } else if (isBackStage(item)) {
            updateItemSellin(item);
            updateAgedItemQuality(item);
            if (item.sellIn < 10) {
                updateAgedItemQuality(item);
            }
            if (item.sellIn < 5) {
                updateAgedItemQuality(item);
            }
            if (item.sellIn < 0) {
                updateItemQualityToZero(item);
            }
        } else if (isSulfuras(item)) {
            // do nothing
        } else {
            updateItemSellin(item);
            updateNormalItemQuality(item);
            if (item.sellIn < 0) {
                updateNormalItemQuality(item);
            }
        }
    }

    private static void updateItemQualityToZero(Item item) {
        item.quality = 0;
    }

    private static void updateNormalItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static void updateItemSellin(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void updateAgedItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private static boolean isBackStage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}