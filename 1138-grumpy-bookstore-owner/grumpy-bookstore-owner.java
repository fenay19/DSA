class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;

        // Customers satisfied normally
        int base = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }

        // First window: extra customers we can save
        int window = 0;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                window += customers[i];
            }
        }

        int maxWindow = window;

        // Slide the window
        for (int i = minutes; i < n; i++) {

            // Add new customer
            if (grumpy[i] == 1) {
                window += customers[i];
            }

            // Remove customer leaving the window
            if (grumpy[i - minutes] == 1) {
                window -= customers[i - minutes];
            }

            maxWindow = Math.max(maxWindow, window);
        }

        return base + maxWindow;
    }
}