/**
 * https://leetcode.com/problems/simple-bank-system/description/
 */
class Bank {
    long[] balance1;
    int n;
    public Bank(long[] balance) {
        balance1 = balance;
        n = balance.length;
    }

    private boolean isValidAccount(int acc) {
        if (acc >= 1 && acc <= n) return true;
        return false;
    }

    private boolean suffBalance(int acc, long amount) {
        if (balance1[acc-1] >= amount) return true;
        return false;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (isValidAccount(account1) && isValidAccount(account2)
                && suffBalance(account1, money)) {
            balance1[account1-1] -= money;
            balance1[account2-1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (isValidAccount(account)) {
            balance1[account-1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (isValidAccount(account) && suffBalance(account, money)) {
            balance1[account-1] -= money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */