import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestInventory1 {

	@Before
	public void setUp() throws Exception {
	}

	Inventory inventory = new Inventory();
	
	/*
	 * Test AddGuitar() method
	 */
	@Test
	public void testAddGuitar() 
	{
		
		inventory.addGuitar("332211", 4999.95f, Builder.COLLINGS, "CJ", Type.ACOUSTIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.SITKA);
		 Guitar guitar1 = new Guitar();
		guitar1 = inventory.getGuitar("332211"); // Get guitar with given serial number
		String model = guitar1.getSpec().getModel(); //Get serial number of guitar fetched
		assertEquals("CJ", model); // validates the equality of expected and actual value
		
		inventory.addGuitar("442211", 2999.95f, Builder.FENDER, "CJ", Type.ACOUSTIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.ALDER);
		
		System.out.println("Testing add method:");
		for (Iterator i = inventory.guitars.iterator(); i.hasNext(); ) 
		{
		      Guitar guitar2 = (Guitar)i.next();
		      //checking if first guitar is still available after adding second guitar
		      System.out.println("Serial number of guitar " +(inventory.guitars.indexOf(guitar2)+1)+ " is " +guitar2.getSerialNumber());
		}
		
	}
	
	/*
	 * Tests GetGuitar() method
	 */
	
	@Test
	public void testGetGuitar() 
	{
		inventory.addGuitar("332211", 4999.95f, Builder.COLLINGS, "CJ", Type.ACOUSTIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.SITKA);
		Guitar guitar3 = new Guitar();
		guitar3 = inventory.getGuitar("332211"); //get a guitar with given serial number
		//we need to check if the guitar fetched from getGuitar() matches required guitar
		Guitar requiredGuitar = new Guitar("332211", 4999.95f, Builder.COLLINGS, "CJ", Type.ACOUSTIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.SITKA);
		 //System.out.println("price is" +requiredGuitar.getPrice());
		//testing the equality of expected and actual values
		assertEquals(requiredGuitar.getSerialNumber(), guitar3.getSerialNumber());
		System.out.println("Testing get method:");
		System.out.println("Serial number of the required guitar is " +requiredGuitar.getSerialNumber());
		System.out.println("Serial number of the actual guitar is " +guitar3.getSerialNumber());
		//assertTrue.guitarEquals
	}
  
	/*
	 * Tests searchGuitar() method by setting only builder value
	 */
	@Test
	public void testSearchGuitar1()
	{	
		inventory.addGuitar("552211", 2999.95f, Builder.GIBSON, "CJ", Type.ACOUSTIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.ALDER);
		inventory.addGuitar("652211", 1999.95f, Builder.GIBSON, "CJ", Type.ACOUSTIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.CEDAR);
		inventory.addGuitar("752211", 8999.95f, Builder.FENDER, "CJ", Type.ACOUSTIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.CEDAR);
		GuitarSpec whatErinLikes = new GuitarSpec();
	    whatErinLikes.setBuilder(Builder.GIBSON);
	    whatErinLikes.setModel("");
	    List<Guitar> MatchedGuitars = new LinkedList<>();    
	    MatchedGuitars= inventory.search(whatErinLikes);
	    System.out.println("Testing search method:");
	    if (!MatchedGuitars.isEmpty()) 
	    {
	      System.out.println("Size of the guitars list is " +MatchedGuitars.size());
	      assertEquals(2,MatchedGuitars.size());
	    }
	}
	
	/*
	 * Tests searchGuitar() method by setting only builder value
	 */
	
	@Test
	public void testSearchGuitar2()
	{	
        
		inventory.addGuitar("752211", 8999.95f, Builder.FENDER, "CJ", Type.ACOUSTIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.CEDAR);
		
		GuitarSpec whatErinLikes = new GuitarSpec();
	    whatErinLikes.setBuilder(Builder.FENDER);
	    whatErinLikes.setModel("");
	    List<Guitar> MatchedGuitars = new LinkedList<>();    
	    MatchedGuitars= inventory.search(whatErinLikes);
	    System.out.println("Testing second search method:");
	    if (!MatchedGuitars.isEmpty()) 
	    {
	      System.out.println("Size of the guitars list is " +MatchedGuitars.size());
	      assertEquals(1,MatchedGuitars.size());
	    }
	}
	/*
	 * Tests searchGuitar() method by setting only Type value
	 */
	
	
	@Test
	public void testSearchGuitar3()
	{	
        
		inventory.addGuitar("152211", 8999.95f, Builder.FENDER, "CJ", Type.ELECTRIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.CEDAR);
		inventory.addGuitar("52211", 8999.95f, Builder.FENDER, "CJ", Type.ELECTRIC,
                Woodtype.INDIAN_ROSEWOOD, Woodtype.SITKA);
		
		GuitarSpec whatErinLikes = new GuitarSpec();
	    whatErinLikes.setType(Type.ELECTRIC);
	    //whatErinLikes.setModel("");
	    List<Guitar> MatchedGuitars = new LinkedList<>();    
	    MatchedGuitars= inventory.search(whatErinLikes);
	    System.out.println("Testing Third search method:");
	    if (!MatchedGuitars.isEmpty()) 
	    {
	      System.out.println("Size of the guitars list is " +MatchedGuitars.size());
	      assertEquals(2,MatchedGuitars.size());
	    }
	}
	
	/*
	 * Tests searchGuitar() method by giving specifications
	 */
	
	
	@Test
	public void testSearchGuitar4()
	{	
        
		inventory.addGuitar("3211", 8999.95f, Builder.FENDER, "stratocastor", Type.ELECTRIC,
                Woodtype.ALDER, Woodtype.ALDER);
		inventory.addGuitar("2211", 8999.95f, Builder.FENDER, "stratocastor", Type.ELECTRIC,
                Woodtype.ALDER, Woodtype.ALDER);
		
		GuitarSpec whatErinLikes = new GuitarSpec();
	    whatErinLikes.setType(Type.ELECTRIC);
	    whatErinLikes.setModel("Stratocastor");
	    whatErinLikes.setBackWood(Woodtype.ALDER);
	    whatErinLikes.setTopWood(Woodtype.ALDER);
	    whatErinLikes.setBuilder(Builder.FENDER);
	    List<Guitar> MatchedGuitars = new LinkedList<>();    
	    MatchedGuitars= inventory.search(whatErinLikes);
	    System.out.println("Testing Fourth search method:");
	    if (!MatchedGuitars.isEmpty()) 
	    {
	      System.out.println("Size of the guitars list is " +MatchedGuitars.size());
	      assertEquals(2,MatchedGuitars.size());
	    }
	}
	
}

