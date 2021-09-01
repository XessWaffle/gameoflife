
public class RulesGoL {
	/*Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	Any live cell with more than three live neighbours dies, as if by over-population.
	Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.*/
	public int alive;
	public boolean one(boolean[] tf){
		alive = numAlive(tf);
		if(alive < 2){
			return true;
		} else {
			return false;
		}
	}
	public boolean two(boolean[] tf){
		alive = numAlive(tf);
		if(alive > 3){
			return true;
		} else {
			return false;
		}
	}
	public boolean four(boolean[] tf){
		alive = numAlive(tf);
		if(alive == 2|| alive == 3){
			return true;
		} else {return false;}
	}
	public boolean three(boolean[] tf){
		alive = numAlive(tf);
		
		if(alive == 3){
			return true;
		} else {
			return false;
		}
	}
	public int numAlive(boolean[] tf){
		alive = 0;
		for(int i = 0; i < 8; i++){
			if(tf[i]){
				alive++;
			}
		}
		return alive;
	}
}
