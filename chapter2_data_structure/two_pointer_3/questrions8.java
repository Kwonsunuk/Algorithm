import java.util.Arrays;
import java.util.Random;

/**
 * '좋은 수' 구기
 * 주어진 N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 '좋은 수'라고 한다. N개의 수 중 좋은 수가 총 몇개인지 출력하시오.
 * 
 * 1번째 줄에 수의 개수 N(1 <= N <= 2,000), 2번째 줄에 N개의 수의 값(Aᵢ)이 주어진다. (|Aᵢ| <= 1,000,000,000, Aᵢ는 정수)
 * 
 * 10 // 수의 개수
 * 1 2 3 4 5 6 7 8 9 10
 * 결과 8
 */
public class questrions8 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // 실행 시간 측정 시작

        Random rand = new Random();
        int N = rand.nextInt(2_000) + 1;
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = rand.nextInt(1_000_000_000) + 1;
        }
        Arrays.sort(A);

        int count = 0; // '좋은 수' 개수 카운트

        // 배열의 각 수 A[k]가 다른 두 수의 합으로 표현될 수 있는지 확인
        for (int k = 0; k < N; k++) {
            int find = A[k]; // 현재 검사 중인 수
            int i = 0;       // 왼쪽 포인터
            int j = N - 1;   // 오른쪽 포인터

            // 투 포인터 알고리즘을 이용한 합 비교
            while (i < j) {
                if (i == k) { // 자기 자신은 제외
                    i++;
                    continue;
                } else if (j == k) { // 자기 자신은 제외
                    j--;
                    continue;
                }

                int sum = A[i] + A[j];

                if (sum == find) { // 좋은 수 발견
                    count++;
                    break;
                } else if (sum < find) { // 합이 작으면 왼쪽 포인터 증가
                    i++;
                } else { // 합이 크면 오른쪽 포인터 감소
                    j--;
                }
            }
        }

        long endTime = System.nanoTime(); // 실행 시간 측정 종료
        double elapsedMs = (endTime - startTime) / 1_000_000.0;

        System.out.println("좋은 수의 개수: " + count);
        System.out.printf("실행 시간: %.4f ms (%.6f sec)\n", elapsedMs, elapsedMs / 1000);
    }    
}
