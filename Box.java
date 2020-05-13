package ru.geekbrains.java_3.lesson_1.homework;

import java.util.ArrayList;

public class Box <FruitType extends Fruit> {
    private ArrayList<FruitType> fruits;

    public float getWeight(){
        float sum=fruits.get(0).getWeight();
        for (int i = 1; i <fruits.size() ; i++) {
            sum+=fruits.get(i).getWeight();
        }
        return sum;

    }

    Box(){
        fruits=new ArrayList<>();
    }

    public void addFruit(FruitType fruit){
        fruits.add( fruit);
    }
    public boolean compare (Box box){
        return (this.getWeight()==box.getWeight());
    }

    public Box shift (Box <FruitType>box){
        for (int i = 0; i <fruits.size() ; i++) {
            box.addFruit(fruits.get(i));
        }
        return box;

    }





}
