package workouts.java;

// Personal exception made to be thrown if the user tries to input a number that is not valid
public class invalidInput extends Exception{
	String errorMessage;
	// Class constructor that stores msg in the instance variable to be printed to the screen 
	// whenever it is caught in the try-catch block
	public invalidInput(String msg){
		this.errorMessage = msg;
	}
	// Overriding the default toString() in order to automatically print out the error message
	// without having to specifically call the class 
	@Override
	public String toString(){
		return "ERROR: " + this.errorMessage + "\n";
	}
}