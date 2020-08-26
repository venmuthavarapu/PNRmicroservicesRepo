package mypack;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class FramaworkOptionalvalueMEANSdEFAULTvALUE 
{
	
	
	
	@Test
	@Parameters({"input1","input2"})
	public void method(@Optional("Ram ") String x,@Optional("Lakshmi") String y)
	{
		System.out.println(x+""+y);
	}
	}
	
