
class Solution {
    public int findNthDigit(int n) {
        long digit = 1;
        long cnt = 9;
        long start = 1;

        while (n > digit * cnt) {
            n -= digit * cnt;
            digit++;
            cnt *= 10;
            start *= 10;
        }

        long num = start + (n - 1) / digit;
        int indx = (int) ((n - 1) % digit);

        return String.valueOf(num).charAt(indx) - '0';
    }
}
