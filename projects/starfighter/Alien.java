package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 4/27/18
//Class: AP Comp Sci A
//Lab: Aliens.java

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

public class Alien extends MovingThing {
    private int speed;
    private Image image;

    public Alien() {
        this(0, 0, 35, 35, 1);
    }

    public Alien(int x, int y) {
        this(x, y, 35, 35, 1);
    }

    public Alien(int x, int y, int s) {
        this(x, y, 35, 35, s);
    }

    public Alien(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        speed = s;
        try {
            URL url = getClass().getResource("alien.png");
            image = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println("failed to load alien.jpg");
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

    public boolean collide(Ship s) {
        System.out.println(s.getX());
        System.out.println(s.getY());
        System.out.println(s.getWidth());
        System.out.println(s.getHeight());
        return touching(this, s);
    }

    public String toString() {
        return super.toString() + getSpeed();
    }
}
