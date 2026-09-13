package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final byte sendDay;
    private static final int BASE_COST = 1;

    public Parcel(String description, int weight, String deliveryAddress, byte sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована.");
    }

    public String getDescription() {
        return description;
    }

    public byte getSendDay() {
        return sendDay;
    }


    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public int getCost() {
        return BASE_COST;
    }

    public int calculateDeliveryCost(int cost) {
        return weight * cost;
    }

    public int getWeight() {
        return weight;
    }
}