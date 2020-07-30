/*
Minimum operations of given type to make all elements of a matrix equal

Problem Description

Given a matrix of integers A of size N x M and an integer B.

In a single operation, B can be added to or subtracted from any element of the matrix.

Find and return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

1 <= N, M <= 1000
-1000 <= A[i] <= 1000
1 <= B <= 1000


Input Format

The first argument given is the integer matrix A. The second argument given is the integer B.


Output Format

Return the minimum number of operations required to make all the elements of the matrix equal and if it impossible return -1 instead.


Example Input

 A = [  
        [0, 2, 8]
        [8, 2, 0]
        [0, 2, 8]
     ]
 B = 2



Example Output

 12



Example Explanation

 We can make all value equal to 2 by adding 2 one time to 0's and subtracting 2 three times from 8's.
 So there are all total 12 operations needed to be done.
*/

public class Solution {
    public int solve(int[][] A, int k) {
        int n = A.length; 
		int m = A[0].length;
        int [] arr = new int[n * m]; 
	
		int mod = ((A[0][0] % k)+k)%k; 
	
		for (int i = 0; i < n; ++i) 
		{ 
			for (int j = 0; j < m; ++j) 
			{ 
				arr[i * m + j] = A[i][j]; 
	
				if (((A[i][j] % k)+k)%k != mod) 
				{ 
					return -1; 
				} 
			} 
		} 
	
		Arrays.sort(arr); 
	
		int median = arr[arr.length / 2]; 
		int minOperations = 0; 
		
		for (int i = 0; i < n * m; ++i) 
			minOperations += Math.abs(arr[i] - median) / k; 
		
		return minOperations;  
    }
}

