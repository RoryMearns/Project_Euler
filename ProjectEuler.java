public class ProjectEuler {

	// Some basic algorithm exercises from Project Euler: https://projecteuler.net/

	public void project01 () {	// Multiples of 3 and 5
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

	public void project02 () {	// Even Fibonacci Numbers
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

	public void project03 () {	// Largest Prime Factor
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

	public void project04 () {	// Largest palindrome product
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

	public void project05 () {	// Smallest multiple
		// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
		int i = 2520;
		while (true) {
			if (i%3 == 0 && i%4 == 0
				&& i%5 == 0 && i%6 == 0
				&& i%7 == 0 && i%8 == 0
				&& i%9 == 0 && i%10 == 0
				&& i%11 == 0 && i%12 == 0
				&& i%13 == 0 && i%14 == 0
				&& i%15 == 0 && i%16 == 0
				&& i%17 == 0 && i%18 == 0
				&& i%19 == 0 && i%20 == 0) {
				System.out.println("The answer to Project 5 is: " + i);
				break;
			}
			i+=10;
		}
	}

	public void project06 () {	// Sum square difference
		// Find the difference between the sum of the squares of the first 100 natural numbers and the square of the sum

		int sumOfSquares = 0;
		int squareOfSum = 0;

		for (int i=1; i<=100; i++) {
			sumOfSquares = sumOfSquares + (i*i);
			squareOfSum = squareOfSum + (i);
		}
		squareOfSum *= squareOfSum;
		System.out.println("The answer to Project 5 is: " + (squareOfSum - sumOfSquares));
	}

	public void	project07 () { 	// 10001st prime
		// What is the 10 001st prime number?

		int counter = 6;
		int number = 13;

		while(counter < 10001) {
			number++;
			if (isPrime(number)) {
				counter++;
			}
		}
		System.out.println("The answer to Project 6 is: " + number);
	}

	public boolean isPrime (int x) {	// Helper method for Project 7
		// Checks to see if a number is prime, returns true if it is
		for (int i=2; i*2<x; i++){
			if (x%i == 0) {
				return false;
			}
		}
		return true;
	}


	public static void main (String[] args) {
		ProjectEuler project = new ProjectEuler();
		// project.project01();
		// project.project02();
		// project.project03();
		// project.project04();
		// project.project05();
		// project.project06();
		project.project07();
	}
}








