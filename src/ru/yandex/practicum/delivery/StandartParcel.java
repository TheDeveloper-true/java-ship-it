package ru.yandex.practicum.delivery;

public class StandartParcel extends  Parcel{
    private static final int BASE_COST = 2;

    public StandartParcel(String description, int weight, String deliveryAddress, byte sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getCost() {
        return BASE_COST;
    }

    public int calculateDeliveryCost() {
        return super.calculateDeliveryCost(BASE_COST);
    }
}
