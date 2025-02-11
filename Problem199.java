import java.util.*;
import java.io.*;

public class Problem199 {

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

    static void dfs(TreeNode node, int currDepth, List<Integer> list){
        if(node == null){
            return ;
        }

        if(currDepth == list.size()){
            list.add(node.val);
        }

        dfs(node.right, currDepth + 1, list);
        dfs(node.left, currDepth + 1, list);
    }

    public static List<Integer> rightSideViewDFS(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;
        
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();

            int i=1;
            while(i <= n){
                TreeNode node = q.poll();
                if(i == n){
                    list.add(node.val);
                }

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                i++;
            }
        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String[] arr = input.nextLine().split(" ");

            TreeNode root = TreeNode.insertLevelOrder(arr);
            List<Integer> res = rightSideViewDFS(root);
            for(int i: res){
                pw.print(i + " ");
            }
            pw.println();
        }

        pw.flush();
    }
}