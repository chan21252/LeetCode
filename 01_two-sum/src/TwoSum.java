import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indexArr = new int[2];
        /*
         * 遍历数组，从0到length-1
         * 检查当前元素和往后的每个元素相加是否等于target
         * 返回匹配两个元素的下标
         */
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum Solution");
    }

    //两遍哈希表
    public int[] twoSum2(int[] nums, int target) {
        //数组元素和索引变成哈希表，{2:0, 7:1, 11:3, ...}
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        //遍历数组，从map中找是否有元素 = target - nums[i]，并且map元素的值!=i
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    //一遍哈希表
    public int[] twoSum3(int[] nums, int target) {
        /*
         * 遍历数组，当前元素nums[i]，要找的数是 complement = target-nums[i]
         * 哈希表中是否有键为complement，并且该键的值!=i
         * 如果有，则返回 i 和 哈希表complement键的值
         * 否则继续
         * 将 nums[i]:i 加入哈希表
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;

        TwoSum ts = new TwoSum();
        int[] index = ts.twoSum2(nums, target);
        System.out.println(index[0] + "," + index[1]);
    }
}
