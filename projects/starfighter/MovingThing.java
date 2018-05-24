package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 4/25/18
//Class: AP Comp Sci A
//Lab: MovingThings.java

import java.awt.*;

public abstract class MovingThing implements Moveable {
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public MovingThing() {
        xPos = 10;
        yPos = 10;
        width = 10;
        height = 10;
    }

    public MovingThing(int x, int y) {
        xPos = x;
        yPos = y;
        width = 10;
        height = 10;
    }

    public MovingThing(int x, int y, int w, int h) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    public void setPos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public void setX(int x) {
        xPos = x;
    }

    public int getY() {
        return yPos;
    }

    public void setY(int y) {
        yPos = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int w) {
        width = w;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int h) {
        height = h;
    }

    public void move(String direction, int speed) {
        if (direction.equals("UP")) {
            setY(getY() - speed);
        }
        if (direction.equals("DOWN")) {
            setY(getY() + speed);
        }
        if (direction.equals("LEFT")) {
            setX(getX() - speed);
        }
        if (direction.equals("RIGHT")) {
            setX(getX() + speed);
        }
    }

    public boolean touching(MovingThing one, MovingThing two) {
        return (one.getX() >= two.getX()
                && one.getX() + one.getWidth() <= two.getX() + two.getWidth()
                && one.getY() >= two.getY()
                && one.getY() + one.getHeight() <= two.getY() + two.getHeight());
    }

    public abstract void draw(Graphics window);

    public String toString() {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
    }
}