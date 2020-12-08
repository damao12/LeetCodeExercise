package LeetCodeTest;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by 婷灵 on 2020/7/17.
 */
public class LeetCode_1 {
    public static void main(String args[]){
        LeetCode_1 test=new LeetCode_1();
        int nums[]={3,2,4};
        int target=6;
        int res[]=test.twoSum2(nums,target);
        for(int i=0;i<2;i++){
            System.out.print(res[i]+" ");
        }

    }
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==0||nums==null){
            return null;
        }
        int res[]=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    break;
                }
                if(res[1]!=0)
                    break;
            }
        }

        return res;

    }

    public int[] twoSum2(int[] nums, int target) {
        if(nums.length==0||nums==null){
            return null;
        }
        int res[]=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                res[0]=map.get(nums[i]);
                res[1]=i;
            }
            map.put(target-nums[i],i);
        }
        return res;

    }
}
