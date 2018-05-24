package starfighter;

//A+ Computer Science  -  www.apluscompsci.com
//Name: Neil Powers
//Date: 4/27/18
//Class: AP Comp Sci A
//Lab: Ship.java

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class OuterSpace extends Canvas implements KeyListener, Runnable {
    private boolean alive = true;
    public static int wins;
    private Ship ship;
    private AlienHorde horde;
    private Bullets shots;

    private boolean[] keys;
    private BufferedImage back;

    public OuterSpace() {
        setBackground(Color.black);
        keys = new boolean[6];

        ship = new Ship(10, 410, 35, 35, 2);
        shots = new Bullets();
        horde = new AlienHorde(32);
        horde.makeHorde(80, 10, 30, 30, 1);
        wins = 0;

        this.addKeyListener(this);
        new Thread(this).start();

        setVisible(true);
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.BLACK);
        graphToBack.fillRect(0, 0, 800, 600);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("StarFighter     -     Number of Shots: " + shots.getNumShots()
                + "     Number of Hits: " + shots.getNumHits()
                + "     Percent of Shots Hits: " + shots.getHitToMissRatio()
                + "     Relative # of Wins: " + wins, 25, 550);

        if (keys[0] && ship.getX() > 0) {
            ship.move("LEFT");
        }
        if (keys[1] && ship.getX() + ship.getWidth() + ship.getWidth() / 2 < 800) {
            ship.move("RIGHT");
        }
        if (keys[2] && ship.getY() > 400) {
            ship.move("UP");
        }
        if (keys[3] && ship.getY() + ship.getHeight() + 40 < 570) {
            ship.move("DOWN");
        }
        if (keys[4]) {
            if (shots.getSize() <= 4)
                shots.add(new Ammo(ship.getX() + ship.getWidth() / 2 - 3, ship.getY() + 5));
            keys[4] = false;
        }
        if (keys[5]) {
            shots.add(new Ammo(ship.getX() + ship.getWidth() / 2 - 2, ship.getY() + 5));
        }
        //add code to move Ship, Alien, etc.


        //add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship

        ship.draw(graphToBack);
        shots.moveEmAll();
        shots.cleanEmUp();
        shots.drawEmAll(graphToBack);
        horde.moveEmAll();
        horde.drawEmAll(graphToBack);
        horde.addRandomAlien();
        horde.removeDeadOnes(shots.getList(), ship);

        twoDGraph.drawImage(back, null, 0, 0);

        if (horde.getSize() == 0) {
            wins++;
            horde.makeHorde(80, 10, 30, 30, 1);
            shots.removeAll();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) keys[0] = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) keys[1] = true;
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) keys[2] = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) keys[3] = true;
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_Z
                || e.getKeyCode() == KeyEvent.VK_CONTROL) keys[4] = true;
        if (e.getKeyCode() == KeyEvent.VK_G) keys[5] = true;
        if (e.getKeyCode() == KeyEvent.VK_Q) System.exit(0);
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) keys[0] = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) keys[1] = false;
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) keys[2] = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) keys[3] = false;
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_Z
                || e.getKeyCode() == KeyEvent.VK_CONTROL) keys[4] = false;
        if (e.getKeyCode() == KeyEvent.VK_G) keys[5] = false;
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        //no code needed here
    }

    public void run() {
        try {
            while (alive) {
                Thread.currentThread().sleep(10);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}

