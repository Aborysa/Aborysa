package youtube.aborysa.game.Math.geometrics;

public class Vector2f implements Cloneable{
	private float x,y = 0;
	private Point2f pos = null;
	private float length = 0;
	private float angle = 0;
	public Vector2f(float x, float y, Point2f pos){
		this.x = x;
		this.y = y;
		if (pos != null){
			this.pos = pos;
		}else{
			this.pos = new Point2f(0,0,false);
		}
		calcLength();
		calcAngle();
	}
	public Vector2f(float x, float y){
		this(x,y,null);
	}	
	public Vector2f(float x, float y, float x2, float y2){
		this(x,y,new Point2f(x2,y2,false));
	}
	public void setPos(Point2f pos){
		if (pos != null){
			this.pos = pos;
			calcLength();
			calcAngle();
		}
	}
	public float getLength(){
		return length;
	}
	public void calcLength(){
		length = (float) Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
	}
	public void calcAngle(){
	//	System.out.println("ACOS: " + Math.acos(x)/(getLength()));
		angle = (float) Math.acos(x/getLength());
		if (x < 0){
			angle += Math.PI;
		}
	}
	public float getAngle(){
		return angle;
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
		calcLength();
		calcAngle();
	}
	public void normalize(){
		x /= getLength();
		y /= getLength();
		calcLength();
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
		scal = Math.abs(vec1.getX() * vec2.getX()) + (vec1.getY()*vec2.getY());
		return scal;
	}
	public static float getAngle(Vector2f vec1, Vector2f vec2){
		float rad = 0;
		//System.out.println(getScalar(vec1,vec2));
		//TODO fix the error, replace the next line
		rad = (float) Math.acos(getScalar(vec1,vec2)/(vec1.getLength()*vec2.getLength()));
		return rad;
	}

	public String toString(){
		return "[" + getX() + "," + getY() + "]";
	}
	public static Projection getProjection(Vector2f axis, Point2f[] vertecies,Point2f pos){
		Projection temp = null;
		float min = getScalar(axis,vertecies[0].addPoint(pos.clone()).toVector());
		float max = min;
	//	int maxI = 0;
		int minI = 0;
		for(int i=0; i < vertecies.length;i++){
			float scale = getScalar(axis, vertecies[i].addPoint(pos.clone()).toVector());
			if (scale > max){
				max = scale;
				//maxI = i;
			}else if(scale < min){
				min = scale;
				minI = i;
			}
			
		}
		temp = new Projection(axis, min,max);
		return temp;
	}
	public Projection getProjection(Point2f[] vertecies, Point2f pos){
		return getProjection(this,vertecies, pos);
	}
	public Vector2f clone(){
		Vector2f clone;
		try {
			clone = (Vector2f)super.clone();
			clone.setPos(pos.clone());
			return clone;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
