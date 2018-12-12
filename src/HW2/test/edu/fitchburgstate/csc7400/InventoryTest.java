package HW1.edu.fitchburgstate.csc7400;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory keeps a searchable collection of Guitars. It is meant to be use to
 * find matching guitars for customers.
 * 
 * @author orlando
 * @version 2.0
 */
public class Inventory {
	private List<Guitar> guitars = new LinkedList<Guitar>();

	/*
	 * Constructor Inventory initialized here. serialNumber is manufacturer serial
	 * number price is store price builder is Guitar's manufacturer model is
	 * manufacturers model type is the type of guitar whether it is electric or
	 * acoustic backWood the type of wood used for guitar body topWood the type of
	 * wood used for guitars face
	 */

	public void addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood,
			String topWood) {
		Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
		guitars.add(guitar);
	}

	/*
	 * serialNumber is serial number of Guitar This method returns guitar that has
	 * input serial number
	 */

	@SuppressWarnings("rawtypes")
	public Guitar getGuitar(String serialNumber) {
		for (Iterator i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	/**
	 * Loops through the linked list of guitars to search a type of guitar.
	 * 
	 * @params Guitar
	 * @return Single Guitar
	 */
	public List<Guitar> search(GuitarSpec searchGuitar) {
		List<Guitar> matchedList = new LinkedList<Guitar>();
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (searchGuitar.matchedGuitar(searchGuitar))
				matchedList.add(guitar);
		}
		return matchedList;
	}

	/**
	 * Loops through the linked list of guitars to search a price matched guitars.
	 * 
	 * @params price
	 * @return Price matched guitars
	 */
	public List<Guitar> searchGuitarsByPrice(double price) {
		List<Guitar> priceMatchSearch = new LinkedList<Guitar>();
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if (guitar.getPrice() == price) {
				priceMatchSearch.add(guitar);
			}
		}
		return priceMatchSearch;
	}

	public void addGuitar(String serialNumber, double price, GuitarBuilder guitarBuilder, String guitarModel,
			TypeOfGuitar guitarType, TypeOfWood guitarBackWood, TypeOfWood guitarTopWood) {
		// TODO Auto-generated method stub
		
	}

}

