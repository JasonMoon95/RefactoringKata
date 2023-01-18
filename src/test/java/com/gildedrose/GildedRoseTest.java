package com.gildedrose;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private GildedRose gildedRose;
    private Item[] items;

    @Before
    public void setUp() {
    }

    @Test
    void foo() {
        Item[] items = new Item[] {Item.of("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", items[0].name);
    }

    @Test
    public void testQuality() {
        //given
        items = new Item[] {
                Item.of("Aged Brie", 10, 30),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item.of("Sulfuras, Hand of Ragnaros", 0, 80),
                Item.of("Normal Item", 10, 20)
        };
        gildedRose = new GildedRose(items);

        //when
        gildedRose.updateQuality();

        //then
        assertEquals(31, items[0].quality);
        assertEquals(21, items[1].quality);
        assertEquals(80, items[2].quality);
        assertEquals(19, items[3].quality);
    }

    @Test
    public void testSellIn() {
        //given
        items = new Item[] {
                Item.of("Aged Brie", 10, 30),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item.of("Sulfuras, Hand of Ragnaros", 0, 80),
                Item.of("Normal Item", 10, 20)
        };
        gildedRose = new GildedRose(items);

        //when
        gildedRose.updateQuality();

        //then
        assertEquals(9, items[0].sellIn);
        assertEquals(14, items[1].sellIn);
        assertEquals(0, items[2].sellIn);
        assertEquals(9, items[3].sellIn);
    }

    @Test
    public void testQualityWithExpiredItem(){
        //given
        items = new Item[] {
                Item.of("Aged Brie", -1, 49),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 0, 49),
                Item.of("Sulfuras, Hand of Ragnaros", -1, 80),
                Item.of("Normal Item", -1, 0)
        };
        gildedRose = new GildedRose(items);

        //when
        gildedRose.updateQuality();

        //then
        assertEquals(50, items[0].quality);
        assertEquals(0, items[1].quality);
        assertEquals(80, items[2].quality);
        assertEquals(0, items[3].quality);
    }

    @Test
    public void testQualityWithMaxQuality(){
        //given
        items = new Item[] {
                Item.of("Aged Brie", 10, 50),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 15, 50),
                Item.of("Sulfuras, Hand of Ragnaros", 10, 80),
                Item.of("Normal Item", 10, 50)
        };
        gildedRose = new GildedRose(items);

        //when
        gildedRose.updateQuality();

        //then
        assertEquals(50, items[0].quality);
        assertEquals(50, items[1].quality);
        assertEquals(80, items[2].quality);
        assertEquals(49, items[3].quality);
    }
}
