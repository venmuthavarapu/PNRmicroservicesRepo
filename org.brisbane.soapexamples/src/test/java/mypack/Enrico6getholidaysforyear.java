package mypack;

import java.math.BigInteger;
import java.rmi.RemoteException;
import mypack.EnricoStub.DateType;
import mypack.EnricoStub.GetHolidaysForYear;
import mypack.EnricoStub.GetHolidaysForYearResponse;
import mypack.EnricoStub.HolidayCollectionType;
import mypack.EnricoStub.HolidayType;


public class Enrico6getholidaysforyear {

	public static void main(String[] args) throws RemoteException 
	
	{
		// Creating Object Stub Class
		EnricoStub stub=new EnricoStub();
		
		//Create request object with parameters
		/*DateType dt=new DateType();
		dt.setDay(6);
		dt.setMonth(7);
		dt.setYear(2020);*/
				
		GetHolidaysForYear req=new GetHolidaysForYear();
		Integer y=new Integer(2020);
		BigInteger by=BigInteger.valueOf(y);

		req.setYear(by);
		req.setCountry("usa");
		req.setRegion("mn");
		req.setHolidayType("public_holiday");
		
		
		//Create response object by submitting parameterized request
		try
		{
			GetHolidaysForYearResponse res=stub.getHolidaysForYear(req);
			HolidayCollectionType l=res.getHolidays();
			HolidayType x[]=l.getHoliday();
			for(int i=0;i<x.length;i++)
			{
				DateType dt=x[i].getDate();
				System.out.println(dt.getDay()+"-"+dt.getMonth()+":"+x[i].getHolidayType());
			}
		}
			catch(Exception ex)
		{
			System.out.println("No holiday for the given year");
		
		}
	
}
}


	
 

