package org.ds;

import java.util.*;


/**
 * 496. 下一个更大元素 I
 */
public class NextGreaterElement1 {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n2 - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek())
                stack.pop();
            if (!stack.isEmpty())
                map.put(nums2[i], stack.peek());
            else
                map.put(nums2[i], -1);
            stack.push(nums2[i]);
        }
        for (int i = 0; i < n1; ++i)
            ans[i] = map.get(nums1[i]);
        return ans;
    }


    /**
     * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出：[-1,3,-1]
     * 解释：nums1 中每个值的下一个更大元素如下所述：
     * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
     * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
     * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
     */
    public static void main(String[] args) {
        NextGreaterElement1 nextGreaterElement1 = new NextGreaterElement1();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ints = nextGreaterElement1.nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(ints));
    }
}
