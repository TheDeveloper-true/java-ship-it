package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    private static final int BASE_COST = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, byte sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + super.getDescription() + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public int getCost() {
        return BASE_COST;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + super.getDescription() + " изменила местоположение на " + newLocation);
    }


    public int calculateDeliveryCost() {
        return super.calculateDeliveryCost(BASE_COST);
    }
}
