package youtube.aborysa.game.Math.geometrics;

public class polyShape {
	Point2f[] vertecies; 
	Point2f pos;
	
	public polyShape(Point2f[] vertecies, Point2f pos){
		this.vertecies = vertecies;
		this.pos = pos;
	}
	public void setPos(Point2f pos){
		this.pos = pos;
	}
	public Point2f[] getVertecies(){
		return vertecies;
	}
	public Point2f getPos(){
		return pos;
	}
	public Vector2f[] getNormals(boolean normalize){
		Vector2f[] edges = getEdges();
		Vector2f[] normals = new Vector2f[edges.length];
		for(int i=0; i < normals.length;i++){
			normals[i] = new Vector2f(edges[i].getY(),-edges[i].getX());
			if(normalize){
				normals[i].normalize();
			}
		}
		return normals;
	}
	public Vector2f[] getEdges(){
		Vector2f[] temp = new Vector2f[vertecies.length];
		for(int i=0; i< temp.length;i++){
			temp[i] = Point2f.getVector(vertecies[i%vertecies.length], vertecies[(i+1)%vertecies.length]);
		}
		return temp;
	}
	public Point2f getCenter(){
		int x = 0;
		int y = 0;
		Point2f center = null;
		for(int i=0; i< vertecies.length;i++){
			x += vertecies[i].getX();
			y += vertecies[i].getY();
		}
		center = new Point2f(x/vertecies.length, y/vertecies.length); 
		return center;
	}
	public static Vector2f getCollision(polyShape shape1, polyShape shape2){
		Vector2f rsVec = null;
		boolean overlapping = true;
		Vector2f[] axis = shape1.getNormals(true);
		Vector2f[] axis2 = shape2.getNormals(true);
		Point2f center_1 = shape1.getCenter().addPoint(shape1.getPos());
		Point2f center_2 = shape2.getCenter().addPoint(shape2.getPos());
		//Might need to change the code
		

		Vector2f[] rsVecList = new Vector2f[axis.length+axis2.length];
		
		for(int i=0; i<axis.length;i++){
			Projection p1 = Vector2f.getProjection(axis[i], shape1.getVertecies(),shape1.getPos());
			Projection p2 = Vector2f.getProjection(axis[i], shape2.getVertecies(), shape2.getPos());
			Vector2f oVec = p1.getOverlap(p2);
			//Checking overlapping
			if(oVec == null){
				System.out.println("NULL");
				overlapping = false;
				rsVec = null;
				break;
			}else{
				if(rsVec == null || rsVec.getLength() > oVec.getLength())
					rsVec = oVec;
				rsVecList[i] = oVec; //might be usefull
		
			}
		}
		for(int i=0; i<axis2.length;i++){
			//if(!overlapping){
			//	break;
			//}
			Projection p1 = Vector2f.getProjection(axis2[i], shape1.getVertecies(),shape1.getPos());
			Projection p2 = Vector2f.getProjection(axis2[i], shape2.getVertecies(), shape2.getPos());
		
			Vector2f oVec = p2.getOverlap(p1);
			//Checking overlapping
			if(oVec == null){
				System.out.println("NULL");
				overlapping = false;
				rsVec = null;
				break;
			}else{
				if(rsVec == null || rsVec.getLength() > oVec.getLength())
					rsVec = oVec;
				rsVecList[i] = oVec; //might be usefull
			}
						
		}
		if (rsVec != null){
			int x_M = 1;
			int y_M = 1;
			if (center_1.x > center_2.x){
				x_M *= -1;
			}
			if(center_1.y > center_2.y){
				y_M *= -1;
			}
			rsVec.set(rsVec.getX() * x_M, rsVec.getY() * y_M);
		}
		return rsVec;
	}
	
	
	

}
