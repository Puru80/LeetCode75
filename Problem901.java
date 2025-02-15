import java.util.*;
import java.io.*;

class StockSpanner {

    Stack<int[]> s;

    public StockSpanner() {
        s = new Stack<>();
    }

    public int next(int price) {
        int days = 1;
        while(!s.isEmpty() && s.peek()[0] <= price){
            days += s.pop()[1];
        }

        s.push(new int[]{price, days});

        return days;
    }
}

public class Problem901 {

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
            int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();

            StockSpanner spanner = new StockSpanner();
            for(int i=1;i<arr.length;i++){
                pw.print(spanner.next(arr[i]) + " ");
            }

            pw.println();

        }

        pw.flush();
    }
}