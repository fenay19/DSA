class Solution {
    public String removeDuplicateLetters(String s) {

        int[] last = new int[26];

        // Store last occurrence of every character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Already present in answer
            if (set.contains(ch))
                continue;

            // Remove bigger characters if they appear later
            while (!st.isEmpty()
                    && st.peek() > ch
                    && last[st.peek() - 'a'] > i) {

                set.remove(st.pop());
            }

            st.push(ch);
            set.add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
}