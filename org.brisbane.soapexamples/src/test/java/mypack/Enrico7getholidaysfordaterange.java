package mypack;

import java.rmi.RemoteException;
import mypack.EnricoStub.DateType;
import mypack.EnricoStub.GetHolidaysForDateRange;
import mypack.EnricoStub.GetHolidaysForDateRangeResponse;
import mypack.EnricoStub.HolidayCollectionType;
import mypack.EnricoStub.HolidayType;


public class Enrico7getholidaysfordaterange {

	public static void main(String[] args) throws RemoteException 
	
	{
		// Creating Object Stub Class
		EnricoStub stub=new EnricoStub();
		
		//Create request object with parameters
		
		GetHolidaysForDateRange req=new GetHolidaysForDateRange();

		DateType dt1=new DateType();
		dt1.setDay(1);
		dt1.setMonth(1);
		dt1.setYear(2020);
		
		DateType dt2=new DateType();
		dt2.setDay(31);
		dt2.setMonth(12);
		dt2.setYear(2021);

		req.setFromDate(dt1);
		req.setToDate(dt2);
		req.setCountry("usa");
		req.setRegion("ca");
		req.setHolidayType("public_holiday");
		
		
		//Create response object by submitting parameterized request
		try
		{
			GetHolidaysForDateRangeResponse res=stub.getHolidaysForDateRange(req);
			HolidayCollectionType l=res.getHolidays();
			HolidayType x[]=l.getHoliday();
			for(int i=0;i<x.length;i++)
			{
				DateType dt=x[i].getDate();
				System.out.println(dt.getDay()+"-"+dt.getMonth()+
						"-"+dt.getYear()+":"+x[i].getHolidayType());
			}
		}
			catch(Exception ex)
		{
			System.out.println("No holidays in this year");
		
		}
	
}
}


	
 

