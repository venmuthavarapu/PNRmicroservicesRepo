package mypack;

import java.rmi.RemoteException;

import mypack.EnricoStub.DateType;
import mypack.EnricoStub.GetSupportedCountries;
import mypack.EnricoStub.GetSupportedCountriesResponse;
import mypack.EnricoStub.SupportedCountriesType;
import mypack.EnricoStub.SupportedCountryType;


public class Enrico1getsupportedcountries 
     {

	public static void main(String[] args) throws RemoteException 
	
	{
		// Creating Object Stub Class
		EnricoStub stub=new EnricoStub();
		GetSupportedCountries req=new GetSupportedCountries();
		GetSupportedCountriesResponse res=stub.getSupportedCountries(req);
		
		SupportedCountriesType sct=res.getSupportedCountries();
		SupportedCountryType[] x=sct.getSupportedCountry();
		System.out.println("Count of all Supported Countries are: "+x.length);
		
		for(int i=0;i<x.length;i++)
		{
		System.out.println(x[i].getFullName()+"......."+x[i].getCountryCode());
		//........
		try
		{
			int l=x[i].getRegion().length;
			System.out.println("Regions in "+x[i].getFullName()+" are:");
			for(int j=0;j<l;j++)
			{
				System.out.print(x[i].getRegion()[j]+" \t");
			}
			System.out.println();
			
		}
		catch(Exception ex)
		{
			System.out.println("No region in "+x[i].getFullName());
		}
		//.......
		
		try
		{
			int l=x[i].getHolidayType().length;
			System.out.print("Holiday types in "+x[i].getFullName()+" are: ");
			for(int j=0;j<l;j++)
			{
				System.out.println(x[i].getHolidayType()[j]+" \t");
			}
			System.out.println();
			
		}
		catch(Exception ex)
			{
			System.out.println("No Holiday types in "+x[i].getFullName());
			}
		System.out.println();
		DateType fdt=x[i].getFromDate();
		System.out.println(fdt.getDay()+"..."+fdt.getMonth()+"..."+fdt.getYear());
		DateType tdt=x[i].getToDate();
		System.out.println(tdt.getDay()+"..."+tdt.getMonth()+"..."+tdt.getYear());
		}
		
	}
 }

