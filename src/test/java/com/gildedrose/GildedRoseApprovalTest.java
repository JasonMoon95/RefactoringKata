package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GildedRoseApprovalTest {
    @Test
    void updateQuality(){
        String[] name = {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"};
        Integer[] sellIn = {-1, 0, 6, 11};
        Integer[] quality = {0, 2, 49, 50};

        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, name, sellIn, quality);
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        GildedRose gildedRose = new GildedRose(new Item[]{Item.of(name, sellIn, quality)});
        gildedRose.updateQuality();
        return Arrays.asList(gildedRose.items).toString();
    }
}
