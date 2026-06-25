class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<Pair> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!st.isEmpty() && st.peek().ch == c) {
                st.peek().count++;

                if (st.peek().count == k) {
                    st.pop();
                }
            } else {
                st.push(new Pair(c, 1));
            }
        }

        StringBuilder ans = new StringBuilder();

        for (Pair p : st) {
            for (int i = 0; i < p.count; i++) {
                ans.append(p.ch);
            }
        }

        return ans.toString();
    }
}