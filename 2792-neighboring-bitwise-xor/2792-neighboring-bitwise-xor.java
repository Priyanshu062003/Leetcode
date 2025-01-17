
public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int val = 0;
        for(int i: derived)
            val ^= i;
        return val==0;
    }
}