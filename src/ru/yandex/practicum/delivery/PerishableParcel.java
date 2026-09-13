package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private final byte timeToLive;
    private static final int BASE_COST = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, byte sendDay, byte timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(byte currentDay) {
        boolean expired;
        if ((timeToLive + super.getSendDay()) > currentDay) {
            expired = false;
        } else {
            expired = true;
        }
        return expired;
    }

    @Override
    public int getCost() {
        return BASE_COST;
    }

    public int calculateDeliveryCost() {
        return super.calculateDeliveryCost(BASE_COST);
    }
}
