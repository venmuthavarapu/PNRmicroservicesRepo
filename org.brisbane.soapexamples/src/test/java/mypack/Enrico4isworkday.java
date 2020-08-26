package mypack;

import java.rmi.RemoteException;
import mypack.EnricoStub.DateType;
import mypack.EnricoStub.IsWorkDay;
import mypack.EnricoStub.IsWorkDayResponse;
import mypack.EnricoStub.IsWorkDayType;

public class Enrico4isworkday {

	public static void main(String[] args) throws RemoteException 
	
	{
		// Creating Object Stub Class
		EnricoStub stub=new EnricoStub();
		
		//Create request object with parameters
		DateType dt=new DateType();
		dt.setDay(6);
		dt.setMonth(7);
		dt.setYear(2020);
				
		IsWorkDay req=new IsWorkDay();
		req.setDate(dt);
		req.setCountry("usa");
		req.setRegion("nj");
		
		
		//Create response object by submitting parameterized request
		IsWorkDayResponse res=stub.isWorkDay(req);
		IsWorkDayType l=res.getIsWorkDay();
		boolean b=l.getIsWorkDay();
		//........
		if(b)
			{
			System.out.println(" Yes,It is Working day");
			}		   
	    else
			{
			System.out.println("No,It isnot Working day");
			}
	}
}

	
 

