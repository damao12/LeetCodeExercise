package LeetCodeTest;

/**
 * Created by 婷灵 on 2020/8/18.
 */
public class LeetCode_9 {
    public static void main(String args[]){
        int x1=121;
        int x2=-121;
        int x3=10;
        int x4=1;
       System.out.println(LeetCode_9.isPalindrome(x1));
        System.out.println(LeetCode_9.isPalindrome(x2));
        System.out.println(LeetCode_9.isPalindrome(x3));
        System.out.println(LeetCode_9.isPalindrome(x4));
    }
    public  static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String s=String.valueOf(x);
        int i=0;
        while (i<s.length()/2){
            int tempC=s.charAt(i)-'0';
            int tempI=x%10;
            if(tempC==tempI){
                i++;
                x=x/10;
            }else{
                return false;
            }
        }
        return true;

    }
}
