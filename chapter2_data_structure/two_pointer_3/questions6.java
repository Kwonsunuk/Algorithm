import java.util.Random;

/**
 * 연속된 자연수의 합 구하기
 * 어떠한 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 <= N <= 10,000,000)을
 * 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다. 이때 사용하는 자연수는 N이어야 한다. 예를들어 15를
 * 나타내는 방법은 15, 7 + 8, 4 + 5 + 6, 1 + 2 + 3 + 4 + 5이다. 반면, 10을 나타내는 방법은 1 + 2 +
 * 3 + 4 이다.
 * 이처럼 N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오.
 * 
 * 1번째 줄에 정수 N이 주어진다.
 */
public class questions6 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // 실행 시간 측정 시작

        Random rand = new Random(); // 랜덤 객체 생성

        int N = rand.nextInt(10_000_000) + 1; // 1 이상 10,000,000 이하의 자연수 N 생성
        System.out.println("입력된 N: " + N); // 생성된 N 출력

        int start_index = 1; // 투 포인터 시작 지점
        int end_index = 1; // 투 포인터 끝 지점
        int count = 1; // 경우의 수 (초기값 1: N 자기 자신이 되는 경우 포함)
        int sum = 1; // 현재 구간의 합

        // 투 포인터 방식으로 연속된 자연수의 합으로 N이 되는 경우의 수 찾기
        while (end_index != N) {
            if (sum == N) {
                count++; // 합이 정확히 N일 경우 카운트 증가
                end_index++; // 끝 포인터를 오른쪽으로 한 칸 이동
                sum += end_index; // 새 값을 합에 더함
            } else if (sum > N) {
                sum -= start_index; // 합이 N보다 크면 시작 포인터 위치 값을 뺌
                start_index++; // 시작 포인터를 오른쪽으로 한 칸 이동
            } else {
                end_index++; // 합이 N보다 작으면 끝 포인터 확장
                sum += end_index; // 새 값을 합에 더함
            }
        }

        long endTime = System.nanoTime(); // 실행 시간 측정 종료
        double elapsedMs = (endTime - startTime) / 1_000_000.0; // 밀리초(ms) 단위로 변환

        // 실행 결과 출력
        System.out.printf("실행 시간:  %.4f ms (%.6f sec)\nstart_index = %d, end_index = %d, 결과 값: %d\n",
                elapsedMs, elapsedMs / 1000, start_index, end_index, count);
    }
}