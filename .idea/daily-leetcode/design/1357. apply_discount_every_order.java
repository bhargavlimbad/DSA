/**
 * https://leetcode.com/problems/apply-discount-every-n-orders/description/
 */
class Cashier {
    int custNum = 1;
    int N;
    double discountFact;
    Map<Integer, Integer> productList;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        N = n;
        discountFact = (100 - discount)/100.0;
        productList = new HashMap<>();

        for (int i=0;i<prices.length;i++) {
            productList.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        double bill = 0.0;
        for (int i=0;i<product.length;i++) {
            bill = bill + (productList.get(product[i]))*(amount[i]);
        }

        if (custNum%N == 0) {
            bill = (bill*discountFact);
        }
        custNum++;

        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */