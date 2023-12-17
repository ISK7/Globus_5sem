package igor.kiselev.task;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;

public class Consistently {
    public HashMap<Character,Integer> Count(String source) {
        HashMap<Character,Integer> result = new HashMap<Character,Integer>();
        for(int i = 0; i < source.length(); i++) {
            if(result.containsKey(source.charAt(i))) {result.replace(source.charAt(i),result.get(source.charAt(i)) + 1);}
            else result.put(source.charAt(i),1);
        }
        return result;
    }
}
