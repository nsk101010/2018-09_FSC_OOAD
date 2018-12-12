import java.util.Iterator;
public class GuitarSpec
{
private String model;
private Builder builder; 
private Type type;
private Woodtype backWood, topWood;

public GuitarSpec(Builder builder, String model, Type type,
              Woodtype backWood, Woodtype topWood)
{
	    this.builder = builder;
	    this.model = model;
	    this.type = type;
	    this.backWood = backWood;
	    this.topWood = topWood;
}

 public GuitarSpec() 
{
}
 
 /*
  * Returns the result of match
  */
 
 public Boolean Match(GuitarSpec guitarspec)
 {
	 String model1=""; 
	 //'this' refers to SearchGuitar and guitarspec refers to each guitar in inventory
	 if(this.getModel() != null && !this.getModel().equals(""))
	 {
		model1 = this.getModel().toLowerCase();    //model value is converted to string if it is not null or empty.
	 }
	 //compare all the specifications
	 if ((this.getBuilder() == null ) || (this.getBuilder() == guitarspec.getBuilder())) 
	  {if ((this.getModel() == null) || (this.getModel().equals("")) ||
	          (model1.equals(guitarspec.getModel().toLowerCase())))
	   {if ((this.getType() == null ) || (this.getType() == guitarspec.getType()))
	    {if ((this.getBackWood() == null ) || (this.getBackWood() == guitarspec.getBackWood()))
	     {if ((this.getTopWood() == null ) || (this.getTopWood() == guitarspec.getTopWood()))
	      return true;
	     }}}}
	 return false;
 }
 
  public Builder getBuilder() 
  {
    return builder;
  }
  public void setBuilder(Builder builder) 
  {
	    this.builder = builder;
  }
  public String getModel() 
  {
    return model;
  }
  public void setModel(String model) 
  {
	    this.model = model;
  }
  public Type getType() 
  {
    return type;
  }
  public void setType(Type type) 
  {
	    this.type = type;
  }
  public Woodtype getBackWood() 
  {
    return backWood;
  }
  public void setBackWood(Woodtype backWood) 
  {
	    this.backWood = backWood;
  }
  public Woodtype getTopWood() 
  {
    return topWood;
  }
  public void setTopWood(Woodtype topWood) 
  {
	    this.topWood = topWood;
  }
}

