package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.

    Example 1:
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation: 
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.

    Constraints:
        1) 3 <= nums.length <= 3000
        2) -105 <= nums[i] <= 105
 */
public class ThreeSum {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int curr = 0; curr < nums.length - 2; curr++) {

            if (curr > 0 && nums[curr] == nums[curr - 1]){
                continue;
            }

            int left = curr + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[curr] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[curr], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] numbers = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(numbers);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
