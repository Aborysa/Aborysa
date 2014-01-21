package youtube.aborysa.game.Math.geometrics;

public class Triangle extends Polygon{


	public Triangle(Point2f[] points) {
		super(null);
		Point2f[] p = new Point2f[3];
		if (points.length <= 3){
			for(int i=0; i<3;i++){
				p[i] = points[i];
			}
		}
		setPoints(points);
		fin();
	}
	
}
