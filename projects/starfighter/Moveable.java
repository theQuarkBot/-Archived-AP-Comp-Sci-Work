package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 4/27/18
//Class: AP Comp Sci A
//Lab: Ship.java

public interface Moveable {
    public void setPos(int x, int y);

    public int getX();

    public void setX(int x);

    public int getY();

    public void setY(int y);

    public int getWidth();

    public void setWidth(int w);

    public int getHeight();

    public void setHeight(int h);

    public int getSpeed();

    public void setSpeed(int s);

    public void move(String direction, int speed);

    public boolean touching(MovingThing one, MovingThing two);

}
