package youtube.aborysa.game.GameObjects;

import youtube.aborysa.game.Math.geometrics.Point2f;
import youtube.aborysa.game.Math.geometrics.Polygon;
import youtube.aborysa.game.Math.geometrics.Triangle;
import youtube.aborysa.game.Math.geometrics.Vector2f;

public class TestGround {
	
	Polygon surface;
	Triangle[] polygons;
	public TestGround(Point2f[] drawingPoints,Point2f[] surfacePoints){
		
		if(drawingPoints.length % 3 == 0){	
			polygons = new Triangle[drawingPoints.length/3];
			for(int i=0; i<(drawingPoints.length/3);i++){
				polygons[i] = new Triangle(new Point2f[]{drawingPoints[i*3],drawingPoints[i*3+1],drawingPoints[i*3+2]});
			}
			surface = new Polygon(surfacePoints);
		}
	}
	public Polygon getSurface(){
		return surface;
	}
	public Triangle[] getMesh(){
		return polygons;
	}
	public Vector2f getSurfaceVector(int x, int y){
		float dist1=1000, dist2=1000;
		Point2f p1 = null;
		Point2f p2 = null;
		Vector2f temp;
		Vector2f rVector;
		Point2f[] surfacePoints = surface.getPoints();
		for(int i=0; i<surfacePoints.length;i++){
			temp = new Vector2f(surfacePoints[i].getX() - x ,surfacePoints[i].getY(), surfacePoints[i]);
			System.out.println(temp.getLength());
			if (temp.getLength() < dist1){
				dist2 = dist1;
				dist1 = temp.getLength();
				p2 = p1;
				p1 = surfacePoints[i];
			}else if(temp.getLength() < dist2){
				dist2 = temp.getLength();
				p2 = surfacePoints[i];
			}
		}
		rVector = new Vector2f(p1.getX(),p1.getY(),p2);
		return rVector;
	}
	
}
