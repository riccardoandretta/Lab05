package it.polito.tdp.anagrammi.model;

import java.util.Scanner;

public class TestModel {

	 public static void main(String[] args)
	    {
		 	Model model = new Model();
	        System.out.println("Welcome to Anagram Maker ...");
	        System.out.println("\t... a program which uses recursion to list " +
	                           "the anagrams of a word.\n");

	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a word > ");
	        String word = scanner.next();

	        System.out.println("The anagrams of " + word + " are:");
	        System.out.println("------------------------------------");

	        model.calcolaAnagrammi(word);
	        System.out.println("\n\nThanks for using \"Anagram Maker\" -- where words " +
	                    "come to life.\n\n");
	        scanner.close();

	    }
		

}
