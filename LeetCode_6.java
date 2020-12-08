package LeetCodeTest;

/**
 * Created by 婷灵 on 2020/8/3.
 */
public class LeetCode_6 {
    public static void main(String args[]){
        int n=2;
        String s="ABC";
        System.out.println(convert(s,n));
    }

    public static String convert(String s, int numRows) {
        if(s==null||s.length()==0||numRows==1)
            return s;
        StringBuilder res=new StringBuilder();
        for (int i=1;i<=numRows;i++){
           int j=i-1;
           while (j<s.length()){
               res.append(s.charAt(j));
               if(i!=1&&i!=numRows){
                   if(j+2*(numRows-i)<s.length()){
                       res.append(s.charAt(j+2*(numRows-i)));
                   }
               }
               j=j+2*(numRows-1);
           }
        }
        return res.toString();

    }
}
