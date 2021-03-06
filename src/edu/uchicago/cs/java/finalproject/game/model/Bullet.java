package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;

import edu.uchicago.cs.java.finalproject.controller.Game;


public class Bullet extends Sprite {

	  private final double FIRE_POWER = 35.0;
      private Image img = Toolkit.getDefaultToolkit().getImage(Bullet.class.getResource("bullet.gif"));

	 
	
        public Bullet(Falcon fal){
		
		super();
		
		
		//defined the points on a cartesean grid
		ArrayList<Point> pntCs = new ArrayList<Point>();
		
		pntCs.add(new Point(0,1)); //top point
		
		pntCs.add(new Point(1,0));
		pntCs.add(new Point(0,-1));
		pntCs.add(new Point(-1,0));

		assignPolarPoints(pntCs);

		//a bullet expires after 20 frames
	    setExpire( 20 );
	    setRadius(6);
        setColor(Color.WHITE);
	    

	    //everything is relative to the falcon ship that fired the bullet
	    setDeltaX( fal.getDeltaX() +
	               Math.cos( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
	    setDeltaY( fal.getDeltaY() +
	               Math.sin( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
	    setCenter( fal.getCenter() );

	    //set the bullet orientation to the falcon (ship) orientation
	    setOrientation(fal.getOrientation());
	}

    //override the expire method - once an object expires, then remove it from the arrayList. 
	public void expire(){
 		if (getExpire() == 0) {
            //CommandCenter.movFriends.remove(this);
        }
		 else 
			setExpire(getExpire() - 1);
	}


    @Override
    public void draw(Graphics g) {
        //super.draw(g);
        //fill this polygon (with whatever color it has)
        //g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
        //now draw a white border
        //g.setColor(Color.WHITE);
        //g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
        g.drawImage(img,getCenter().x-10 , getCenter().y-10 , null);


    }

}
