import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmanzelmann on 4/10/2015.
 */
public class LongestIncreasingSubsequence {
    List<List<Integer>> longestIncreasingSub;

    public LongestIncreasingSubsequence(List<Integer> list) {
        longestIncreasingSub = new ArrayList<List<Integer>>();

        for (int i = 0; i < list.size(); i++) {
            longestIncreasingSub.add(new ArrayList<Integer>());
        }

        // the first longest increasing subsequence list is just one element
        // the element is the first element in the list
        // i.e. list = {3, 2, 6, 4, 5, 1}
        // then the first element is just '3'
        List<Integer> temp = longestIncreasingSub.get(0);
        temp.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i) && longestIncreasingSub.get(i).size() < longestIncreasingSub.get(j).size()+1) {
                    prntList(i);
                    prntList(j);
                    System.out.println();
                    longestIncreasingSub.set(i, new ArrayList<Integer>(longestIncreasingSub.get(j)));
                }
            }

            longestIncreasingSub.get(i).add(list.get(i));
            System.out.print("final list: ");
            prntList(i);
            System.out.println();
        }
    }

    public void prntLongestIncreasingSub() {
        for (List<Integer> l : longestIncreasingSub) {
            for (Integer i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public void prntList(int i) {
        List<Integer> temp = longestIncreasingSub.get(i);
        System.out.print("list " + i + ": ");
        for (Integer k : temp)
            System.out.print(k + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 2, 6, 4, 5, 1));
        LongestIncreasingSubsequence temp = new LongestIncreasingSubsequence(list);
        temp.prntLongestIncreasingSub();
    }
}
