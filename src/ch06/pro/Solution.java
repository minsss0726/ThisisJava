package ch06.pro;

public class Solution {
	public int solution (int m , int[] ledger) {
		
		int account = 0;
		
		
		for (int i:ledger) {
			if ( account + i >= (0 - m)) {
				account += i;
			} 
		}
		
		return account;
	}

}
