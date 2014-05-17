package youtube.aborysa.game.Math.geometrics;

public class polyShape {
	Point2f[] vertecies; 
	
	public polyShape(Point2f[] vertecies){
		this.vertecies = vertecies;
	}
	
	public Point2f[] getVertecies(){
		return vertecies;
	}
	public Vector2f[] getNormals(boolean normalize){
		Vector2f[] edges = getEdges();
		Vector2f[] normals = new Vector2f[edges.length];
		for(int i=0; i < normals.length;i++){
			normals[i] = new Vector2f(-edges[i].getY(),edges[i].getX());
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
	
	
	

}
