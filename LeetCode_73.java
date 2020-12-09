package com.imooc.o2o.ThreadTest;

/**
 * Created by 婷灵 on 2020/12/9.
 */
public class LeetCode_73 {
    public void setZeroes(int[][] matrix) {
        //用两个数组来记录哪一行哪一列有0，然后对于某一行或者某一列有0把它置0
        //rows用来记录行
        boolean[] rows=new boolean[matrix.length];
        //cols用来记录列
        boolean[] cols=new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(!rows[i]){
                        rows[i]=true;
                    }
                    if(!cols[j]){
                        cols[j]=true;
                    }
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rows[i]||cols[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        //前面我们都是新建了两个数组来记录哪一行或者哪一列有0，
        //现在我们可以直接用第一行和第一列来记录
        //并用另外两个标志位来记录第一行的情况
        boolean first_row=false;
        boolean first_col=false;
        //首先判断第一列的情况,用forst_col来记录
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                first_col=true;
                break;
            }
        }
        //然后判断第一行的情况，用first_row记录
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                first_row=true;
                break;
            }
        }
        //从i=1，j=1开始判断，利用第一行第一列来记录其他的
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(first_row){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if(first_col){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}
