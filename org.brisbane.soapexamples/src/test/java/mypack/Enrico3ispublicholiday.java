package mypack;

import java.rmi.RemoteException;
import mypack.EnricoStub.DateType;
import mypack.EnricoStub.IsHolidayType;
import mypack.EnricoStub.IsPublicHoliday;
import mypack.EnricoStub.IsPublicHolidayResponse;

public class Enrico3ispublicholiday {

	public static void main(String[] args) throws RemoteException 
	
	{
		// Creating Object Stub Class
		EnricoStub stub=new EnricoStub();
		
		//Create request object with parameters
		DateType dt=new DateType();
		dt.setDay(5);
		dt.setMonth(7);
		dt.setYear(2020);
		
		
		IsPublicHoliday req=new IsPublicHoliday();
		req.setDate(dt);
		req.setCountry("usa");
		req.setRegion("nj");
		
		
		//Create response object by submitting parameterized request
		IsPublicHolidayResponse res=stub.isPublicHoliday(req);
		IsHolidayType l=res.getIsPublicHoliday();
		boolean b=l.getIsHoliday();
		//........
		if(b)
			{
			System.out.println(" Yes,It is Publicholiday");
			}		   
	    else
			{
			System.out.println("No,It isnot Publicholiday");
			}
	}
}

	
 

