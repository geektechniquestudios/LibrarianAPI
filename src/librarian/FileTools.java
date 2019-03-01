package librarian;

//Created by Terry Dorsey

import java.util.ArrayList;
import java.util.Random;


public class FileTools
{
	private static String wordListType;

	public static void setWordList(String whichWordList)
	{
		wordListType = whichWordList;
	}
	
	public static String getRandomWord()
	{	
		if(wordListType == null)
		{
			wordListType = "DefaultDictionary.txt";
		}
		ArrayList<String> wordBank = new ArrayList<String>();
		wordBank = FileTools.getRandomWordArrList();
		
		Random randomNumGen = new Random();
		int randomWordIndex = randomNumGen.nextInt(wordBank.size()) + 0;
		
		return wordBank.get(randomWordIndex);
	}
	
	public static String getRandomWord(String whichWordList)
	{
		setWordList(whichWordList);
		return getRandomWord();
	}
	
	public static void writeNewWord(String wordToAdd)
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.writeToFile(wordToAdd);
	}
	
	public static void writeNewWord(String wordToAdd, String whichWordList)
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.writeToCustomFile(wordToAdd, whichWordList);
	}

	public static ArrayList<String> getRandomWordArrList()
	{
		if(wordListType == null)
		{
			wordListType = "DefaultDictionary.txt";
		}
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.setWordList(wordListType);
		someFileManagement.openFile();
		ArrayList<String> arrayListToReturn = someFileManagement.readFile();
		someFileManagement.closeFile();

		return arrayListToReturn;
	}
	
	public static ArrayList<String> getRandomWordArrList(String whichWordList)
	{
		setWordList(whichWordList);
		return getRandomWordArrList(); 
	}

	public static void deleteWord(int indexOfWordToDelete)
	{
		if(wordListType == null)
		{
			wordListType = "CustomDictionary.txt";
		}
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.setWordList(wordListType);
		someFileManagement.openFile();
		ArrayList<String> listOfCurrentFile = someFileManagement.readFile();
		listOfCurrentFile.remove(indexOfWordToDelete);
		someFileManagement.writeCleanToFile(listOfCurrentFile, wordListType);
		someFileManagement.closeFile();
	}
	
	public static void deleteWord(int indexOfWordToDelete, String whichWordList)
	{
		setWordList(whichWordList);
		deleteWord(indexOfWordToDelete);
	}

	public static boolean getToggleState()
	{
		boolean boolToReturn = true;//acts as exception protection, and suppresses warnings

		FileManagement someFileManagement = new FileManagement();
		someFileManagement.openMemoryFile();
		String stateToReturn = someFileManagement.readMemoryFile();
		if(stateToReturn.equals("toggleOn"))
		{
			boolToReturn = true;
		}
		else if (stateToReturn.equals("toggleOff"))
		{
			boolToReturn = false;
		}
		
		return boolToReturn;
	}

	public static void setToggleState(boolean toggleState)
	{
		String stringToPass;
		if(toggleState)
		{
			stringToPass = "toggleOn";
		}
		else
		{
			stringToPass = "toggleOff";
		}
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.setToggleState(stringToPass);
		someFileManagement.writeToMemoryFile(stringToPass);
	}
}