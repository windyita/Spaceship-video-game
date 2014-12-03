package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;

/**
 * Created by yangyan on 11/23/14.
 */
public abstract class MovableAdapter implements Movable{
    public MovableAdapter() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void move() {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public int points() {
        return 0;
    }

    @Override
    public Point getCenter() {
        return null;
    }

    @Override
    public int getRadius() {
        return 0;
    }

    @Override
    public void expire() {

    }

    @Override
    public void fadeInOut() {

    }
}
