package com.bskyb.internettv.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bskyb.internettv.context.InternetTVContext;
import com.bskyb.internettv.impl.ParentalControlServiceImpl;
import com.bskyb.internettv.parental_control_service.ParentalControlService;

/**
 * MainApp class is the main class used to intialize SpringContext and 
 * intialize ParentalControlService Interface; 
 * @author Prasad Ramalingam
 *
 */
public class MainApp {
	
	public static void main(String args[]){
		ApplicationContext context = new AnnotationConfigApplicationContext(
				InternetTVContext.class);
		
		ParentalControlService pcs = (ParentalControlServiceImpl) context.getBean("parentalControlServiceImpl");
	    try {
			System.out.println(pcs.canWatchMovie("U", "M101"));;
			System.out.println(pcs.canWatchMovie("U", "M104"));;
			
			// Error scenarios
			//System.out.println(pcs.canWatchMovie("18", "M104333"));;	    	
			//System.out.println(pcs.canWatchMovie("UD", "M104"));;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    ((ConfigurableApplicationContext)context).close();
	}	

}
