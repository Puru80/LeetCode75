import java.util.*;
import java.io.*;

public class Problem2390 {

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

    public static String removeStars(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '*')
                stack.pop();
            else 
                stack.add(s.charAt(i));
        }

        String result = "";
        while (!stack.empty()) {
            result = stack.pop() + result;
        }

        return result;
    }


    public static String removeStarsWithoutStack(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder("");

        char ch;
        for (int i = 0; i < n; ++i) {
            ch = s.charAt(i);
            if (ch == '*') {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String s = input.nextLine();
            pw.println(removeStars(s));
        }

        pw.flush();
    }
}