package wordBreak;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s==null || s.trim().isEmpty() || wordDict==null || wordDict.isEmpty())
			return false;
		
		s = s.trim();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<s.length()-1; i++){
			for(int j=i; j<s.length()-1; j++){
				if(wordDict.contains(s.substring(i, j))){
					if(map.containsKey(j)){
						if(i>0 && map.containsKey(i-1))
							map.put(j, i);
					}
					else	map.put(j, i);
				}
			}
		}
		
		if(map.isEmpty())	return false;
		
		int end = s.length()-1;
		while(true){
			if(!map.containsKey(end))	return false;
			end = map.get(end) - 1;
			if(end==0)	break;
		}
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
