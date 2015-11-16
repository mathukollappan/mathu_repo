package com.interview.intergallectic.InputReceiver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReceiver 
{
	private EventHandler inputReceiver = null;
	
	public void init()
	{
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream("C:/Users/mathuk/Desktop/input.txt"));
			while(scanner.hasNextLine())
			{
				String text = scanner.nextLine();
				System.out.println(text);
				inputReceiver.inputReceived(text);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
		
		
	}
	public void addInputEventListener(EventHandler inputReceiver)
	{
		this.inputReceiver = inputReceiver;
	}
}
