package youtube.aborysa.game.Math.geometrics;

public class Triangle extends Polygon{

	
	public Triangle(Point2f[] points, Point2f pos) {
		super(null, pos);
		Point2f[] p = new Point2f[3];
		if (points.length <= 3){
			for(int i=0; i<3;i++){
				p[i] = points[i];
			}
		}
		setPoints(p);
	}
	public void fin(){
		super.fin();
	}
	
}
