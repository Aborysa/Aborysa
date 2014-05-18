package youtube.aborysa.game.Math.geometrics;

public class polyCircle extends polyShape{

	public polyCircle(int radius, int edgCount, Point2f pos) {
		super(new Point2f[edgCount], pos);
		for(int i=0; i<vertecies.length;i++){
			vertecies[i] = new Point2f((float)(radius*(Math.cos(Math.PI*2*i/edgCount))),(float)(radius*(Math.sin(Math.PI*2*i/edgCount))),false);	
			System.out.println(vertecies[i]);
		}
		//System.exit(0);
	}

}
