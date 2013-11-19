package youtube.aborysa.game.Math.geometrics;

public class Vector2f {
	private float x,y = 0;
	private Point2f pos = null;
	public Vector2f(float x, float y, Point2f pos){
		this.x = x;
		this.y = y;
		if (pos != null){
			this.pos = pos;
		}else{
			this.pos = new Point2f(0,0,false);
		}
	}
	public Vector2f(float x, float y, float x2, float y2){
		this.x = x;
		this.y = y;
		this.pos = new Point2f(x2,y2,false);
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

}
