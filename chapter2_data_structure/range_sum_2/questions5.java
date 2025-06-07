import java.util.Random;
/*
 * 나머지 합 구하기
 * N개의 수 A₁, A₂, ..., Aₙ이 주어졌을 때 연속된 부분의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 * 즉, Aᵢ + ... + Aⱼ(i ≤ j)의 합이 M으로 나누어 떨어지는 (i, j)쌍의 개수를 구하시오.
 * 
 * 1번째 줄에 N과 M(1 ≤ N ≤ 10⁶, 2 ≤ M ≤ 10³), 2번째 줄에 N개의 개수 A₁, A₂, ..., Aₙ이 주어진다.(0 ≤ Aᵢ ≤ 10⁹)
 */

public class questions5 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int N, M; // N: 수의 개수, M: 나눌 수 (모듈로 기준)
        int[] A;  // A: 입력 수열 (1-based 인덱스 사용)
        long[] S; // S: 누적합을 저장할 배열 (long: 오버플로우 방지)

        Random rand = new Random(); // 난수 생성을 위한 Random 객체 생성

        N = rand.nextInt(1_000_000) + 1; // N을 1 이상 1,000,000 이하의 랜덤 정수로 설정
        M = rand.nextInt(1_000) + 1;     // M을 1 이상 1,000 이하의 랜덤 정수로 설정

        A = new int[N + 1]; // 수열 A 배열 생성 (1-based index → 0번은 사용 안 함)
        S = new long[N + 1]; // 누적합 배열 S 생성 (0번은 0으로 시작)

        for (int i = 1; i <= N; i++) {
            A[i] = rand.nextInt(1_000_000_000 + 1); // 각 A[i]를 0 이상 10⁹ 이하의 정수로 랜덤 생성
            S[i] = S[i - 1] + A[i]; // S[i] = 앞까지 누적합 + 현재 값 → 누적합 배열 계산
        }


        int count = 0;
        int[] mod = new int[M]; // 나머지 카운트 배열
        mod[0] = 1; // S[0] % M == 0인 경우 포함

        for (int i = 1; i <= N; i++) {
            int remainder = (int)(S[i] % M); // 현재 누적합을 M으로 나눈 나머지
            count += mod[remainder]; // 지금까지 같은 나머지가 나온 횟수만큼 더함
            mod[remainder]++; // 현재 나머지를 카운팅
        }
        System.out.printf("입력된 N: %,d, M: %,d\n", N, M);
        System.out.println("M으로 나누어떨어지는 구간 수: " + count);

        long endTime = System.nanoTime();
        double elapsedMs = (endTime - startTime) / 1_000_000.0;
        System.out.printf("실행 시간: %.4f ms (%.6f sec)\n", elapsedMs, elapsedMs / 1000);
    }
}
