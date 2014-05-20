package youtube.aborysa.game.Math.geometrics;

public class Projection {
	float min;
	float max; //Don't think I need pos and
	Vector2f dv;
	public Projection(Vector2f dv,float min, float max){
		this.min = min;
		this.max = max;
		this.dv = dv;
	}
	public Vector2f getOverlap(Projection p1){
		return getOverlap(this, p1);
	}
	public float getMin(){
		return min;
	}
	public float getMax(){
		return max;
	}
	public Vector2f getDV(){
		return dv;
	}
	public static Vector2f getOverlap(Projection p1, Projection p2){
		Vector2f projectionVector = null;
		float min1 = p1.getMin();
		float max1 = p1.getMax();
		float min2 = p2.getMin();
		float max2 = p2.getMax();
		Vector2f dv1 = p1.getDV();
		float diff = 0;
		if(!(max2 < min1 || min2 > max1)){
			/*	if(min1 > min2 || max1 < max2){  
				 	
			}else if(min2 > min1 || max2 < max1){ 
				
			}else*/ 
			if(Math.abs(min1 - max2) < Math.abs(min2 - max1) ){
				diff = (min1 - max2);
			}else{
				diff = (min2 - max1);
			}
			Vector2f dv3 = dv1.clone();
		//	dv3.set(dv1.getX()*diff, dv1.getY()*diff);
			projectionVector = new Vector2f(dv1.getX() * diff , dv1.getY() * diff );
			
			//	projectionVector = new Vector2f((float)Math.cos(dv1.getAngle())*diff , (float)Math.sin(dv1.getAngle())*diff );
			System.out.println(projectionVector);
		}
		return projectionVector;
	}
}
