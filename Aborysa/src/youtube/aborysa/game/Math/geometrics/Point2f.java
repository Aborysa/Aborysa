package youtube.aborysa.game.Math.geometrics;

public class Point2f {
	float x,y;
	boolean multiP = false;
	public Point2f(float x, float y, boolean multiPoint){
		this.x = x;
		this.y = y;
		multiP = multiPoint; //Monstly for checking if the point is a line
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
}
