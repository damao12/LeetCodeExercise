package LeetCodeTest;

import sun.misc.LRUCache;

/**
 * Created by 婷灵 on 2020/8/20.
 * 这个题很有意思，暴力解法的第一感觉是两个for循环
 * 看了解题思路之后是双指针（其实第一次想的时候一直觉得是动态规划，双指针的想法还挺难想到的）
 */
public class LeetCode_11 {

    public static void main(String args[]){
        int[] nums={1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new LeetCode_11().maxArea(nums));
    }

    public int maxArea(int[] height) {
        if(height==null||height.length<2)
            return 0;
        int left=0,right=height.length-1,area=0;
        while (left<right){
           /* area=Math.max((right-left)*Math.min(height[left],height[right]),area);
            if(height[left]>height[right])
                right--;
            else
                left++;*/
           int tempArea=0;
           if(height[left]>height[right]){
               tempArea=(right-left)*height[right];
               right--;
           }else {
               tempArea=(right-left)*height[left];
               left++;
           }
            area=tempArea>area?tempArea:area;
        }
        return area;

    }
}
