/*
 * 구간 합 구하기 1
 * 수 N개가 주어졌을 때 i번째 수에서 j 번째 수까지의 합을 구하는 프로그램을 작성하시오.
 * 1번째 줄에 수의 개수 N(1 <= N <= 100,000), 합을 구해야하는 횟수 M(1 <= M <= 100,000),
 * 2번째 줄에 N개의 개수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수다. 3번째 줄부터는 M개의 줄에 
 * 합을 구해야하는 구간 i와 j가 주어진다.
 */

import java.util.Random;

public class questions3 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Random rand = new Random();

        // 1. N: 수열의 길이, M: 질의 수
        int N = rand.nextInt(100_000) + 1;
        int M = rand.nextInt(100_000) + 1;

        int[] A = new int[N + 1];// 실제 수열
        int[] S = new int[N + 1];// 합 배열

        long beforeInitLoop = System.nanoTime();
        // 2. 수열 생성 (1~1000 사이 랜덤값)
        for (int i = 1; i <= N; i++) {
            A[i] = rand.nextInt(1000) + 1;
            S[i] = S[i - 1] + A[i]; // 합 배열 만드는 공식 사용
        }
        long afterInitLoop = System.nanoTime();

        long beforeQueryLoop = System.nanoTime();
        int i = 0, j = 0, range_sum;
        for (int q = 1; q <= M; q++) {
            i = rand.nextInt(N) + 1; // i는 1 ~ N
            j = rand.nextInt(N - i + 1) + i; // j는 i 이상 N 이하
            range_sum = S[j] - S[i - 1];
        }
        long afterQueryLoop = System.nanoTime();
        long endTime = System.nanoTime();

        double initTime = (afterInitLoop - beforeInitLoop) / 1_000_000.0;
        double queryTime = (afterQueryLoop - beforeQueryLoop) / 1_000_000.0;
        double totalTime = (endTime - startTime) / 1_000_000.0;

        System.out.printf("시작 위치:" + i + " 종료 위치:" + j);
        System.out.printf("수열 및 합 배열 생성 시간: %.4f ms (%.6f sec)\n", initTime, initTime / 1000);
        System.out.printf("구간 합 계산 총 시간: %.4f ms (%.6f sec)\n", queryTime, queryTime / 1000);
        System.out.printf("전체 실행 시간: %.4f ms (%.6f sec), 수열 생성 제외: %.4f ms (%.6f sec)\n",
            totalTime, totalTime / 1000, totalTime - initTime, (totalTime - initTime) / 1000);
    }
}

/*
 * 합 배열을 만드는 공식
 * S[i] = S[i - 1] + A[i]
 * 구간 합을 구하는 공식
 * S[j] - S[i-1] (i에서 j까지 구간합)
 */
