class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        // Concatenate s with itself; if goal is a substring, it's a rotation
        String doubled = s + s;
        return doubled.contains(goal);
    }
}