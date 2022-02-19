# USF-CS545-Spring22-Extra-credit-1-Leet-Code-Problems

Update every week to record my LeetCode solutions.

## Feb 18
I choose two merge sort problems under the tags of "facebook" and "sort"：

18. 4Sum (Medium)
https://leetcode.com/problems/4sum/

16. 3Sum (Medium)
https://leetcode.com/problems/3sum-closest/


## Feb 11
I choose two merge sort problems under the tags of "facebook" and "merge sort"：

215. Kth Largest Element in an Array (Medium)  
https://leetcode.com/problems/kth-largest-element-in-an-array/

148. Sort List  
https://leetcode.com/problems/sort-list/

Merge sort works by

     1. making recursive calls to divide a list of elements into two sublists until the base case is reached;
     
     2. repeatedly merging two lists together and returning a sorted list until the whole list is sorted.

So, for each problem, we want to

     1. rule out corner cases;
     
     2. find the middle point and split the list into two sublist;
     
     3. merge two sublists into a sorted list;

I make helper methods private because right now I don't need to use them in other places.
