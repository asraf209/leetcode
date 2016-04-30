package wordBreak;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	
	public static boolean wordBreak(String s, Set<String> wordDict) {
		if(s==null || s.trim().isEmpty() || wordDict==null || wordDict.isEmpty())
			return false;
		
		s = s.trim();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++){
			for(int j=i; j<s.length(); j++){
				if(wordDict.contains(s.substring(i, j+1))){
					if(map.containsKey(j)){
						if(i>0 && map.containsKey(i-1))
							map.put(j, i);
					}
					else	map.put(j, i);
				}
			}
		}
		System.out.println(map);
		
		if(map.isEmpty())	return false;
		
		int end = s.length()-1;
		while(end >= 0){
			if(!map.containsKey(end))	return false;
			end = map.get(end);		
			end = end -1;
		}
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		String[] d = {"leet", "code"};
		Set<String> dict = new HashSet<>(Arrays.asList(d));
		System.out.println(wordBreak(s, dict));
	}

}
