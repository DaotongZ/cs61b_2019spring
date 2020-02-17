public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	String imgFileName;
	static final double Gconstant = 6.67e-11;
	public Body(double xP,double yP, double xV,
		double yV,double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass  = m;
		this.imgFileName = img;
	}

	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass  = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance(Body p){
		double distance = Math.sqrt(Math.pow(this.xxPos-p.xxPos,2)+Math.pow(this.yyPos-p.yyPos,2));
		return distance;
	}

	public double calcForceExertedBy(Body p){
		double force = Gconstant*this.mass*p.mass/Math.pow(this.calcDistance(p),2);
		return force;
	}

	public double calcForceExertedByX(Body p){
		double forceX = this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
		return forceX;

	}

	public double calcForceExertedByY(Body p){
		double forceY = this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
		return forceY;
		
	}

	public void update(double time, double xforce, double yforce){
		double aX = xforce/this.mass;
		double aY = yforce/this.mass;
		this.xxVel = this.xxVel+time*aX;
		this.yyVel = this.yyVel+time*aY;
		this.xxPos = this.xxPos+time*this.xxVel;
		this.yyPos = this.yyPos+time*this.yyVel;

	}

	public class draw(){
		 s
	}
}