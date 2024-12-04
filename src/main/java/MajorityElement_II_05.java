import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MajorityElement_II_05 {

    public static void main(String[] args) {

        List<Integer> list = findMajority(new int[]{2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6});

        list.forEach(item -> System.out.print("items : " + item + " ,"));

    }

    public static List<Integer> findMajority(int[] nums) {

        List<Integer> res = new ArrayList<>();

        int cand1 = -1, cand2 = -1, count1 = 0, count2 = 0;

        for (int num : nums) {

            if (cand1 == num) {
                count1++;
            }
            else if (cand2 == num) {
                count2++;
            }
            else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }

        }

        count1 = 0; count2 = 0;

        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }

        int mini = nums.length/3;

        if (count1 > mini)
            res.add(cand1);

        if (count2 > mini)
            res.add(cand2);


        Collections.sort(res);
        return res;
    }

}
