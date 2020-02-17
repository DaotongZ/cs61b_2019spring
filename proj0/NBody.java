public class NBody{


	public static double readRadius(String file){
		In in = new In(file);

		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();

		return secondItemInFile;
	}

	public static Body[] readBodies(String file){
		
		Body[] array = new Body[5];
		In in = new In(file);

		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		
		
		

		for(int i=0;i<5;i++){
			array[i] = new Body(in.readDouble(),in.readDouble(),
				in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
			

		}

		return array;




	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = NBody.readRadius(filename);
		Body[] planets = NBody.readBodies(filename);

		String backgroundimage = "images/starfield.jpg";
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 100);
		StdDraw.picture(50, 50, backgroundimage);
		StdDraw.show();
		StdDraw.pause(2000);




	}
}