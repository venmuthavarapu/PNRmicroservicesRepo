package mypack;

import java.math.BigInteger;
import java.rmi.RemoteException;
import mypack.EnricoStub.GetHolidaysForMonth;
import mypack.EnricoStub.GetHolidaysForMonthResponse;
import mypack.EnricoStub.HolidayCollectionType;
import mypack.EnricoStub.HolidayType;


public class Enrico5getholidaysformonth {

	public static void main(String[] args) throws RemoteException 
	
	{
		// Creating Object Stub Class
		EnricoStub stub=new EnricoStub();
		
		//Create request object with parameters
		/*DateType dt=new DateType();
		dt.setDay(6);
		dt.setMonth(7);
		dt.setYear(2020);*/
				
		GetHolidaysForMonth req=new GetHolidaysForMonth();
		Integer m=new Integer(11);
		BigInteger bm=BigInteger.valueOf(m);
		req.setMonth(bm);
		Integer y=new Integer(2020);
		BigInteger by=BigInteger.valueOf(y);

		req.setYear(by);
		req.setCountry("usa");
		req.setRegion("mn");
		req.setHolidayType("public_holiday");
		
		
		//Create response object by submitting parameterized request
		try
		{
			GetHolidaysForMonthResponse res=stub.getHolidaysForMonth(req);
			HolidayCollectionType l=res.getHolidays();
			HolidayType x[]=l.getHoliday();
			for(int i=0;i<x.length;i++)
			{
				System.out.println(x[i].getDate().getDay()+":"+x[i].getHolidayType());

			}
		}
			catch(Exception ex)
		{
			System.out.println("No holiday for the given month");
		
		}
	}
}

	

	
 

