package ir.Soldiers;

public class Soldier {
    private final String name;
    private final String elixir;
    private int health;
    private int speed;
    private final int damage;
    private final int rage;

    public Soldier(String name, String elixir, int health, int speed, int damage, int rage) {
        this.name = name;
        this.elixir = elixir;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        this.rage = rage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getElixir() {
        return elixir;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getRage() {
        return rage;
    }
}
