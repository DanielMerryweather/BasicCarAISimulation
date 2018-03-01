
public class Network {
	
	// A
	// B   1
	// C   2   A
	// D   3   B
	// E   4   C
	
	double[][] v;

	public Network(double[][] v) {
		this.v = v;
	}
	
	public double[] pulse(double[] in){
		double[] nodes = {0,0,0,0};
		double[] out = {0,0,0};
		
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				nodes[i] += in[j]*v[i][j];
			}
		}
		
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				out[i] += nodes[j]*v[4+i][j];
			}
		}
		
		return out;
	}
	
	public Network cross(Network n){
		double[][] fn = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				double c = Math.random();
				double rn = 0.02;
				if(c < 0.02){
					fn[i][j] = Math.random()*2-1;
				}else if(c > 0.5 + rn/2){
					fn[i][j] = v[i][j];
				}else{
					fn[i][j] = n.v[i][j];
				}
				
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				double c = Math.random();
				double rn = 0.02;
				if(c < 0.02){
					fn[4+i][j] = Math.random()*2-1;
				}else if(c > 0.5){
					fn[4+i][j] = v[4+i][j];
				}else{
					fn[4+i][j] = n.v[4+i][j];
				}
			}
		}
		return new Network(fn);
	}

}
