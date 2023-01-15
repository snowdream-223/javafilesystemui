package io;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

//******Author：zhiminzhang
//******Data:2022/12/17 21:11
public class bianlitree {


    public static void visitAllNodes(TreeNode node ,String[] strings) {
        int length = strings.length;
        // node is visited exactly once

        if (node.getChildCount() >= 0) {//判断是否有子节点

            for (Enumeration e = node.children(); e.hasMoreElements(); ) {

                TreeNode n = (TreeNode) e.nextElement();


                //visitAllNodes(n);//若有子节点则再次查找

            }

        }
    }
}
