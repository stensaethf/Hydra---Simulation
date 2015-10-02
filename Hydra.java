/**
 * Hydra.java
 * A Java program to play out the mythical slaying scenario of the Hydra
 * Created by Frederik Roenn Stensaeth
 * 04.29.14
 */

// Define Hydra class. Takes initial_head as parameter.
public class Hydra {
	// Set up private variables
	private String head;
	private Stack<String> head_stack;

	// Define Hydra constructor. Takes initial_head as parameter. Sets up the
	//stack and starts to slay the hydra
	public Hydra(String initial_head) {
		//long startTime = System.currentTimeMillis();
		// Declare stack to be used to store heads
		head_stack = new MysteryStackImplementation<String>();
		System.out.printf("Starting Hydra with \"%s\"\n", initial_head);
		// Push initial_head onto stack
		head_stack.push(initial_head);
		// Call chop method
		chop();
		//long endTime = System.currentTimeMillis();
		//System.out.printf("%d ms\n", endTime - startTime);
	}

	// Define choip method. Takes no parameters. Slays hydra by removing one
	//character from the head at a time
	private void chop() {
		// Execute while statement as long as the hydra has a head
		while (!head_stack.isEmpty()) {
			System.out.printf("Chopping head %s\n", head_stack.peek());
			// Pop head from stack
			head = head_stack.pop();
			// If head is string of more than one character remove the first
			//letter from the head and push two copies of the new head onto
			//the stack
			if (head.length() > 1) {
				head = head.substring(1, head.length());
				head_stack.push(head);
				head_stack.push(head);
			}
		}
		// Hurray! Print success message
		System.out.println("The Hydra is slain!");
	}

	// Define main function. Takes args as parameter. Creates Hydra object.
	public static void main(String[] args) {
		// If incorrect parameter is given print usage message and exit system
		if (args.length != 1) {
			//System.out.println("Usage: java Hydra String");
			System.exit(1);
		// If correct parameter is given create new Hydra object
		} else {
			Hydra hydra = new Hydra(args[0]);
		}
	}
}