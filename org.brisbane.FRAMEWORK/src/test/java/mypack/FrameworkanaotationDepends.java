package mypack;
import org.testng.annotations.Test;
public class FrameworkanaotationDepends
{
	@Test(priority=1,groups= {"smoketest"})
	public void method1()
	{
		System.out.println("connected to the Server");
	}

	   
	@Test(priority=2,dependsOnMethods={"method1"},groups={"smoketest"})
	public void method2()
	{
		System.out.println("Submit the request");
	}

	@Test(priority=3,dependsOnMethods={"method1"},groups={"smoketest"})
	public void method3()
	{
		System.out.println("Analyze Response");
	}

	   
	   
	   
   }