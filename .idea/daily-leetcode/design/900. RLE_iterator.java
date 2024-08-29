/**
 * https://leetcode.com/problems/rle-iterator/
 */
class RLEIterator {
    int pointer;
    int counter;
    int[] enc;

    public RLEIterator(int[] encoding) {
        pointer = 0;
        counter = 0;
        enc = encoding;
    }

    public int next(int n) {
        if (pointer >= enc.length) return -1;

        int count = enc[pointer];
        while (n > count) {
            n -= count;
            pointer += 2;

            if (pointer >= enc.length) return -1;
            count = enc[pointer];
        }

        enc[pointer] -= n;
        return enc[pointer+1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */