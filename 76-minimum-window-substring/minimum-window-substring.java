class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Required frequency
        for (int k = 0; k < t.length(); k++) {
            char ch = t.charAt(k);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int cnt = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int j = 0; j < s.length(); j++) {

            char ch = s.charAt(j);

            // Add character to window
            if (mp.containsKey(ch)) {

                window.put(ch, window.getOrDefault(ch, 0) + 1);

                // Only count required occurrences
                if (window.get(ch) <= mp.get(ch)) {
                    cnt++;
                }
            }

            // Window is valid
            while (cnt == t.length()) {

                // Update minimum window
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char left = s.charAt(i);

                // Remove left character
                if (mp.containsKey(left)) {

                    window.put(left, window.get(left) - 1);

                    // Now window is missing a required character
                    if (window.get(left) < mp.get(left)) {
                        cnt--;
                    }
                }

                i++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}