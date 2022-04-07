package RepositoryPackage;

import java.io.IOException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RepositoryApp{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> rep = new LinkedList<String>();
		rep.add("sample1.html"); //Pre-added sample files.
		rep.add("sample2.txt");
		rep.add("sample3.js");
		
		displayWelcomeScreen(); //Displaying Welcome Message.
		int decision = 1; //Int var. to store if User wants to continue performing operations or stop.
		do {
			featuresList(); //To display features of the program.
			int input=100;
			try {
			System.out.println("Please provide a non-decimal Numeric Input corresponding to the above available options/operations : (1, 2 or 3) to continue!");
			input = sc.nextInt();
			
			} catch(InputMismatchException e) {
				sc.nextLine();
			}
			switch(input) {
				case 1 :
					displayFiles(rep); //Method to display existing files in current directory.
					break;
				case 2 :
					repOperations(sc, rep); //Method to perform ops. in the current directory.
					break;
				case 3 :
					exitProgram(); //Method to exit the program.
					break;
				default :
					System.out.println("Oops! Looks like you provided a wrong input, please follow Input instructions specified above.");
					
			}
		continueStatements(); //Asking user's choice to continue or stop.
		try {
			decision = sc.nextInt();
			} catch (Exception e) {
				System.out.println("You have provided a wrong Input! Please follow Input Instructions.\n");
				sc.nextLine();
			}
		} while(decision == 1);
		System.out.println("Thankyou for using this program!");
	}

	public static void continueStatements() {
		System.out.println("\n");
		System.out.println("----------------------------------------------------");
		System.out.println("Do you wish to continue using the program?");
		System.out.println("Enter 1 to CONTINUE or 0 to EXIT");
		System.out.println("");
	}

	public static void exitProgram() {
		System.out.println("Exited Successfully..Thankyou for using this program!");
		System.exit(0);
	}

	public static void repOperations(Scanner sc, List<String> rep) {
		System.out.println("Please Input a numeric value for required Operations : \n");
		System.out.println("1) Add a file to the current directory - Root\\\\");
		System.out.println("2) Delete a specific file from the current directory - Root\\\\");
		System.out.println("3) Search for a specific file from the current directory - Root\\\\");
		System.out.println("4) Return to previous menu in the current directory - Root\\\\");
		int inputOp=100;
		try {
		inputOp = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("You have provided a wrong Input! Please follow Input Instructions.");
		}
		switch(inputOp) { //Second switch case to get input for specific op.
			case 1 :
				sc.nextLine();
				addFile(sc, rep); //Method to add a new file to current directory.
				break;
			case 2 :
				sc.nextLine();
				deleteFile(sc, rep); //Method to delete a file from current directory.
				break;
			case 3 :
				sc.nextLine();
				searchFile(sc, rep); //Method to search for a file in current directory.
				break;
			case 4 :
				sc.nextLine();
				featuresList(); //Redirecting to previous menu.
				break;
			default :
				System.out.println("Oops! Looks like you provided a wrong input, please follow Input instructions specified above.");
		}
	}

	public static void searchFile(Scanner sc, List<String> rep) {
		System.out.println("Please enter the name of file to be SEARCHED : [Case Sensitive]");
		String searchFile = sc.nextLine();
		if(rep.contains(searchFile)) {
			System.out.println("Success! '" + searchFile + "' : Found Successfully in Root:\\\\");
		}
		else
			System.out.println("Sorry! '" + searchFile + "' : Not Found in Root:\\\\");
	}

	public static void deleteFile(Scanner sc, List<String> rep) {
		System.out.println("Please enter the name of file to be DELETED : [Case Sensitive]");
		String deleteFile = sc.nextLine();
		if(rep.contains(deleteFile)) {
			rep.remove(deleteFile);
			System.out.println("'" + deleteFile + "' : Deleted Successfully!");
		}
		else
			System.out.println(deleteFile + " : File Not Found in Root:\\\\");
	}

	public static void addFile(Scanner sc, List<String> rep) {
		System.out.println("Please enter the name of file to be ADDED : ");
		String newFile = sc.nextLine();
		if(rep.contains(newFile))
			System.out.println("File already exists in Root:\\\\");
		else {
			rep.add(newFile);
			System.out.println("'" + newFile + "' : Added Successfully!");
		}
	}

//	public static void displayFiles(List<String> rep) {
//		System.out.println("Files in Current Directory - Root:\\\\ \n");
//		Collections.sort(rep);
//		Iterator<String> it = rep.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//	}

	public static void displayWelcomeScreen() {
		
		System.out.println("----------------------------------------------------");
		System.out.println("  WELCOME TO THE VIRTUAL KEY FOR YOUR REPOSITORIES");
		System.out.println("----------------------------------------------------");
		System.out.println("        Developed by : JAIDEEP LALCHANDANI");
		System.out.println("----------------------------------------------------");
		System.out.println("");
	}

	public static void featuresList() {
		System.out.println("FEATURES of this Program : \n");
		System.out.println("1 Display Files of Current Directory");
		System.out.println("2 Operations Menu");
//		System.out.println("2.1 ADD a File to the Existing Directory");
//		System.out.println("2.2 DELETE a File from the Existing Directory (Case Sensitive)");
//		System.out.println("2.3 Search a File in Existing Directory (Case Sensitive)");
//		System.out.println("2.4 Return to Main Context");
		System.out.println("3 Exit the program");
		System.out.println("----------------------------------------------------");
	}
	
	public static void displayFiles(List<String> rep) {
		System.out.println("Files in Current Directory : \n");
		Collections.sort(rep);
		Iterator<String> it = rep.iterator();
		System.out.printf("%15s %29s", "Directory", "File Name");
		System.out.println();
		System.out.println("----------------------------------------------------");
		while(it.hasNext()) {
			System.out.format("%14s %32s", "Root:\\\\", it.next());
			System.out.println();
			System.out.println("----------------------------------------------------");
		}
		System.out.println("Total Number Of Files Present : " + rep.size());
	}
}
