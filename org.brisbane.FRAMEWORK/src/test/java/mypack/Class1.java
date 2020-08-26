package mypack;
import org.testng.Assert;  
import org.testng.annotations.Listeners;  
import org.testng.annotations.Test;

@Listeners
public class Class1   
{  
@Test  
public void sum()  
{  
int sum=0;  
int a=5;  
int b=7;  
sum=a+b;  
System.out.println(sum);  
}  
@Test  
public void testtofail()  
{  
System.out.println("Test case has been failed");  
Assert.assertTrue(false);  
}  
}   