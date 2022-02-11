import java.util.Arrays;

public class Solution {

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