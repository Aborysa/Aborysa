package youtube.aborysa.game.Math.geometrics;

public class Circle implements Cloneable{
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
	private void setPos(Point2f pos){
		if (pos != null)
			this.pos = pos; 
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
	public Circle clone(){
		try {
			Circle clone = (Circle)(super.clone());
			clone.setPos(getPos().clone());
			return clone;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
