package org.example.dz;

import static org.example.dz.Main.forks;

public class Person implements Runnable {
    private final String name;
    private final int forkLeft;
    private final int forkRight;
    private Integer cnt = 2;

    public Person(String name, int forkLeft, int forkRight) {
        this.name = name;
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;

    }

    private boolean takeForks() {
        if (forks[forkLeft].get() && forks[forkRight].get()) {
            forks[forkLeft].set(false);
            forks[forkRight].set(false);
            System.out.println("Философ " + this.name + " took forks");
            return true;
        } else {
            forks[forkLeft].set(true);
            forks[forkRight].set(true);
            return false;
        }
    }

    public boolean eating() {
        if (takeForks()) {
            System.out.println("Философ " + this.name + " is eating...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        System.out.println("Философ " + this.name + " присоединился");
        while (this.cnt >= 0) {
            if (eating()) this.cnt--;
            else {
                System.out.println("Философ " + this.name + " размышляет...");
            }
        }
    }
}
