//Github link: git@github.com:Shumin1207/USF-CS545-Spring22-Extra-credit-1-Leet-Code-Problems.git
// 18、16、215、248

import java.util.*;


public class Solution {

    // April.01
//      114. Flatten Binary Tree to Linked List https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//      669. Trim a Binary Search Tree https://leetcode.com/problems/trim-a-binary-search-tree/

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val >= low && root.val <= high) {
            root.right = trimBST(root.right, low, high);
            root.left = trimBST(root.left, low, high);
        } else if (root.val < low) {
            root = trimBST(root.right, low, high);
        } else {
            root = trimBST(root.left, low, high);
        }
        return root;
    }

    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode left = flatten(root.left);
        TreeNode tail = left;
        TreeNode right = flatten(root.right);

        while (tail != null && tail.right != null) {
            tail = tail.right;
        }

        if (tail != null) {
            tail.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
    }


    // Mar.11 I choose two Linked List problems under the tags of "facebook" and "merge sort"：
//      92. Reverse Linked List II  https://leetcode.com/problems/reverse-linked-list-ii/
//      24. Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs/

    /**
     * 24. Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs/
     * base cases: head == null, head.next == null;
     * use recursion:
     * we get a newHead from the subproblem which is already swapped in pairs;
     * then we swap the head and head.next in the current level and attach the newHead from the subproblem at the end;
     * return the head of the current level;
     **/
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = head.next;
        head.next = swapPairs(newNode.next);
        newNode.next = head;
        return newNode;
    }

    /**
     * 92. Reverse Linked List II  https://leetcode.com/problems/reverse-linked-list-ii/
     * edge cases: head == null, head.next == null, left == right;
     * diferent cases:
     * 1. left == 1 or left > 1;
     * 2. right == length or right < length;
     * use iterative method;
     **/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode reverseStart = null;
        ListNode reverseEnd = null;
        ListNode prev = null;
        ListNode next = null;

        while (left > 1 && cur.next != null) {
            dummy.next = head;
            reverseStart = cur;
            cur = cur.next;
            left--;
            right--;
        }

        reverseEnd = cur;
        prev = cur;
        cur = cur.next;
        prev.next = null;

        while (right > 1 && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            right--;
        }

        if (reverseStart == null) {
            dummy.next = prev;
        } else {
            reverseStart.next = prev;
        }

        reverseEnd.next = cur;

        return dummy.next;
    }


