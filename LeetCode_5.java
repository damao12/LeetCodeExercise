package LeetCodeTest;

/**
 * Created by 婷灵 on 2020/8/18.
 * 最长回文子串，最长回文子串一直都没有学会过，好好尝试写
 * 1 暴力解法，找出所有的子串，然后判断每一个子串是不是回文串，找出最长的那个
 *   这种解法的时间复杂度是O（N3），找出子串O(N2)，判断是不是回文串O(N)
 * 2 找最长回文子串的难度在于，很难判断最长回文子串的中心在哪里，因此可以以每一个字符为中心，看回文串的长度
 *   在判断的时候分两种情况，一种是偶数个回文串，此时中心有两个；一种是奇数个的回文串，此时中心只有一个
 *   这个是第一个函数
 * 3 马拉车算法
 */
public class LeetCode_5 {

    public static void main(String args[]){
        LeetCode_5 test=new LeetCode_5();
        System.out.println(test.longestPalindrome(""));
    }


    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        String res=s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            String tempS1=lengthPalindrome(i,i,s);
            String tempS2=lengthPalindrome(i,i+1,s);
            if(tempS1.length()>res.length()){
                res=tempS1;
            }
            if(tempS2.length()>res.length()){
                res=tempS2;
            }
        }
        return res;

    }
    private String lengthPalindrome(int left,int right,String s){
        int i=0;
        while (left>=0&&right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                i++;
            }else{
                break;
            }
        }
        if(i!=0){
            left++;
        }
        return s.substring(left,right);
    }
}


