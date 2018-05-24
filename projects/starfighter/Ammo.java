package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 4/27/18
//Class: AP Comp Sci A
//Lab: Aliens.java

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

public class Ammo extends MovingThing {
    private int speed;
    private Image image;
    private boolean ok = true;

    public Ammo() {
        this(0, 0, 5);
    }

    public Ammo(int x, int y) {
        this(x, y, 5);
    }

    public Ammo(int x, int y, int s) {
        super(x, y, 8, 12);
        speed = s;
        try {
            URL url = getClass().getResource("goodMissile.png");
            image = ImageIO.read(url);
        } catch (Exception e) {
            System.out.println("failed to load goodMissile.jpg");
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void draw(Graphics window) {
        window.drawImage(image, getX(), getY(), 6, 8, null);
    }

    public void draw(Graphics window, Image image) {
        window.drawImage(image, getX(), getY(), 6, 8, null);
    }

    public void move(String direction) {
        super.move(direction, speed);
    }

    //MovingThing used rather than Alien for better extensibility
    public boolean collision(MovingThing movingThing) {
        if (touching(this, movingThing)) {
            kill();
            Bullets.numHits++;
            return true;
        } else return false;
    }

    //I think this will be helpful when making the Bullets class (easier to tell when to get rid of ammo instances)
    public boolean isOK() {
        if (getY() < 0 || getY() >= 600)
            kill();
        return ok;
    }

    //Same for this one
    private void kill() {
        ok = false;
    }

    public String toString() {
        return super.toString() + " " + getSpeed();
    }
}
