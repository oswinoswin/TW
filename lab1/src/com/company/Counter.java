package com.company;
/**
 * Created by student11 on 2016-03-01.
 */
public class Counter {
    public int number=0;

    public void increment(){
        number++;
        // System.out.println("increment " + number);
    }

    public void decrement(){
        number--;
        // System.out.println("decrement " + number);
    }
    public int value(){
        return number;
    }
}