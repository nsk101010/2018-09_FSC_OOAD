public class Guitar {

  private String serialNumber;
  private double price;
  public GuitarSpec spec;
  
  public Guitar()
  {  
  }

  public Guitar(String serialNumber, double price, Builder builder, String model, 
		  Type type, Woodtype backWood, Woodtype topWood) 
  {
    this.serialNumber = serialNumber;
    this.price = price;
    spec = new GuitarSpec(builder, model,type, backWood, topWood);
    this.spec = spec;
  }
  
 /* public Guitar(String serialNumber, double price, GuitarSpec spec) 
  {
    this.serialNumber = serialNumber;
    this.price = price;
    this.spec = spec;
  }*/
  
  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialnumber) {
	    this.serialNumber = serialnumber;
	  }
  
  public double getPrice() {
    return price;
  }
  public void setPrice(double newPrice) {
    this.price = newPrice;
  }
 public GuitarSpec getSpec()
 {
	 return spec;
 }
}


