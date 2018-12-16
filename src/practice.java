import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * Created by kendeas93 on 11/03/17.
 */
public class practice {

    public static void main(String[] args) throws ParseException {
//        Pattern pattern = Pattern.compile(".*[^0-9].*");
//        Pattern pattern = Pattern.compile("^[0-9]+$");

//        System.out.println(pattern.matcher("2s12").matches());

//        printDuplicates2("Programming");
//        System.out.println("Missing number: " + findMissingNumber(new int[]{1,2,3,4,5,6}, 7));

//        int[] input = new int[]{1,7,2,-3,0,5};
//        System.out.println("Contains object: " + doesItContain(input, 2));

//        findLargestAndSmallest(input);
//
//        int[] x = {8,6,5,5,3,4,-3, -2};
//        int result = secondSmallest(x);
//
//        System.out.println("Second smallest: " + result);

//        System.out.println("Steps answer: " + countSteps(4));
//
//        System.out.println(getDay("05", "08", "2015"));

//        fibonacci(10);
        String word1 = "mpla", word2 = "apmxl";
        System.out.printf("The words %s and %s are %sanagrams!", word1, word2, areAnagrams(word1, word2) ? "" : "not ");
    }

    public static void printDuplicates(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> wordMap = new HashMap<>();
        for (char ch : chars) {
            wordMap.put(ch, wordMap.containsKey(ch) ? wordMap.get(ch) + 1 : 1);
        }

        Set<Map.Entry<Character, Integer>> entrySet = wordMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("Entry %s has %d instances in %s\n", entry.getKey(), entry.getValue(), str);
            }
        }
    }

    public static void printDuplicates2(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> wordMap = new HashMap<>();

        for (char ch : chars) {
            int temp = 1;
            if (wordMap.containsKey(ch))
                temp = wordMap.get(ch) + 1;
            wordMap.put(ch, temp);
        }
        for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > 1) System.out.printf("Entry %s has %d instances in %s!\n", entry.getKey(), entry.getValue(), str);
        }
    }

    public static boolean areAnagrams(String wordA, String wordB) {
        char[] word1 = wordA.toCharArray();
        char[] word2 = wordB.toCharArray();

        Map<Character, Integer> lettersInWord1 = new HashMap<Character, Integer>();

        for (char c : word1) {
            int count = 1;
            if (lettersInWord1.containsKey(c)) {
                count = lettersInWord1.get(c) + 1;
            }
            lettersInWord1.put(c, count);
        }

        for (char c : word2) {
            int count = -1;
            if (lettersInWord1.containsKey(c)) {
                count = lettersInWord1.get(c) - 1;
            }
            lettersInWord1.put(c, count);
        }

        for (char c : lettersInWord1.keySet()) {
            if (lettersInWord1.get(c) != 0) {
                return false;
            }
        }

        return true;
    }

    public static int findMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = ((totalCount*totalCount) + totalCount) / 2;
        int actualSum = 0;

        for (int i : numbers) {
            actualSum += i;
        }

        return expectedSum - actualSum;
    }

    public static <T> boolean doesItContain(T[] numbers, T i) {
        return Arrays.asList(numbers).contains(i);
    }

    public static void findLargestAndSmallest(int[] numbers) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int n : numbers) {
            if (n > largest) {
                largest = n;
            }
            if (n < smallest) {
                smallest = n;
            }
        }
        System.out.printf("Smallest: %d\nLargest: %d\n", smallest, largest);
    }

    static int secondSmallest(int[] x) {
        int smallestInt = Integer.MAX_VALUE;
        int secondSmallestInt = Integer.MAX_VALUE;

        if (x.length < 2)
            return 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == smallestInt) {
                secondSmallestInt = smallestInt;
            } else if (x[i] < smallestInt) {
                secondSmallestInt = smallestInt;
                smallestInt = x[i];
            } else if (x[i] < secondSmallestInt) {
                secondSmallestInt = x[i];
            }
        }
        int[] ints = new int[3];
        return secondSmallestInt;
    }

    static long fibonacci(int n) {
        if (n == 0)
            return 0;
        long a = 0, b = 1, ret = 0;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            ret = a + b;
            a = b;
            b = ret;
            System.out.print(" " + ret);
        }
        return ret;
    }

    static long countSteps(int n) {

        // Tribonacci numbers: a(n) = a(n-1) + a(n-2) + a(n-3) with a(0)=a(1)=0, a(2)=1

        if (n == 0)
            return 0;

        n += 2; // Offset n by 2 to get the steps result

        long a = 0, b = 0, c = 1;
        long d = a + b + c;

        for(int i=4;i<=n;i++)
        {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        return d;
    }

    public static String getDay(String day, String month, String year) {
        /*
        * Write your code here.
        */
        String input_date = day + "/" + month + "/" + year;
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = null;
        try {
            dt1 = format1.parse(input_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);

        return finalDay.toUpperCase();
    }

//    public static void main(String[] args) throws IOException {
//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        BufferedReader in = new BufferedReader(reader);
//        String line;
//        int number;
//        while ((line = in.readLine()) != null) {
//            try {
//                number = Integer.parseInt(line);
//                System.out.println(squareInt(number));
//            } catch (NumberFormatException e) {
//                System.out.println("Error");
//            }
//        }
//    }
//
//    public static int squareInt(int n) {
//        return n*n;
//    }
}
}
