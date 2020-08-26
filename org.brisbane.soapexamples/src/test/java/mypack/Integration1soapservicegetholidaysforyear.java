package mypack;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;

import mypack.EnricoStub.DateType;
import mypack.EnricoStub.GetHolidaysForYear;
import mypack.EnricoStub.GetHolidaysForYearResponse;
import mypack.EnricoStub.HolidayCollectionType;
import mypack.EnricoStub.HolidayType;


public class Integration1soapservicegetholidaysforyear {

	public static void main(String[] args) throws RemoteException 
	
	{
		// Creating Object Stub Class
		EnricoStub stub=new EnricoStub();
		//	
		GetHolidaysForYear req=new GetHolidaysForYear();
		Integer y=new Integer(2022);
		BigInteger by=BigInteger.valueOf(y);
		//
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
			ArrayList<String> soapres=new ArrayList<String>();
			for(int i=0;i<x.length;i++)
			{
				DateType dt=x[i].getDate();
				//System.out.println(dt.getDay()+"-"+dt.getMonth()+":"+x[i].getHolidayType());
				
				if(dt.getMonth()<10 && dt.getDay()<10)
				{
					soapres.add(dt.getYear()+"-0"+dt.getMonth()+"-0"+dt.getDay());
				}
				else if(dt.getMonth()<10 && dt.getDay()>10)
				{
					soapres.add(dt.getYear()+"-0"+dt.getMonth()+"-"+dt.getDay());
				}
				else if(dt.getMonth()>=10 && dt.getDay()<10)
				{
					soapres.add(dt.getYear()+"-"+dt.getMonth()+"-0"+dt.getDay());
				}
				else 
				{
					soapres.add(dt.getYear()+"-"+dt.getMonth()+"-"+dt.getDay());
				}
				System.out.println(soapres.get(i));
				
			
			}
		}
			catch(Exception ex)
		{
			System.out.println("No holiday for the given year");
		
		}
	
}
}


	
 