// Feb.18 I choose two merge sort problems under the tags of "facebook" and "merge sort"：
//      18. 4Sum  https://leetcode.com/problems/4sum/
//      16. 3Sum  https://leetcode.com/problems/3sum-closest/

    /**
     * 18. 4Sum https://leetcode.com/problems/4sum/ Solution:
     * uses merge sort to sort the list;
     * uses 2 for loops and 2 pointers to find the 4 numbers.
     **/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return null;
        }
        int[] sorted = sortNums(nums, 0, nums.length - 1);
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 0; a < sorted.length - 3; a++) {
            for (int b = a + 1; b < sorted.length - 2; b++) {
                int d = sorted.length - 1;
                int c = b + 1;
                while (c < d) {
                    int sum = sorted[a] + sorted[b] + sorted[c] + sorted[d];
                    if (sum == target) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(sorted[a]);
                        tempList.add(sorted[b]);
                        tempList.add(sorted[c]);
                        tempList.add(sorted[d]);
                        if (!result.contains(tempList)) {
                            result.add(tempList);
                        }
                    }
                    if (sum > target) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }
        return result;
    }


    /**
     * 16. 3Sum Closest https://leetcode.com/problems/3sum-closest/ Solution:
     * uses merge sort to sort the list;
     * uses a for loop and 2 pointers to find the 3 numbers such that the sum is closest to target.
     **/
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int[] sorted = sortNums(nums, 0, nums.length - 1);
        return findSum(sorted, target);
    }

    public static int counter = 0;
    public static int merge = 0;

    public int[] sortNums(int[] nums, int start, int end) {
        if (start >= end) {
            counter++;
            int[] result = new int[]{nums[start]};
//            System.out.println("After the " +counter + " recursive call: " + Arrays.toString(result));
            return result;
        }
        int mid = (end + start) / 2;
        int[] left = sortNums(nums, start, mid);
        System.out.println("Left: " + Arrays.toString(left));
        int[] right = sortNums(nums, mid + 1, end);
        System.out.println("Right: " + Arrays.toString(right));
        int[] merged = merge(left, right);
        counter++;
        merge++;
        System.out.println("After the " + counter + " recursive call: " + Arrays.toString(merged));
        System.out.println("Merge: " + merge);
        return merged;
    }

    private int[] merge(int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int q = 0;
        int[] result = new int[left.length + right.length];
        while ((q < result.length) && (l < left.length) && (r < right.length)) {
            if (left[l] < right[r]) {
                result[q] = left[l];
                q++;
                l++;
            } else {
                result[q] = right[r];
                q++;
                r++;
            }
        }
        while (l < left.length) {
            result[q] = left[l];
            q++;
            l++;
        }
        while (r < right.length) {
            result[q] = right[r];
            q++;
            r++;
        }
        return result;
    }

    private int findSum(int[] nums, int target) {

        if (nums == null) {
            return 0;
        }
        int result = Integer.MAX_VALUE - target;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int temp = nums[i] + nums[low] + nums[high];
                if (Math.abs(temp - target) < Math.abs(result - target)) {
                    result = temp;
                }
                if (temp > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }


    // I choose two merge sort problems under the tags of "facebook" and "merge sort"：
    //      215. Kth Largest Element in an Array (Medium)  https://leetcode.com/problems/kth-largest-element-in-an-array/
    //      148. Sort List  https://leetcode.com/problems/sort-list/
    //
    // Merge sort works by
    //      1. making recursive calls to divide a list of elements into two sublists until the base case is reached;
    //      2. repeatedly merging two lists together and returning a sorted list until the whole list is sorted.
    //
    // So, for each problem, we want to
    //      1. rule out corner cases;
    //      2. find the middle point and split the list into two sublist;
    //      3. merge two sublists into a sorted list;
    //
    // I make helper methods private because right now I don't need to use them in other places.

    //Problem 1: 215. Kth Largest Element in an Array (Medium)
    // https://leetcode.com/problems/kth-largest-element-in-an-array/

    public int findKthLargest(int[] nums, int k) {
        // rule out corner cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] result = sortArrays(nums, 0, nums.length - 1);
        return result[k - 1];
    }

    private int[] sortArrays(int[] nums, int l, int r) {
        // base case
        if (r == l) {
            int[] array = new int[]{nums[r]};
            return array;
        }

        // recursive steps
        int mid = (l + r) / 2;
        int[] left = sortArrays(nums, l, mid);
        int[] right = sortArrays(nums, mid + 1, r);

        return mergeArrays(left, right);
    }

    private int[] mergeArrays(int[] left, int[] right) {
        int low = 0;  //pointer of left sub-array;
        int high = 0;  //pointer of right sub-array;
        int idx = 0; //index of the result array which will be returned;
        int[] result = new int[left.length + right.length];


        while (low < left.length && high < right.length) {
            if (left[low] > right[high]) {
                result[idx++] = left[low++];
            } else {
                result[idx++] = right[high++];
            }
        }

        if (low != left.length) {
            for (int i = low; i < left.length; i++) {
                result[idx++] = left[i];
            }
        }

        if (high != right.length) {
            for (int i = high; i < right.length; i++) {
                result[idx++] = right[i];
            }
        }

//        System.out.println(Arrays.toString(result));
        return result;
    }


    // Problem 2: 148. Sort List
    // https://leetcode.com/problems/sort-list/

    public ListNode sortList(ListNode head) {
        // rule out corner cases
        if (head == null || head.next == null) {
            return head;
        }

        return sort(head);
    }

    private ListNode sort(ListNode head) {
        // base cases
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode part = mid.next;
        mid.next = null; // split the linked list

        ListNode left = sort(head);
        ListNode right = sort(part);

        ListNode newHead = merge(left, right);
        return newHead;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1); // dummy head
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }
        return dummy.next;
    }

}