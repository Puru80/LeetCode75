import java.util.*;
import java.io.*;

public class Problem2352 {

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

    private static final int PRIME = 31; // A prime number
    private static final int MOD = (int) 1e9 + 7; // A large prime number

    static int calculateHash(int[] arr) {
        int hash = 0;
        int power = 1;

        for (int i : arr) {
            hash = (hash + i * power) % MOD;
            power = (power * PRIME) % MOD;
        }

        return hash;
    }

    /* public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int[] rowHashes = new int[n];
        int[] colHashes = new int[n];

        for (int i = 0; i < n; i++) {
            rowHashes[i] = calculateHash(grid[i]);
        }

        for(int i: rowHashes){
            pw.print(i + " ");
        }
        pw.println();

        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[i] = grid[j][i];
            }

            colHashes[i] = calculateHash(col);
        }

        for(int i: colHashes){
            pw.print(i + " ");
        }
        pw.println();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rowHashes[i] == colHashes[j]) {
                    ans++;
                }
            }
        }

        return ans;
    } */

    public static int equalPairs(int[][] grid){
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                s += Integer.toString(grid[i][j]);
                s += "*";
            }

            if (!map.containsKey(s))
                map.put(s, 1);
            else
                map.put(s, map.get(s) + 1);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            String s = "";
            for(int j=0;j<n;j++){
                s += Integer.toString(grid[j][i]);
                s += "*";
            }

            if(map.containsKey(s)){
                ans += map.get(s);
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int[][] grid = new int[n][];

            for (int i = 0; i < n; i++) {
                grid[i] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                        .toArray();
            }

            pw.println(equalPairs(grid));
        }

        pw.flush();
    }
}
