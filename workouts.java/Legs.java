package workouts.java;
public class Legs extends Exercises{
	// Default constructor for Legs class which simply calls on the constructor from the parent class 
	public Legs() {
		super();
	}
	// Class constructor that initializes the instance variables
	public Legs(int sets, int reps, int weights, String workout) {
		super(sets, reps, weights, workout);
	}
	
	// printMenu overrides the superclass and prints out the workouts for exercising Legs
	@Override
	public void printMenu() {
		System.out.println("\tExercises:");
		System.out.println("\t>>>Quads.....");
		System.out.println("\t1)Leg Press");
		System.out.println("\t2)Leg Extension");
		System.out.println("\t3)Deep Squats");
		System.out.println("\t4)Jump Squats");
		System.out.println("\t5)Weighted Squats");
		System.out.println("\t6)Lunges");
		
		System.out.println("\n\t>>>Calves.....");
		System.out.println("\t7)Weighted Calf Raises");
		System.out.println("\t8)Burnouts");
		
		System.out.println("\n\t9)DONE");
		System.out.println("Which workout are you logging? ");
		System.out.print("INPUT: ");
	}
}
