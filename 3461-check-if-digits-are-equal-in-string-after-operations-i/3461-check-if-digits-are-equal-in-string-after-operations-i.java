class Solution {
    public boolean hasSameDigits(String s) {
        // int n=s.length();
        // StringBuilder sb=new StringBuilder(s);
        // while(n>2){
        //     StringBuilder next = new StringBuilder();
        //     for(int i=0;i<n-1;i++){
        //         int sum=(( s.charAt(i)-'0')+( s.charAt(i+1)-'0'))%10;
        //         next.append((char)(sum + '0'));
        //     }
        //     sb=next;
        //     n--;
        // }
        // return sb.charAt(0)==sb.charAt(1);


        int n = s.length();
        int[] arr = new int[n];

        // Convert string digits to integer array
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        // Reduce step by step until 2 elements left
        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            n--; // array length decreases by 1 each time
        }

        // Compare the final two digits
        return arr[0] == arr[1];
    }
}