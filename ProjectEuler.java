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
		System.out.println("The answer to Project 6 is: " + (squareOfSum - sumOfSquares));
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
		System.out.println("The answer to Project 7 is: " + number);
	}

	public void project08 () {	// Largest product in a series
		// Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?

		String theNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		long maxProduct = 0;
		long currentProduct;

		for (int i=0; i<theNumber.length()-13; i++) {
			currentProduct = 1;
			for (int k=i; k<i+13; k++) {
				currentProduct = currentProduct * Integer.parseInt(theNumber.substring(k, k + 1));
				maxProduct = (currentProduct>maxProduct)? currentProduct : maxProduct;
			}
		}
		System.out.println("The answer to Project 8 is: " + maxProduct);
	}

	public void project09 () {	// Special Pythagorean triplet
		// There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc

		int finalA = 0;
		int finalB = 0;
		int finalC = 0;

		for (int a=0; a<1000; a++) {
			for (int b=a+1; b<1000; b++) {
				for (int c=b+1; c<1000; c++)
				if (a*a+b*b == c*c && a+b+c == 1000) {
					finalA = a; 
					finalB = b;
					finalC = c;
					break;
				}
			}
		}
		System.out.println("The answer to Project 9 is: " + (finalA*finalB*finalC));
	}

	public void project10 () {	// Summation of primes
		// Find the sum of all the primes below two million
		// First tried a brute force method using my isPrime() method, this took way too long
		// The below implementation was created after studying the Sieve of Eratosthenes, incredibly quick by comparison

		long sum = 0;
		boolean[] numbers = new boolean[2000001];
		double max = Math.sqrt(numbers.length);

		for (int i=2; i<numbers.length; i++) {
			if (numbers[i] == false) {
				sum += i;
				if (i<max) {
					for (long k=2*i; k<numbers.length; k+=i) {
						numbers[(int)k] = true;
					}
				}
			}
		}
		System.out.println("The answer to Project 10 is: " + sum);
	}

	public void project11 () {	// Largest product in a grid
		// What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?

		int largestProduct = 0;
		int temp;
		int[][] numbers = {{8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
			{49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
			{81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
			{52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},
			{22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
			{24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
			{32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
			{67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
			{24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
			{21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
			{78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
			{16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
			{86, 56, 0, 48, 35, 71, 89, 7, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
			{19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
			{4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
			{88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
			{4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
			{20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
			{20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
			{1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48}};

		for (int i=0; i<numbers.length; i++) {
			for (int k=0; k<numbers[0].length; k++) {
				// From each number: 

				// Check horizontal
				if (k <= numbers[0].length-4) {
					temp = numbers[i][k]*numbers[i][k+1]*numbers[i][k+2]*numbers[i][k+3];
					largestProduct = (temp>largestProduct)? temp : largestProduct;
				}
				// Check vertical
				if (i <= numbers.length-4) {
					temp = numbers[i][k]*numbers[i+1][k]*numbers[i+2][k]*numbers[i+3][k];
					largestProduct = (temp>largestProduct)? temp : largestProduct;
				}
				// Check diagonals
				if (k <= numbers[0].length-4 && i <= numbers.length-4) {
					temp = numbers[i][k]*numbers[i+1][k+1]*numbers[i+2][k+2]*numbers[i+3][k+3];
					largestProduct = (temp>largestProduct)? temp : largestProduct;
				}
				if (k <= numbers[0].length-4 && i >= 3) {
					temp = numbers[i][k]*numbers[i-1][k+1]*numbers[i-2][k+2]*numbers[i-3][k+3];
					largestProduct = (temp>largestProduct)? temp : largestProduct;
				}

			}
		}
		System.out.println("The answer to Project 11 is: " + largestProduct);
	}

// --------------------------------------------- Helper Methods --------------------------------------------- //

	public boolean isPrime (int x) {	// Helper method for checking prime quality
		// Checks to see if a number is prime, returns true if it is

		for (int i=2; i*2<x; i++){
			if (x%i == 0) {
				return false;
			}
		}
		return true;
	}

// ----------------------------------------------- Main Method ---------------------------------------------- //

	public static void main (String[] args) {
		ProjectEuler project = new ProjectEuler();
		// project.project01();
		// project.project02();
		// project.project03();
		// project.project04();
		// project.project05();
		// project.project06();
		// project.project07();
		// project.project08();
		// project.project09();
		// project.project10();
		project.project11();
	}
}








