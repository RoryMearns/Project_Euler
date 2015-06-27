public class ProjectEuler {

	// Some basic algorithm exercises from Project Euler: https://projecteuler.net/

	public void project01 () {
		// Multiples of 3 and 5
		// Find the sum of all multiples of 3 & 5 less than 1000
		int i = 0;
		int x = 0;
		while (i < 1000) {
			if (i%3 == 0 || i%5 ==0) {
				x += i;
			}
			i++;
		}
		System.out.println("The answer to Project 1 is: " + x);
	}

	public void project02 () {
		// Even Fibonacci Numbers
		// Find the sum of all even Fibonacci numbers less than 4 million
		int last = 1;
		int current = 2;
		int sum = 0;
		int temp;
		while (current < 4000000) {
			if (current%2 == 0) {
				sum += current;
			}
			temp = current;
			current += last; 
			last = temp;
		}
		System.out.println("The answer to Project 2 is: " + sum);
	}

	public static void main (String[] args) {
		ProjectEuler project = new ProjectEuler();
		project.project01();
		project.project02();
	}
}