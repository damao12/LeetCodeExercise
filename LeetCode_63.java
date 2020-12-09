package com.imooc.o2o.ThreadTest;

/**
 * Created by 婷灵 on 2020/12/9.
 */
class LeetCode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0)
            return 0;
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] nums=new int[m][n];
        nums[0][0]=obstacleGrid[0][0]==0?1:0;
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==0){
                nums[0][i]=nums[0][i-1];
            }else{
                nums[0][i]=0;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    nums[i][j]=0;
                }else if(j==0){
                    nums[i][j]=nums[i-1][j];
                }else{
                    nums[i][j]=nums[i-1][j]+nums[i][j-1];
                }
            }
        }
        return nums[m-1][n-1];
    }
}