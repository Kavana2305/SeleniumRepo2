package Generic_utility;

import java.util.Random;

public class Java_utility {

	
       public int getRandomNum()
       {
    	Random ran=new Random();
	        
   	    int ranNumb = ran.nextInt(1000);
   	    return ranNumb;
       }
	}


