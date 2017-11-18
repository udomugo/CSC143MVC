import java.util.List;

public class TextView implements View{
	
	private DrawingModel model;
	
	@Override
	public void update(DrawingModel model) {
		// TODO Auto-generated method stub
		// Print the data describing the shapes
		this.model = model;
		List<Shape> shapes = this.model.getShapes();
		for (Shape s : shapes) {
			//System.console().flush();
			System.out.println(s);
		}
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
