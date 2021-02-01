package ir.GameElements;

import ir.Soldier;

public class SoldierRun extends Thread {
    private Soldier a;
    private int r;
    private int change;

    public SoldierRun(Soldier a, int change) {
        this.change = change;
        this.a = a;
    }

    @Override
    public void run() {
        if (change == 1) {
            while (a.getX() >= a.getLimit()) {
                r = a.getX() - a.getSpeed();
                System.out.println(r);
                a.setX(r);
                a.getImageView().setTranslateX(a.getX());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            while (a.getX() <= a.getLimit()) {
                r = a.getX() - a.getSpeed();
                System.out.println(r);
                a.setX(r);
                a.getImageView().setTranslateX(a.getX());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
