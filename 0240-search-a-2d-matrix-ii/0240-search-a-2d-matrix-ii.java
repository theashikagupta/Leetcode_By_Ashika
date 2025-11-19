class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int r=0;
        int c=matrix[0].length-1;
        return helper(matrix,target,r,c);
    }
    public static boolean helper(int[][]matrix,int target, int r,int c){
            
            if(r>matrix.length-1 || c<0) return false;
            if(target==matrix[r][c]){
                return true;
            }else if(target>matrix[r][c]){
                return helper(matrix,target,r+1,c);
            }else{
                return helper(matrix,target,r,c-1);
            }
    }
}
