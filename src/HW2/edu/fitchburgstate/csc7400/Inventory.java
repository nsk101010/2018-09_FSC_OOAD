/* Class		 : Object-Oriented Design and Analysis
* Professor  : Orlando Montalvo
* Assignment : HW2 
* Students	 : @saran 
* Date		: 2018-09-03
*/

package HW2.edu.fitchburgstate.csc7400;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Inventory  Class keeps a searchable collection of Guitars. It is meant to be use
 * to find matching guitars for customers. 
 */
public class Inventory {
  private List<Guitar> guitars = new LinkedList<Guitar>();
  
  /*Provide serialNumber,price,builder,model,type,backWood and topWood to add a guitar
  Adds a new guitar by providing serialNumber,price,builder,model,type,backWood and topWood*/
  
  			

  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) 
  {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  /*Search by Guitar using Guitar object with parameter(builder,model,type,backWood and topWood) 
  * the values must be first passed into guitar class and get the guitar object first
  * @param searchGuitar
  * @return Guitar or null */
  
  public Guitar search(Guitar searchGuitar) 
  {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equalsIgnoreCase(guitar.getManufacturer())))//It compares  manufacturer name with no case sensitivity
        continue;
    
      String model = searchGuitar.getModel();
      
      if ((model != null) && (!model.equals("")) &&
          (!model.equalsIgnoreCase(guitar.getModel())))//It compares model without case sensitivity
        continue;
      
      String type = searchGuitar.getType();
      if ((type != null) && (!searchGuitar.equals("")) &&
          (!type.equalsIgnoreCase(guitar.getType())))//It compares the type without the case sensitivity
        continue;
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equalsIgnoreCase(guitar.getBackWood())))//It compares the backwood ignoring  case
        continue;
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equalsIgnoreCase(guitar.getTopWood())))//it compares the the topwood ignoring the case
        continue;
      return guitar;
    }
    return null;
  }
}
