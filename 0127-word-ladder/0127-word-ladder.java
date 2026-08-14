class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Create a set of all words in the word list for quick lookup.
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord is not in the word set, no valid transformation exists.
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Use a queue to perform BFS (Breadth-First Search).
        Queue<String> wordQueue = new LinkedList<>();

        // Start BFS with the beginWord.
        wordQueue.add(beginWord);

        // Distance from the beginWord (initially 1 since beginWord is counted).
        int distance = 1;

        // BFS loop: continue until the queue is empty.
        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();

            // Process each word in the current level.
            for (int i = 0; i < size; i++) {
                String currWord = wordQueue.poll();

                // If the current word is the endWord, return the distance.
                if (currWord.equals(endWord)) {
                    return distance;
                }

                // Try changing each character in the current word.
                for (int j = 0; j < currWord.length(); j++) {
                    char[] temp = currWord.toCharArray();

                    // Replace the character at index j with every letter from 'a' to 'z'.
                    for (char c = 'a'; c <= 'z'; c++) {
                        temp[j] = c;
                        String newWord = new String(temp);

                        if (wordSet.contains(newWord)) {
                            wordQueue.add(newWord);
                            wordSet.remove(newWord); 
                        }
                    }
                }
            }

            distance++;
        }
        return 0;
    }
}