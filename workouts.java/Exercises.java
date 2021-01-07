package workouts.java;

public abstract class Exercises {
	// This is the abstract superclass that gets inherited by subclasses
	private int reps;
	private int sets;
	private double weight;
	private String type;
	private String workout;
	// Default class constructor that gets implemented if an object is created without any values
	public Exercises() {
		this.reps = 0;
		this.sets = 0;
		this.weight = 0.0;
		this.workout = "";
		this.type = "";
	}
	// Class constructor that initializes the instance variables
	public Exercises(int reps, int sets, double weights, String workout) {
		this.reps = reps;
		this.sets = sets;
		this.weight = weights;
		this.workout = workout;
	}	
	// This method is meant to get defined by subclasses for printing out the different 
	// workouts for each body parts
	abstract void printMenu();
	
	// Reps setter and getter methods for the number of workout repititions
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	// Sets setter and getter methods for the number of workout sets
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	// Weights setter and getter methods for the weight used in each workouts
	public double getWeights() {
		return weight;
	}
	public void setWeights(double weight) {
		this.weight = weight;
	}
	// Workouts setter and getter methods that store the exact workout performed 
	public String getWorkout() {
		return workout;
	}
	public void setWorkout(String workout) {
		this.workout = workout;
	}
	// Type setter and getter methods that is used to distinguish the workout 
	// between bodyweight and weighted workouts
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
}