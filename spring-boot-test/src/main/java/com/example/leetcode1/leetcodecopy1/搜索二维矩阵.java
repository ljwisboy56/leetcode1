package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-08 17:59
 */
public class 搜索二维矩阵 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1}};

//        arr[0] = new int[]{1,3,5,7};
//        arr[1] = new int[]{10,11,16,20};
//        arr[2] = new int[]{23,30,34,50};

//        arr[1] = new int[]{1,1};



        boolean res = new 搜索二维矩阵().searchMatrix(arr,2);
        System.out.println(res);


    }


    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length ==0){
            return false;
        }

       int m = matrix.length;

       int n = matrix[0].length;

       int len = m * n;

       int start =0;

       int end = len-1;

       int res= -1;

       while (start <= end){

           int mid = (start + end)/2;

           int realRow = mid / n ;

           int realCol = mid % n;

           if(target < matrix[realRow][realCol]){
               end = mid - 1;
           }else if(target >matrix[realRow][realCol]){
               start = mid +1;
           }else {
               res = mid;
               break;
           }
       }

       return res != -1;

    }
}
