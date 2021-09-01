import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
public class GameOfLife {
	private JFrame board;
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){	
				new GameOfLife();
			
			}	
		});
	}
	public GameOfLife(){
		board = new LifeBoardViewer();
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setBackground(Color.BLACK);
		board.setVisible(true);
		
		initialize();
	}
	public void initialize(){
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(board.getContentPane(),popupMenu);
		
		JMenuItem mntmZoomOut = new JMenuItem("Copy");
		popupMenu.add(mntmZoomOut);
		
		JMenuItem mntmZoomIn = new JMenuItem("Paste");
		popupMenu.add(mntmZoomIn);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
}