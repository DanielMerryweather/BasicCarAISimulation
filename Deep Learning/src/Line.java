
public class Line {
	
	int x1;
	int y1;
	int x2;
	int y2;
	
	double slope;
	double offset;

	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.calcSlope();
		this.calcOffset();
	}
	
	public void calcSlope(){
		this.slope = ((double)this.y2-(double)this.y1)/((double)this.x2-(double)this.x1);
	}
	
	public void calcOffset(){
		this.offset = this.y1 - this.slope*this.x1;
		if(Double.isNaN(this.offset)){
			this.offset = 0;
		}
	}
	
	public double[] intersect(Line l){
		if(this.slope == l.slope && (this.offset != l.offset)){
			return new double[]{0,0};
		}else{
			double x = (l.offset-this.offset)/(this.slope-l.slope);
			double y = this.slope*x+(this.y1-this.x1*slope);
			if(this.slope == 0){
				if(Double.isInfinite(l.slope)){
					y = this.y1;
					x = l.x1;
					return new double[]{x,y};
				}
				y = this.y1;
				x = (y-l.offset)/l.slope;
				//return new double[]{x,y};
				// mx+b = y
				// (y-b)/m = x
			}else if(Double.isInfinite(this.slope)){
				if(l.slope == 0){
					y = l.y1;
					x = this.x1;
					return new double[]{x,y};
				}
				x = this.x1;
				y = l.slope*x+l.offset;
				//return new double[]{x,y};
			}else if(l.slope == 0){
				y = l.y1;
				x = (y-this.offset)/this.slope;
				//return new double[]{x,y};
			}else if(Double.isInfinite(l.slope)){
				x = l.x1;
				y = this.slope*x+this.offset;
				//return new double[]{x,y};
			}
			if(this.hasWithin(x, y) && l.hasWithin(x, y)){
				return new double[]{x,y};
			}else{
				return new double[]{0,0};
			}
		}
	}
	
	public boolean hasWithin(double x, double y){
		double nx1 = this.x1;
		double ny1 = this.y1;
		double nx2 = this.x2;
		double ny2 = this.y2;
		
		if(nx1 > nx2){
			nx1 = nx2;
			nx2 = this.x1;
		}
		if(ny1 > ny2){
			ny1 = ny2;
			ny2 = this.y1;
		}
		
		if(x >= nx1 && x <= nx2){
			if(y >= ny1 && y <= ny2){
				return true;
			}
		}
		
		return false;
	}
	
	public Line rotate(double rot){
		double ang1 = Math.atan2(this.y1, this.x1);
		double ang2 = Math.atan2(this.y2, this.x2);
		double len1 = Math.sqrt(this.x1*this.x1+this.y1*this.y1);
		double len2 = Math.sqrt(this.x2*this.x2+this.y2*this.y2);
		Line l = new Line((int)(Math.cos(ang1+rot)*len1),(int)(Math.sin(ang1+rot)*len1),(int)(Math.cos(ang2+rot)*len2),(int)(Math.sin(ang2+rot)*len2));
		return l;
	}

}
