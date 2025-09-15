class Solution {
    public int romanToInt(String s) {
        //TC:O(n) SC:O(n)
        int n = s.length();
        int total = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));

            // If a smaller value is placed before a bigger value → subtract it (like IV = 4).
            // Otherwise, add it (like VI = 6)

            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                total -= value;
            } else {
                total += value;
            }
        }
        return total;
    }
}