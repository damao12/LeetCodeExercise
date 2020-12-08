package LeetCodeTest;

/**
 * Created by 婷灵 on 2020/8/3.
 * 这题如果不要求时间复杂度的话，最容易想到的方法就是把两个数组合并成一个有序数组,然后去中位数，但是那样感觉
 * 因为要开一个新数组有空间复杂度，而且最起码跑完两个数组。
 * 所以选择了跑一半的方式
 */
public class LeetCode_4 {
    public static void main(String args[]){
        int nums1[] ={2,3};
        int nums2[] = {};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length;
        double res=0;
       if(nums1==null||nums1.length==0){
           length=nums2.length;
           if(length%2==0){
               res=(nums2[length/2]+nums2[length/2-1])/2.0;
           }else{
               res=nums2[length/2];
           }
       }else if(nums2==null||nums2.length==0){
           length=nums1.length;
           if(length%2==0){
               res=(nums1[length/2]+nums1[length/2-1])/2.0;
           }else{
               res=nums1[length/2];
           }
       }else{
           length=nums1.length+nums2.length;
         int i=0,j=0,temp=0;
         while (i<nums1.length&&j<nums2.length&&temp<length/2){
             if(nums1[i]<nums2[j]){
                 res=nums1[i];
                 i++;
             }else{
                 res=nums2[j];
                 j++;
             }
             temp++;
         }
         while (i<nums1.length&&temp<length/2){
             res=nums1[i];
             i++;
             temp++;
         }
           while (j<nums2.length&&temp<length/2){
               res=nums2[j];
               temp++;
               j++;
           }
           if(length%2!=0)
               if(i<nums1.length&&j<nums2.length){
                   if(nums1[i]<nums2[j])
                       res=nums1[i];
                   else
                       res=nums2[j];
               }else if(i>=nums1.length){
                   res=nums2[j];
               }else{
                   res=nums1[i];
               }

           else{
               if(i<nums1.length&&j<nums2.length){
                   if(nums1[i]<nums2[j])
                       res=(res+nums1[i])/2;
                   else
                       res=(res+nums2[j])/2;
               }else if(i>=nums1.length){
                   res=(res+nums2[j])/2;
               }else{
                   res=(res+nums1[i])/2;
               }

           }

       }
       return res;

    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length;
        double res=0;
        if(nums1==null||nums1.length==0){
            length=nums2.length;
            if(length%2==0){
                res=(nums2[length/2]+nums2[length/2-1])/2.0;
            }else{
                res=nums2[length/2];
            }
        }else if(nums2==null||nums2.length==0){
            length=nums1.length;
            if(length%2==0){
                res=(nums1[length/2]+nums1[length/2-1])/2.0;
            }else{
                res=nums1[length/2];
            }
        }else{
            length=nums1.length+nums2.length;
            int i=0,j=0,temp=0;
            while (i<nums1.length&&j<nums2.length&&temp<length/2){
                if(nums1[i]<nums2[j]){
                    res=nums1[i];
                    i++;
                }else{
                    res=nums2[j];
                    j++;
                }
                temp++;
            }
            while (i<nums1.length&&temp<length/2){
                res=nums1[i];
                i++;
                temp++;
            }
            while (j<nums2.length&&temp<length/2){
                res=nums2[j];
                temp++;
                j++;
            }
            if(length%2!=0)
                if(i<nums1.length&&j<nums2.length){
                    if(nums1[i]<nums2[j])
                        res=nums1[i];
                    else
                        res=nums2[j];
                }else if(i>=nums1.length){
                    res=nums2[j];
                }else{
                    res=nums1[i];
                }

            else{
                if(i<nums1.length&&j<nums2.length){
                    if(nums1[i]<nums2[j])
                        res=(res+nums1[i])/2;
                    else
                        res=(res+nums2[j])/2;
                }else if(i>=nums1.length){
                    res=(res+nums2[j])/2;
                }else{
                    res=(res+nums1[i])/2;
                }

            }

        }
        return res;

    }
}
