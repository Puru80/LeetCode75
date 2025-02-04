import java.util.*;
import java.io.*;

public class Problem394 {

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

    public static String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> word = new Stack<>();
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                count = count * 10 + (s.charAt(i) - '0');
            } else if (ch == '[') {
                word.push(sb.toString());
                sb.setLength(0);
                num.push(count);
                count = 0;
            } else if(ch == ']'){
                int val = num.pop();
                String temp = sb.toString();
                sb.setLength(0);
                sb.append(word.pop());
                sb.append(temp.repeat(val));
            } else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();
            pw.println(decodeString(s));
        }

        pw.flush();
    }
}