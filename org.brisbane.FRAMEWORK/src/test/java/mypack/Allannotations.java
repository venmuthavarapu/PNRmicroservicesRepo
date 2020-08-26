package mypack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class Allannotations 

{
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("BeforeTest");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("BeforeMethod");
	}
	@Test
	public void Test()
	{
		System.out.println("Test");
	}
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("AfterMethod");
	}
	@Test(priority=2)
	public void TestC2()
	{
		System.out.println("Test Case2");
	}
	
	
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("AfterClass");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("AfterSuite");
	}
	
	@Test(priority=1)
	public void TestC1()
	{
		System.out.println("TestCase 1");
	}
	
	
	
}

