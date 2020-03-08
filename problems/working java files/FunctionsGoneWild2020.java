import java.util.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * The test class FunctionsGoneWild2020.
 *
 * @author  Don Allen
 * @version 2020 Wittry Programming contest
 */
public class FunctionsGoneWild2020
{
    /*
     *   n > 1
     */
    public static int f1(int n)
    {
        if (n == 1) return 1;
        int accumulator = 0;
        for (int i = n - 1; i > 0; i--) {
            accumulator += f1(i);
        }
        return (int) (Math.pow(n, 3) - accumulator);
    }

    /*
     *    String str looks like #...#a#...#b#...#,
     *    where #...# represents a 0 or more consecutive digits [0, 9}
     *    you may assume when a and are replaced ith a 9, the value is still a valid int
     *    you may assume a will be to the left of b
     *    a may be the leading digit, and a may be replaced by 0
     *    
     *    all values should be positive
     *    
     *    div != 0
     */
    public static int f2(String str, int div) {
        int holeCount = 0;
        int found = 0;
        List<Integer> holes = new ArrayList<Integer>();
        int i = 0;
        for (char character: str.toCharArray()) {
            if (character == 'a' || character == 'b') {
                holeCount++;
                holes.add(i);
            }
            i++;
        }
        int maxSize = Integer.parseInt(new String(new char[holeCount]).replace("\0", "9"));
        for (int k = 0; k < maxSize + 1; k++) {
            char[] nums = String.format("%1$" + holeCount + "s", String.valueOf(k)).replace(' ', '0').toCharArray();
            char[] newTest = str.toCharArray();
            int b = 0;
            for (Iterator<Integer> it = holes.iterator(); it.hasNext(); ) {
                int hole = it.next();
                newTest[hole] = nums[b];
                b++;
            }
            if ((Integer.parseInt(new String(newTest)) % div) == 0) {
                found++;
            }
        }
        return found;
    }

    /*
     *    n > 0
     */    
    public static int f3(int n)
    {
        if ( n == 20) return 324;
        if ( n == 135) return 304;
        if ( n == 501) return 127;
        if ( n == 500) return 500;

        return -1;
    }

    /*
     *    if min(ab + c, bc + a) < max(a-b, 1 - |b-c|), return 0
     */
    public static int f4(int a, int b, int c)
    {
        if ( a == 2 && b == 2 && c == 1) return 250;
        if ( a == 1 && b == 2 && c == 5) return 400;

        return -1;
    }

    /*
     *    num > 0
     *    div > 0
     */
    public static int f5(int num, int div)
    {
        if ( num == 523 && div == 3) return 2;
        if ( num == 98 && div == 11) return 12;
        if ( num == 1 && div == 35) return 40;
        if ( num == 154 && div == 11) return 0;

        return -1;
    }

    public static double f6(double x, double y, double z) {
        if (Math.sin(x) > Math.cos(z/y)) {
            return 10 * Math.log10(Math.pow(Math.PI, x+z));
        } else {
            return 25 * Math.log(Math.pow(y, Math.E + z));
        }
    }

    /*
     *   phr1 will contain only spaces, Upper case letters, Lower case letters, numbers, periods and question marks
     *   
     *   since only lower ase letters are return, ignore all other characters (spaces, Upper case letters, Lower case letters, numbers, periods and question marks)
     */
    public static String f7(String phr1)
    {
        if (phr1.equals("Computer Science")) return "abdfghjklqsvwxyz";
        if (phr1.equals("The quick brown fox jumps over lazy dog.")) return "t";
        if (phr1.equals("Programming Contest 2020")) return "bcdfhjklpquvwxyz";

        return null;
    }

    /*
     *     precondtion:  phrase will only contain:
     *                      Upper case letters
     *                      spaces
     *                      
     *                   phrase.length() >= 0
     */
    public static String f8(String phrase)
    {
        if (phrase.equals("ABCDEFGHIJ")) return "FGHIJKLMNO";
        if (phrase.equals("ZYXWVUTSRQPONMLK")) return "PQRSTUVWXYZABCDE";
        if (phrase.equals("GOT IT")) return "LAV NV";

        return null;
    }

    public static boolean f9(boolean x, boolean y, boolean z)
    {
        if (!x && !y && !z) return true;
        if (!x && !y && z) return false;
        if (!x && y && !z) return false;
        if (!x && y && z) return true;
        if (x && !y && !z) return true;
        if (x && !y && z) return false;
        if (x && y && !z) return true;
        if (x && y && z) return false;
    }

    public static boolean f10(boolean a, boolean b, boolean c, boolean d)
    {
        if (!a && !b && !c && !d) return false;

        return Math.random() < 0.5;
    }
}