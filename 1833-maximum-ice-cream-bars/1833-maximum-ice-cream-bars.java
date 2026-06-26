class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for (int c : costs) {
            maxCost = Math.max(maxCost, c);
        }

        int[] freq = new int[maxCost + 1];
        for (int c : costs) {
            freq[c]++;
        }

        int count = 0;
        for (int cost = 1; cost <= maxCost; cost++) {
            if (freq[cost] == 0) continue;
            if (coins < cost) break;

            // Buy as many as possible at this cost
            int canBuy = Math.min(freq[cost], coins / cost);
            coins -= canBuy * cost;
            count += canBuy;
        }

        return count;
    }
}