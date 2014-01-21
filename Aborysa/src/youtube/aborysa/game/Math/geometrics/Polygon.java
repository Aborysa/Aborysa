package youtube.aborysa.game.Math.geometrics;

public class Polygon {
	Point2f[] points;
	boolean finalized = false;
	public Polygon(Point2f[] points){
		this.points = points;
	}
	public void setPoints(Point2f[] points){
		finalized = false;
		this.points = points;
	}
	public void fin(){
		if (!finalized){
			Point2f[] temp = new Point2f[points.length];
			for(int i = 0; i < points.length;i++){
				temp[i] = points[i].clone();
			}
			points = temp;
			finalized = true;
		}
	}
	
	
	
	
	public Point2f[] getPoints(){
		return points;
	}
}
