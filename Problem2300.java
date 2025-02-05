import java.util.*;
import java.io.*;

public class Problem2300 {

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

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int start = 0, end = m - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                long product = (long) spell * potions[mid];

                if (product >= success) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            res[i] = m - start;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] spells = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            /* for (int i : spells) {
                pw.print(i + " ");
            }
            pw.println(); */

            int[] potions = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            /* for (int i : potions) {
                pw.print(i + " ");
            }
            pw.println(); */

            long success = input.nextLong();

            // pw.println(success);

            int[] res = successfulPairs(spells, potions, success);
            for (int i: res) {
                pw.print(i + " ");
            }

            pw.println();
        }

        pw.flush();
    }
}