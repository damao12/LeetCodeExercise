package com.imooc.o2o.ThreadTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 婷灵 on 2020/12/14.
 */
public class LeetCode_49 {
    public static void main( String[] args ) {
        String[] str={"abets","bead","remain","betas","abed","baste","airline","leading","beast","dealing","beats","airmen","marine","single","bade","aligned"};
        LeetCode_49 test=new LeetCode_49();
       List<List<String>> res=test.groupAnagrams(str);
       for(List<String> list:res){
           for(String s:list){
               System.out.print(s+" ");
           }
           System.out.println();
       }
    }


    //这种方法可以，但是时间复杂度太大，超出时间限制
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        for(String str:strs){
            int[] nums=new int[26];
            boolean flag=false;
            for(int i=0;i<str.length();i++){
                nums[str.charAt(i)-'a']++;
            }
            for(List<String> list:res){
                int[] count=nums.clone();
                String temp=list.get(0);
                if(temp.length()!=str.length()){
                    continue;
                }
                int i=0;
                for(;i<temp.length();i++){
                    if(count[temp.charAt(i)-'a']<=0){
                        break;
                    }else{
                        count[temp.charAt(i)-'a']--;
                    }
                }
                if(i==temp.length()){
                    list.add(str);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                List<String> list=new ArrayList<>();
                list.add(str);
                res.add(list);
            }
        }
        return res;
    }


    //这个想法真的太好了，把26个字母对应于26个质数
    long[] prime = new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<Long, ArrayList<String>> map=new HashMap<>();
        List<List<String>> lists=new ArrayList<>();
        for(String str:strs){
            Long hash=getHash(str);
            if(!map.containsKey(hash)){
                map.put(hash,new ArrayList<>());
            }
            map.get(hash).add(str);
        }
        for(Long key:map.keySet()){
            lists.add(map.get(key));
        }
        return lists;
    }

    private Long getHash(String str) {
        long hash=1;
        for(char c:str.toCharArray()){
            hash*=prime[c%26];
        }

        return hash;
    }
}
