package com.carto.pattern.decorator;

/*Software entities should open for extension, but close for modification*/
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void WearTShirts() {
        System.out.print("大T恤 ");
    }

    public void WearBigTrouser() {
        System.out.print("垮裤 ");
    }

    public void WearSneakers() {
        System.out.print("破球鞋 ");
    }

    public void WearSuit() {
        System.out.print("西装 ");
    }
}
