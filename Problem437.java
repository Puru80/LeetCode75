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

class Solution {
    // private HashMap<Integer, Integer> map;

    private int dfs(TreeNode node, int prefixSum, int targetSum, HashMap<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        prefixSum += node.val;
        int count = map.getOrDefault(prefixSum - targetSum, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        count += dfs(node.left, prefixSum, targetSum, map);
        count += dfs(node.right, prefixSum, targetSum, map);

        map.put(prefixSum, map.get(prefixSum) - 1);

        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return dfs(root, 0, targetSum, map);
    }
}

public class Problem437 {

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

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String[] arr = input.nextLine().split(" ");
            int targetSum = input.nextInt();

            TreeNode root = TreeNode.insertLevelOrder(arr);

            Solution sol = new Solution();
            pw.println(sol.pathSum(root, targetSum));
        }

        pw.flush();
    }
}