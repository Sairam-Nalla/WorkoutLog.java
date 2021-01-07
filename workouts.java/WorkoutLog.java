/*
	Programmer: 	Sairam Nalla
	Purpose: 	This program allows the user to keep track of what exercises they perform, specifically: the number of reps, sets, and the amount of weight used. 
			The program allows formats the day the workouts get logged in order to be able to keep track of the user's progress overtime in the gym. All of 
			the data gets stored in a text file labaled WorkoutLog.txt 			
*/
package workouts.java;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class WorkoutLog {
	// getUserExercise takes the specific workout type and creates an object specifically for whatever body part you worked out. 
	// Once the object is created, it then gets returned to be stored in an ArrayList
	public static Exercises getUserExercise(Object obj, int reps,int sets, double weights, Scanner scnr) {
		Exercises ex = null;
		// try-catch block to ensure the user has valid input (only positive integers)
		try {
			ex = (Exercises) obj;
			// if the extercise type is specifically for bodyweight, such as pushups and dips, then 
			// only the number of reps and sets are counted since bodyweight is constant
			if (ex.getType().equalsIgnoreCase("Body Weight")) {
				System.out.print("NUMBER OF REPS: ");
				reps = scnr.nextInt();
				// a personal exception is thrown if the user tries to input a negative number
				if (reps < 1)
					throw new invalidInput(reps + " is not valid! Answer must be a positive number");
				ex.setReps(reps);
				
				System.out.print("\nNUMBER OF SETS: ");
				sets = scnr.nextInt();
				// a personal exception is thrown if the user tries to input a negative number
				if (sets < 1)
					throw new invalidInput(sets + " is not valid! Answer must be a positive number");
				ex.setSets(sets);
			}
			else {
				System.out.print("NUMBER OF REPS: ");
				reps = scnr.nextInt();
				// a personal exception is thrown if the user tries to input a negative number
				if (reps < 1)
					throw new invalidInput(reps + " is not valid! Answer must be a positive number");
				ex.setReps(reps);
				
				System.out.print("\nNUMBER OF SETS: ");
				sets = scnr.nextInt();
				// a personal exception is thrown if the user tries to input a negative number
				if (sets < 1)
					throw new invalidInput(sets + " is not valid! Answer must be a positive number");
				ex.setSets(sets);
				
				System.out.print("\nWEIGHTS(lbs): ");
				weights = scnr.nextDouble();
				// a personal exception is thrown if the user tries to input a negative number
				if (weights < 1)
					throw new invalidInput(weights + " is not valid! Answer must be a positive number");
				ex.setWeights(weights);
			}
		}catch (invalidInput inv){
			// If invalidInput exception gets thrown then the message specific to that exception class 
			// will be printed to the screen and the method will get called again to get the correct
			// response.
			System.out.println(inv);
			getUserExercise(obj, reps, sets, weights, scnr);
		}catch(InputMismatchException exp) {
			// If the user inputs anything other than an integer, then an InputMismatchException will
			// automatically get thrown by the compiler in which case this personal message will be 
			// printed to the screen and the method will get called again with a new Scanner value
			// in order to not get stuck in an infinite loop with the try-catch block
			System.out.println("ERROR: Input must be in the form of a number between 1-9!");
			getUserExercise(obj, reps, sets, weights,new Scanner(System.in));
		}
		// If the exercise is successfully logged then the object will get returned to be written in the text file later on
		return ex;
	}
	
	
	// Private class specifically for Back workouts. This class contains all of the exercises that pertain
	// to exercising the back and by calling on it you create a BackWorkouts object that will store
	// the specific workout done, the number of reps, the number of sets, and the amount of weight used
	// if the exercise is not bodyweight
	private static void BackWorkouts(ArrayList <Exercises> log, Scanner scnr) {
		int userInput;
		int reps = 0;
		int sets = 0;
		double weights = 0.0;
		int cont = 1; // cont will allow the program to exit the while loop whenever the user wants
		Back BackWorkout = new Back(); // Creating a BackWorkout object
		try{
			while (cont == 1) {
				// The printMenu() calls on the menu specific to back workouts stored in the BackWorkout Class
				BackWorkout.printMenu();
				userInput = scnr.nextInt();
				// If an integer that is not within the range 1-8 is entered, the personal exception
				// gets thrown to tell the user the data they entered is not valid and give them
				// the opportunity to re-enter the data without having to restart the program
				if (!(userInput >= 1 && userInput <= 8)) {
					throw new invalidInput(userInput + " is not one of the options");
				}
				// Switch loop is used to create an object that stores specific data based on what data the
				// user selects from the main menu. Then the getUserExercise() method is called in which 
				// the number of reps, sets, and weights are stored. Once that data is stored, we typcast
				// the object to specifically be of type BackWorkout class
				switch(userInput) {
					case 1:
						BackWorkout = (Back) getUserExercise(BackWorkout, reps, sets, weights, scnr);
						BackWorkout.setWorkout("Bent Over Rows");
						break;
					case 2:
						BackWorkout = (Back) getUserExercise(BackWorkout, reps, sets, weights, scnr);
						BackWorkout.setWorkout("Dumbell Single Arm Rows");
						break;
					case 3:
						BackWorkout = (Back) getUserExercise(BackWorkout, reps, sets, weights, scnr);
						BackWorkout.setWorkout("Seated Cable Rows");
						break;
					case 4:
						BackWorkout.setType("Body Weight");
						BackWorkout = (Back) getUserExercise(BackWorkout, reps, sets, weights, scnr);
						BackWorkout.setWorkout("Pullups");
						break;
					case 5:
						BackWorkout.setType("Body Weight");
						BackWorkout = (Back) getUserExercise(BackWorkout, reps, sets, weights, scnr);
						BackWorkout.setWorkout("Chinups");
						break;
					case 6:
						
						BackWorkout = (Back) getUserExercise(BackWorkout, reps, sets, weights, scnr);
						BackWorkout.setWorkout("Lat Pullups");
						break;
					case 7:
						BackWorkout = (Back) getUserExercise(BackWorkout, reps, sets, weights, scnr);
						BackWorkout.setWorkout("DeadLifts");
						break;
					case 8:
						cont = 0;
						break;
				}
			}
		// If any exceptions are thrown then they will be caught below in the catch blocks and the
		// appropriate message gets printed to the screen
		}catch (invalidInput inv){
			System.out.println(inv);
			BackWorkouts(log, scnr);
		}catch(InputMismatchException exp) {
			System.out.println("ERROR: Input must be in the form of a number between 1-8!");
			BackWorkouts(log, new Scanner(System.in));
		}
		// If there are not issues then the BackWorkouts object gets stored in the log ArrayList
		// that is a part of the BackWorkout() method parameter
		log.add(BackWorkout);
	}
	// Private class specifically for Legs workouts. This class contains all of the exercises that pertain
	// to exercising the Legs and by calling on it you create a LegsWorkouts object that will store
	// the specific workout done, the number of reps, the number of sets, and the amount of weight used
	// if the exercise is not bodyweight
	private static void LegsWorkouts(ArrayList <Exercises> log, Scanner scnr) {
		int userInput;
		int reps = 0;
		int sets = 0;
		double weights = 0.0;
		int cont = 1;// cont will allow the program to exit the while loop whenever the user wants
		Legs LegsWorkout = new Legs();// Creating a LegsWorkout object
		try{
			while (cont == 1) {
				// The printMenu() calls on the menu specific to back workouts stored in the LegsWorkout Class
				LegsWorkout.printMenu();
				userInput = scnr.nextInt();
				// If an integer that is not within the range 1-9 is entered, the personal exception
				// gets thrown to tell the user the data they entered is not valid and give them
				// the opportunity to re-enter the data without having to restart the program
				if (!(userInput >= 1 && userInput <= 9)) {
					throw new invalidInput(userInput + " is not one of the options");
				}
				// Switch loop is used to create an object that stores specific data based on what data the
				// user selects from the main menu. Then the getUserExercise() method is called in which 
				// the number of reps, sets, and weights are stored. Once that data is stored, we typcast
				// the object to specifically be of type LegsWorkout class
				switch(userInput) {
					case 1:
						LegsWorkout = (Legs) getUserExercise(LegsWorkout, reps, sets, weights, scnr);
						LegsWorkout.setWorkout("Leg Press");
						break;
					case 2:
						LegsWorkout = (Legs) getUserExercise(LegsWorkout, reps, sets, weights, scnr);
						LegsWorkout.setWorkout("Leg Extension");
						break;
					case 3:
						LegsWorkout.setType("Body Weight");
						LegsWorkout = (Legs) getUserExercise(LegsWorkout, reps, sets, weights, scnr);
						LegsWorkout.setWorkout("Deep Squats");
						break;
					case 4:
						LegsWorkout.setType("Body Weight");
						LegsWorkout = (Legs) getUserExercise(LegsWorkout, reps, sets, weights, scnr);
						LegsWorkout.setWorkout("Jump Squats");
						break;
					case 5:
						LegsWorkout = (Legs) getUserExercise(LegsWorkout, reps, sets, weights, scnr);
						LegsWorkout.setWorkout("Weighted Squats");
						break;
					case 6:
						LegsWorkout.setType("Body Weight");
						LegsWorkout = (Legs) getUserExercise(LegsWorkout, reps, sets, weights, scnr);
						LegsWorkout.setWorkout("Lunges");
						break;
					case 7:
						LegsWorkout = (Legs) getUserExercise(LegsWorkout, reps, sets, weights, scnr);
						LegsWorkout.setWorkout("Weighted Calf Raises");
						break;
					case 8:
						LegsWorkout = (Legs) getUserExercise(LegsWorkout, reps, sets, weights, scnr);
						LegsWorkout.setWorkout("Burnouts");
						break;
					case 9:
						cont = 0;
						break;
				}
			}
		// If any exceptions are thrown then they will be caught below in the catch blocks and the
		// appropriate message gets printed to the screen
		}catch (invalidInput inv){
			System.out.println(inv);
			LegsWorkouts(log, scnr);
		}catch(InputMismatchException exp) {
			System.out.println("ERROR: Input must be in the form of a number between 1-9!");
			LegsWorkouts(log, new Scanner(System.in));
		}
		// If there are not issues then the LegsWorkout object gets stored in the log ArrayList
		// that is a part of the LegsWorkout() method parameter
		log.add(LegsWorkout);
	}
	// Private class specifically for Shoulder workouts. This class contains all of the exercises that pertain
	// to exercising the shoulders and by calling on it you create a ShoulderWorkouts object that will store
	// the specific workout done, the number of reps, the number of sets, and the amount of weight used
	// if the exercise is not bodyweight
	private static void ShoulderWorkouts(ArrayList <Exercises> log, Scanner scnr) {
		int userInput;
		int reps = 0;
		int sets = 0;
		double weights = 0.0;
		int cont = 1;// cont will allow the program to exit the while loop whenever the user wants
		Shoulders ShoulderWorkout = new Shoulders();// Creating a ShoulderWorkout object
		try{
			while (cont == 1) {
				// The printMenu() calls on the menu specific to back workouts stored in the ShoulderWorkout Class
				ShoulderWorkout.printMenu();
				userInput = scnr.nextInt();
				// If an integer that is not within the range 1-9 is entered, the personal exception
				// gets thrown to tell the user the data they entered is not valid and give them
				// the opportunity to re-enter the data without having to restart the program
				if (!(userInput >= 1 && userInput <= 9)) {
					throw new invalidInput(userInput + " is not one of the options");
				}
				// Switch loop is used to create an object that stores specific data based on what data the
				// user selects from the main menu. Then the getUserExercise() method is called in which 
				// the number of reps, sets, and weights are stored. Once that data is stored, we typcast
				// the object to specifically be of type ShoulderWorkout class
				switch(userInput) {
					case 1:
						ShoulderWorkout.setType("Body Weight");
						ShoulderWorkout = (Shoulders) getUserExercise(ShoulderWorkout, reps, sets, weights, scnr);
						ShoulderWorkout.setWorkout("Pike Push Ups");
						break;
						
					case 2:
						ShoulderWorkout.setType("Body Weight");
						ShoulderWorkout = (Shoulders) getUserExercise(ShoulderWorkout, reps, sets, weights, scnr);
						ShoulderWorkout.setWorkout("Elevated Pike Push Ups");
						break;
						
					case 3:
						ShoulderWorkout = (Shoulders) getUserExercise(ShoulderWorkout, reps, sets, weights, scnr);
						ShoulderWorkout.setWorkout("Front Raises");
						break;
						
					case 4:
						ShoulderWorkout = (Shoulders) getUserExercise(ShoulderWorkout, reps, sets, weights, scnr);
						ShoulderWorkout.setWorkout("Push Press");
						break;
						
					case 5:
						ShoulderWorkout = (Shoulders) getUserExercise(ShoulderWorkout, reps, sets, weights, scnr);
						ShoulderWorkout.setWorkout("Upright Rows");
						break;
						
					case 6:
						ShoulderWorkout = (Shoulders) getUserExercise(ShoulderWorkout, reps, sets, weights, scnr);
						ShoulderWorkout.setWorkout("Reverse Dec Fly");
						break;
						
					case 7:
						ShoulderWorkout = (Shoulders) getUserExercise(ShoulderWorkout, reps, sets, weights, scnr);
						ShoulderWorkout.setWorkout("Bent-Over Dumbell Lateral Raises");
						break;
						
					case 8:
						ShoulderWorkout = (Shoulders) getUserExercise(ShoulderWorkout, reps, sets, weights, scnr);
						ShoulderWorkout.setWorkout("Barbell Shrugs");
						break;
						
					case 9:
						cont = 0;
						break;
				}
			}
		// If any exceptions are thrown then they will be caught below in the catch blocks and the
		// appropriate message gets printed to the screen
		}catch (invalidInput inv){
			System.out.println(inv);
			ShoulderWorkouts(log, scnr);
		}catch(InputMismatchException exp) {
			System.out.println("ERROR: Input must be in the form of a number between 1-9!");
			ShoulderWorkouts(log, new Scanner(System.in));
		}
		// If there are not issues then the ShoulderWorkout object gets stored in the log ArrayList
		// that is a part of the ShoulderWorkout() method parameter
		log.add(ShoulderWorkout);
	}
	// Private class specifically for Ab workouts. This class contains all of the exercises that pertain
	// to exercising the Abs and by calling on it you create an AbWorkouts object that will store
	// the specific workout done, the number of reps, the number of sets, and the amount of weight used
	// if the exercise is not bodyweight
	private static void AbWorkouts(ArrayList <Exercises> log, Scanner scnr) {
		int userInput;
		int reps = 0;
		int sets = 0;
		double weights = 0.0;
		int cont = 1;// cont will allow the program to exit the while loop whenever the user wants
		Abs AbWorkout = new Abs();// Creating an AbWorkout object
		try{
			while(cont == 1) {
				// The printMenu() calls on the menu specific to Ab workouts stored in the AbsWorkout Class
				AbWorkout.printMenu();
				userInput = scnr.nextInt();
				// If an integer that is not within the range 1-9 is entered, the personal exception
				// gets thrown to tell the user the data they entered is not valid and give them
				// the opportunity to re-enter the data without having to restart the program
				if (!(userInput >= 1 && userInput <= 9)) {
					throw new invalidInput(userInput + " is not one of the options");
				}
				// Switch loop is used to create an object that stores specific data based on what data the
				// user selects from the main menu. Then the getUserExercise() method is called in which 
				// the number of reps, sets, and weights are stored. Once that data is stored, we typcast
				// the object to specifically be of type AbsWorkout class
				switch(userInput) {
					case 1:
						AbWorkout = (Abs) getUserExercise(AbWorkout, reps, sets, weights, scnr);
						AbWorkout.setWorkout("Dumbell Curls");
						break;
						
					case 2:
						AbWorkout.setType("Body Weight");
						AbWorkout = (Abs) getUserExercise(AbWorkout, reps, sets, weights, scnr);
						AbWorkout.setWorkout("Push Ups");
						break;
						
					case 3:
						AbWorkout = (Abs) getUserExercise(AbWorkout, reps, sets, weights, scnr);
						AbWorkout.setWorkout("Hammer Curls");
						break;
						
					case 4:
						AbWorkout = (Abs) getUserExercise(AbWorkout, reps, sets, weights, scnr);
						AbWorkout.setWorkout("Barbell Curls");
						break;
						
					case 5:
						AbWorkout = (Abs) getUserExercise(AbWorkout, reps, sets, weights, scnr);
						AbWorkout.setWorkout("OverHead Tricep Extensions");
						break;
						
					case 6:
						AbWorkout.setType("Body Weight");
						AbWorkout = (Abs) getUserExercise(AbWorkout, reps, sets, weights, scnr);
						AbWorkout.setWorkout("Diamond Push Ups");
						break;
						
					case 7:
						AbWorkout.setType("Body Weight");
						AbWorkout = (Abs) getUserExercise(AbWorkout, reps, sets, weights, scnr);
						AbWorkout.setWorkout("Tricep Dips");
						break;
						
					case 8:
						AbWorkout = (Abs) getUserExercise(AbWorkout, reps, sets, weights, scnr);
						AbWorkout.setWorkout("Rope Tricep Pushdown");
						break;
						
					case 9:
						cont = 0;
						break;
				}
			}
		// If any exceptions are thrown then they will be caught below in the catch blocks and the
		// appropriate message gets printed to the screen
		}catch (invalidInput inv){
			System.out.println(inv);
			AbWorkouts(log, scnr);
		}catch(InputMismatchException exp) {
			System.out.println("ERROR: Input must be in the form of a number between 1-9!");
			AbWorkouts(log, new Scanner(System.in));
		}
		// If there are not issues then the AbsWorkout object gets stored in the log ArrayList
		// that is a part of the AbsWorkout() method parameter
		log.add(AbWorkout);
	}
	// Private class specifically for Arm workouts. This class contains all of the exercises that pertain
	// to exercising the Arms and by calling on it you create an ArmsWorkouts object that will store
	// the specific workout done, the number of reps, the number of sets, and the amount of weight used
	// if the exercise is not bodyweight
	private static void ArmWorkouts(ArrayList <Exercises> log, Scanner scnr) {
		int userInput;
		int reps = 0;
		int sets = 0;
		double weights = 0.0;
		int cont = 1;// cont will allow the program to exit the while loop whenever the user wants
		Arms ArmWorkout = new Arms();// Creating an ArmWorkout object
		try{
			while(cont == 1) {
				// The printMenu() calls on the menu specific to Arm workouts stored in the ArmWorkout Class
				ArmWorkout.printMenu(); 
				userInput = scnr.nextInt();
				// If an integer that is not within the range 1-9 is entered, the personal exception
				// gets thrown to tell the user the data they entered is not valid and give them
				// the opportunity to re-enter the data without having to restart the program
				if (!(userInput >= 1 && userInput <= 9)) {
					throw new invalidInput(userInput + " is not one of the options");
				}
				// Switch loop is used to create an object that stores specific data based on what data the
				// user selects from the main menu. Then the getUserExercise() method is called in which 
				// the number of reps, sets, and weights are stored. Once that data is stored, we typcast
				// the object to specifically be of type ArmWorkout class
				switch(userInput) {
					case 1:
						ArmWorkout = (Arms) getUserExercise(ArmWorkout, reps, sets, weights, scnr);
						ArmWorkout.setWorkout("Dumbell Curls");
						break;
						
					case 2:
						ArmWorkout.setType("Body Weight");
						ArmWorkout = (Arms) getUserExercise(ArmWorkout, reps, sets, weights, scnr);
						ArmWorkout.setWorkout("Push Ups");
						break;
						
					case 3:
						ArmWorkout = (Arms) getUserExercise(ArmWorkout, reps, sets, weights, scnr);
						ArmWorkout.setWorkout("Hammer Curls");
						break;
						
					case 4:
						ArmWorkout = (Arms) getUserExercise(ArmWorkout, reps, sets, weights, scnr);
						ArmWorkout.setWorkout("Barbell Curls");
						break;
						
					case 5:
						ArmWorkout = (Arms) getUserExercise(ArmWorkout, reps, sets, weights, scnr);
						ArmWorkout.setWorkout("OverHead Tricep Extensions");
						break;
						
					case 6:
						ArmWorkout.setType("Body Weight");
						ArmWorkout = (Arms) getUserExercise(ArmWorkout, reps, sets, weights, scnr);
						ArmWorkout.setWorkout("Diamond Push Ups");
						break;
						
					case 7:
						ArmWorkout.setType("Body Weight");
						ArmWorkout = (Arms) getUserExercise(ArmWorkout, reps, sets, weights, scnr);
						ArmWorkout.setWorkout("Tricep Dips");
						break;
						
					case 8:
						ArmWorkout = (Arms) getUserExercise(ArmWorkout, reps, sets, weights, scnr);
						ArmWorkout.setWorkout("Rope Tricep Pushdown");
						break;
						
					case 9:
						cont = 0;
						break;
				}
			}
		// If any exceptions are thrown then they will be caught below in the catch blocks and the
		// appropriate message gets printed to the screen
		}catch (invalidInput inv){
			System.out.println(inv);
			ArmWorkouts(log, scnr);
		}catch(InputMismatchException exp) {
			System.out.println("ERROR: Input must be in the form of a number between 1-9!");
			ArmWorkouts(log, new Scanner(System.in));
		}
		// If there are not issues then the AbsWorkout object gets stored in the log ArrayList
		// that is a part of the ArmWorkout() method parameter
		log.add(ArmWorkout);
	}
	
	// printMainMenu() method prints the different muscle groups user may have worked out and then
	// stores the user input into an int variable called userInput that gets returned
	public static int printMainMenu() {
		Scanner scnr = new Scanner(System.in);
		int userInput = 1;
		try {
			// If an integer that is not within the range 1-6 is entered, the personal exception
			// gets thrown to tell the user the data they entered is not valid and give them
			// the opportunity to re-enter the data without having to restart the program
			if (userInput < 1 ||userInput > 6)
				throw new invalidInput(userInput + " is not one of the options");
			System.out.println("WELCOME TO YOUR WORKOUT LOG");
			System.out.println("-------------------------------");
			System.out.println("1) Arms");
			System.out.println("2) Shoulder");
			System.out.println("3) Back");
			System.out.println("4) Legs");
			System.out.println("5) Abs");
			System.out.println("6) DONE");
			System.out.println("Which Body Part did you work out today?");
			System.out.print("INPUT: ");
			userInput = scnr.nextInt();
			
		// If any exceptions are thrown then they will be caught below in the catch blocks and the
		// appropriate message gets printed to the screen
		}catch (invalidInput inv){
			System.out.println(inv);
			printMainMenu();
		}catch(InputMismatchException exp) {
			System.out.println("ERROR: Input must be in the form of a number between 1-6!\n\n");
			printMainMenu();
		}
		// If there were no issues then the method returns the value stored in userInput
		return userInput;
	}
	// enterWorkouts() method is used to write to a text file the specific workout the user is logging
	public static void enterWorkouts(ArrayList<Exercises> log) {
		try {
			// method uses java.io classes to write the data stored in the ArrayList called log into a
			// text file called "WorkoutLog.txt"
			String fname = "WorkoutLog.txt";
			File file = new File(fname);
			// method uses java.util.Date, java.text.SimpleDateFormat, and java.text.DateFormat to write 
			// the specific day of the week the workout was logged for and the specific date  
			DateFormat dt = new SimpleDateFormat("E - dd/MM/yyy");
			Date date = new Date();
			FileWriter fw = new FileWriter(fname,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			// If the text file does not already exist then start off with labeling the text file
			if (!file.exists()) {
				file.createNewFile();
				fw.write("\tWorkout Log");
				fw.write("--------------------------------");
			}
			// format for each workout log entry
			pw.println("+------------------------+");
			pw.println("| " + dt.format(date) + "  |");
			pw.println("+------------------------+");
			Exercises reference = null;
			// For loop iterates through every object stored in the log ArrayList
			for (int i = 0; i < log.size(); i++) {
				reference = log.get(i); // temporary variable to store each object 
				// if no values were set for the reps and sets then we skip the object
				if (reference.getReps() == 0 || reference.getSets() == 0)
					continue;
				// Writes the appropriate header for each entry based on the object's reference
				// using java.io.PrintWriter 
				if (reference instanceof Arms) {
					pw.println("\tArms Workouts:");	
				}else if (reference instanceof Legs) {
					pw.println("\tLegs Workouts:");
				}else if (reference instanceof Shoulders) {
					pw.println("\tShoulders Workouts:");
				}else if (reference instanceof Back) {
					pw.println("\tBack Workouts:");
				}else if (reference instanceof Abs) {
					pw.println("\tAbs Workouts:");
				}
				
				// Writes the exact number of reps, sets, and weights used by the user
				// using java.io.PrintWriter 
				pw.println("\t>>>" + reference.getWorkout());
				pw.println("\t\tReps: " + reference.getReps());
				pw.println("\t\tSets: " + reference.getSets());
				// if the workout logged is not a bodyweight workout then the specific 
				// weight used for that workout is included in the text file as well
				if (!(reference.getType().equalsIgnoreCase("Body Weight")))
					pw.println("\t\tWeights:" + reference.getWeights() + " lbs");
			}
			pw.println("");
			pw.close();
		// If there were any I/O issues specifically, then the catch block will print to the screen
		// that the program was not able to log the workout and prints the last thing that was 
		// executed in teh printStack
		}catch(IOException ex) {
			System.out.println("Could not log your workout");
			ex.printStackTrace();
		}
		// If there were no issues then the program will print the following to the screen
		System.out.println("Succesfully logged workout");
	}
	public static void main(String[]args) throws IOException {
		// ArrayList is used to store all of the workout objects since we do not know the exact 
		// number of objects that will be created
		ArrayList<Exercises> log = new ArrayList<Exercises>();
		int userInput;
		int cont = 1;// cont will allow the program to exit the while loop whenever the user wants
		
		while (cont == 1) {
			Scanner scnr = new Scanner(System.in);
			userInput = printMainMenu(); // calls on printMainMenu() to print the menu to the screen
			// and then stores the user's input in the userInput variable
			switch(userInput) {
				case 1:
					ArmWorkouts(log, scnr);			
					break;
				case 2:
					ShoulderWorkouts(log, scnr);
					break;
				case 3:
					BackWorkouts(log, scnr);
					break;
				case 4:
					LegsWorkouts(log, scnr);
					break;
				case 5:
					AbWorkouts(log,scnr);
					break;
				case 6:
					// Once the user has finished logging their workouts, the enterWorkouts() method
					// gets called to write the workouts into the "WorkoutLog.txt" file
					enterWorkouts(log); 
					cont = 0;
					break;
				}
			}
			
		}
}
