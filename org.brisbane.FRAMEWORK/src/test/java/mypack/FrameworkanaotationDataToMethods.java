package mypack;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FrameworkanaotationDataToMethods
{
	@DataProvider(name="data")
	public Object[][] method1(Method m)
	{
	 if(m.getName().equalsIgnoreCase("method2"))
	{
		 return new Object[][] {
			 		{12,34,45},
			 		{21,43,65}
				 };
	}
	 else
	 {
		 return new Object[][]
				 {
			 {"abdul","kalam","Apj"},
			 {"dhoni","ms","india"}
				 };
	 }
	}
	
	@Test(priority=1,dataProvider= "data")
	public void method2(int x,int y,int z)
	{
		int w=x+y+z;
		System.out.println(w);
	}

	@Test(priority=2,dataProvider= "data")
	public void method3(String x,String y,String z)
	{
		String w=x+" "+y+" "+z;
		System.out.println(w);
	}
}

	