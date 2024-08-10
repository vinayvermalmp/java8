package com.vin.concurrency;

class CountDown implements Runnable {
    String[] timeStr = {"zero", "one","two", "three","four","five", "six", "seven", "eight", "nine" };
    @Override
    public void run() {
        for (int i = 9; i >= 0 ; i--) {
            // System.out.println(timeStr[i]);
            try {
                System.out.println(timeStr[i]);
                Thread.sleep(500);
            }catch (InterruptedException ite){
                ite.printStackTrace();
            }


        }
    }
}
public class TimeBomb {
    public static void main(String[] args) {
        Thread timer = new Thread(new CountDown());
        System.out.println("starting 10 second count down............");
        timer.start();
        try {
            timer.join();
        } catch (InterruptedException ite){
            ite.printStackTrace();
        }
        System.out.println("Boom!!");
    }


}






