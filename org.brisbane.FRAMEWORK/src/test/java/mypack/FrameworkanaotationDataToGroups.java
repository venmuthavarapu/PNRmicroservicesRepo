package mypack;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FrameworkanaotationDataToGroups
{
		@DataProvider(name="testdata")
		public Object[][] datamethod(ITestContext context)
		{
		 Object[][] data=null;
		 System.out.println("No of groups are :"+context.getIncludedGroups().length);
		  //System.out.println(context.getIncludedGroups().length);
		 for(String g:context.getIncludedGroups())
		{
			 System.out.println(g) ;
			 if(g.equalsIgnoreCase("ArithmeticOperations"))
			 {
				 data=new Object[][]
					 {
				 		{"10","20"},
				 		{"30","78"}
					 };
					 break;
			 }
	 else if(g.equalsIgnoreCase("StringManipulations"))
		 {
			 data= new Object[][]
					 {
						 {"abdul","kalam"},
						 {"dhoni","ms"}
					 };
					 break;
		 }
		
		 
		 
	 else if(g.equalsIgnoreCase("StringManipulations"))
		 {
			 data= new Object[][]
					 {
						 {"abdul","kalam"},
						 {"dhoni","ms"}
					 };
					 break;
		 }
		}
		 return(data);
	} 

	@Test(groups= {"ArithmeticOperations"},dataProvider= "testdata")
	public void noSadd(String x,String y)
	{
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=a+b;
		System.out.println(c);
	}

	@Test(groups= {"ArithmeticOperations"},dataProvider= "testdata")
	public void noSsub(String x,String y)
	{
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=a-b;
		System.out.println(c);
	}
	
	@Test(groups= {"StringManipulations"},dataProvider= "testdata")
	public void stringsconcat1(String x,String y)
	{
			String z=x+y;
		System.out.println(z);
	}
	
	@Test(groups= {"StringManipulations"},dataProvider= "testdata")
	public void stringsconcat2(String x,String y)
	{
			String z=y+x;
		System.out.println(z);
	}


}

	