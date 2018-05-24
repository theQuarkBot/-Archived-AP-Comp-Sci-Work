package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 4/27/18
//Class: AP Comp Sci A
//Lab: Ship.java

import javax.swing.*;
import java.awt.*;

public class StarFighter extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public StarFighter() {
        super("STARFIGHTER");
        setSize(WIDTH, HEIGHT);

        OuterSpace theGame = new OuterSpace();
        ((Component) theGame).setFocusable(true);

        getContentPane().add(theGame);

        setVisible(true);
    }

    public static void main(String args[]) {
        StarFighter run = new StarFighter();
    }
}