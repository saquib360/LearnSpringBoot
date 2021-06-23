package learnjava;

 class  Comp {
		private double re, im;
		  
	    public Comp(double re, double im) {
	        this.re = re;
	        this.im = im;
	    }
	  
	    // Overriding equals() to compare two Complex objects
	    @Override
	    public boolean equals(Object o) {
	  
	        // If the object is compared with itself then return true  
	        if (o == this) {
	            return true;
	        }
	  
	        /* Check if o is an instance of Complex or not
	          "null instanceof [type]" also returns false */
	        if (!(o instanceof Comp)) {
	            return false;
	        }
	          
	        // typecast o to Complex so that we can compare data members 
	        Comp c = (Comp) o;
	          
	        // Compare the data members and return accordingly 
	        return Double.compare(re, c.re) == 0
	                && Double.compare(im, c.im) == 0;
	    }
	}
	  
	// Driver class to test the Complex class
	public class TestEquals {
	  
	    public static void main(String[] args) {
	    	Comp c1 = new Comp(10, 15);
	    	Comp c2 = new Comp(10, 17);
	        if (c1.equals(c2)) {
	            System.out.println("Equal ");
	        } else {
	            System.out.println("Not Equal ");
	        }
	    }
}
