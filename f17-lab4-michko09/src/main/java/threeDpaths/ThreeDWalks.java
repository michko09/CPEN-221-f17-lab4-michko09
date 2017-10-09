package threeDpaths;

public class ThreeDWalks {

	/**
	 * 
	 * @param l
	 *            >= 0
	 * @param m
	 *            >= 0
	 * @param n
	 *            >= 0
	 * @return The number of paths from (0,0,0) to (l,m,n) using the rules specified
	 *         in the problem statement.
	 */
	private static int count = 0;
	private static int steps = 0;

	public static long numPaths(int l, int m, int n) {
		if (l >= 0 && m >= 0 && n >= 0) {
			steps++;
		} else {
			steps = 1;
		}
		// Fix steps so that is not static and equals the step befor this calling
		System.out.println("l is: " + l + " m is: " + m + " n is: " + n);
		System.out.println("steps is: " + steps);
		// System.out.println("count is: " + count);

		// Base Case 1: The object is already at the destination
		if (l == 0 && m == 0 && n == 0) {
			count++;
			steps = 1;
		} else if (l == 0 && m == 0 && n <= 3 || l == 0 && n == 0 && m <= 3 || m == 0 && n == 0 && l <= 3) {
			if (l > 0) {
				l = 0;
			} else if (m > 0) {
				m = 0;
			} else if (n > 0) {
				n = 0;
			}
			numPaths(l,m,n);
		}
		// Base Case 3: Moving one unit
		else if (steps % 3 == 1 && l >= 0 && m >= 0 && n >= 0) {
			numPaths(l - 1, m, n);
			numPaths(l, m - 1, n);
			numPaths(l, m, n - 1);
		}
		// Base Case 4: Moving two units
		else if (steps % 3 == 2 && l >= 0 && m >= 0 && n >= 0) {
			numPaths(l - 2, m, n);
			numPaths(l, m - 2, n);
			numPaths(l, m, n - 2);
		}
		// Base Case 5: Moving three units
		else if (steps % 3 == 0 && l >= 0 && m >= 0 && n >= 0) {
			numPaths(l - 3, m, n);
			numPaths(l, m - 3, n);
			numPaths(l, m, n - 3);
		}

		System.out.println("count is: " + count);
		return count;

	}

}
