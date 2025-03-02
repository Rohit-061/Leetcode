class Solution {
  
    // Method to find the string based on the longest common prefix (lcp) information provided.
    public String findTheString(int[][] lcp) {
        // 'n' is the length of the string to be constructed.
        int n = lcp.length;
        // 's' is the character array that will form the resultant string.
        char[] chars = new char[n];
      
        // Iterate over each character starting from 'a' to 'z' to construct the string.
        for (char c = 'a'; c <= 'z'; ++c) {
            int i = 0;
            // Skip filled characters in the 'chars' array.
            while (i < n && chars[i] != '\0') {
                ++i;
            }
            // If all characters are filled, break the loop as the string is complete.
            if (i == n) {
                break;
            }
            // Assign the current character to each position in the array that has a
            // non-zero value in the lcp matrix for that index.
            for (int j = i; j < n; ++j) {
                if (lcp[i][j] > 0) {
                    chars[j] = c;
                }
            }
        }
      
        // Check if there are any unfilled positions in 'chars'. If found, return an empty string.
        for (int i = 0; i < n; ++i) {
            if (chars[i] == '\0') {
                return "";
            }
        }

        // Validate whether the constructed string is correct based on the lcp information.
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (chars[i] == chars[j]) {
                    if (i == n - 1 || j == n - 1) {
                        if (lcp[i][j] != 1) {
                            return "";
                        }
                    } else if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
                        return "";
                    }
                } else if (lcp[i][j] > 0) {
                    return "";
                }
            }
        }
      
        // Return the constructed string.
        return new String(chars);
    }
}