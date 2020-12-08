package LeetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 婷灵 on 2020/9/10.
 */
public class LeetCode_15 {
    public static void main(String args[]){
        int[] nums={0,0,0,0,0};
        List<List<Integer>> res=new ArrayList<>();
        LeetCode_15 test=new LeetCode_15();
        res=test.threeSum(nums);
        for(int i=0;i<res.size();i++){
            for(int  j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    //这个代码存在的问题是：还没有去重
    public List<List<Integer>> threeSum( int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            int left=i+1,right=nums.length-1;
            int temp=-nums[i];
            while(left<right){
                if(nums[left]+nums[right]==temp){
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    int m=0;
                    for(;m<res.size();m++){
                        int n=0;
                        for(;n<3;n++){
                            if(res.get(m).get(n)!=list.get(n))
                                break;
                        }
                        if(n==3)
                            break;
                    }
                    if(m==res.size()){
                        res.add(new ArrayList(list));
                    }
                    list=new ArrayList<>();
                    left++;
                }else if(nums[left]+nums[right]>temp){
                    right--;
                }else {
                    left++;
                }

            }
        }
        return res;

    }
}
