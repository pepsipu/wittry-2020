
import java.lang.*;
import java.util.*;
/**
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
public class PalindromicNumber
{
    static int NO_OF_CHARS = 256;
    /*
     *   n >= 0
     */
    public static boolean isPalindromic( int n )
    {
        String str = "" + n;
        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);
        for (int i = 0; i < str.length(); i++)
            count[(int)(str.charAt(i))]++;
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++)
        {
            if ((count[i] & 1) == 1)
                odd++;

            if (odd > 1)
                return false;
        }
        return true;
    }

    /*
     *     n >= 0
     *
     *     you may assume the created palidrome will be a legal int value
     */
    public static int getSmallestPalindrome(int num)
    {

        String s = "" + num;
        if(s.length()<=1)
        {

            return num;
        }

        if(s.length()==3)
        {
            if(s.charAt(0)==s.charAt(1) || s.charAt(0)==s.charAt(2) || s.charAt(1)==s.charAt(2))
            {
                String str = "";
                if(s.charAt(0)==s.charAt(1))
                {
                    str = "" + s.charAt(0) + s.charAt(2) + s.charAt(1);
                }
                if(s.charAt(1)==s.charAt(2))
                {
                    str = "" + s.charAt(1) + s.charAt(0) + s.charAt(2);
                }
                if(s.charAt(0)==s.charAt(2))
                {
                    str = "" + s.charAt(0) + s.charAt(2) + s.charAt(2);
                }
                return Integer.parseInt(str);
            }

        }

        String new_s = s+"#"+new StringBuilder(s).reverse().toString();
        int[] position = new int[new_s.length()];

        for(int i=1;i<position.length;i++)
        {
            int pre_pos = position[i-1];
            while(pre_pos>0 && new_s.charAt(pre_pos)!=new_s.charAt(i))
                pre_pos = position[pre_pos-1];
            position[i] = pre_pos+((new_s.charAt(pre_pos)==new_s.charAt(i))?1:0);
        }

        String temp = new StringBuilder(s.substring(position[position.length-1])).reverse().toString()+s;
        System.out.println("Output: " + temp);
        int x = Integer.parseInt(temp);
        return x;
    }

    public static String getReverse(String str)
    {
        String reverse = "";
        for(int i = str. length() - 1; i >= 0; i--)
        {
            reverse = reverse + str. charAt(i);
        }
        return reverse;
    }


}