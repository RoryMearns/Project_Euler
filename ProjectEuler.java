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


	public static void main (String[] args) {
		ProjectEuler project = new ProjectEuler();
		project.project01();
		project.project02();
		project.project03();
	}
}