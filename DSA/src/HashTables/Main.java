package HashTables;

import java.util.*;

public class Main {

    public static boolean itemInCommon(int[] a1, int[] a2) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int i = 0; i < a1.length; i++) {
            hm.put(a1[i], true);
        }

        for (int i = 0; i < a2.length; i++) {
            if (hm.get(a2[i]) != null && hm.get(a2[i]) == true) {
                return true;
            }
        }

        return false;
    }

    public static Character firstNonRepeatingChar(String myStr) {

        if (myStr == null || myStr.length() == 0) {
            return null;
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : myStr.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static List<List<String>> groupAnagrams(String[] arrays) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : arrays) {

            char[] chars = word.toCharArray();

            Arrays.sort(chars);

            String data = new String(chars);

            map.computeIfAbsent(data, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    // code mới ngày 26/5

    public static int[] twoSum(int[] arrays, int sum) {

        if (arrays == null || arrays.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arrays.length; i++) {

            int remaining = sum - arrays[i];

            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            }

            map.put(arrays[i], i);
        }

        return new int[]{};
    }

    public static int[] subarraySum(int[] arrays, int target) {

        if (arrays == null || arrays.length == 0) {
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < arrays.length; i++) {

            sum += arrays[i];

            int remain = sum - target;

            if (map.get(remain) != null) {
                return new int[]{map.get(remain) + 1, i};
            }

            map.put(sum, i);
        }

        return new int[]{};
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {

        Set<Integer> setUnque = new HashSet<>(list);

        List<Integer> newList = new ArrayList<>(setUnque);

        return newList;
    }

    public static boolean hasUniqueChars(String mystr) {

        if (mystr == null || mystr.isEmpty()) {
            return true;
        }

        Set<Character> set = new HashSet<>();

        for (char c : mystr.toCharArray()) {
            set.add(c);
        }

        return set.size() == mystr.length();
    }

    // code moi ngay 27/5

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i : arr1) {
            map.put(i, true);
        }

        List<int[]> list = new ArrayList<>();

        for (int i : arr2) {

            int remain = target - i;

            if (map.getOrDefault(remain, false)) {
                list.add(new int[]{remain, i});
            }
        }

        return list;
    }

    public static int longestConsecutiveSequence(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int result = 1;
        int current = 1;

        int previous = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] - previous == 0) {

            } else if (nums[i] - previous == 1) {

                current++;

            } else {

                result = Math.max(result, current);

                current = 1;
            }

            previous = nums[i];
        }

        return Math.max(result, current);
    }

    public static void testLongestConsecutiveSequence(String testName, int[] nums, int expected) {

        int result = longestConsecutiveSequence(nums);

        System.out.println(testName);

        System.out.println("Expected: " + expected);

        System.out.println("Result: " + result);

        System.out.println();
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

        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;

        int[] result1 = subarraySum(nums1, target1);

        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;

        int[] result2 = subarraySum(nums2, target2);

        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;

        int[] result3 = subarraySum(nums3, target3);

        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;

        int[] result4 = subarraySum(nums4, target4);

        System.out.println("[]");

        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);

        List<Integer> newList = removeDuplicates(myList);

        System.out.println(newList);

        System.out.println(hasUniqueChars("abcdefg"));
        System.out.println(hasUniqueChars("hello"));
        System.out.println(hasUniqueChars(""));
        System.out.println(hasUniqueChars("0123456789"));
        System.out.println(hasUniqueChars("abacadaeaf"));

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);

        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        testLongestConsecutiveSequence("Consecutive Integers", new int[]{1, 2, 3, 4, 5}, 5);
        testLongestConsecutiveSequence("No Sequence", new int[]{1, 3, 5, 7, 9}, 1);
        testLongestConsecutiveSequence("Duplicates", new int[]{1, 2, 2, 3, 4}, 4);
        testLongestConsecutiveSequence("Negative Numbers", new int[]{1, 0, -1, -2, -3}, 5);
        testLongestConsecutiveSequence("Empty Array", new int[]{}, 0);
        testLongestConsecutiveSequence("Multiple Sequences", new int[]{1, 2, 3, 10, 11, 12, 13}, 4);
        testLongestConsecutiveSequence("Unordered Elements", new int[]{5, 1, 3, 4, 2}, 5);
        testLongestConsecutiveSequence("Single Element", new int[]{1}, 1);
        testLongestConsecutiveSequence("All Identical Elements", new int[]{2, 2, 2, 2, 2}, 1);
    }

}