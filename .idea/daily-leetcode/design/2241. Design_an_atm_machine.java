/**
 * https://leetcode.com/problems/design-an-atm-machine/description/
 */
class ATM {
    // {0, 20} {1, 50} {2, 100} {3, 200} {4, 500}
    int[] notes;

    public ATM() {
        notes = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i=0;i<5;i++) {
            notes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] result = new int[5];

        if (amount >= 500) {
            int temp = helper(amount, 500, notes[4]);
            result[4] = temp;
            amount -= 500*temp;
        }
        if (amount >= 200) {
            int temp = helper(amount, 200, notes[3]);
            result[3] = temp;
            amount -= 200*temp;
        }
        if (amount >= 100) {
            int temp = helper(amount, 100, notes[2]);
            result[2] = temp;
            amount -= 100*temp;
        }
        if (amount >= 50) {
            int temp = helper(amount, 50, notes[1]);
            result[1] = temp;
            amount -= 50*temp;
        }
        if (amount >= 20) {
            int temp = helper(amount, 20, notes[0]);
            result[0] = temp;
            amount -= 20*temp;
        }

        if (amount == 0) {
            for (int i=0;i<5;i++) {
                notes[i] -= result[i];
            }
            return result;
        }
        int[] res = {-1};
        return res;
    }

    private int helper(int amount, int note, int count) {
        return Math.min(count, (amount/note));
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */

/**
 * Chain of responcibility principle
 */