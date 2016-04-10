package style;

public enum ContainerLayout {
	
	FLOW,
	GRID,
	STACK,
	CAROUSEL;
	
	public static final String getLayoutOf(ContainerLayout layout){
		switch(layout){
		case FLOW:
			return "flowLayout";
			
		case GRID:
			return "gridLayout";
			
		case STACK:
			return "stackLayout";
			
		case CAROUSEL:
			return "carouselLayout";
			
		default:
			System.out.println("Invalid ContainerLayout value of: "+layout);
			return null;
		}
	}

}
