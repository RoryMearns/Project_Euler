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

	public void project03 () {
		// Largest Prime Factor
		// What is the largest prime factor of the number 600851475143
		// Sought help from wiki & http://stackoverflow.com/questions/4273368/prime-factorization-program-in-java

		long num = 600851475143L;
		long i;

		for (i = 2; i <= num; i++) {
			if (num % i == 0) {
				num /= i;
				i--;
			}
		}
		System.out.println("The answer to Project 3 is: " + i);
	}

	public void project04 () {
		// Largest palindrome product
		// Find the largest palindrome made from the product of two 3-digit numbers

		int number;
		int finalNumber = 0;
		int x = 999;
		int y = 999;
		String numString;
		String numBackwards;

		while (x>800) {
			while (y>800) {
				number = x*y;
				// Store the number as a string twice, one normal & one reversed, then compare the two:
				numString = String.valueOf(number);
				numBackwards = new StringBuilder(numString).reverse().toString();
				if (numString.equals(numBackwards)) {
					finalNumber = (number > finalNumber) ? number : finalNumber;
				}
				y--;
			}
			x--;
			y = 999;
		}
		System.out.println("The answer to Project 4 is: " + finalNumber);
	}


	public static void main (String[] args) {
		ProjectEuler project = new ProjectEuler();
		// project.project01();
		// project.project02();
		// project.project03();
		project.project04();
	}
}








