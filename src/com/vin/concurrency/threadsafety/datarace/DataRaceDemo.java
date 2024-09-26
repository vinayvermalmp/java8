package com.vin.concurrency.threadsafety.datarace;

/*
Data Race Demo

solution ->
a) Atomic class from api
b) synchronized keyword
c) Lock interface
*
* */

/*
This definition can probably be generalized by saying that an execution contains a data race
if it contains at least two conflicting accesses that are not properly coordinated (a.k.a synchronized), but
I am going to talk about data races as they are defined by the JMM. And, unfortunately,
the above definition has a significant flaw.
* */
public class DataRaceDemo {

    public static int count = 0;

    public static void addToCounter(){
        int c = count;
        System.out.println("Before. "+count + ". Thread id: "+Thread.currentThread().getId());
        count = c + 1; // not atomic
        System.out.println("After. "+count + ". Thread id: "+Thread.currentThread().getId());
    }
    public static void main(String[] args) {
        for(int i=1; i<=10; i++){
            new Thread(() -> addToCounter())
                    .start();
        }
    }
}
