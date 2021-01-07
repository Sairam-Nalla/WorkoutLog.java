package workouts.java;
public class Shoulders extends Exercises{
	// Default constructor for Legs class which simply calls on the constructor from the parent class 
	public Shoulders() {
		super();
	}
	// Class constructor that initializes the instance variables
	public Shoulders(int sets, int reps, int weights, String workout) {
		super(sets, reps, weights, workout);
	}
	
	// printMenu overrides the superclass and prints out the workouts for exercising Shoulders
	@Override
	public void printMenu() {
		System.out.println("\tExercises:");
		System.out.println("\t>>>Shoulders.....");
		System.out.println("\t1)Pike Push Ups");
		System.out.println("\t2)Elevated Pike Push Ups");
		System.out.println("\t3)Front Raises");
		System.out.println("\t4)Push Press");
		System.out.println("\t5)Upright Rows");
		System.out.println("\t6)Reverse Deck Fly");
		System.out.println("\t7)Bent-Over Dumbell Lateral Raises");
		System.out.println("\t8)Barbell Shrugs");
		
		System.out.println("\n\t9)DONE");
		System.out.println("Which workout are you logging? ");
		System.out.print("INPUT: ");
	}
}
