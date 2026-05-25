package HashTables;

import java.util.*;

public class Main {
    public static boolean itemInCommon(int[] a1, int[] a2) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i = 0;i < a1.length;i++) {
            hm.put(a1[i], true);
        }

        for (int i = 0;i < a2.length;i++) {
            if(hm.get(a2[i]) != null && hm.get(a2[i]) == true) {
                return true;
            }
        }
        return false;
    }
    public static Character firstNonRepeatingChar(String myStr){
        if(myStr == null || myStr.length() == 0){
            return null;
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        Character previousChar = null;
        for(char c : myStr.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
    public static List<List<String>> groupAnagrams(String[] arrays){
        Map<String, List<String>> map = new HashMap<>();
        for(String word: arrays){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String data = new String(chars);
            map.computeIfAbsent(data, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {

        /*HashTable myHashTable = new HashTable();

        myHashTable.set("paint", 20);
        myHashTable.set("bolts", 40);
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);

        System.out.println( myHashTable.keys() );
*/
/*
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
*/
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));


    }

 }


