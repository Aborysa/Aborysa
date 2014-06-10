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
		if(!   ((max2 > max1 & min2 > max1) || (max2 < min1 & min2 < max1))){

			/*if(Math.abs( max2  - min1 ) > Math.abs(min2 - max1)){
				projectionVector = new Vector2f(dv1.getX()*((max2-min1) * (-1)) , dv1.getY() * ((max2-min1) *(-1)));
			}else{
				projectionVector = new Vector2f(dv1.getX()*((max2-min1)) , dv1.getY() * ((max2-min1)));
			}*/
			//projectionVector = new Vector2f(dv1.getX()*((max2-min1) * (-1)) , dv1.getY() * ((max2-min1) *(-1)));
			
		//projectionVector = 	new Vector2f(dv1.getX()*((max2-min1) * (-1)) , dv1.getY() * ((max2-min1) *(-1)));
		//Vector2f temp = new Vector2f(dv1.getX()*((max2-min1)) , dv1.getY() * ((max2-min1)));
		/*if(temp.getLength() < projectionVector.getLength())
			projectionVector = temp;
		*/
			projectionVector = new Vector2f((float)Math.cos(dv1.getAngle())*(-max2+min1) , (float)Math.sin(dv1.getAngle())*(-max2+min1) );
		//	System.out.println(projectionVector);
		}else{
			System.out.println("NO CONTAINMENT");
		} 
		return projectionVector;
	}
}
