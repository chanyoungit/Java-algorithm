import java.io.*;
import java.util.StringTokenizer;

public class NOTE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][3];
            char[] ch = new char[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                int count = 0;
                int index = 0;
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        int power = arr[j][2] / ((int) (Math.pow(arr[i][0] - arr[j][0], 2))
                                + (int) (Math.pow(arr[i][1] - arr[j][1], 2)));
//						System.out.println(power);
                        if (arr[i][2] < power) {
                            count++;
                            index = j;
                        }
                    }
                }
                if (count == 0) {
                    ch[i] = 'K';
                } else if (count == 1) {
                    ch[i] = (char) (index + '0');
                } else {
                    ch[i] = 'D';
                }
            }
            bw.write("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                bw.write(ch[i] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}