import java.util.Random;

/*
 * 구간 합 구하기 2
 * N x N개의 수가 N x N 크기의 표에 채워져있다. 표한의 수 중 (X1, Y1)에서
 * (X2, Y2)까지의 합을 구하려 한다. X는 행, Y는 열을 의미한다. 예를들어 N = 4이고, 표가 밑과 같이 채워져 있을 때..
 * 1 2 3 4
 * 2 3 4 5
 * 3 4 5 6
 * 4 5 6 7
 * (2, 2)에서 (3, 4)까지의 합을 구하면 3 + 4 + 5 + 4 + 5 + 6 = 27이다.
 * 
 * 1번째 줄에 표의 크기 N과 합을 구해야하는 횟수 M이 주어진다. (1 <= N <= 1024, 1 <= M <= 100,000)
 * 2번째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 4개의 정수 X1, Y1, X2, Y2가 주어지며
 * 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수다.(X1 <= X2, Y1 <= Y2)
 */

public class questions4 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Random rand = new Random();

        int N = rand.nextInt(1024) + 1; // 표의 크기 (1~1024)
        int M = rand.nextInt(100_000) + 1; // 질의 횟수 (1~100,000)

        int[][] arr = new int[N + 1][N + 1]; // 1-based indexing을 위해 +1 (기본 배열)

        // 2차원 배열 값 랜덤 생성.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = rand.nextInt(1000) + 1;
            }
        }
        long afterInitArray = System.nanoTime();

        int[][] arr_s = new int[N + 1][N + 1]; // 합 배열 S

        // 2차원 합 배열 생성.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // arr_s[i][j] = 위 + 왼쪽 - 중복 + 현재
                arr_s[i][j] = arr_s[i - 1][j] + arr_s[i][j - 1] - arr_s[i - 1][j - 1] + arr[i][j];
            }
        }

        long beforeQueryLoop = System.nanoTime();
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        long sum = 0;
        for (int q = 1; q <= M; q++) {
            x1 = rand.nextInt(N) + 1;
            y1 = rand.nextInt(N) + 1;
            x2 = rand.nextInt(N - x1 + 1) + x1;
            y2 = rand.nextInt(N - y1 + 1) + y1;

            sum = arr_s[x2][y2] - arr_s[x1 - 1][y2] - arr_s[x2][y1 - 1] + arr_s[x1 - 1][y1 - 1];
        }
        long afterQueryLoop = System.nanoTime();

        long endTime = System.nanoTime();
        double arrayInitTime = (afterInitArray - startTime) / 1_000_000.0;
        double queryTime = (afterQueryLoop - beforeQueryLoop) / 1_000_000.0;
        double totalTime = (endTime - startTime) / 1_000_000.0;

        System.out.printf("2차원 배열 생성 시간: %.4f ms (%.6f sec)\n", arrayInitTime, arrayInitTime / 1000);
        System.out.printf("구간 합 계산 시간: %.4f ms (%.6f sec)\n", queryTime, queryTime / 1000);
        System.out.printf("전체 실행 시간: %.4f ms (%.6f sec), 배열 생성 제외: %.4f ms (%.6f sec)\n",
                totalTime, totalTime / 1000, totalTime - arrayInitTime, (totalTime - arrayInitTime) / 1000);

        System.out.printf("마지막 질의 %d: (%d, %d)에서 (%d, %d)까지의 구간 합은 %d입니다.\n", M, x1, y1, x2, y2, sum);

    }
}

/*
 * [1차원 합 배열 공식]
 * - 합 배열 생성: S[i] = S[i - 1] + A[i]
 * - 구간 합 계산: S[j] - S[i - 1] → A[i]부터 A[j]까지의 합
 *
 * [2차원 합 배열 공식]
 * - 합 배열 생성: S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + A[i][j]
 * - 구간 합 계산:
 * S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1]
 * → (x1, y1)부터 (x2, y2)까지 직사각형 영역의 합
 */
