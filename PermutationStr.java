//Given two strings s1 and s2, return true if s2 contains a 
//permutation of s1, or false otherwise.

//In other words, return true if one of s1's permutations is the substring //of s2.

class PermutationStr {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Create a frequency map for characters in s1
        int[] charCountS1 = new int[26];
        for (char c : s1.toCharArray()) {
            charCountS1[c - 'a']++;
        }

        // Create a sliding window to iterate through s2
        int left = 0;
        int right = 0;

        // Track the frequency map for characters in the window
        int[] windowCount = new int[26];

        while (right < s2.length()) {
            char currentChar = s2.charAt(right);
            windowCount[currentChar - 'a']++;

            // Check if the window size is equal to s1 length
            if (right - left + 1 == s1.length()) {
                // Compare character frequencies in window and s1
                if (isMatch(charCountS1, windowCount)) {
                    return true;
                }

                // Slide the window by removing the leftmost character
                windowCount[s2.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return false;
    }

    private boolean isMatch(int[] charCountS1, int[] windowCount) {
        for (int i = 0; i < 26; i++) {
            if (charCountS1[i] != windowCount[i]) {
                return false;
            }
        }
        return true;
    }
}