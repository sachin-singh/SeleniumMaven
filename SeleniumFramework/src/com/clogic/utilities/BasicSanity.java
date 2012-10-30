package com.clogic.utilities;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.clogic.SeleniumFramework.BasicSetUp;
import com.clogic.SeleniumFramework.ClassTest;

public class BasicSanity {
	
	String caller="";
	String description = "";
	public static void main(String[] args){
		
		BasicSetUp setUp = new BasicSetUp();
		BasicSanity san = new BasicSanity();
		try {
			setUp.setUp();
			san.readtext();
			setUp.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void readtext() throws Exception {
		ClassTest test = new ClassTest();
		test.testtest();
		
		ArrayList<String> callerId  = new ArrayList<String>();
		ArrayList<String> desc= new ArrayList<String>();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("CallerID_Mapping.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console 
				  	StringTokenizer tok = new StringTokenizer(strLine, "	");
				  	caller= tok.nextElement().toString();
				  	System.out.println(caller);
				  	
				  	description=tok.nextElement().toString();
				  	System.out.println(description);
				  	test.testtest2(caller, description);
				  	
				  	
			  }
			  //Close the input stream
			  in.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			 }
		}
		
		
	
	}

