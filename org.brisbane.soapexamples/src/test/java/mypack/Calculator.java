package mypack;

import java.rmi.RemoteException;

import mypack.CalculatorStub.Add;
import mypack.CalculatorStub.AddResponse;
import mypack.CalculatorStub.Divide;
import mypack.CalculatorStub.DivideResponse;
import mypack.CalculatorStub.Multiply;
import mypack.CalculatorStub.MultiplyResponse;
import mypack.CalculatorStub.Subtract;
import mypack.CalculatorStub.SubtractResponse;

public class Calculator 
     {

	public static void main(String[] args) throws RemoteException 
	
	{
		CalculatorStub stub=new CalculatorStub();

		Add req1=new Add();
		req1.setIntA(45);
		req1.setIntB(55);
		AddResponse res1=stub.add(req1);
	   	System.out.println(res1.getAddResult());
	
		Subtract req2=new Subtract();
		req2.setIntA(45);
		req2.setIntB(55);
		SubtractResponse res2=stub.subtract(req2);
	   	System.out.println(res2.getSubtractResult());
	   	
		Multiply req3=new Multiply();
		req3.setIntA(3);
		req3.setIntB(5);
		MultiplyResponse res3=stub.multiply(req3);
	   	System.out.println(res3.getMultiplyResult());
	
		Divide req4=new Divide();
		req4.setIntA(3);
		req4.setIntB(5);
		DivideResponse res4=stub.divide(req4);
	   	System.out.println(res4.getDivideResult());
	}

}
