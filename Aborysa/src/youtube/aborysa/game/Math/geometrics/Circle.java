package youtube.aborysa.game.Math.geometrics;

public class Circle {
	private float radius;
	private Point2f pos = null;
	public Circle(float radius,Point2f pos){
		this.radius = radius;
		if (pos == null){
			this.pos = new Point2f(0,0,false);
		}else{
			this.pos = pos;
		}
	}
	public float getRadius(){
		return radius;
	}
	public Point2f getPos(){
		return pos;
	}
	public void setRadius(float radius){
		this.radius = radius;
	}
}
