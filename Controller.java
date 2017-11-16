import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Controller implements ActionListener, ComponentListener, MouseListener{
	
	private DrawingModel model;
	
	private ArrayList<Viewer> viewers = new ArrayList<Viewer>();
	
	public Controller(DrawingModel m, Viewer v) {
		this.model = m;
		this.viewers.add(v);
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println(arg0.getActionCommand());
//		if (arg0.getActionCommand().equals("Add Level")) {
//			model.addLevel();
//			System.out.println("Add Button Pushed");
//		} else 
			if (arg0.getActionCommand().equals("Remove Level")) {
			model.removeLevel();
			System.out.println("Remove Button Pushed");
		} else if (arg0.getActionCommand().equals("Reset Shapes")) {
			model.resetShapes();
			System.out.println("Reset Button Pushed");
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Click: ( " + arg0.getX() + ", " + arg0.getY() + " )");
		ArrayList<Shape> shapes = model.getShapes(); 
		for (int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).checkClick(arg0.getX(), arg0.getY())) {
				model.addLevel(shapes.get(i));
			} else {
				System.out.println("Click not on Shape");
			}	
		}
	}
	
	
	
	
	
}
