import java.util.*;
import java.io.*;

public class Problem1161 {

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

    public static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int ans = 0;
        int level = 0;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            level += 1;
            int n = q.size();

            int sum = 0;
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }

            if(sum > max){
                ans = level;
                max = sum;
            }

        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String[] arr = input.nextLine().split(" ");

            TreeNode root = TreeNode.insertLevelOrder(arr);
            pw.println("Ans: " + maxLevelSum(root));
        }

        pw.flush();
    }
}
