package com.pendu.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Stream 
{
	
	private int nbr = (int)(Math.random()*336529);
	private String txt= null;
	private int line;
	
	public Stream()
	{		
		try(FileReader readFile = new FileReader("dico.txt");
		    BufferedReader readBuffer = new BufferedReader(readFile);
			LineNumberReader readLine = new LineNumberReader(readBuffer))
		{
			
			readLine.setLineNumber(nbr);
			line = readLine.getLineNumber();
			
			for(int i = 0; i < line; i++)
			{	
				this.setTxt(readBuffer.readLine());
			}

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void setTxt(String word)
	{
		this.txt = word;
	}
	
	public String getTxt()
	{
		return this.txt;
	}

}
