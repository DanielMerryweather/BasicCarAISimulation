import java.util.ArrayList;

public class Ray {
	
	int len;
	ArrayList<Line> lines;
	
	Line ray;

	public Ray(int len, ArrayList<Line> lines) {
		this.len = len;
		this.lines = lines;
	}
	
	public double check(int x, int y, double rot){
		ray = new Line(x,y,(int)(x+Math.cos(rot)*len),(int)(y+Math.sin(rot)*len));
		double v = 0;
		for(Line l : lines){
			double[] i = ray.intersect(l);
			if(i[0]+i[1] != 0){
				i[0] -= x;
				i[1] -= y;
				double cv = 1-Math.sqrt(i[0]*i[0]+i[1]*i[1])/len;
				if(cv>v){
					v = cv;
				}
			}
		}
		return v;
	}
	
	public void close(){
		lines.clear();
	}

}
