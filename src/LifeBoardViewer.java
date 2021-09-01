import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
public class LifeBoardViewer extends JFrame {
	public LifeBoardComponent scene;
	public RulesGoL r = new RulesGoL();
	
	//Edit these four to modify game board size
	public static final int xCubes = 220;
	public static final int yCubes = 120;
	public static final int xPix = 1200;
	public static final int yPix = 600;
	public static final int xCellSize = 5;
	public static final int yCellSize = 5;
	
	
	
	class Highlighter implements MouseListener{
		ActionListener l = new TimerListener();
		Timer t = new Timer(100,l);
		public void mousePressed(MouseEvent e){
			
			scene.fillUnit(e.getX(), e.getY());
		}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e){}
		public void mouseEntered(MouseEvent e){
			//scene.am.reset(scene.truFal);
			t.stop();
		}
		public void mouseExited(MouseEvent e){
			//scene.truFal = scene.am.getRandBoolean();
			t.start();
		}		
	}
	class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			runProg(scene.truFal);
		}
	}
	public LifeBoardViewer(){
		
		scene = new LifeBoardComponent(xCubes,yCubes);
		add(scene);
		
		Highlighter hl = new Highlighter();
		scene.addMouseListener(hl);
		
		setSize(xPix,yPix);
	}
	
	public void runProg(boolean[][] sceneSetter){
		for(int x = 0; x < this.xCubes;x++){
			for(int y = 0; y<this.yCubes;y++){
				boolean[] tf = scene.am.getSurrCells(x, y, sceneSetter);
				if(sceneSetter[x][y]){
					if(r.one(tf)){
						scene.cells[x][y].setColor(UnitCell.DEFAULT_COLOR);
						//scene.cells[x][y].setColor(scene.cells[x][y].getRandomColor());
						//scene.cells[x][y].setColor(Color.RED);
					}
					if(r.two(tf)){
						scene.cells[x][y].setColor(UnitCell.DEFAULT_COLOR);
						//scene.cells[x][y].setColor(scene.cells[x][y].getRandomColor());
						//scene.cells[x][y].setColor(Color.RED);
					}
					if(r.four(tf)){
						if(r.alive == 2){
							scene.cells[x][y].setColor(Color.BLUE);
							//scene.cells[x][y].setColor(scene.cells[x][y].getRandomColor());
							//scene.cells[x][y].setColor(Color.RED);
						} else {
							scene.cells[x][y].setColor(Color.RED);
							//scene.cells[x][y].setColor(scene.cells[x][y].getRandomColor());
							//scene.cells[x][y].setColor(Color.RED);
						}
					}
				} else if(!sceneSetter[x][y]){
					if(r.three(tf)){
						scene.cells[x][y].setColor(Color.YELLOW);
						//scene.cells[x][y].setColor(scene.cells[x][y].getRandomColor());
						//scene.cells[x][y].setColor(Color.RED);
					}
				}
			}
		}
		scene.repaint();
	}
}