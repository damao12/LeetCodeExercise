package LeetCodeTest;

/**
 * Created by 婷灵 on 2020/8/10.
 */
public class LeetCode_8 {

    public static void main(String args[]){
        String s1="2147483648";
        String s2="   -42";
        String s3="4193 with words";
        String s4="words and 987";
        String s5="-91283472332";

        System.out.println(myAtoi(s1));
       /* System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));*/

    }

    public static int myAtoi(String str) {
        if(str==null||str.length()==0)
            return 0;
        boolean flag=true;
        int i=0;
        while (i<str.length()&&str.charAt(i)==' '){
            i++;
        }
        if(i<str.length()&&str.charAt(i)=='-'){
            flag=false;
            i++;
        }else if(i<str.length()&&str.charAt(i)=='+'){
            i++;
        }
        int res=0;
        while (i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            int temp=str.charAt(i)-'0';
            if((res>214748364||(res==214748364&&temp>=8))&&flag){
                return 2147483647;
            }else if((res>214748364||(res==214748364&&temp>=9))&&!flag){
                return -2147483648;
            }
            res=res*10+temp;
            i++;
        }
        return flag?res:-res;
    }
}
