class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : p.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int j = 0;
        HashMap<Character, Integer> seen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            seen.put(ch, seen.getOrDefault(ch, 0) + 1);

            // Shrink the window if it becomes too large
            while (i - j + 1 > p.length()) {
                char cx = s.charAt(j);

                seen.put(cx, seen.get(cx) - 1);

                if (seen.get(cx) == 0) {
                    seen.remove(cx);
                }

                j++;
            }

            // Check only when window size equals p.length()
            if (i - j + 1 == p.length() && map.equals(seen)) {
                ans.add(j);
            }
        }

        return ans;
    }
}