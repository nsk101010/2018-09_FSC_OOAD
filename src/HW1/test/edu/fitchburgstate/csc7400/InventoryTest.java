/* Class		 : Object-Oriented Design and Analysis
* Professor  : Orlando Montalvo
* Assignment : HW1
* Students	 : saran,vamsi 
* Date		: 2018-09-03
*/

package HW1.test.edu.fitchburgstate.csc7400;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HW1.edu.fitchburgstate.csc7400.Guitar;
import HW1.edu.fitchburgstate.csc7400.Inventory;

import org.junit.jupiter.api.Test;
/*Inventory test class test all the methods present in the inventory class it also have
 * test cases which get results with different inputs.
 * */
class InventoryTest {
	Inventory inventory;
	private List<Guitar> guitars = new LinkedList<Guitar>();
	
	/*we set up by adding guitar to a inventory before each test case run*/
	@BeforeEach
	
	void setUp() throws Exception 
	{
		
		this.inventory=new Inventory();
				
				
				
	Guitar guiter=new Guitar("V95693",
			1499.95,
			"Fender",
			"Stratocastor",
			"electric",
			"Alder",
			"Alder");
	guitars.add(guiter);
	
	inventory.addGuitar(guiter.getSerialNumber(), guiter.getPrice(), guiter.getManufacturer(),guiter.getModel() , guiter.getType(), guiter.getBackWood(), guiter.getTopWood());
				
	Guitar test=new Guitar("566-62", 8999.95, "Ryan", "Cathedral", "acoustic",
            "Cocobolo", "Cedar");
	inventory.addGuitar(test.getSerialNumber(),test.getPrice() , test.getManufacturer(), test.getModel(), test.getType(),test.getBackWood(), test.getTopWood());
		}
	@Test
	/*Testing the inventory by passing guitar with all arguments*/
	void getDetails()
	{
		Guitar test=new Guitar("76531", 6295.95, "Martin", "OM-28", "acoustic",
                        "Brazilian Rosewood", "Adriondack");
		Guitar res=inventory.search(test);
		assertEquals(test.getSerialNumber(),res.getSerialNumber());
		assertEquals(test.getPrice(),res.getPrice());
		assertEquals(test.getManufacturer(),res.getManufacturer());
		assertEquals(test.getBackWood(),res.getBackWood());
		assertEquals(test.getTopWood(),res.getTopWood());
		assertEquals(test.getType(),res.getType());
		assertEquals(test.getModel(),res.getModel());
	}
	
	/*when backwood is passed*/
	@Test
	void getBackwood()
	
	{
		Guitar test=new Guitar("", 0, "", null, null, "MyBackwood","");
		Guitar res=inventory.search(test);
		assertEquals(test.getBackWood(),res.getBackWood());
		
	}
	/*when search Topwood is passed is passed*/
	@Test
	void getTopwood()
	
	{
		Guitar test=new Guitar("", 0, "", null, null, "","MyTopwood");
		Guitar res=inventory.search(test);
		assertEquals(test.getTopWood(),res.getTopWood());
		
	}
	/*when search backwood is passed*/
	@Test
	void getBackWood()
	
	{
		Guitar test=new Guitar("", 0, "", null, null, "MyBackwood","");
		Guitar res=inventory.search(test);
		assertEquals(test.getBackWood(),res.getBackWood());
		
	}
	/*when search manufacturer  is passed*/
	@Test
	void getManufacturer()
	
	{
		Guitar test=new Guitar("", 0, "Mymanufacturer", null, null, "","");
		Guitar res=inventory.search(test);
		assertEquals(test.getManufacturer(),res.getManufacturer());
		
	}
	
	/*when search type is passed*/
	@Test
	void getType()
	
	{
		Guitar test=new Guitar("", 0, "", null, "type","","");
		Guitar res=inventory.search(test);
		assertEquals(test.getType(),res.getType());
		
	}
	/*when search seral no is passed*/
	@Test
	void getSeralno()
	
	{
		Guitar test=new Guitar("V11223", 0, "", null, null, "","");
		Guitar res=inventory.search(test);
		assertEquals(test.getSerialNumber(),res.getSerialNumber());
		
	}
	/* search by type which is not listed */
	@Test
	void SearchType()
	{
		Guitar test=new Guitar(null, 0, null, null," Mytype", null,null);
		Guitar res=inventory.search(test);
		assertEquals(null,res);
	}
	/* search by Mnaufacturer which is not listed */
	@Test
	void SearchManufacturer()
	{
		Guitar test=new Guitar(null, 0, null, "mymanufacturer", null, null,null);
		Guitar res=inventory.search(test);
		assertEquals(null,res);
	}
	/* search by topwood which is not listed */
	@Test
	void SearchTopwood()
	{
		Guitar test=new Guitar(null, 0, null, null, null, null,"MyTopWood");
		Guitar res=inventory.search(test);
		assertEquals(null,res);
	}
	/* search by backwood which is not listed */
	@Test
	void SearchBackwood()
	{
		Guitar test=new Guitar(null, 0, null, null, null, "Mybackwood",null);
		Guitar res=inventory.search(test);
		assertEquals(null,res);
	}
	/* search by model which is not listed */
	@Test
	void model()
	{
		Guitar test=new Guitar(null, 0, null, "model", null, null,null);
		Guitar res=inventory.search(test);
		assertEquals(null,res);
	}
	
}

