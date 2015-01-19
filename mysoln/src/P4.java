import java.util.Hashtable;

/**
 * Created by asraful on 1/18/15.
 */
public class P4 {
    static int getLongestLength(String word){
        if(word == null || word.trim() == "")   return 0;
        char[] chars = word.trim().toCharArray();

        Hashtable<Character, Boolean> table = new Hashtable<Character, Boolean>();

        int max = 0, len = 0, start = 0, nextStart = 0;

        for(int i=0; i<chars.length; i++){
            if(!table.containsKey(chars[i])){
                len++;
                if(max < len){
                    max = len;
                    start = nextStart;
                }
                table.put(chars[i], true);
            }
            else{
                table.clear();
                nextStart = i;
                len = 1;
                if(max < len){
                    max = len;
                    start = nextStart;
                }
                table.put(chars[i], true);
            }
        }
        System.out.println("Start index: " + start);
        System.out.println("Max length: " + max);
        return max;
    }
}
