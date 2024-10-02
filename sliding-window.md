# Problems Solvable using this Template

- 3 Longest Substring Without Repeating Characters
- 159 Longest Substring with At Most Two Distinct Characters (Medium)
- 340 Longest Substring with At Most K Distinct Characters
- 424 Longest Repeating Character Replacement
- 487 Max Consecutive Ones II
- 713 Subarray Product Less Than K
- 1004 Max Consecutive Ones III
- 1208 Get Equal Substrings Within Budget (Medium)
- 1493 Longest Subarray of 1's After Deleting One Element
- 1695 Maximum Erasure Value
- 1838 Frequency of the Most Frequent Element
- 2009 Minimum Number of Operations to Make Array Continuous
- 2024 Maximize the Confusion of an Exam

## The following problems are also solvable using the shrinkable template with the "At Most to Equal" trick

- 930 Binary Subarrays With Sum (Medium)
- 992 Subarrays with K Different Integers
- 1248 Count Number of Nice Subarrays (Medium)
- 2062 Count Vowel Substrings of a String (Easy)

## Template 1: Sliding Window (Shrinkable)

The best template I've found so far:

```java
int i = 0, j = 0, ans = 0;
for (; j < N; ++j) {
    // CODE: use A[j] to update state which might make the window invalid
    for (; invalid(); ++i) { // when invalid, keep shrinking the left edge until it's valid again
        // CODE: update state using A[i]
    }
    ans = max(ans, j - i + 1); // the window [i, j] is the maximum window we've found thus far
}
return ans;
```

Essentially, we want to keep the window valid at the end of each outer for loop.

### Example Solution:

#### Problem:
What should we use as the state? It should be the sum of numbers in the window.
How to determine invalid? The window is invalid if `(j - i + 1) * A[j] - sum > k`.

```java
// OJ: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Author: github.com/lzl124631x
// Time: O(NlogN)
// Space: O(1)
class Solution {
    public int maxFrequency(int[] A, int k) {
        Arrays.sort(A);
        long i = 0, N = A.length, ans = 1, sum = 0;
        for (int j = 0; j < N; ++j) {
            sum += A[j];
            while ((j - i + 1) * A[j] - sum > k) sum -= A[i++];
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
```

### FAQ:

- **Why is the time complexity O(NlogN)?**
  The sorting takes O(NlogN). The two-pointer part only takes O(N) because both the pointers `i` and `j` traverse the array only once.
  
- **Why is `(j - i + 1) * A[j] - sum <= k` valid?**
  `(j - i + 1)` is the length of the window `[i, j]`. We want to increase all the numbers in the window to equal `A[j]`. The number of operations needed is `(j - i + 1) * A[j] - sum`, which should be `<= k`.

## Template 2: Sliding Window (Non-shrinkable)

```java
int i = 0, j = 0;
for (; j < N; ++j) {
    // CODE: use A[j] to update state which might make the window invalid
    if (invalid()) { // Increment the left edge ONLY when the window is invalid
        // CODE: update state using A[i]
        ++i;
    }
    // after `++j` in the for loop, this window `[i, j)` of length `j - i` might be valid.
}
return j - i;
```

### Example Solution:

```java
// OJ: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
// Author: github.com/lzl124631x
// Time: O(NlogN)
// Space: O(1)
class Solution {
    public int maxFrequency(int[] A, int k) {
        Arrays.sort(A);
        long i = 0, j = 0, N = A.length, sum = 0;
        for (; j < N; ++j) {
            sum += A[j];
            if ((j - i + 1) * A[j] - sum > k) sum -= A[i++];
        }
        return j - i;
    }
}
```

## Apply these Templates to Other Problems

### 1493. Longest Subarray of 1's After Deleting One Element (Medium)

#### Sliding Window (Shrinkable)

- **What's the state?** `cnt` as the number of `0`s in the window.
- **What's invalid?** `cnt > 1` is invalid.

```java
// OJ: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
// Author: github.com/lzl124631x
// Time: O(N)
// Space: O(1)
class Solution {
    public int longestSubarray(int[] A) {
        int i = 0, j = 0, N = A.length, cnt = 0, ans = 0;
        for (; j < N; ++j) {
            cnt += A[j] == 0 ? 1 : 0;
            while (cnt > 1) cnt -= A[i++] == 0 ? 1 : 0;
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
```

#### Sliding Window (Non-shrinkable)

```java
// OJ: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
// Author: github.com/lzl124631x
// Time: O(N)
// Space: O(1)
class Solution {
    public int longestSubarray(int[] A) {
        int i = 0, j = 0, N = A.length, cnt = 0;
        for (; j < N; ++j) {
            cnt += A[j] == 0 ? 1 : 0;
            if (cnt > 1) cnt -= A[i++] == 0 ? 1 : 0;
        }
        return j - i - 1;
    }
}
```

### 3. Longest Substring Without Repeating Characters (Medium)

#### Sliding Window (Shrinkable)

- **State:** `cnt[ch]` is the number of occurrences of character `ch` in the window.
- **Invalid:** `cnt[s[j]] > 1` is invalid.

```java
// OJ: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Author: github.com/lzl124631x
// Time: O(N)
// Space: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, N = s.length(), ans = 0;
        int[] cnt = new int[128];
        for (; j < N; ++j) {
            cnt[s.charAt(j)]++;
            while (cnt[s.charAt(j)] > 1) cnt[s.charAt(i++)]--;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
```

#### Sliding Window (Non-shrinkable)

```java
// OJ: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Author: github.com/lzl124631x
// Time: O(N)
// Space: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, N = s.length();
        int[] cnt = new int[128];
        int dup = 0;
        for (; j < N; ++j) {
            dup += ++cnt[s.charAt(j)] == 2 ? 1 : 0;
            if (dup > 0) dup -= --cnt[s.charAt(i++)] == 1 ? 1 : 0;
        }
        return j - i;
    }
}
```

### 713. Subarray Product Less Than K (Medium)

#### Sliding Window (Shrinkable)

- **State:** `prod` is the product of the numbers in the window.
- **Invalid:** `prod >= k` is invalid.

```java
// OJ: https://leetcode.com/problems/subarray-product-less-than-k/
// Author: github.com/lzl124631x
// Time: O(N)
// Space: O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] A, int k) {
        if (k == 0) return 0;
        long i = 0, j = 0, prod = 1, ans = 0;
        for (; j < A.length; ++j) {
            prod *= A[j];
            while (i <= j && prod >= k) prod /= A[(int) i++];
            ans += j - i + 1;
        }
        return (int) ans

;
    }
}
```
