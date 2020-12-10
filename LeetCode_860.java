package com.imooc.o2o.ThreadTest;

/**
 * Created by 婷灵 on 2020/12/10.
 */
public class LeetCode_860 {
    public boolean lemonadeChange(int[] bills) {
        int countFive=0,countTen=0;
        for(int bill:bills){
            if(bill==5){
                countFive++;
            }else if(bill==10){
                if(countFive>0){
                    countFive--;
                    countTen++;
                }else{
                    return false;
                }
            }else{
                if(countTen>0&&countFive>0){
                    countFive--;
                    countTen--;
                }else if(countFive>=3){
                    countFive-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
