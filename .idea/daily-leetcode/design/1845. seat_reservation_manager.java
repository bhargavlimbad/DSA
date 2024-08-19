/**
 * https://leetcode.com/problems/seat-reservation-manager/description/
 * Approach 1 :
 * TC : O(nlogn) [logn for adding element in the priority queue and we are doing it n times]
 *      O((n+m)logn) [m is number of times reservation method calls performed]
 * SC : O(n)
 */
class SeatManager {
    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();

        for (int i=1;i<=n;i++) {
            pq.add(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */

/**
 * Approach 2 : Optimize the initial n adding call to priority queue
 */