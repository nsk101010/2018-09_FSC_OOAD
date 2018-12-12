package HW1.test.edu.fitchburgstate.csc7400;

/**
 * JUnit Test cases for GuitarType class  
 * @author saran
 * @version 1.0
 */


public enum GuitarType {
	Electric, Acoustic;
	public String toString()
	{
		switch(this)
		{
		case Electric:
			return "Electric";
		case Acoustic:
			return "Acoustic";
		default: throw new IllegalArgumentException();
		
		}
	}

}
