# Disclaimer

---

This is from my early Java days, so... **this is basically digital garbage** but hey, it might serve you well if you need to work with a list of words.

---

# LibrarianAPI 
##### Java 1.8

I made this with the intent to drastically reduce FileIO verbosity in Java when working with lists of words. This tool has a built in word list with almost 1000 words as well as tools to manipulate word lists. The best uses for these tools are games that use random words, like crosswords, wordsearches, hangman, boggle, pictionary, and it could easily be adapted to Scrabble. All this code assumes words are separated by a new line. If anyone wants a longer word list, I would be happy to find one and add it to this project. Just drop me a line.

<br/>
Oh yeah, and this project contains a prototype for remembering the states of toggles when an application is closed.
<br/>
<br/>

## How to use
You can copy the packages from this repo and paste them into your project's src folder, or import the .jar located at the root of this project. If you import the .jar, you will still need to add the package called "memory" to your project under src.

<br/>
<br/>
<br/>

## You can get a random String from a .txt based list

By doing what's below, you can get a random word from the most recently assigned list. If you don't choose a list, if will default to the DefaultDictionary.txt file.

```
FileTools.getRandomWord();
```

If you want to use your own word list, or the "CustomDictionary.txt" included, you can use

```
FileTools.setWordList(String whichWordList);
```

where "whichWordList" is the name of your .txt file containing the list. Or you can pass the name of the .txt file located in your package called "memory" as a parameter to do it in one step

```
FileTools.getRandomWord(String whichWordList);
```
where whichWordList is the .txt file from which you would like to get a random word.

<br/>
<br/>
<br/>

## You can add words to your custom dictionary, or any other list

To add words to your word list use
```
FileTools.writeNewWord(String wordToAdd);
``` 
By default, this will write to your CustomDictionary.txt file. If you want to write to a different file, you can just add the filename as a  parameter in place of whichWordList like below
```
FileTools.writeNewWord(String wordToAdd, String whichWordList);
```
<br/>
<br/>
<br/>

## You can get the contents of the list in an ArrayList format

Say you have a JList object for swing that needs to populated, or you want an ObservableList<String> from a .txt file for javafx, this makes getting words from the file to the list so easy, it's just one line. This returns an ArrayList<String>.
  
```
FileTools.getRandomWordArrList();
```
The above will return the most recently assigned list that was set. You can set a word list to use by doing

```
FileTools.setWordList(String whichWordList);
```
If you do not set a word list at any point prior to using this line, you will assign the DefaultDictionary.txt file included in this repo. However, if you would like to set a word list in the same line that you summon a random word, you can use this overloaded version belowI

```
FileTools.getRandomWordArrList(String whichWordList);
```
where whichWordList is the .txt file you want to get a random word from.

<br/>
<br/>
<br/>

## You can delete words by index

This is really nice, because getting the selected index of a list element from a swing or javafx application is easy. You can just do 

```
.getSelectionModel().getSelectedIndex();
```
to your element.

You can delete words by doing 
```
FileTools.deleteWord(int indexOfWordToDelete);
```
By default, it will refer to the most recently assigned list. If one hasn't been assigned, CustomDictionary.txt will be used. You can set the file to reference by calling  

```
FileTools.setWordList();
```
or by passing the word list to use as a parameter like below

```
FileTools.deleteWord(int indexOfWordToDelete, String whichWordList)
```
where whichWordList is the .txt file you want to refer to.

<br/>
<br/>
<br/>

## You can maintain toggle states for your menus

I wanted users' choices to be remembered so they wouldn't have to keep going into options menus, so I made a technique for that, but it only works for one element currently. If anyone is interested in this, I will develop it more. I may do it for my own reasons in the future.
<br/>
You can get the saved state of a toggle by doing 

```
FileTools.getToggleState();
```
it will return a boolean of true or false based on whether the toggle's last save was on or off respectively.

<br/>

You can also set the toggle state of that same file by doing

```
FileTools.setToggleState(boolean toggleState);
```

The above method will return "toggleOn" or "toggleOff"

I hope this helps someone out there.
