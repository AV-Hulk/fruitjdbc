package com.houhong.bean;

/**
 * @author AV_Hulk
 * @create 2022-03-07 23:01
 **/
public class Fruit {
    int id;
    String name;
    double price;
    int number;
    double subtotal;

    public Fruit(int id, String name, double price, int number, double subtotal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.subtotal = subtotal;
    }

    public Fruit(String name, double price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.subtotal = price * number;
    }

    public Fruit(String name, double price, int number, double subtotal) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.subtotal = subtotal;
    }

    public Fruit() {
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", subtotal=" + subtotal +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
