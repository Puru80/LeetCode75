import java.util.*;
import java.io.*;


public class Problem649 {

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

    public static String predictPartyVictory(String senate){
        Queue<Integer> rad = new ArrayDeque<>();
        Queue<Integer> dir = new ArrayDeque<>();

        int n = senate.length();

        for(int i=0;i<n;i++){
            if(senate.charAt(i) == 'R'){
                rad.add(i);
            } else {
                dir.add(i);
            }
        }

        while(!rad.isEmpty() && !dir.isEmpty()){
            if(rad.peek() < dir.peek()){
                rad.add(n++);
            } else{
                dir.add(n++);
            }
            rad.poll();
            dir.poll();
        }

        return rad.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();

            pw.println(predictPartyVictory(s));
        }

        pw.flush();
    }
}
