class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;                  //no of rows
        int col=matrix[0].length;              //no of columns
        return helper(matrix,0 ,row*col-1,col,target);
    
        
 
    }
    public static boolean helper(int[][] matrix,int low,int high, int col,int target){
       
        if(low>high) return false;
        int mid=low+(high-low)/2;
        int r=mid/col;
        int c=mid % col;
        if(matrix[r][c]==target){
            return true;
        }
        else if(matrix[r][c]>target){
            return helper(matrix,low,mid-1,col,target);
        }
        else{
            return helper(matrix,mid+1,high,col,target);
        }
    }
}