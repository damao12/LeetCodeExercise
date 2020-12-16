package com.imooc.o2o.ThreadTest;

import java.util.HashMap;

/**
 * Created by 婷灵 on 2020/12/16.
 */
public class LeetCode_290 {

    public static void main( String[] args ) {
        String s1="ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s2="s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        LeetCode_290 test=new LeetCode_290();
       System.out.println( test.wordPattern(s1,s2));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] ss=s.split(" ");
        char[] cs=pattern.toCharArray();
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<String,Integer> map2=new HashMap<>();
        if(ss.length!=cs.length){
            return false;
        }
        for(int i=0;i<ss.length;i++){
            if(!map1.containsKey(cs[i])&&map2.containsKey(ss[i])){
                return false;
            }else if(map1.containsKey(cs[i])&&!map2.containsKey(ss[i])){
                return false;
            }else if(map1.containsKey(cs[i])&&map2.containsKey(ss[i])&&map1.get(cs[i]).intValue()!=map2.get(ss[i]).intValue()){
                return false;
            }else{
                map1.put(cs[i],i);
                map2.put(ss[i],i);
            }
        }
        return true;
    }
}
