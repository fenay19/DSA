import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> parents = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return ans;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            Set<String> levelVisited = new HashSet<>();

            for (int k = 0; k < size; k++) {

                String word = q.poll();

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original)
                            continue;

                        arr[i] = ch;

                        String next = new String(arr);

                        if (!dict.contains(next))
                            continue;

                        if (!visited.contains(next)) {

                            if (!levelVisited.contains(next)) {
                                q.offer(next);
                                levelVisited.add(next);
                            }

                            parents
                                .computeIfAbsent(next, x -> new ArrayList<>())
                                .add(word);

                            if (next.equals(endWord))
                                found = true;
                        }
                    }

                    arr[i] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        if (!found)
            return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, path);

        return ans;
    }

    private void dfs(String word, String beginWord, List<String> path) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);

            return;
        }

        if (!parents.containsKey(word))
            return;

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, path);

            path.remove(path.size() - 1);
        }
    }
}