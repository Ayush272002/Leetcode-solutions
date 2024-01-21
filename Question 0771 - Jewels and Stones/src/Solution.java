import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
       char[] jew = jewels.toCharArray();
       char[] stn = stones.toCharArray();

        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < jew.length; i++) {
            map.put(jew[i] , true);
        }

        int count = 0;
        for (int i = 0; i < stn.length; i++) {
            if(map.containsKey(stn[i])) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}