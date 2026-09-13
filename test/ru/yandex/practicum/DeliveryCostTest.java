package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandartParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryCostTest {
    private final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(11);
    private final StandartParcel standartParcel = new StandartParcel("Some", 25, "Some", (byte) 4);
    private final FragileParcel fragileParcel = new FragileParcel("Some", 10, "Some", (byte) 4);
    private final PerishableParcel perishableParcel = new PerishableParcel("Some", 20, "Some", (byte) 4, (byte)5);

    @Test
    void shouldReturnTrueWhenWeight25() {
        int standartCost = 50;
        assertEquals(standartCost, standartParcel.calculateDeliveryCost());
    }

    @Test
    void shouldReturnTrueWhenWeight10() {
        int fragileCost = 40;
        assertEquals(fragileCost, fragileParcel.calculateDeliveryCost());
    }

    @Test
    void shouldReturnTrueWhenWeight20() {
        int perishableCost = 60;
        assertEquals(perishableCost, perishableParcel.calculateDeliveryCost());
    }

    @Test
    void isExpired() {
        byte dateToExpired = 9;
        assertTrue(perishableParcel.isExpired(dateToExpired));
    }

    @Test
    void newParcelInBox() {
        fragileParcelBox.addParcel(fragileParcel);
        assertTrue(fragileParcelBox.isBoolForTest());
    }
}
