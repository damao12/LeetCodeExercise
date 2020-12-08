package LeetCodeTest;

import java.util.HashMap;

/**
 * Created by 婷灵 on 2020/8/3.
 */
public class LeetCode_3 {
    public static void main(String args[]){
        String s="abba";
        System.out.println(lengthOfLongestSubstring(s));
        String s1="bbbb";
        System.out.println(lengthOfLongestSubstring(s1));
        String s2="pwwkew";
        System.out.println(lengthOfLongestSubstring(s2));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        int start=0;
        int res=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
               start=start>map.get(s.charAt(i))+1?start:map.get(s.charAt(i))+1;
            }
                map.put(s.charAt(i),i);
            res=res>i-start+1?res:i-start+1;
        }
        return res;

    }
}
