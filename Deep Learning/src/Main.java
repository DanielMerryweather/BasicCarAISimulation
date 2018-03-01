import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	
	static JFrame f = new JFrame();
	
	static Shape test = new Shape();
	static Shape test2 = new Shape();
	
	static Shape oLane = new Shape();
	static Shape iLane = new Shape();
	
	static boolean w;
	static boolean a;
	static boolean d;
	static boolean x;
	static boolean c;
	
	static double place;
	
	static Gene ai1;
	
	static GenePool gp;
	
	public static void main(String[] args) {
		
		/*Network n = new Network(new double[][]{{.3,.15,0,0,0},
											   {0,.2,.6,.2,0},
											   {.2,.2,.2,.2,.2},
											   {0,0,0,.15,.3},
											   {1,0,0,0},
											   {0,0,0,1},
											   {-.25,-.25,-.25,-.25}});*/
											   
		
		//oLane.add(500, 100);
		//iLane.add(500, 200);
		
		oLane.add(500, 100);
		oLane.add(673, 100);
		oLane.add(719, 106);
		oLane.add(773, 125);
		oLane.add(820, 161);
		oLane.add(852, 205);
		oLane.add(861, 248);
		oLane.add(860, 302);
		oLane.add(852, 346);
		oLane.add(835, 391);
		oLane.add(805, 431);
		oLane.add(761, 469);
		oLane.add(708, 489);
		oLane.add(666, 492);
		oLane.add(640, 495);
		oLane.add(612, 503);
		oLane.add(598, 514);
		oLane.add(592, 528);
		oLane.add(592, 540);
		oLane.add(597, 550);
		oLane.add(605, 557);
		oLane.add(624, 561);
		oLane.add(643, 563);
		oLane.add(669, 567);
		oLane.add(701, 571);
		oLane.add(808, 585);
		oLane.add(846, 592);
		oLane.add(877, 610);
		oLane.add(898, 631);
		oLane.add(910, 665);
		oLane.add(915, 700);
		oLane.add(907, 732);
		oLane.add(890, 760);
		oLane.add(867, 782);
		oLane.add(839, 792);
		oLane.add(732, 825);
		oLane.add(602, 850);
		oLane.add(486, 857);
		oLane.add(317, 853);
		oLane.add(212, 844);
		oLane.add(165, 833);
		oLane.add(116, 806);
		oLane.add(83, 759);
		oLane.add(67, 712);
		oLane.add(66, 655);
		oLane.add(91, 604);
		oLane.add(123, 563);
		oLane.add(183, 532);
		oLane.add(237, 521);
		oLane.add(276, 521);
		oLane.add(305, 519);
		oLane.add(352, 511);
		oLane.add(376, 495);
		oLane.add(391, 481);
		oLane.add(397, 466);
		oLane.add(402, 447);
		oLane.add(402, 410);
		oLane.add(390, 392);
		oLane.add(347, 374);
		oLane.add(320, 370);
		oLane.add(296, 371);
		oLane.add(267, 370);
		oLane.add(183, 370);
		oLane.add(111, 356);
		oLane.add(75, 334);
		oLane.add(47, 289);
		oLane.add(46, 250);
		oLane.add(68, 200);
		oLane.add(101, 171);
		oLane.add(144, 154);
		oLane.add(186, 150);
		oLane.add(241, 153);
		oLane.add(325, 152);
		oLane.add(344, 149);
		oLane.add(372, 138);
		oLane.add(411, 119);
		oLane.add(452, 107);
		iLane.add(500, 200);
		iLane.add(675, 198);
		iLane.add(703, 204);
		iLane.add(729, 213);
		iLane.add(752, 231);
		iLane.add(760, 243);
		iLane.add(763, 256);
		iLane.add(762, 294);
		iLane.add(758, 318);
		iLane.add(743, 353);
		iLane.add(723, 375);
		iLane.add(699, 391);
		iLane.add(682, 393);
		iLane.add(660, 394);
		iLane.add(624, 397);
		iLane.add(586, 407);
		iLane.add(530, 444);
		iLane.add(500, 490);
		iLane.add(492, 540);
		iLane.add(505, 588);
		iLane.add(529, 621);
		iLane.add(570, 645);
		iLane.add(617, 659);
		iLane.add(663, 665);
		iLane.add(695, 669);
		iLane.add(802, 683);
		iLane.add(810, 684);
		iLane.add(815, 688);
		iLane.add(816, 687);
		iLane.add(816, 693);
		iLane.add(817, 692);
		iLane.add(815, 694);
		iLane.add(814, 696);
		iLane.add(813, 698);
		iLane.add(803, 700);
		iLane.add(696, 733);
		iLane.add(586, 752);
		iLane.add(480, 759);
		iLane.add(319, 755);
		iLane.add(214, 746);
		iLane.add(205, 743);
		iLane.add(182, 732);
		iLane.add(167, 709);
		iLane.add(163, 690);
		iLane.add(164, 669);
		iLane.add(179, 648);
		iLane.add(195, 631);
		iLane.add(223, 622);
		iLane.add(247, 619);
		iLane.add(268, 619);
		iLane.add(315, 617);
		iLane.add(382, 605);
		iLane.add(432, 575);
		iLane.add(475, 533);
		iLane.add(493, 490);
		iLane.add(500, 443);
		iLane.add(496, 378);
		iLane.add(470, 334);
		iLane.add(405, 294);
		iLane.add(360, 280);
		iLane.add(308, 273);
		iLane.add(261, 272);
		iLane.add(185, 272);
		iLane.add(143, 262);
		iLane.add(141, 260);
		iLane.add(141, 257);
		iLane.add(144, 254);
		iLane.add(152, 252);
		iLane.add(157, 251);
		iLane.add(174, 248);
		iLane.add(186, 248);
		iLane.add(223, 251);
		iLane.add(307, 250);
		iLane.add(374, 243);
		iLane.add(428, 218);
		iLane.add(441, 213);
		iLane.add(482, 201);
		
		f.setSize(1000,1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Main());
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent m) {
				//oLane.add(f.getContentPane().getMousePosition().x + (int)(50*Math.cos(place)), f.getContentPane().getMousePosition().y + (int)(50*Math.sin(place)));
				//iLane.add(f.getContentPane().getMousePosition().x + (int)(-50*Math.cos(place)), f.getContentPane().getMousePosition().y + (int)(-50*Math.sin(place)));
			}
		});
		
		f.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_W){
					w = true;
				}
				if(k.getKeyCode() == KeyEvent.VK_A){
					a = true;
				}
				if(k.getKeyCode() == KeyEvent.VK_D){
					d = true;
				}
				if(k.getKeyCode() == KeyEvent.VK_X){
					if(x){
						x = false;
					}else{
						x = true;
					}
				}
				if(k.getKeyCode() == KeyEvent.VK_C){
					if(c){
						c = false;
					}else{
						c = true;
					}
				}
				if(k.getKeyCode() == KeyEvent.VK_P){
					for(Point p : oLane.verts){
						System.out.println("oLane.add(" + (int)p.getX() + ", " + (int)p.getY() + ");");
					}
					for(Point p : iLane.verts){
						System.out.println("iLane.add(" + (int)p.getX() + ", " + (int)p.getY() + ");");
					}
				}
				if(k.getKeyCode() == KeyEvent.VK_LEFT){
					place -= .1;
				}
				if(k.getKeyCode() == KeyEvent.VK_RIGHT){
					place += .1;
				}
			}

			@Override
			public void keyReleased(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_W){
					w = false;
				}
				if(k.getKeyCode() == KeyEvent.VK_A){
					a = false;
				}
				if(k.getKeyCode() == KeyEvent.VK_D){
					d = false;
				}
			}

			@Override
			public void keyTyped(KeyEvent k) {
			}
		});
		
		//ai1 = new Gene();
		
		gp = new GenePool(20);
		
		double st = System.currentTimeMillis();
		double dt = 1000/30;
		
		while(true){
			
			double ct = System.currentTimeMillis();
			//double ift = ct;

			if (ct >= st + dt) {
				st += dt;
			}

			if (gp.genes != null) {
				gp.calc();

				//f.repaint();

				if (!gp.alive()) {
					gp.perc();
					gp.next();

					System.gc();
				}

				f.repaint();
				
				/*ct = System.currentTimeMillis();
				if (ct < st + dt) {
				} else {
					System.out.println(ift - ct);
				}*/
			}
		}
	}
	
	public void paint(Graphics bg){
		Graphics2D g = (Graphics2D) bg;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		for(Line l : oLane.toLines()){
			g.drawLine(l.x1, l.y1, l.x2, l.y2);
		}
		
		for(Line l : iLane.toLines()){
			g.drawLine(l.x1, l.y1, l.x2, l.y2);
		}
		
		try{
			gp.show(g);
		}catch(Exception e){}
		g.dispose();
	}
}
