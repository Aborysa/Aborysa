package youtube.aborysa.game.Math.geometrics;

public class Vector2f {
	float x,y = 0;
	Point2f pos = null;
	public Vector2f(float x, float y, Point2f pos){
		this.x = x;
		this.y = y;
		if (pos != null){
			this.pos = pos;
		}else{
			this.pos = new Point2f(0,0,false);
		}
	}
	public float getLength(){
		float len = 0;
		len = (float) Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
		return len;
	}
	public float getAngel(){
		float ang = 0;
		ang = (float) Math.acos((x)/(getLength()));
		return ang;
	}
	public float getdYdX(){
		if (x !=0){
			return y/x;
		}else{
			return y/0.0000001f;
		}
	}
	public void set(float x, float y){
		this.x = x;
		this.y = y;	
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public Point2f getPos(){
		return pos;
	}
	public static float getScalar(Vector2f vec1 ,Vector2f vec2){
		float scal = 0;
		scal = (vec1.getX() * vec2.getX()) + (vec1.getY()*vec2.getY());
		return scal;
	}
	public static float getAngel(Vector2f vec1, Vector2f vec2){
		float rad = 0;
		rad = (float) Math.acos(getScalar(vec1,vec2)/(vec1.getLength()*vec2.getLength()));
		return rad;
	}
	public static Point2f getIntersection(Vector2f vec1, Vector2f vec2){
		Point2f pos1 = vec1.getPos();
		Point2f pos2 = vec2.getPos();
		Point2f iPoint = null;
		float x1 = vec1.getX() + pos1.getX();
		float x2 = vec2.getX() + pos2.getX();
		float y1 = vec1.getY() + pos1.getY();
		float y2 = vec2.getY() + pos2.getY(); 
		if (getAngel(vec1,vec2) == 0){
			System.out.println("Same direction");
			Vector2f vecA = new Vector2f(pos1.getX()-x2,pos1.getY()-y2,null);
			Vector2f vecB = new Vector2f(x2 - vec2.getX(), y2 - vec2.getY(), null);
			if(getAngel(vecA,vecB) != 0){
				return null;
			}
			iPoint = new Point2f(0,0,true);
		}else{
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
			iPoint = new Point2f(x,y,false);
			
		}
		
		
		
		return iPoint;
	}
}
