package youtube.aborysa.game.Math.geometrics;

public class Point2f implements Cloneable{
	float x,y;
	boolean multiP = false;
	
	public Point2f(float x, float y, boolean multiPoint) {
		this.x = x;
		this.y = y;
		multiP = multiPoint; //Monstly for checking if the point is a line
	}
	public Point2f(float x, float y) {
		this(x,y,false);
	}
	public boolean isMultiPoint(){
		return multiP;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setCords(float x, float y){
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return ("X: " + x + ", Y: " + y);
	}
	public Vector2f getVector(Point2f pos){
		return getVector(this, pos);
	}
	public static Vector2f getVector(Point2f pos1, Point2f pos2, boolean relative){
		Point2f pos3 = null;
		if(relative)
			pos3 = pos1;
		return new Vector2f(pos1.getX() - pos2.getX(),pos1.getY() - pos2.getY(),pos3);
	};
	public static Vector2f getVector(Point2f pos1, Point2f pos2){
		return getVector(pos1,pos2,false);
	};
	public Vector2f toVector(){
		return new Vector2f(getX(),getY());
	}
	public Point2f clone(){
		try {
			return (Point2f)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
