package datastructures.hashtable;

import java.util.HashMap;

public class ItemInCommon {
	public static boolean itemInCommon(int[] array1, int[] array2){
        HashMap<Boolean, Integer> hm = new HashMap<>();
        
        for(int e: array1){
            hm.put(true, e);
        }
        
        for(int a:array2){
            if(hm.containsValue(a))
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
        
        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */

	}
    
}
