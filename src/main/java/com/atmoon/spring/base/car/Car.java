package com.atmoon.spring.base.car;

public class Car {

    private String carNo;

    private int carWeight;

    private String carColor;

    public Car(String carNo, int carWeight, String carColor){
        this.carNo = carNo;
        this.carWeight = carWeight;
        this.carColor = carColor;
    }

    public Car(int carWeight, String carNo, String carColor){
        this.carWeight = carWeight;
        this.carNo = carNo;
        this.carColor = carColor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNo='" + carNo + '\'' +
                ", carWeight=" + carWeight +
                ", carColor='" + carColor + '\'' +
                '}';
    }
}
