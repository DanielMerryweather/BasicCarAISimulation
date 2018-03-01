import java.awt.Graphics;
import java.awt.Graphics2D;

public class Car {

	double x;
	double y;
	double rot;
	double speed;
	
	public Car(double x, double y, double rot, double speed) {
		this.x = x;
		this.y = y;
		this.rot = rot;
		this.speed = speed;
	}
	
	public void update(double t, double speed){
		t-=0.5;
		this.x += Math.cos(rot)*this.speed;
		this.y += Math.sin(rot)*this.speed;
		this.speed += speed;
		this.speed *= 0.95;
		this.rot += t/10;
	}
	
	public void show(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate((int)x, (int)y);
		g2d.rotate(rot);
		g2d.fillRect(-10, -10, 40, 20);
		g2d.dispose();
	}

}
