
public enum Type
  {
	  ELECTRIC,
	  ACOUSTIC;
	  
	  public String toString() {
		  switch(this) {
		  case ACOUSTIC: return "acoustic";
		  case ELECTRIC: return "electric";
		  default: throw new IllegalArgumentException();
		  }
	  }
  }

