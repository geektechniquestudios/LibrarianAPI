package librarian;

//Created by Terry Dorsey

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement
{
	private Scanner someScanner;
	private String wordListToUse;
	private String toggleState;

	public void setWordList(String whichWordList)
	{
		wordListToUse = whichWordList;
	}

	public void setToggleState(String whichToggleState)
	{
		toggleState = whichToggleState;
	}

	public void openMemoryFile()
	{
		try
		{
			someScanner = new Scanner
			(
				new File
				(
					System.getProperty("user.dir") + "/src/memory/StateMemory.txt"
				)
			);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Opening StateMemory failed!");
		}
	}

	public String readMemoryFile()
	{
		return someScanner.nextLine();
	}

	public void writeToMemoryFile(String currentStateToggle)
	{
		try
		{
			BufferedWriter someWriter = new BufferedWriter
			(
				new FileWriter
				(
					System.getProperty("user.dir") + "/src/memory/StateMemory.txt", false
				)
			);
			someWriter.write(toggleState);
			someWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Writing to StateMemory failed!");
		}
	}

	public void openFile()
	{		try
		{
			someScanner = new Scanner
				(
					new File
					(
						System.getProperty("user.dir") + "/src/memory/" + wordListToUse
					)
				);
		}
		catch(Exception e)
		{
			System.out.println("Opening " + wordListToUse + " failed!\n Make sure you called setWordList before trying to open a file.");
		}
	}

	public ArrayList<String> readFile()
	{
		ArrayList<String> someList = new ArrayList<String>();
		while (someScanner.hasNext())
		{
		    someList.add(someScanner.nextLine());
		}
		return someList;
	}

	public void closeFile()
	{
		someScanner.close();
	}

	public void writeToFile(String newWord)
	{
		try
		{
			BufferedWriter someWriter = new BufferedWriter
				(
					new FileWriter
						(
								System.getProperty("user.dir") + "/src/memory/" + "CustomDictionary.txt", true
						)
				);
			someWriter.append("\n" + newWord);
			someWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Writing to WordBank failed!");
		}
	}

	public void writeToCustomFile(String newWord, String customFile)
	{
		try
		{
			BufferedWriter someWriter = new BufferedWriter
				(
					new FileWriter
						(
								System.getProperty("user.dir") + "/src/memory/" + customFile, true
						)
				);
			someWriter.append("\n" + newWord);
			someWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Writing to WordBank failed!");
		}
	}
	
	public void writeCleanToFile(ArrayList<String> updatedFile)
	{
		try
		{
			BufferedWriter someWriter = new BufferedWriter
				(
					new FileWriter
						(
								System.getProperty("user.dir") + "/src/memory/" + "CustomDictionary.txt", false
						)
				);

			boolean firstRun = true;
			for (String x: updatedFile)
			{
				if(firstRun == true)
				{
					someWriter.write(x);
					firstRun = false;
				}
				else
				{
					someWriter.write("\n" + x);
				}
			}
			someWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Deleting a word failed!");
		}
	}
}
