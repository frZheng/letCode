package Trees.Tree;

import java.util.List;

//import java.util.ArrayList;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getVal() {
        return val;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};