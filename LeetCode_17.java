package LeetCodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 婷灵 on 2020/8/26.
 */
public class LeetCode_17 {
    public static void main(String args[]){
        char[] c={'a','b','c'};
        System.out.println(c.toString());
    }
    //这边用的是暴力递归的方式，得益于昨天做上升子串，暴力遍历
    List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return res;
        }
        String s="";
        int num=0;
        char[] chs=digits.toCharArray();
        def(s,num,chs);
        return res;

    }
    private void def(String s,int num,char[] chs){
        if(num==chs.length){
            String temp=s;
            res.add(temp);
            return;
        }
        if(chs[num]=='2'){
            def(s+'a',num+1,chs);
            def(s+'b',num+1,chs);
            def(s+'c',num+1,chs);
        }else if(chs[num]=='3'){
            def(s+'d',num+1,chs);
            def(s+'e',num+1,chs);
            def(s+'f',num+1,chs);
        }else if(chs[num]=='4'){
            def(s+'g',num+1,chs);
            def(s+'h',num+1,chs);
            def(s+'i',num+1,chs);
        }else if(chs[num]=='5'){
            def(s+'j',num+1,chs);
            def(s+'k',num+1,chs);
            def(s+'l',num+1,chs);
        }else if(chs[num]=='6'){
            def(s+'m',num+1,chs);
            def(s+'n',num+1,chs);
            def(s+'o',num+1,chs);
        }else if(chs[num]=='7'){
            def(s+'p',num+1,chs);
            def(s+'q',num+1,chs);
            def(s+'r',num+1,chs);
            def(s+'s',num+1,chs);
        }else if(chs[num]=='8'){
            def(s+'t',num+1,chs);
            def(s+'u',num+1,chs);
            def(s+'v',num+1,chs);
        }else if(chs[num]=='9'){
            def(s+'w',num+1,chs);
            def(s+'x',num+1,chs);
            def(s+'y',num+1,chs);
            def(s+'z',num+1,chs);
        }
    }
    //官方解法（主要用到了hashMap）在leetcode里面，使用了hashMap之后时间变少了，
    // 还有就是StringBuilder比String空间复杂度要少，但是这两者都是用的递归的思想
    public List<String> letterCombinations1(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null||digits.length()==0){
            return res;
        }
        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        dfs(digits,res,0,map,new StringBuilder());
        return res;
    }
    private void dfs(String s,List<String> list,int index,HashMap<Integer,String> map,StringBuilder temp){
        if(index==s.length()){
            list.add(temp.toString());
            return;
        }
        String t=map.get(s.charAt(index)-'0');
        for(int  i=0;i<t.length();i++){
            temp.append(t.charAt(i));
            dfs(s,list,index+1,map,temp);
            temp.deleteCharAt(index);
        }
    }
}
