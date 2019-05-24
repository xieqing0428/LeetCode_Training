import java.util.*;

/**
 * @ClassName: No_0015_3Sum
 * @Description: 0015. 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * @Author: XieQing
 * @Date: 2019-05-24 13:15
 * @Version: 1.0
 */
public class No_0015_3Sum {
    class SolutionA {
        /**
         * 执行用时 : 170 ms
         * 内存消耗 : 58.1 MB
         */
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();
            List<Integer> temp = new ArrayList<>();
            int len = nums.length;
            if (len == 0) {
                return new ArrayList<>(result);
            }
            Arrays.sort(nums);
            if (nums[len - 1] < 0 || nums[0] > 0) {
                return new ArrayList<>(result);
            }
            int zeroA, zeroB;
            int markHead = 0;
            int markTail = len - 1;
            int tempHead = nums[0] - 1;
            for (int i = 1; i < len - 1; i++) {
                zeroA = 0 - nums[i];
                while (markHead < i && markTail > i) {
                    if (tempHead == nums[markHead]) {
                        markHead++;
                        continue;
                    }
                    zeroB = nums[markHead] + nums[markTail];
                    if (zeroB > zeroA) {
                        markTail--;
                    } else if (zeroB < zeroA) {
                        tempHead = nums[markHead];
                        markHead++;
                    } else {
                        temp.add(nums[markHead]);
                        temp.add(nums[i]);
                        temp.add(nums[markTail]);
                        result.add(temp);
                        temp = new ArrayList<>();
                        tempHead = nums[markHead];
                    }
                }
                markHead = 0;
                markTail = len - 1;
                tempHead = nums[0] - 1;
            }
            return new ArrayList<>(result);
        }
    }

    class SolutionB {
        /**
         * 执行用时 : 84 ms
         * 内存消耗 : 55 MB
         */
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ls = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                    int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                    while (l < r) {
                        if (nums[l] + nums[r] == sum) {
                            ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) l++;
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            l++;
                            r--;
                        } else if (nums[l] + nums[r] < sum) {
                            while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                            l++;
                        } else {
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            r--;
                        }
                    }
                }
            }
            return ls;
        }
    }

    class SolutionC {
        /**
         * 耗时27ms
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) { return result; }
            Arrays.sort(nums);
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] > 0) { break; }
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;//重复
                }
                int target = 0 - nums[k]; //fit一个
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    if (nums[i] + nums[j] == target) {
                        List<Integer> r = new ArrayList<>();
                        r.add(nums[k]);
                        r.add(nums[i]);
                        r.add(nums[j]);
                        result.add(r);
                        while (i < j && nums[i] == nums[i + 1]) { ++i; }
                        while (i < j && nums[j] == nums[j - 1]) { --j; }
                        ++i;
                        --j;
                    } else if (nums[i] + nums[j] < target) { ++i; } else { --j; }
                }
            }
            return result;
        }
    }

    class SolutionD {
        /**
         * 耗时17ms
         */
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) { return Collections.emptyList(); }
            List<List<Integer>> res = new ArrayList<>();
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;
            int negSize = 0;
            int posSize = 0;
            int zeroSize = 0;
            for (int v : nums) {
                if (v < minValue) { minValue = v; }
                if (v > maxValue) { maxValue = v; }
                if (v > 0) { posSize++; } else if (v < 0) { negSize++; } else { zeroSize++; }
            }
            if (zeroSize >= 3) { res.add(Arrays.asList(0, 0, 0)); }
            if (negSize == 0 || posSize == 0) { return res; }
            if (minValue * 2 + maxValue > 0) { maxValue = -minValue * 2; } else if (maxValue * 2 + minValue < 0) {
                minValue = -maxValue * 2;
            }

            int[] map = new int[maxValue - minValue + 1];
            int[] negs = new int[negSize];
            int[] poses = new int[posSize];
            negSize = 0;
            posSize = 0;
            for (int v : nums) {
                if (v >= minValue && v <= maxValue) {
                    if (map[v - minValue]++ == 0) {
                        if (v > 0) { poses[posSize++] = v; } else if (v < 0) { negs[negSize++] = v; }
                    }
                }
            }
            Arrays.sort(poses, 0, posSize);
            Arrays.sort(negs, 0, negSize);
            int basej = 0;
            for (int i = negSize - 1; i >= 0; i--) {
                int nv = negs[i];
                int minp = (-nv) >>> 1;
                while (basej < posSize && poses[basej] < minp) { basej++; }
                for (int j = basej; j < posSize; j++) {
                    int pv = poses[j];
                    int cv = 0 - nv - pv;
                    if (cv >= nv && cv <= pv) {
                        if (cv == nv) {
                            if (map[nv - minValue] > 1) { res.add(Arrays.asList(nv, nv, pv)); }
                        } else if (cv == pv) {
                            if (map[pv - minValue] > 1) { res.add(Arrays.asList(nv, pv, pv)); }
                        } else {
                            if (map[cv - minValue] > 0) { res.add(Arrays.asList(nv, cv, pv)); }
                        }
                    } else if (cv < nv) { break; }
                }
            }
            return res;
        }
    }
}
