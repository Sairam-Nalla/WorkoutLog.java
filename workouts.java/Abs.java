package workouts.java;

public class Abs extends Exercises{
	// Default constructor for Abs class which simply calls on the constructor from the parent class 
	public Abs() {
		super();
	}
	// Class constructor that initializes the instance variables
	public Abs(int sets, int reps, int weights, String workout) {
		super(sets, reps, weights, workout);
	}
	
	// printMenu overrides the superclass and prints out the workouts for exercising Abs
	@Override
	public void printMenu() {
		System.out.println("\tExercises:");
		System.out.println("\t>>>Abs.....");
		System.out.println("\t1)Dumbell Crunchs");
		System.out.println("\t2)Tuck and Crunchs");
		System.out.println("\t3)V-sits");
		System.out.println("\t4)Crunches");
		System.out.println("\t5)Hanging Leg Raises");
		System.out.println("\t6)V-Ups");
		System.out.println("\t7)Weighted Russian Twists");
		System.out.println("\t8)Side Planks");
		
		System.out.println("\n\t9)DONE");
		System.out.println("Which workout are you logging? ");
		System.out.print("INPUT: ");
	}
}