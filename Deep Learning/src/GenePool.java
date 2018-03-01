import java.awt.Graphics2D;
import java.util.ArrayList;

public class GenePool {

	ArrayList<Gene> genes;
	
	public GenePool(int n){
		this.genes = new ArrayList<Gene>();
		for(int i=0;i<n;i++){
			this.genes.add(new Gene());
		}
	}
	
	public GenePool(GenePool ogp){
		this.genes = new ArrayList<Gene>();
		ogp.perc();
		for(int i=0;i<ogp.genes.size();i++){
			double ra = Math.random();
			double rb = Math.random();
			Gene a = null;
			Gene b = null;
			for(int j=0;j<ogp.genes.size();j++){
				ra -= ogp.genes.get(j).perc;
				if(ra <=0){
					a = ogp.genes.get(j);
					break;
				}
			}
			for(int j=0;j<ogp.genes.size();j++){
				rb -= ogp.genes.get(j).perc;
				if(rb <=0){
					b = ogp.genes.get(j);
					break;
				}
			}
			while(a==b){
				rb = Math.random();
				for(int j=0;j<ogp.genes.size();j++){
					rb -= ogp.genes.get(j).perc;
					if(rb <=0){
						b = ogp.genes.get(j);
						break;
					}
				}
			}
			Network nn = a.n.cross(b.n);
			Gene ng = new Gene(nn.v);
			ng.dead = false;
			this.add(ng);
		}
		ogp.genes.clear();
	}
	
	public void next(){
		this.perc();
		
		ArrayList<Gene> ngns = this.genes;
		
		for(int i=0;i<this.genes.size();i++){
			double ra = Math.random();
			double rb = Math.random();
			int a = 0;
			int b = 0;
			for(int j=0;j<this.genes.size();j++){
				ra -= this.genes.get(j).perc;
				if(ra <=0){
					a = j;
					break;
				}
			}
			for(int j=0;j<this.genes.size();j++){
				rb -= this.genes.get(j).perc;
				if(rb <=0){
					b = j;
					break;
				}
			}
			while(a==b){
				rb = Math.random();
				for(int j=0;j<this.genes.size();j++){
					rb -= this.genes.get(j).perc;
					if(rb <=0){
						b = j;
						break;
					}
				}
			}
			
			Gene ng = this.genes.get(i);
			ng.n = this.genes.get(a).n.cross(this.genes.get(b).n);
			
			ngns.set(i, ng);
		}
		this.genes = ngns;
	}
	
	public void add(Gene g){
		this.genes.add(g);
	}
	
	public void calc(){
		if(this.alive()){
			for(Gene g : this.genes){
				try{
					if(!g.dead){
						g.update();
					}
				}catch(Exception e){}
			}
		}
	}
	
	public void show(Graphics2D g2d){
		for(Gene g : this.genes){
			Graphics2D ig = (Graphics2D) g2d.create();
			g.draw(ig);
			ig.dispose();
		}
	}
	
	public boolean alive(){
		boolean f = false;
		if(genes != null){
			for(Gene g : this.genes){
				if(g.dead == false){
					f = true;
				}
			}
		}
		return f;
	}
	
	public void perc(){
		double totfitt = 0;
		for(Gene g : this.genes){
			totfitt += g.cps;
		}
		for(Gene g : this.genes){
			g.perc = g.cps / totfitt;
			if(Double.isNaN(g.perc)){
				g.perc = 0;
			}
		}
	}
	
	public void close(){
		for(Gene g : genes){
			g.close();
		}
		genes.clear();
	}
	
}
