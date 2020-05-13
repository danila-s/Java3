package ru.geekbrains.java_3.lesson_1.homework;

import java.util.ArrayList;



import java.util.ArrayList;
import java.util.Arrays;

public class Array <T> {
    private T[]arr;


    public Array(T[]arr){
        this.arr=arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }
    public T[] getArr(){
        return arr;
    }

    public void changeComponents(int num1, int num2){
        if(num1>=0&&num1<arr.length&&num2>=0&&num2<arr.length) {
            T a;
            a=arr[num1];
            arr[num1]=arr[num2];
            arr[num2]=a;
        }
        else System.out.println("Num1 or num2 is not on array size");;

    }
    public ArrayList getArrayList(){
        ArrayList<T>list=new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        return list;
    }

    public void showArray(){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}

