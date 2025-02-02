import java.util.*;
import java.io.*;

public class Problem1657 {

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

    public static boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch: word1.toCharArray()){
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for(int i=0;i<freq1.length;i++){
            if((freq1[i] == 0 && freq2[i] != 0 ) || freq1[i] != 0 && freq2[i] == 0) 
                return false;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i=0;i< freq1.length; i++){
            if(freq1[i] != freq2[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        FastReader input = new FastReader();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/VSCode/LeetCode75/output.txt")));
        int t = input.nextInt();

        while (t-- > 0) {
            String word1 = input.nextLine();
            String word2 = input.nextLine();

            pw.println(closeStrings(word1, word2));
        }

        pw.flush();
    }
}