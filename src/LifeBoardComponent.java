import javax.swing.*;
import java.util.*;
import java.awt.*;
public class LifeBoardComponent extends JPanel {
	public UnitCell[][] cells; 
	public boolean[][] truFal;
	public ArrayMod am = new ArrayMod();
	private int xCell;
	private int yCell;
	
	public LifeBoardComponent(int xCell, int yCell){
		this.xCell = xCell;
		this.yCell = yCell;
		setCells(xCell,yCell);
		for(int x = 0; x < xCell; x++){
			for(int y = 0; y < yCell; y++){
				cells[x][y] = new UnitCell(new Rectangle(x*(LifeBoardViewer.xCellSize + 1),y*(LifeBoardViewer.yCellSize + 1),LifeBoardViewer.xCellSize, LifeBoardViewer.yCellSize), UnitCell.DEFAULT_COLOR);
			}
		}
	}
	
	public void setCells(int x, int y){
		cells = new UnitCell[x][y];
		truFal = new boolean[x][y];
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		for(int x = 0; x < xCell; x++){
			for(int y = 0; y < yCell; y++){
				g2.setPaint(cells[x][y].getColor());
				g2.fill(cells[x][y].getShape());
			}
		}
		am.prepareTruFal();
		g2.dispose();
	}
	public void fillUnit(int xPt, int yPt){
		for(int x = 0; x < xCell; x++){
			for(int y = 0; y < yCell; y++){
				if(cells[x][y].getShape().contains(xPt,yPt)){
					cells[x][y].setColor(Color.BLACK);
					repaint();
				}
			}
		}
	}
	public void fillUnit(UnitCell u, Color c){
		u.setColor(c);
	}
	
	class ArrayMod{
		public void prepareTruFal(){
			for(int x = 0; x < xCell; x++){
				for(int y = 0; y < yCell; y++){
					if(cells[x][y].isFilled()){truFal[x][y] = true;}
					else {truFal[x][y] = false;}
				}
			}
		}
		public boolean[][] getRandBoolean(){
			Random rand = new Random();
			boolean[][] randStart = new boolean[xCell][yCell];
			for(int x = 0; x < xCell; x++){
				for(int y = 0; y < yCell; y++){
					int z = rand.nextInt(100);
					if(z<=4){randStart[x][y] = true;}
					else {randStart[x][y] = false;}
				}
			}
			return randStart;
		}
		public void reset(boolean[][] tf){
			for(int x = 0; x < xCell;x++){
				for(int y = 0; y<yCell ; y++){
					tf[x][y] = false;
				}
			}
		}
		public boolean[] getSurrCells(int xArr, int yArr, boolean[][] cells){
			boolean[] trueFalse = new boolean[8];
			
			if(xArr - 1 >= 0 && yArr - 1 >= 0){
				trueFalse[0] = cells[xArr-1][yArr-1];
			} else {
				trueFalse[0] = false;
			}
			if(xArr - 1 >= 0 && yArr >= 0){
				trueFalse[1] = cells[xArr-1][yArr];
			} else {
				trueFalse[1] = false;
			}
			
			if(xArr - 1 >= 0 && yArr + 1 < yCell){
				trueFalse[2] = cells[xArr-1][yArr+1];
			} else {
				trueFalse[2] = false;
			}
			
			if(xArr >= 0 && yArr - 1 >= 0){
				trueFalse[3] = cells[xArr][yArr-1];
			} else {
				trueFalse[3] = false;
			}
			
			if(xArr >= 0 && yArr + 1 < yCell){
				trueFalse[4] = cells[xArr][yArr+1];
			} else {
				trueFalse[4] = false;
			}
			
			if(xArr + 1 < xCell && yArr - 1 >= 0){
				trueFalse[5] = cells[xArr+1][yArr-1];
			} else {
				trueFalse[5] = false;
			}
			
			if(xArr + 1 < xCell && yArr >= 0){
				trueFalse[6] = cells[xArr+1][yArr];
			} else {
				trueFalse[6] = false;
			}
			
			if(xArr + 1 < xCell && yArr + 1 < yCell){
				trueFalse[7] = cells[xArr+1][yArr+1];
			} else {
				trueFalse[7] = false;
			}
			return trueFalse;
	
		}
	}
}
