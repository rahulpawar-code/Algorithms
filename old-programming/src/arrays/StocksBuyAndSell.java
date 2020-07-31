package arrays;

public class StocksBuyAndSell {
	private static void printIndicies(int prices[]) {
		if (prices == null || prices.length <= 0) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		int buy = 0;
		int sell = -1;
		
		for (int i = 1; i < prices.length; ++i) {
			if (prices[i] < prices[i - 1]) {
				if (buy < i -1) {
					sell = i - 1;
					System.out.print("(" + buy + "," + sell + ") ");
				}
				buy = i;
			}
		}
		
		if (prices[prices.length - 1] > prices[buy]) {
			sell = prices.length - 1; 
			System.out.println("(" + buy + "," + sell + ") ");
		} else if (sell == -1) {
			System.out.println("No profit");
		}
	}
	
	public static void main(String[] args) {
		int prices[] = {100, 180, 260, 310, 40, 535, 695};
		printIndicies(prices);
		
		int prices2[] = {2, 3, 4, -1};
		printIndicies(prices2);
	
	}
	
}
