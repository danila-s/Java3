package ru.geekbrains.java_3.lesson_1.homework;

import java.util.ArrayList;

public class Main {
  /*
    1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
    a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
    b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    c. Для хранения фруктов внутри коробки можете использовать ArrayList;
    d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
    g. Не забываем про метод добавления фрукта в коробку.
  */
    public static void main(String[] args) {
        String[]arr=new String[]{"a","b","c","d","e"};
        Array<String>array=new Array<>(arr);
        array.changeComponents(0,3);
        array.showArray();
        ArrayList <String>s=new ArrayList<>(array.getArrayList());
        System.out.println(s);

        Box <Apple>box1=new Box<>();
        Apple apple1=new Apple();
        Apple apple2=new Apple();
        Apple apple3=new Apple();


        box1.addFruit(apple1);
        box1.addFruit(apple2);
        box1.addFruit(apple3);


        System.out.println(box1.getWeight());
        Box<Orange>box2=new Box<>();
        Orange or1= new Orange();
        Orange or2= new Orange();
        box2.addFruit(or2);
        box2.addFruit(or1);
        System.out.println(box1.compare(box2));
        Box<Apple>box3=new Box<>();
        box3.addFruit(new Apple());

        System.out.println((box1.shift(box3)).getWeight());
    }
}
