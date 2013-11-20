package youtube.aborysa.game.Math.geometrics;

public class geo {
	//float x,y = 0;
	//Comment
	public static Point2f[] getIntersection(Circle c1, Circle c2){
		
		Point2f[] crossings = new Point2f[2];
		Point2f pos1 = c1.getPos();
		Point2f pos2 = c2.getPos();
		float dX = Math.abs(pos1.getX() - pos2.getX());
		float dY = Math.abs(pos1.getY() - pos2.getY());
		float dist =(float)Math.sqrt(Math.pow(dX,2) + Math.pow(dY, 2));
		if ((dist) < (c1.getRadius() + c2.getRadius())){
			float x1 = 0;
			float y1 = 0;
			float x2 = 0;
			float y2 = 0;
			//Insert intersection algorithm here
			
			
			
		}
		
		
		return null;
		
	}
	public static Point2f getIntersection(Vector2f vec1, Vector2f vec2){
		Point2f pos1 = vec1.getPos();
		Point2f pos2 = vec2.getPos();
		Point2f iPoint = null;
		float x1 = vec1.getX() + pos1.getX();
		float x2 = vec2.getX() + pos2.getX();
		float y1 = vec1.getY() + pos1.getY();
		float y2 = vec2.getY() + pos2.getY(); 
		if (Vector2f.getAngel(vec1,vec2) == 0){
			System.out.println("Same direction");
			Vector2f vecA = new Vector2f(pos1.getX()-x2,pos1.getY()-y2,null);
			Vector2f vecB = new Vector2f(x2 - vec2.getX(), y2 - vec2.getY(), null);
			if(Vector2f.getAngel(vecA,vecB) != 0){
				return null;
			}
			iPoint = new Point2f(0,0,true);
		}else{
			if(x1 < pos1.getX()){
				
			}
			System.out.println("Crossing");
			float a1 = vec1.getdYdX();
			float a2 = vec2.getdYdX();
			float dA = a1 - a2;
			float d1 = 0;
			float d2 = 0;
			if (pos1.getX() < x1){
				d1 = Math.abs(pos1.getX()) * a1 + pos1.getY();
			}else{
				d1 = Math.abs(x1) * a1 + y1;
			}
			if (pos2.getX() < x2){
				d2 = Math.abs(pos2.getX()) * a2 + pos2.getY();
			}else{
				d2 = Math.abs(x2) * a2 + y2;
			}
			
			System.out.println(d1);
			System.out.println("A: " + a2 + ", D: " + d2);
			float dD = d2 - d1;
			float x = dD/dA;
			float y = a1*x + d1;
			System.out.println("Possible pos: " +x + ", " + y);
			iPoint = new Point2f(x,y,false);
			if ((x1 > pos1.getX() && x1 < x) || (x1 < pos1.getX() && x1 > x)) {
				return null;
			}
			if ((y1 > pos1.getY() && y1 < y)||(y1<pos1.getY() && y1>y)) {
				return null;
			}
			if ((x2 > pos2.getX() && x2 < x) || (x2 < pos2.getX() && x2 > x)) {
				return null;
			}
			if ((y2 > pos2.getY() && y2 < y)||(y2<pos2.getY() && y2>y)) {
				return null;
			}			
		}
		return iPoint;
	}
}
