package edu.uchicago.cs.java.finalproject.game.model;

import edu.uchicago.cs.java.finalproject.controller.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yangyan on 11/23/14.
 */
public class Explosion extends MovableAdapter{
    private Point pntCenter;
    private int nExpiry;
    private int nRadius;

    public Explosion(Asteroid ast) {
        pntCenter = ast.getCenter();
        nExpiry = 20;
        nRadius = 200;
    }

    @Override
    public void expire() {
        super.expire();
        nExpiry--;
        nRadius-=10;
        if (nExpiry < 1){
            CommandCenter.getMovDebris().remove(this);
        }

    }

    @Override
    public void draw(Graphics g) {

        super.draw(g);
        g.setColor(new Color(Game.R.nextInt(256),Game.R.nextInt(256),Game.R.nextInt(256)));
        g.fillOval(pntCenter.x - nRadius/2, pntCenter.y - nRadius/2, nRadius, nRadius);
    }

}
