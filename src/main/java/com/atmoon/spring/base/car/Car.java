package com.atmoon.spring.base.car;

public class Car {

    private String carNo;

    private int carWeight;

    private String carColor;

    public Car(String carNo, int carWeight, String carColor) {
        this.carNo = carNo;
        this.carWeight = carWeight;
        this.carColor = carColor;
    }

    /*public Car(String carNo,int carWeight,String carColor){
        this.carNo = carNo;
        this.carWeight = carWeight;
        this.carColor = carColor;
    }

    public Car(String carNo,String carColor,int carWeight){
        this.carNo = carNo;
        this.carColor = carColor;
        this.carWeight = carWeight;
    }*/

    @Override
    public String toString() {
        return "Car{" +
                "carNo='" + carNo + '\'' +
                ", carWeight=" + carWeight +
                ", carColor='" + carColor + '\'' +
                '}';
    }
}
