package youtube.aborysa.game.Math.geometrics;

public class Polygon {
	Point2f[] points;
	Point2f pos;
	boolean finalized = false;
	
	public Polygon(Point2f[] points, Point2f pos){
		this.points = points;
		this.pos = pos;
	}
	public void setPos(Point2f pos){
		this.pos = pos;
	}
	public void setPoints(Point2f[] points){
		finalized = false;
		this.points = points;
	}
	public Point2f getPos(){
		return pos;
	}
	public void fin(){
		if (!finalized){
			Point2f[] temp = new Point2f[points.length];
			for(int i = 0; i < points.length;i++){
				temp[i] = points[i].clone();
			}
			pos = pos.clone();
			points = temp;
			finalized = true;
		}
		
	}
	
	
	
	
	public Point2f[] getPoints(){
		return points;
	}
}
