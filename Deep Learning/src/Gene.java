import java.awt.Graphics2D;
import java.util.ArrayList;

public class Gene {
	
	Ray[] rays = {null,null,null,null,null};
	
	Car c = new Car(550, 150, 0, 0);
	
	int raynum = 5;
	
	int framesleft = 180;
	int fitness = 0;
	double check = 30;
	int cps = 0;
	boolean dead = false;
	
	double perc = 0;
	
	int pos = 1;
	
	Network n;

	static ArrayList<Line> cls = new ArrayList<Line>();
	
	Shape carb;
	
	public Gene(double[][] d) {
		n = new Network(d);
		
		cls.addAll(Main.oLane.toLines());
		cls.addAll(Main.iLane.toLines());
		for(int i=0;i<raynum;i++){
			rays[i] = new Ray(100, cls);
			rays[i].check((int)c.x, (int)c.y, c.rot);
		}
	}
	
	public Gene() {
		
		cls.addAll(Main.oLane.toLines());
		cls.addAll(Main.iLane.toLines());
		double[][] rn = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				rn[i][j] = Math.random()*2-1;
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				rn[4+i][j] = Math.random()*2-1;
			}
		}
		n = new Network(rn);
		
		for(int i=0;i<raynum;i++){
			rays[i] = new Ray(100, cls);
			rays[i].check((int)c.x, (int)c.y, c.rot);
		}
	}
	
	public void update(){
		if(dead){
			return;
		}else{
			fitness++;
			framesleft--;
			if(framesleft <= 0){
				dead = true;
			}
		}
		double[] checks = {0,0,0,0,0};
		for(int i=0;i<raynum;i++){
			checks[i] = rays[i].check((int)c.x, (int)c.y, c.rot + 0.4 * (i-raynum/2));
		}
		
		double[] o = n.pulse(checks);
		
		if(check > 2){
			check -= 0.05;
		}
		
		c.update(0.5 + (o[0] - o[1]), .3+o[2]);
		
		carb = new Shape();
		carb.add(-10, 10);
		carb.add(-10, -10);
		carb.add(30, -10);
		carb.add(30, 10);
		
		for(Line l : carb.toLines()){
			l = l.rotate(c.rot);
			l.x1 += (int)c.x;
			l.y1 += (int)c.y;
			l.x2 += (int)c.x;
			l.y2 += (int)c.y;
			for(Line t : cls){
				double[] col = t.intersect(new Line(l.x1,l.y1,l.x2,l.y2));
				if(col[0] != 0){
					dead = true;
				}
			}
			for(int i=0;i<Main.oLane.verts.size();i++){
				Line nl = new Line(Main.oLane.verts.get(pos).x, Main.oLane.verts.get(pos).y, Main.iLane.verts.get(pos).x, Main.iLane.verts.get(pos).y);
				double[] col = nl.intersect(new Line(l.x1,l.y1,l.x2,l.y2));
				if(col[0] != 0){
					framesleft += (int)check;
					cps++;
					if(pos < Main.oLane.verts.size()-1){
						pos++;
					}else{
						pos = 0;
					}
					
				}
			}
		}

		//g2d.fillRect(-10, -10, 40, 20);
	}
	
	public void draw(Graphics2D g){
		
		/*for(int i=0;i<raynum;i++){
			if(!dead){
				g.drawLine(rays[i].ray.x1, rays[i].ray.y1, rays[i].ray.x2, rays[i].ray.y2);
			}
		}*/
		
		/*if(!dead){
			g.drawLine(Main.oLane.verts.get(pos).x, Main.oLane.verts.get(pos).y, Main.iLane.verts.get(pos).x, Main.iLane.verts.get(pos).y);
		}*/
		
		c.show(g);
		g.dispose();
	}
	
	public void close(){
		rays = null;
		c = null;
		raynum = 5;
		framesleft = 180;
		fitness = 0;
		check = 30;
		cps = 0;
		dead = false;
		pos = 1;
	}

}
