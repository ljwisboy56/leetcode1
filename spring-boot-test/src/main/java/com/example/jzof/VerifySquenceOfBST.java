package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-01 16:12
 */
public class VerifySquenceOfBST {
    /**
     * 算法步骤如下：
     * 1. 找到根结点；
     * 2. 遍历序列，找到第一个大于等于根结点的元素i，则i左侧为左子树、i右侧为右子树；
     * 3. 我们已经知道i左侧所有元素均小于根结点，那么再依次遍历右侧，看是否所有元素均大于根结点；若出现小于根结点的元素，则直接返回false；若右侧全都大于根结点，则：
     * 4. 分别递归判断左/右子序列是否为后序序列；
     * <p>
     * 例子：[1 3 2]
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return doVerify(sequence, 0, sequence.length - 1);
    }

    private boolean doVerify(int[] sequence, int start, int end) {
        //这个边界终止条件很重要在递归里面
        //当start=end的时候就是标识递归到最后了都只剩下一个叶节点了那么这个树必然满足bst特性了
        if (start >= end) {
            return true;
        }

        //先拿后续遍历的根节点
        int root = sequence[end];

        //然后遍历从start找到第一个大于根节点root的元素，他就说右子树的根节点
        int i = start;
        while (i < end) {
            if (sequence[i] > root) {
                break;
            }
            i++;
        }

        //j就是右子树的根节点元素
        //然后判断右子树是否都满足bst树的条件：即都大于根节点
        int j = i;
        while (j < end) {
            if (sequence[j] < root) {
                return false;
            }
            j++;
        }

        boolean res;
        res = doVerify(sequence, start, i - 1);

        if (res) {
            doVerify(sequence, j, end - 1);
        } else {
            return res;
        }
        return true;

    }
}
