package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

import edu.uchicago.cs.java.finalproject.controller.Game;

public class NewShipFloater extends Sprite {


	private int nSpin;
    private Image img = Toolkit.getDefaultToolkit().getImage(NewShipFloater.class.getResource("xuchen.gif"));

	public NewShipFloater() {

		super();

		ArrayList<Point> pntCs = new ArrayList<Point>();
		// top of ship
		pntCs.add(new Point(3, 3));
		pntCs.add(new Point(3,0));
		pntCs.add(new Point(3, -3));
		pntCs.add(new Point(0,-3));
		pntCs.add(new Point(-3, -3));
		pntCs.add(new Point(-3,0));
		pntCs.add(new Point(-3, 3));
		pntCs.add(new Point(0,3));

		assignPolarPoints(pntCs);

		setExpire(250);
		setRadius(40);
		setColor(Color.BLACK);


		int nX = Game.R.nextInt(10);
		int nY = Game.R.nextInt(10);
		int nS = Game.R.nextInt(5);
		
		//set random DeltaX
		if (nX % 2 == 0)
			setDeltaX(nX);
		else
			setDeltaX(-nX);

		//set rnadom DeltaY
		if (nY % 2 == 0)
			setDeltaX(nY);
		else
			setDeltaX(-nY);
		
		//set random spin
		if (nS % 2 == 0)
			setSpin(nS);
		else
			setSpin(-nS);

		//random point on the screen
		setCenter(new Point(Game.R.nextInt(Game.DIM.width),
				Game.R.nextInt(Game.DIM.height)));

		//random orientation 
		 setOrientation(Game.R.nextInt(360));

	}

	public void move() {
		super.move();

		setOrientation(getOrientation() + getSpin());

	}

	public int getSpin() {
		return this.nSpin;
	}

	public void setSpin(int nSpin) {
		this.nSpin = nSpin;
	}

	//override the expire method - once an object expires, then remove it from the arrayList.
	@Override
	public void expire() {
		if (getExpire() == 0)
			CommandCenter.movFloaters.remove(this);
		else
			setExpire(getExpire() - 1);
	}

	@Override
	public void draw(Graphics g) {
		//super.draw(g);
		//fill this polygon (with whatever color it has)
		//g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
		//now draw a white border
		//g.setColor(Color.BLACK);
		//g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
        g.drawImage(img,getCenter().x-42 , getCenter().y-42 , null);

	}

}
