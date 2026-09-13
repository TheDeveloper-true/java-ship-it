package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackablePArcels = new ArrayList<>();
    private static ParcelBox<StandartParcel> standartParcelBox = new ParcelBox<>(100);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(50);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(20);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                case 4 :
                    trackParcel();
                    break;
                case 5:
                    showBox();
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Изменить местоположение отслеживаемой посылки");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Какой тип посылки вы хотите отправить?");
        System.out.println("Обычная - 1");
        System.out.println("Хрупкая - 2");
        System.out.println("Скоропортящаяся - 3");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание :");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки :");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес доставки :");
        String adress = scanner.nextLine();
        System.out.println("Введите сегодняшний день месяца :");
        byte day = Byte.parseByte(scanner.nextLine());
        switch (type) {// Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
            case 1:
                StandartParcel standartParcel = new StandartParcel(description, weight, adress, day);
                allParcels.add(standartParcel);
                standartParcelBox.addParcel(standartParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, adress, day);
                allParcels.add(fragileParcel);
                trackablePArcels.add(fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                break;
            case 3:
                System.out.println("Введите срок годности посылки :");
                byte timeToLive = Byte.parseByte(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, adress, day, timeToLive);
                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel p : allParcels) {
            p.packageItem();
            p.deliver();
        }
    }

    private static void calculateCosts() {
        int sumCost = 0;
        for (Parcel p : allParcels){
            sumCost += p.calculateDeliveryCost(p.getCost());
        }
        System.out.println("Стоимость всех покупок : " + sumCost);
        // Посчитать общую стоимость всех доставок и вывести на экран
    }

    private  static void trackParcel() {
        for (Trackable p : trackablePArcels) {
            System.out.println("Введите новую локацию посылки");
            p.reportStatus(scanner.nextLine());
        }
    }

    private  static void showBox() {
        System.out.println("Сожеожимое какой коробки показать?");
        System.out.println("Обычная - 1");
        System.out.println("Хрупкая - 2");
        System.out.println("Скоропортящаяся - 3");
        int type = Integer.parseInt(scanner.nextLine());
        switch (type) {
            case 1 :
                standartParcelBox.getAllParcels();
            case 2 :
                fragileParcelBox.getAllParcels();
            case 3 :
                perishableParcelBox.getAllParcels();
        }
    }
}

