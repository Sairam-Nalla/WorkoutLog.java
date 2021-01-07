package workouts.java;

public class Arms extends Exercises{
	// Default constructor for Legs class which simply calls on the constructor from the parent class 
	public Arms() {
		super();
	}
	// Class constructor that initializes the instance variables
	public Arms(int sets, int reps, int weights, String workout) {
		super(sets, reps, weights, workout);
	}
	
	// printMenu overrides the superclass and prints out the workouts for exercising Arms
	// specifically for Biceps and Tricepts
	@Override
	public void printMenu() {
		System.out.println("\tExercises:");
		System.out.println("\t>>>Biceps.....");
		System.out.println("\t1)Dumbell Curls");
		System.out.println("\t2)Push Ups");
		System.out.println("\t3)Hammer Curls");
		System.out.println("\t4)Barbell Curls");
		
		System.out.println("\n\t>>>Triceps.....");
		System.out.println("\t5)Overhead Tricep Extensions");
		System.out.println("\t6)Diamond Push Ups");
		System.out.println("\t7)Tricep Dips");
		System.out.println("\t8)Rope Tricep Pushdown");
		
		System.out.println("\n\t9)DONE");
		System.out.println("Which workout are you logging? ");
		System.out.print("INPUT: ");
	}
}