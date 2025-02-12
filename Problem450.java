import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode insertLevelOrder(String[] arr) {
        int n = arr.length;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);

        int i = 1;
        while (i < n) {

            TreeNode node = q.poll();

            if (i < n && !arr[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.left);
            }

            i++;

            if (i < n && !arr[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.right);
            }

            i++;

        }

        return root;
    }
}

public class Problem450 {

    public static PrintWriter pw;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("D:/VSCode/LeetCode75/input.txt"));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static TreeNode findLastRight(TreeNode node) {
        if (node.right == null) {
            return node;
        }

        return findLastRight(node.right);
    }

    static TreeNode helper(TreeNode node) {
        if (node.left == null)
            return node.right;
        else if (node.right == null)
            return node.left;

        TreeNode rightChild = node.right;
        TreeNode lastRight = findLastRight(node.left);
        lastRight.right = rightChild;

        return node.left;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return helper(root);
        }

        TreeNode temp = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                } else {
                    root = root.right;
                }
            }
        }

        return temp;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String[] arr = input.nextLine().split(" ");
            int target = input.nextInt();

            TreeNode root = TreeNode.insertLevelOrder(arr);

            root = deleteNode(root, target);

        }

        pw.flush();
    }
}