package ir.GameElements;

import ir.Soldier;

public class SoldierRun extends Thread {
    private final Soldier a;
    private final int change;
    private int SoldierHealthLeft;
    private int targetHealthLeft;


    public SoldierRun(Soldier a, int change) {
        SoldierHealthLeft = a.getHealth();
        this.change = change;
        this.a = a;
        if (!a.getPlayer().getTargets().isEmpty())
            targetHealthLeft = a.getPlayer().getTargets().get(0).getHealth();
        else targetHealthLeft = 0;
    }

    @Override
    public void run() {
        int r;
        if (change == 1) {
            try {
                while (true) {
                    if (a.getX() > a.getLimit()) {
                        r = a.getX() - a.getSpeed();
                    System.out.println("");
                        a.setX(r);
                        a.getImageView().setTranslateX(a.getX());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        if (!a.getPlayer().getTargets().isEmpty()) {
                            targetHealthLeft = a.getPlayer().getTargets().get(0).getHealth() - a.getDamage();
                            a.getPlayer().getTargets().get(0).setHealth(targetHealthLeft);
                            if (a.getPlayer().getTargets().get(0).getHealth() <= 0) {
                                a.getPlayer().deadTarget(a.getPlayer().getTargets().get(0));
                            }
                        System.out.println("" + SoldierHealthLeft);
                            if (!a.getPlayer().getTargets().isEmpty()) {
                                SoldierHealthLeft = a.getHealth() - a.getPlayer().getTargets().get(0).getDamage();
                                a.setHealth(SoldierHealthLeft);
                            System.out.println("" + SoldierHealthLeft);
                            } else a.getPlayer().winCount(a);
                            if (SoldierHealthLeft <= 0) {
                                a.getPlayer().deadSoldier(a);
                                a.isDead();
                            }
                        } else a.getPlayer().winCount(a);
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        } else {
            try {

                while (true) {
                    if (a.getX() < a.getLimit()) {
                        r = a.getX() - a.getSpeed();
                    System.out.println("");
                        a.setX(r);
                        a.getImageView().setTranslateX(a.getX());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        if (!a.getPlayer().getTargets().isEmpty()) {
                            targetHealthLeft = a.getPlayer().getTargets().get(0).getHealth() - a.getDamage();
                            a.getPlayer().getTargets().get(0).setHealth(targetHealthLeft);
                            if (a.getPlayer().getTargets().get(0).getHealth() <= 0) {
                                a.getPlayer().deadTarget(a.getPlayer().getTargets().get(0));
                            }
                        System.out.println("" + SoldierHealthLeft);
                            if (!a.getPlayer().getTargets().isEmpty()) {
                                SoldierHealthLeft = a.getHealth() - a.getPlayer().getTargets().get(0).getDamage();
                                a.setHealth(SoldierHealthLeft);
                            System.out.println("" + SoldierHealthLeft);
                            } else a.getPlayer().winCount(a);
                            if (SoldierHealthLeft <= 0) {
                                a.getPlayer().deadSoldier(a);
                                a.isDead();
                            }
                        } else a.getPlayer().winCount(a);
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
