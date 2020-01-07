package com.example.jzof;

import com.example.letcodeeasy.TreeNode;
import org.apache.poi.hssf.record.formula.functions.T;

/**
 * @author yingru.ljw
 * @date 2019-12-21 17:46
 */
public class Serialize {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        String abc = new Serialize().Serialize(treeNode1);
        System.out.println(abc);



    }

    String Serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Serialize2(root, sb);
        return sb.toString();
    }

    void Serialize2(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        Serialize2(root.left, sb);
        Serialize2(root.right, sb);
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        if(str.length() == 0)
            return null;
        String[] strs = str.split(",");
        return Deserialize2(strs);
    }

    TreeNode Deserialize2(String[] strs) {
        index++;
        if(!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }
        return null;
    }

}
