public class timeComplexityExample1 {
    public static void main(String[] args) {
        /*
         * 시간복잡도
         * 빅-오메가 (Ω) 표기법은 알고리즘의 **최소** 시간 복잡도를 나타냅니다. (Best case)
         * 빅-세타 (Θ) 표기법은 알고리즘의 **평균** 시간 복잡도를 나타냅니다. (Average case)
         * 빅-오 (O) 표기법은 알고리즘의 **최대** 시간 복잡도를 나타냅니다. (Worst case)
         * 반복문 실행 횟수에 따라 시간 복잡도가 결정됩니다:
         * - 빅-오메가: 최선의 경우 반복문은 1번만 실행됩니다.
         * - 빅-세타: 평균적으로 N/2번 반복문이 실행됩니다.
         * - 빅-오: 최악의 경우 반복문은 N번 실행됩니다.
         * 코딩 테스트에서는 주로 빅-오 표기법을 사용하여 시간 복잡도를 분석합니다.
         * 
         * 이 예제에서는 0부터 99999까지의 숫자 중에서 무작위로 선택된 숫자를 찾는 과정을 보여줍니다.
         * 시간 복잡도는 O(N)입니다. (최악의 경우 모든 숫자를 확인해야 하므로)
         * 
         * 시간복잡도 분석:
         * - 최선의 경우: O(1) (찾고자 하는 숫자가 첫 번째로 나오는 경우)
         * - 평균적인 경우: O(N) (무작위로 선택된 숫자가 중간에 위치하는 경우)
         * - 최악의 경우: O(N) (찾고자 하는 숫자가 마지막에 나오는 경우)
         */
        int findNumber = (int) (Math.random() * 100000); // 0부터 99999까지의 무작위 숫자 선택

        // 수행 시간 측정 시작
        long startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            if (i == findNumber) {
                System.out.println("찾은 숫자: " + findNumber);

                break;
            }
            // 연산 추가
            int temp = i * i;
        }

        // 수행 시간 측정 종료
        long endTime = System.nanoTime();

        // 걸린 시간 계산 (나노초 -> 밀리초)
        long durationNano = endTime - startTime;
        double durationMillis = durationNano / 1_000_000.0;

        System.out.println("수행 시간: " + durationMillis + " ms");
        System.out.println("데이터 크기(N): 100");
    }
}
