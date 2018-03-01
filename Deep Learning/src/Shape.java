import java.awt.Point;
import java.util.ArrayList;

public class Shape {
	ArrayList<Point> verts = new ArrayList<Point>();
	
	public void add(int x, int y){
		verts.add(new Point(x,y));
	}
	
	public ArrayList<Line> toLines(){
		ArrayList<Line> lines = new ArrayList<Line>();
		for(int i=0;i<verts.size();i++){
			if(i != verts.size()-1){
				lines.add(new Line(verts.get(i).x,verts.get(i).y, verts.get(i+1).x,verts.get(i+1).y));
			}else{
				lines.add(new Line(verts.get(i).x,verts.get(i).y, verts.get(0).x,verts.get(0).y));
			}
		}
		return lines;
	}
	
}
