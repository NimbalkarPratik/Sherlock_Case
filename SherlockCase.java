import java.util.*;

public class SherlockCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if(( T < 1) || (T > 100 ))
        {
            System.out.println("Condition Not Satisfy");
            return ;
        }
        while (T-- > 0) {
            String pattern = sc.next();
            if((pattern.length() < 1) || (pattern.length() >1000))
            {
                System.out.println("Pattern should be between 1 to 1000");
                return;
            }
            String text = sc.next();
            if((text.length() < 1) || (text.length() >100000))
            {
                System.out.println("Text should be between 1 to 100000");
                return;
            }
            boolean found = false;
            int[] count = new int[26];
            for (int i = 0; i < pattern.length(); i++) {
                count[pattern.charAt(i) - 'a']++;
            }
            for (int i = 0; i <= text.length() - pattern.length(); i++) {
                int[] temp = count.clone();
                boolean flag = true;
                for (int j = i; j < i + pattern.length(); j++) {
                    if (--temp[text.charAt(j) - 'a'] < 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
