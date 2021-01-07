package workouts.java;

public class Back extends Exercises{
	// Default constructor for Back class which simply calls on the constructor from the parent class 
	public Back() {
		super();
	}
	// Class constructor that initializes the instance variables
	public Back(int sets, int reps, int weights, String workout) {
		super(sets, reps, weights, workout);
	}
	
	// printMenu overrides the superclass and prints out the workouts for exercising the Back
	@Override
	public void printMenu() {
		System.out.println("\tExercises:");
		System.out.println("\t>>>Back.....");
		System.out.println("\t1)Bent Over Rows");
		System.out.println("\t2)Dumbell Single Arm Rows");
		System.out.println("\t3)Seated Cable Rows");
		System.out.println("\t4)Pullups");
		System.out.println("\t5)Chinups");
		System.out.println("\t6)Lat Pulldowns");
		System.out.println("\t7)DeadLifts");
		
		System.out.println("\n\t8)DONE");
		System.out.println("Which workout are you logging? ");
		System.out.print("INPUT: ");
	}
}