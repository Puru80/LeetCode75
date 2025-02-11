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

public class Problem872 {

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

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        ArrayList<Integer> lis1 = new ArrayList<>();
        ArrayList<Integer> lis2 = new ArrayList<>();

        s1.push(root1);
        s2.push(root2);

        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();

            if (node.left == null && node.right == null) {
                lis1.add(node.val);
            }

            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
        }

        while (!s2.isEmpty()) {
            TreeNode node = s2.pop();

            if (node.left == null && node.right == null) {
                lis2.add(node.val);
            }

            if (node.left != null) {
                s2.push(node.left);
            }
            if (node.right != null) {
                s2.push(node.right);
            }
        }

        return lis1.equals(lis2);
    }


    static int dfs(Stack<TreeNode> s){
        while(true){
            TreeNode node = s.pop();

            if(node.left != null)
                s.push(node.left);
            if(node.right != null)
                s.push(node.right);

            if(node.left == null && node.right == null)
                return node.val;

        }
    }

    public static boolean leafSimilarOptimized(TreeNode root1, TreeNode root2){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root1);
        s2.push(root2);

        while(!s1.isEmpty() && !s2.isEmpty()){
            if (dfs(s1) != dfs(s2)) return false;
        }

        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String[] arr = input.nextLine().split(" ");
            String[] arr2 = input.nextLine().split(" ");

            TreeNode root1 = TreeNode.insertLevelOrder(arr);
            TreeNode root2 = TreeNode.insertLevelOrder(arr2);

            pw.println(leafSimilarOptimized(root1, root2));
        }

        pw.flush();
    }
}
