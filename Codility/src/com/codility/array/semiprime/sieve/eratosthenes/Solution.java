package com.codility.array.semiprime.sieve.eratosthenes;

class Solution {
	 boolean[] primes, semi;
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] P = {1,4,16};
		int[] Q = {26,10,20};
		int[] val = sol.solution(26, P, Q);
		for(int v: val){
			System.out.print(v + " ");
		}
	}

	public int[] solution(int N, int[] P, int[] Q) {
		if(N == 1){
			int[] ret = {0};
			return ret;
		}
		primes = new boolean[N + 1];
		getprime(N);
		 semi = new boolean[N + 1];
	        semi(N);
	        int[] sum = new int[N + 1];
	        for (int i = 1; i <= N; i++) {
	            sum[i] = sum[i - 1];
	            if (semi[i]) sum[i]++;
	        }
	        for (int i = 0; i < P.length; i++) {
	            P[i] = sum[Q[i]] - sum[P[i] - 1];
	        }
	        return P; 
	}
	
	
	public void semi(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) continue;
            for (int k = i * i; k <= n; k += i) {
                if (primes[k / i]) semi[k] = true;
            }
        }
    }
	
	private void getprime(int N){
		for(int i = 0; i<= N; i++){
			primes[i] = true;
		}
		primes[0] = false;
		primes[1] = false;
		if(N <2){
			return;
		}
		primes[2] = true;
		int i=2;
		while(i*i <= N){
			for(int j = i+i; j<= N; j=j+i){
				primes[j] = false;
			}
			i++;
		}
		
		/*for(int j = 0; j<=N;j++){
			if(primes[j] ==  true)
			System.out.print(j + " ");
		}
		System.out.println();*/
	}
}
