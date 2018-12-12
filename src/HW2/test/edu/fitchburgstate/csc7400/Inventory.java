import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory 
{
  public List guitars;
  public Inventory() 
  {
    guitars = new LinkedList();
  }

  public void addGuitar(String serialNumber, double price,
                        Builder builder, String model,
                        Type type, Woodtype backWood, Woodtype topWood) 
  {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
  
  public Guitar getGuitar(String serialNumber) 
  {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  
 public List<Guitar> search(GuitarSpec searchGuitar) {
	  List<Guitar> MatchedGuitars = new LinkedList<Guitar>();
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      GuitarSpec guitarspec = guitar.getSpec();
 
      if(searchGuitar.Match(guitarspec)) //passing guitarspec object created for every guitar in the list
      {
    	  MatchedGuitars.add(guitar);   //matched guitar is added to list
      }
    }
    return MatchedGuitars;
  }

 /*
  * Finds and returns guitars that matches price
  */

public List<Guitar> Searchwithprice(Guitar priceSpecification) 
{
	  List<Guitar> PriceMatchGuitars = new LinkedList<Guitar>();
  for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) 
  {
    Guitar guitar = (Guitar)i.next();
    int Result = Double.compare(priceSpecification.getPrice(),guitar.getPrice()); //variables of type double are compared with Double.compare
    if (Result == 0)              // Double.compare returns 0 if the values are equal
    {
    	PriceMatchGuitars.add(guitar);    //Adds guitars matching with given price 
    }
  }
  return PriceMatchGuitars;
}
}

