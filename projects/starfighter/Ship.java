package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 4/25/18
//Class: AP Comp Sci A
//Lab: Ship.java

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

public class Ship extends MovingThing {
    private int speed;
    private Image image;

    public Ship() {
        this(10, 10, 60, 60, 2);
    }

    public Ship(int x, int y) {
        this(x, y, 60, 60, 2);
    }

    public Ship(int x, int y, int s) {
        this(x, y, 60, 60, s);
    }

    public Ship(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        speed = s;
        try {
            URL url = getClass().getResource("ship.png");
            image = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println("Failed to load: ship.png");
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void move(String direction) {
        super.move(direction, speed);
    }

    public void draw(Graphics window) {
        window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    public Ship getShip() {
        return this;
    }

    public String toString() {
        return super.toString() + getSpeed();
    }
}
