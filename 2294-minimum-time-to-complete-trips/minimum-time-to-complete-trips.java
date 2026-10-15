
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1;
        long minTime = Integer.MAX_VALUE;

        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        long h = minTime * totalTrips;
        long ans = h;

        while (l <= h) {
            long mid = l + (h - l) / 2;
            long cnt = 0;

            for (int t : time) {
                cnt += mid / t;
            }

            if (cnt >= totalTrips) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
