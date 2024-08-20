/**
 * https://leetcode.com/problems/online-stock-span/description/
 * Approach 1 :
 */
class StockSpanner {
    List<Integer> data;
    public StockSpanner() {
        data = new ArrayList<>();
    }

    public int next(int price) {
        data.add(price);

        int counter = 1;
        for (int i=data.size()-2;i>=0;i--) {
            if (data.get(i) <= price) counter++;
            else break;
        }

        return counter;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/**
 * Approach 2 :
 */