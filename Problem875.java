import java.util.*;
import java.io.*;

public class Problem875 {

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

    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        return max;
    }

    static int calculateTotalHours(int[] arr, int h){
        int totalHours = 0;

        for(int i: arr){
            totalHours += Math.ceil((double)(i)/(double)(h));
        }

        return totalHours;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int lo=0, hi = findMax(piles);

        while(lo <= hi){
            int mid = (lo + hi)/2;
            int totalH = calculateTotalHours(piles, mid);

            if(totalH <= h){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            int[] piles = Arrays.stream(input.nextLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
                    .toArray();
            int h = input.nextInt();

            pw.println(minEatingSpeed(piles, h));

        }

        pw.flush();
    }
}