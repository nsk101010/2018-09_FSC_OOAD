package HW1.test.edu.fitchburgstate.csc7400;

/**
 * JUnit Test cases for WoodType class  
 * @author saran
 * @version 1.0
 */


public enum WoodType {
	
	Indian Rosewood,
	Brazilian Rosewood,
	Mahogany,
	Maple,
	Cocobolo,
	Cedar,
	Adirondack,
	Alder,
	Sitka;
	public String toString()
	{
		switch(this)
		{
		case Indian Rosewood:
			return "Indian Rosewood";
		case Brazilian Rosewood:
			return "Brazilian Rosewood";
		case Mahogany:
			return "Mahogany";
		case Maple:
			return "Maple";
		case Cocobolo:
			return "Cocobolo";
		case Cedar:
			return "Cedar";
		case Adirondack:
			return "Adirondack";
		case Alder:
			return "Alder";
		case Sitka:
			return "Sitka";
		default:throw new IllegalArgumentException();
			
		}
		
	}
	
}
