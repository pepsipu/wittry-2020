
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
        char[] charDigits = String.valueOf(num).toCharArray();
        List<Integer> digits = new ArrayList<Integer>();
        List<Integer> digitsBad = new ArrayList<Integer>();
        List<Character> newPalindrome = new ArrayList<Character>();
        for (char digit: charDigits) {
            digitsBad.add(Integer.parseInt("" + digit));
        }
        for (Integer digit: digitsBad) {
            if (!digits.contains(digit)) {
                digits.add(digit);
            }
        }
        Collections.sort(digits);
        if (digits.get(0) == 0) {
            int temp = digits.get(1);
            digits.set(1, digits.get(0));
            digits.set(0, temp);
        }
        for (Iterator<Integer> it = digits.iterator(); it.hasNext(); ) {
            Integer newInt = it.next();
            newPalindrome.add(String.valueOf(newInt).toCharArray()[0]);
        }
        Collections.reverse(digits);
        if ((digits.size() % 2 == 0)) {
            digits.remove(0);
        }
        for (Iterator<Integer> it = digits.iterator(); it.hasNext(); ) {
            Integer newInt = it.next();
            newPalindrome.add(String.valueOf(newInt).toCharArray()[0]);
        }
        StringBuilder stringPalindrome = new StringBuilder();
        for (Iterator<Character> it = newPalindrome.iterator(); it.hasNext(); ) {
            stringPalindrome.append(it.next());
        }
        return Integer.parseInt(stringPalindrome.toString());
    }


}