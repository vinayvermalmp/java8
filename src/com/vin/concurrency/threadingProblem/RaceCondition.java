package com.vin.concurrency.threadingProblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 50;
    public int getBalance(){
        return  balance;
    }
    public void withdraw(int balance){
        this.balance -= balance;
    }
}
public class RaceCondition implements Runnable{
    private static Lock lock = new ReentrantLock();


    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        Runnable r = new RaceCondition(); // only 1 instance
        Thread john = new Thread(r);  // both thread share the 1 instance
        Thread marry = new Thread(r);
        john.setName("John");
        marry.setName("Marry");
        john.start();
        marry.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5 ; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Account is overdrawn");
            }
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }

    }
//    private synchronized void makeWithdrawal(int amtToWithdraw) {
//    // private void makeWithdrawal(int amtToWithdraw) {
//        if (account.getBalance() >= amtToWithdraw) {
//            System.out.println(Thread.currentThread().getName()
//            + " , Balance before:  " + account.getBalance());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {}
//            account.withdraw(amtToWithdraw);
//            System.out.println(Thread.currentThread().getName()
//                    + " , Balance After:  " + account.getBalance());
//        } else {
//            System.out.println(Thread.currentThread().getName() + " is unable to withdraw "
//                    + " , as balance is:  " + account.getBalance());
//        }
//
//    }

    private void makeWithdrawal(int amtToWithdraw) {
        try {
            lock.lock();
            if (account.getBalance() >= amtToWithdraw) {
                System.out.println(Thread.currentThread().getName()
                        + " , Balance before:  " + account.getBalance());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                account.withdraw(amtToWithdraw);
                System.out.println(Thread.currentThread().getName()
                        + " , Balance After:  " + account.getBalance());
            } else {
                System.out.println(Thread.currentThread().getName() + " is unable to withdraw "
                        + " , as balance is:  " + account.getBalance());
            }
        } finally {
            lock.unlock();
        }


    }
}
