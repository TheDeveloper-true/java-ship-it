package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    List<T> box = new ArrayList<>();
    private final int maxWeight;
    private int currentWeight = 0;
    private boolean boolForTest;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel){
        currentWeight += parcel.getWeight();
        if (maxWeight > currentWeight) {
            box.add(parcel);
            boolForTest = true;
        } else {
            System.out.println("Максимальный вес коробки превышен. Посылка отправится без коробки.");
            boolForTest = false;
        }
    }

    public void getAllParcels() {
        for (T parcel : box) {
            System.out.println("Посылка " + parcel.getDescription() + ", вес " + parcel.getWeight());
        }
    }

    public boolean isBoolForTest() {
        return boolForTest;
    }
}
