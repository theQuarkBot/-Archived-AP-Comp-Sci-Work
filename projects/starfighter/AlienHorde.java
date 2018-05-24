package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 5/03/18
//Class: AP Comp Sci A
//Lab: AlienHorde.java

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlienHorde {
    private List<Alien> aliens;
    private boolean right = true;
    private boolean left = false;
    private boolean down = false;
    private int furthestRight;
    private int furthestLeft;
    private int size;

    public AlienHorde(int size) {
        aliens = new ArrayList<>();
        this.size = size;
    }

    public void add(Alien al) {
        aliens.add(al);
    }

    public void drawEmAll(Graphics window) {
        if (getSize() > 0)
            for (Alien al : aliens) {
                al.draw(window);
                if (al.getX() > furthestRight) furthestRight = al.getX();
                if (al.getX() < furthestLeft) furthestLeft = al.getX();
            }
    }

    public void makeHorde(int x, int y, int w, int h, int s) {
        int startX = x;
        for (int i = 0; i < size; i++) {
            aliens.add(new Alien(x, y, w, h, s));
            if (x >= 800 - startX - w * 2) {
                x = startX;
                y += h + 10;
            } else {
                x += w + 10;
            }
        }
    }

    public void moveEmAll() {
        if (getSize() > 0) {
            for (Alien a : this.getAliens()) {
                if (a.getX() > furthestRight && right) {
                    furthestRight = a.getX();
                }
                if (a.getX() < furthestLeft && left) {
                    furthestLeft = a.getX();
                }
            }

            if (furthestRight >= 800 - aliens.get(0).getWidth() * 3 / 2 && right) {
                right = false;
                left = true;
                down = true;
            }
            if (furthestLeft <= 0 && left) {
                right = true;
                left = false;
                down = true;
            }

            if (down) {
                for (Alien a : aliens) {
                    a.move("DOWN");
                    a.move("DOWN");
                    a.move("DOWN");
                    a.move("DOWN");
                    a.move("DOWN");
                }
                down = false;
                furthestLeft = 800;
                furthestRight = 0;
            } else if (right)
                for (Alien a : aliens)
                    a.move("RIGHT");
            else if (left)
                for (Alien a : aliens)
                    a.move("LEFT");
        }
    }

    public void removeDeadOnes(List<Ammo> shots, Ship s) {
        if (getSize() > 0 && shots.size() > 0) {
            for (int i = 0; i < getSize(); i++) {
                if (aliens.get(i).getY() + aliens.get(i).getHeight() >= 540) {
                    OuterSpace.wins -= 2;
                    aliens = new ArrayList<Alien>(0);
                    break;
                }
                for (Ammo shot : shots) {
                    if (shot.collision(aliens.get(i))) {
                        aliens.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
    }

    public int getSize() {
        return aliens.size();
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public String toString() {
        return "Number of Aliens: " + getSize();
    }

    public void addRandomAlien() {
        if (1 == (int) (Math.random() * 500)) {
            this.add(new Alien((int) (Math.random() * 700), 60, 30, 30, 1));
        }
    }
}
