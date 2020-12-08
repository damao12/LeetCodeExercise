package LeetCodeTest;

/**
 * Created by 婷灵 on 2020/8/7.
 */
public class LeetCode_7 {

    public static void main(String args[]){

        int n=12000;
        System.out.println(reverse(n));

    }

    public static int reverse(int x) {
        boolean flag=true;
        if(x==-2147483648)
            return 0;
        if(x<0)
            flag=false;
        x=Math.abs(x);
        int  res=0;
        while (x>0){
            int  temp=x%10;
            if(res>214748364||(res==214748364&&temp>7)){
                return 0;
            }
            res=res*10+temp;
            x=x/10;
        }
        res=flag?res:-res;

      return res;

    }
}
