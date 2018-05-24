package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 5/01/18
//Class: AP Comp Sci A
//Lab: Bullets.java

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Bullets {
    protected static int numHits = 0;
    protected static int numShots = 0;
    protected static double hitToMissRatio = 0.00;
    private List<Ammo> ammo;
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public Bullets() {
        ammo = new ArrayList<>(0);
    }

    public void add(Ammo al) {
        ammo.add(al);
        numShots++;
    }

    public void drawEmAll(Graphics window) {
        if (ammo.size() > 0) {
            for (Ammo al : ammo)
                al.draw(window);
        }
    }

    public void moveEmAll() {
        if (getSize() > 0)
            for (Ammo al : ammo) {
                al.move("UP");
            }
    }

    public void cleanEmUp() {
        if (getSize() > 0)
            for (int i = 0; i < getSize(); i++)
                if (!ammo.get(i).isOK()) {
                    ammo.remove(i);
                    i--;
                    hitToMissRatio = (double) getNumHits() / (double) getNumShots();
                }
    }

    public List<Ammo> getList() {
        return ammo;
    }

    public int getSize() {
        return ammo.size();
    }

    public String toString() {
        return ammo.size() + "bullets on field";
    }

    public int getNumShots() {
        return numShots;
    }

    public int getNumHits() {
        return numHits;
    }

    public String getHitToMissRatio() {
        return decimalFormat.format(hitToMissRatio * 100) + "%";
    }

    public void removeAll() {
        ammo.clear();
    }
}
