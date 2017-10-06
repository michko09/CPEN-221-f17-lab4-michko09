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
	 * @return The number of paths from (0,0,0) to (l,m,n) using the rules
	 *         specified in the problem statement.
	 */
	public static long numPaths(int l, int m, int n) {
		int count = 0;
		int steps = 1;

		// TODO: change this
		// You do not have to worry about overflows.
		if (l == 0 && m == 0 && n == 0) {
			steps = 1;
			count++;
		}
		
		if (steps % 1 == 0) {
			numPaths(l-1,m,n);
			numPaths(l,m-1,n);
			numPaths(l,m,n-1);		
		}
		
		if (steps % 2 == 0) {
			numPaths(l-2,m,n);
			numPaths(l,m-2,n);
			numPaths(l,m,n-2);
		}
		
		if (steps % 3 == 0) {
			numPaths(l-3,m,n);
			numPaths(l,m-3,n);
			numPaths(l,m,n-3);
		}
		
		return steps;

	}

}
