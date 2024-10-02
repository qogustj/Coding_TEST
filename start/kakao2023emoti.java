package start;

import java.util.*;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = {10, 20, 30, 40};
        int[] result = new int[2];

        dfs(0, new int[emoticons.length], users, emoticons, discounts, result);

        return result;
    }

    private void dfs(int depth, int[] discountRates, int[][] users, int[] emoticons, int[] discounts, int[] result) {
        if (depth == emoticons.length) {
            calculateResult(discountRates, users, emoticons, result);
            return;
        }

        for (int discount : discounts) {
            discountRates[depth] = discount;
            dfs(depth + 1, discountRates, users, emoticons, discounts, result);
        }
    }

    private void calculateResult(int[] discountRates, int[][] users, int[] emoticons, int[] result) {
        int totalSubscribers = 0;
        int totalSales = 0;

        for (int[] user : users) {
            int userDiscountRate = user[0];
            int userMaxPrice = user[1];
            int userTotalPrice = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discountRates[i] >= userDiscountRate) {
                    userTotalPrice += emoticons[i] * (100 - discountRates[i]) / 100;
                }
            }

            if (userTotalPrice >= userMaxPrice) {
                totalSubscribers++;
            } else {
                totalSales += userTotalPrice;
            }
        }

        if (totalSubscribers > result[0] || (totalSubscribers == result[0] && totalSales > result[1])) {
            result[0] = totalSubscribers;
            result[1] = totalSales;
        }
    }
}