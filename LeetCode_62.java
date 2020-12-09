package com.imooc.o2o.ThreadTest;

/**
 * Created by 婷灵 on 2020/12/9.
 */
class LeetCode_62 {
    public int uniquePaths(int m, int n) {
        if(n==1||m==1)
            return 1;
        int[][] nums=new int[2][n];
        for(int i=0;i<n;i++){
            nums[0][i]=1;
        }
        for(int i=1;i<2;i++){
            nums[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                nums[1][j]=nums[0][j]+nums[1][j-1];
            }
            nums[0]=nums[1];
        }

        return nums[1][n-1];
    }
}