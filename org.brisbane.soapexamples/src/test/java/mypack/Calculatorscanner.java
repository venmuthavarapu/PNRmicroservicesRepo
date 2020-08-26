package mypack;

import java.util.Scanner;

import mypack.CalculatorStub.Add;
import mypack.CalculatorStub.AddResponse;


public class Calculatorscanner 
     {

	public static void main(String[] args) throws Exception 
	
	{
		        
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input1");
		int x=scan.nextInt();
		System.out.println("Enter input2");
		int y=scan.nextInt();
		
		
		CalculatorStub stub=new CalculatorStub();
		Add req1=new Add();
		req1.setIntA(x);
		req1.setIntB(y);
		AddResponse res1=stub.add(req1);
		int z=res1.getAddResult();
		System.out.println(z);
		
		if(z==x+y)
		{
			System.out.println("test Passed");
		}
		else
		{
		   	System.out.println("test failed");
		}
			
	}

}
