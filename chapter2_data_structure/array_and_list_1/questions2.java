/*
 * 평균 구하기
 * 세준이는 기말고사를 망쳤다. 그래서 점수를 조작해 집으로 가져가기로 결심했다. 일단 세준이는 자기 점수
 * 최댓값을 골랐다. 그런 다음 최댓값을 M이라 할 때 모든 점수를 점수/M*100으로 고쳤다.
 * 예를들어 "최고점이 70,, 수학 점수가 50이라면 수학점수는 50/70*100이므로 71.43점이다."
 * 이와 같은 방법으로 성적을 계산했을 때의 새로운 평균을 구하는 프로그램을 작성하시오.
 * 
 * 1번째 줄에 시험을 본 과목의 개수 N이 주어진다. 해당 값은 N <= 1000.
 * 2번째 줄에 세준이의 현재 성적이 주어진다. 해당 값은 100보다 작거나 같고, 음이 아닌 정수이며, 적어도 1개의 값은 0보다 크다.
 */

import java.util.Random;

public class questions2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Random rand = new Random();
        int N = rand.nextInt(1000) + 1;
        double[] scores = new double[N];

        long beforeFirstLoop = System.nanoTime();
        // N의 갯수만큼 score에 점수 저장.
        for (int i = 0; i < N; i++) {
            scores[i] = rand.nextInt(100) + 1;
        }
        long afterFirstLoop = System.nanoTime();

        // 최대값 찾아 변수에 저장
        long beforeSecondLoop = System.nanoTime();
        double max = 0;
        for (int i = 0; i < N; i++) {
            // 현재 점수가 max보다 크면 max를 갱신
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        long afterSecondLoop = System.nanoTime();

        // 계산된 점수들에 대한 평균값 출력.
        long beforeThirdLoop = System.nanoTime();
        double sum = 0;
        for (int i = 0; i < N; i++) {
            // 점수를 최댓값으로 정규화 후 100을 곱해 새로운 점수를 만듦
            sum += (scores[i] / max) * 100;
        }
        long afterThirdLoop = System.nanoTime();
        // 새로운 점수들의 평균을 출력
        System.out.println("새로운 평균 점수: " + (sum / N));

        long endTime = System.nanoTime();
        double firstLoopTime = (afterFirstLoop - beforeFirstLoop) / 1_000_000.0;
        System.out.printf("첫 번째 for문 (점수 생성): %.4f ms (%.6f sec)\n", firstLoopTime, firstLoopTime / 1000);

        double secondLoopTime = (afterSecondLoop - beforeSecondLoop) / 1_000_000.0;
        System.out.printf("두 번째 for문 (최댓값 찾기): %.4f ms (%.6f sec)\n", secondLoopTime, secondLoopTime / 1000);

        double thirdLoopTime = (afterThirdLoop - beforeThirdLoop) / 1_000_000.0;
        System.out.printf("세 번째 for문 (점수 정규화 및 합계): %.4f ms (%.6f sec)\n", thirdLoopTime, thirdLoopTime / 1000);

        double totalTime = (endTime - startTime) / 1_000_000.0;
        System.out.printf("전체 실행 시간: %.4f ms (%.6f sec)\n", totalTime, totalTime / 1000);
    }

}
