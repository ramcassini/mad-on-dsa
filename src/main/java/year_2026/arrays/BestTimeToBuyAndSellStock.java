package year_2026.arrays;

//121. Best Time to Buy and Sell Stock
//
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int i=0;
        int j =1;
        int min = i;
        int max = 0;
        int soFarMax=0;

        while(i<j && j<prices.length){
            if(prices[min]<prices[j]){


                if(soFarMax<(prices[j]-prices[min])){

                    soFarMax = prices[j]-prices[min];
                    max=j;
                }
//                min=i;
                i=j;
            }
            else{

                i++;
                min=i;
                // j++;
            }
            j++;
        }
        if(soFarMax!=0)
        System.out.println("shares bought on day:"+min+"  and sold on day:"+max);

        return soFarMax;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,6,4,3,1}));
    }
}