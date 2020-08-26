package mypack;

import java.rmi.RemoteException;

import mypack.EnricoStub.DateType;
import mypack.EnricoStub.LocalizedStringType;
import mypack.EnricoStub.WhereIsPublicHoliday;
import mypack.EnricoStub.WhereIsPublicHolidayCountryListType;
import mypack.EnricoStub.WhereIsPublicHolidayResponse;
import mypack.EnricoStub.WhereIsPublicHolidayType;


public class Enrico2whereispublicholiday {

	public static void main(String[] args) throws RemoteException 
	
	{
		// Creating Object Stub Class
		EnricoStub stub=new EnricoStub();
		
		//Create request object with parameters
		DateType dt=new DateType();
		dt.setDay(2);
		dt.setMonth(5);
		dt.setYear(2020);
		WhereIsPublicHoliday req=new WhereIsPublicHoliday();
		req.setDate(dt);
		
		//Create response object by submitting parameterized request
		WhereIsPublicHolidayResponse res=stub.whereIsPublicHoliday(req);
		WhereIsPublicHolidayCountryListType l=res.getCountryList();
		//........
		try
		{
			WhereIsPublicHolidayType[] c=l.getCountry();
			for(int i=0;i<c.length;i++)
			{
				System.out.println(c[i].getCountryFullName()+":Country Holiday List as follows");
				LocalizedStringType[] ls=c[i].getHolidayName();
				int n=ls.length;
				for(int j=0;j<n;j++)
				{
					System.out.println(ls[j].getText());
				}
				
				System.out.println();
			}	
		}
		catch(Exception ex)
		{
			System.out.println("No holiday for the given date:For all Supported Countries");
		}
	}
}

	
 

