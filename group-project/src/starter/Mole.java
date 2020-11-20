package starter;

import javax.swing.Timer;
import acm.graphics.GImage;

public class Mole{
		private SpawnPoint spawn;
		private GImage mole;
		private static final int MOLE_Y_VELOCITY = 3;
		private int timeUp;
		
		/*public Mole(MainApplication app) {
			this.program = app;
		}*/


		Mole(){
			spawn = new SpawnPoint();
			mole = new GImage("mole.jpg",spawn.getX(),spawn.getY());
		}
		
		Mole(SpawnPoint spawn){
			this.spawn = spawn;
			mole = new GImage("mole.jpg",this.spawn.getX(),this.spawn.getY());
		}
		
		Mole(int x, int y){
			spawn = new SpawnPoint(x,y);
			mole = new GImage("mole.jpg",spawn.getX(),spawn.getY());
		}
		
		//Getters and Setters
		public SpawnPoint getSpawn() {
			return spawn;
		}
		
		public GImage getMoleImage() {
			return mole;
		}
		
		public void setSpawn(SpawnPoint spawn) {
			this.spawn = spawn;
		}


}
