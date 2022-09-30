/*
 * Authors: Deepit
 * Assignment 4
 * Due: May 4, 2022 (Had leave due to COVID)
 * Written/Online sources used: Sources for text files listed seperately in text file
 * Help obtained: 
 * I confirm that the above list of sources is 
 * complete AND that I have not talked to anyone else 
 * about the solution to this problem
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class WordGenerator {

	private int wordcount;
	private int sentencecount;
	Scanner text;
	String current_word;

	// constructor
	public WordGenerator(String filename) {
		wordcount = 0;
		sentencecount = 0;
		try {
			text = new Scanner(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
	}

	// function to return whether text has words to process left
	public boolean hasNext() {
		if (text != null)
			return text.hasNext();
		else
			return false;
	}

	// returns the next word that is processed by text
	public String next() {
		if (hasNext()) {
			current_word = text.next();
			wordcount++;
			if (current_word.indexOf('.') != -1 || current_word.indexOf('?') != -1
					|| current_word.indexOf('!') != -1)
				sentencecount++;
		}
		return current_word;
	}

	// returns the number of words processed till now
	public int getWordCount() {
		return wordcount;
	}

	// returns the number of sentences processed till now
	public int getSentenceCount() {
		return sentencecount;
	}

}
