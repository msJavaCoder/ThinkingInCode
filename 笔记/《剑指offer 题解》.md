# 《剑指offer最优题解》
# 前言
**题目来自《剑指 Offer[M]. 名企面试官精讲典型编程题》，豆瓣评分8.3**

**刷题平台推荐：**
[LeetCode](https://leetcode-cn.com/problemset/lcof/)  /
[牛客网](https://www.nowcoder.com/ta/coding-interviews)
--- 
**刷题五部曲：**
1. 阿萨德
2. 阿萨德
3. 阿萨德
4. 阿萨德
5. 阿萨德
---

# 目录
+ **第一章 数组与矩阵**
+ **第二章 栈队列堆**
+ **第三章 链表**
+ **第四章 双指针解法**
+ **第五章 树**
+ **第六章 贪心思想**
+ **第七章 二分查找**
+ **第八章 分治**

## 第一章 数组与矩阵
### 03. 数组中重复的数字
**题目描述：** 
>在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。

**要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。**
```java
Input:
{2, 3, 1, 0, 2, 5}

Output:
2
```

**解题思路：** 

1. 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
2. 在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。

以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复。

**代码实现：**
```java
public boolean duplicate(int[] nums, int length, int[] duplication) {
    if (nums == null || length <= 0)
        return false;
    for (int i = 0; i < length; i++) {
        while (nums[i] != i) {
            if (nums[i] == nums[nums[i]]) {
                duplication[0] = nums[i];
                return true;
            }
            swap(nums, i, nums[i]);
        }
    }
    return false;
}
private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
}
```
### 04. 二维数组中的查找
**题目描述：** 
>给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。

**要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。**
```java
Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.
Given target = 20, return false.
```

**解题思路：** 
1. 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
2. 从右上角开始查找，就可以根据 target 和当前元素的大小关系来快速地缩小查找区间，每次减少一行或者一列的元素。当前元素的查找区间为左下角的所有元素。

**代码实现：**
```java
public boolean find(int target, int[][] matrix) {
  if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return false;
  int rows = matrix.length;
  int cols = matrix[0].length;
  int r = 0;
  int c = cols - 1; // 从右上角位置开始出发
  while (r <= rows - 1 && c >= 0) {
    if (target == matrix[r][c])
         return true;
    else if (target > matrix[r][c])
         r++;
    else
         c--;
    }
    return false;
}
```
### 05. 替换空格
**题目描述：** 
>请实现一个函数，把字符串 s 中的每个空格替换成"%20"。"。

```java
Input:
"A B"

Output:
"A%20B"
```

**解题思路：** 
1. 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），所以当遍历到一个空格时，需要在尾部填充两个任意字符。
2. 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
3. 当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出。

**代码实现：**
```java
public String replaceSpace(StringBuffer str) {
    int P1 = str.length() - 1;
    for (int i = 0; i <= P1; i++)
        if (str.charAt(i) == ' ')
            str.append("  ");
            
    int P2 = str.length() - 1;
    while (P1 >= 0 && P2 > P1) {
        char c = str.charAt(P1--);
        if (c == ' ') {
            str.setCharAt(P2--, '0');
            str.setCharAt(P2--, '2');
            str.setCharAt(P2--, '%');
        } else {
            str.setCharAt(P2--, c);
        }
    }
    return str.toString();
}
```
### 06. 顺时针打印矩阵
**题目描述：** 
>输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。"。

```java
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]

输出：[1,2,3,6,9,8,7,4,5]
```

**解题思路：** 
 1. 空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
 2. 初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
 3. 循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
 4. 根据边界打印，即将元素按顺序添加至列表 res 尾部；
 5. 边界向内收缩 11 （代表已被打印）；
 6. 判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
 7. 返回值： 返回 res 即可。


**代码实现：**
```java
  public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
```
### 50. 第一个只出现一次的字符位置
**题目描述：** 
>在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
```
Input: abacc
Output: b
```

**解题思路：** 
+ 最直观的解法是使用 HashMap 对出现次数进行统计：字符做为 key，出现次数作为 value，遍历字符串每次都将 key 对应的 value 加 1。最后再遍历这个 HashMap 就可以找出出现次数为 1 的字符。

+ 考虑到要统计的字符范围有限，也可以使用整型数组代替 HashMap。ASCII 码只有 128 个字符，因此可以使用长度为 128 的整型数组来存储每个字符出现的次数。

**代码实现：**
```java
public int firstNotRepeatingChar(String str) {
    int[] cnts = new int[128];
    for (int i = 0; i < str.length(); i++)
        cnts[str.charAt(i)]++;
    for (int i = 0; i < str.length(); i++)
        if (cnts[str.charAt(i)] == 1)
            return i;
    return -1;
}
```
## 第二章 栈队列堆
### 09. 用两个栈实现队列
**题目描述：** 
>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
```java
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

**解题思路：** 
1. 只使用一个栈 in 当作队列，另一个栈 out 用来辅助操作。
2. 要想将新加入的元素出现栈底，需要先将 in 的元素转移到 out，将元素入栈 in，最后将 out 的元素全部回到 in。

**代码实现：**
```java
class CQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public CQueue() {
       in=new Stack<Integer>();
       out=new Stack<Integer>();
    }
    // 入队
    public void appendTail(int value) {
        in.push(value);
    }
    // 出队
    public int deleteHead() {
        if(out.isEmpty()){
             while(!in.isEmpty()){
              out.push(in.pop());
             }
        }
        if (out.isEmpty()){
            return -1;
        }
        return out.pop();
    }
}
```
### 30. 包含 min 函数的栈
**题目描述：** 
>定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
```java
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```

**解题思路：** 
>

**代码实现：**
```java
class MinStack {
  Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}
```
### 31. 栈的压入、弹出序列
### 40. 最小的 K 个数
### 31. 栈的压入、弹出序列
### 41.1 数据流中的中位数
### 41.2 字符流中第一个不重复的字符
### 59. 滑动窗口的最大值
## 第三章 链表
### 06. 从尾到头打印链表
### 18.1 在 O(1) 时间内删除链表节点
### 18.2 删除链表中重复的结点
### 22. 链表中倒数第 K 个结点
### 23. 链表中环的入口结点
### 24. 反转链表
### 25. 合并两个排序的链表
### 35. 复杂链表的复制
### 52. 两个链表的第一个公共结点
## 第四章 双指针
### 57.1 和为 S 的两个数字
### 57.2 和为 S 的连续正数序列
### 58.1 翻转单词顺序列
### 58.2 左旋转字符串
## 第五章 树
### 7. 重建二叉树
### 8. 二叉树的下一个结点
### 26. 树的子结构
### 27. 二叉树的镜像
### 28. 对称的二叉树
### 32.1 从上往下打印二叉树
### 32.2 把二叉树打印成多行
### 32.3 按之字形顺序打印二叉树
### 33. 二叉搜索树的后序遍历序列
### 34. 二叉树中和为某一值的路径
### 36. 二叉搜索树与双向链表
### 37. 序列化二叉树
### 54. 二叉查找树的第 K 个结点
### 55.1 二叉树的深度
### 55.2 平衡二叉树
### 68. 树中两个节点的最低公共祖先
## 第六章 贪心思想
### 14. 剪绳子
###  63. 股票的最大利润
## 第七章 二分查找
### 11. 旋转数组的最小数字
### 53. 数字在排序数组中出现的次数
## 第八章 分治思想
# 结尾

---
# 参考资料
+ **《剑指 Offer[M]. 名企面试官精讲典型编程题》**
+ [CS-Notes](http://www.cyc2018.xyz)
+ [LeetCode](https://leetcode-cn.com/problemset/lcof/)
+ [牛客网](https://www.nowcoder.com/ta/coding-interviews)







