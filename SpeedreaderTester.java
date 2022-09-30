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

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class SpeedreaderTester {

	private static WordGenerator grin;
	private static DrawingPanel panel;

	public static void main(String[] args) {

		if (args.length != 5) {
			System.out.println("Wrong number of arguments entered in command line");
			System.exit(0);
		}
		// new Word Generator
		grin = new WordGenerator(args[0]);

		// new Drawing Panel yaay!
		panel = new DrawingPanel(Integer.parseInt(args[1]), Integer.parseInt(args[2]));

		int wpm = (60000 / Integer.parseInt(args[4]));
		try {
			printStaggered(grin.next(), wpm, Integer.parseInt(args[3]));
		} catch (InterruptedException e) {
			System.err.println(e);
			Thread.currentThread().interrupt();
		}

		System.out.println("\nNumber of words: " + grin.getWordCount());
		System.out.println("\nNumber of sentences: " + grin.getSentenceCount());

	} // main

	public static void printStaggered(String str, int sleeptime, int fontsize) throws InterruptedException {

		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontsize);
		g.setFont(f);
		g.setColor(Color.BLACK);
		while (grin.hasNext()) {
			panel.clear();
			g.drawString(grin.next(), 100, 100);
			Thread.sleep(sleeptime);
		}
	} // printStaggered

}
