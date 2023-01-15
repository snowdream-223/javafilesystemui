package ui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Enumeration;
import java.util.Vector;

//******Author：zhiminzhang
//******Data:2022/12/16 22:54
public class uptree {
    JTree treea;
    DefaultTreeModel defaultTreeModela;
    public uptree(JTree tree,
                  DefaultTreeModel defaultTreeModel,
                  DefaultMutableTreeNode root) {
treea=tree;
defaultTreeModela=defaultTreeModel;

        Vector<TreePath> v = new Vector<TreePath>();
        getExpandNode(root, v);
        root.removeAllChildren();
        addNode(root, 3);
        defaultTreeModel.reload();

        int n = v.size();
        for (int i = 0; i < n; i++) {
            Object[] objArr = v.get(i).getPath();
            Vector<Object> vec = new Vector<Object>();
            int len = objArr.length;
            for (int j = 0; j < len; j++) {
                vec.add(objArr[j]);
            }
            expandNode(tree, root, vec);
        }

    }

    public void addNode(DefaultMutableTreeNode node, int n) {
        for (int i = 1; i <= n; i++) {
            DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(i);
            for (int m = 1; m <= n; m++) {
                DefaultMutableTreeNode newChild2 = new DefaultMutableTreeNode(m);
                for (int j = 1; j <= n; j++) {
                    DefaultMutableTreeNode newChild3 = new DefaultMutableTreeNode(m);
                    newChild2.add(newChild3);
                }
                newChild.add(newChild2);
            }
            node.add(newChild);
        }
    }

    public Vector<TreePath> getExpandNode(TreeNode node, Vector<TreePath> v) {
        if (node.getChildCount() > 0) {
            TreePath treePath = new TreePath(defaultTreeModela.getPathToRoot(node));
            if (treea.isExpanded(treePath)) v.add(treePath);
            for (Enumeration e = node.children(); e.hasMoreElements(); ) {
                TreeNode n = (TreeNode) e.nextElement();
                getExpandNode(n, v);
            }
        }
        return v;
    }

    void expandNode(JTree myTree, DefaultMutableTreeNode currNode, Vector<Object> vNode) {
        if (currNode.getParent() == null) {
            vNode.removeElementAt(0);
        }
        if (vNode.size() <= 0) return;

        int childCount = currNode.getChildCount();
        String strNode = vNode.elementAt(0).toString();
        DefaultMutableTreeNode child = null;
        boolean flag = false;
        for (int i = 0; i < childCount; i++) {
            child = (DefaultMutableTreeNode) currNode.getChildAt(i);
            if (strNode.equals(child.toString())) {
                flag = true;
                break;
            }
        }
        if (child != null && flag) {
            vNode.removeElementAt(0);
            if (vNode.size() > 0) {
                expandNode(myTree, child, vNode);
            } else {
                myTree.expandPath(new TreePath(child.getPath()));
            }
        }
    }


}
