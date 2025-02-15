import java.util.*;
import java.io.*;

public class Problem1493 {

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

    public static int longestSubarray(int[] nums) {
        int left = 0, zeroes = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeroes++;
            while (zeroes > 1) {
                if (nums[left] == 0)
                    zeroes--;
                left++;
            }

            ans = Math.max(ans, right - left + 1 - zeroes);
        }

        return (ans == nums.length) ? ans - 1 : ans;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int arr[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int ans = longestSubarray(arr);
            pw.println(ans);
        }

        pw.flush();
    }
}