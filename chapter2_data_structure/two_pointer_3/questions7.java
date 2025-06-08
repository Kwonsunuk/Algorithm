import java.util.Arrays;
import java.util.Random;

/**
 * 주몽의 명령
 * 주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장에게 철기군이 입을 갑옷을 만들라고 명했다.
 * 야철대장은 주몽의 명령에 따르기 위해 연구에 착수하던 중 갑옷을 만드는 재료들은 각각 고유 번호가 있고,
 * 갑옷은 2개의 재료로 만드는데 2가지의 재료의 고유한 번호를 합쳐 M(1 <= M <= 10,000,000)이 되면 갑옷이 만들어진다는
 * 사실을 알았다.
 * 따라서 N(1 <= N <= 15,000)개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
 * 
 * 1번째 줄에 재료의 개수 N, 2번째 줄에 갑옷을 만드는 데 필요한 수 M (1 <= M <= 10,000,000)이 주어진다.
 * 3번째는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 고유 번호는 100,000보다 작거나 같은 자연수다.
 */
public class questions7 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // 실행 시간 측정 시작
        Random rand = new Random();

        int N = rand.nextInt(15_000) + 1; // 재료의 개수 (1 ≤ N ≤ 15,000)
        int M = rand.nextInt(10_000_000) + 1; // 갑옷을 만드는 데 필요한 수 (1 ≤ M ≤ 10,000,000)
        int[] materials = new int[N]; // 재료의 고유 번호를 저장할 배열

        // 완전히 랜덤하게 생성할 경우 갑옷이 만들어지는 경우의 수(count)가 대부분 0이 되는 문제 발생
        // 따라서 디버깅 및 학습 목적상 반드시 한 쌍이 존재하도록 구성
        // 첫 두 재료는 의도적으로 M을 만들 수 있도록 설정 (예: x + y = M)
        int x = rand.nextInt(100_000) + 1; // 첫 번째 재료
        int y = M - x; // 두 번째 재료는 M을 만들 수 있도록 설정

        // 두 수 모두 1 이상 100,000 이하인지 확인
        if (y < 1 || y > 100_000) {
            x = 3;
            y = M - x;
        }

        materials[0] = x;
        materials[1] = y;

        // 나머지 재료는 랜덤으로 생성
        for (int i = 2; i < N; i++) {
            materials[i] = rand.nextInt(100_000) + 1;
        }

        // 굳이 다른 정렬 알고리즘 필요 없이 Arrays.sort() 사용.
        Arrays.sort(materials);

        int count = 0, left = 0, right = N - 1;
        while (left < right) {
            int sum = materials[left] + materials[right];
            if (sum == M) {
                count++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }
        long endTime = System.nanoTime(); // 실행 시간 측정 종료
        double elapsedMs = (endTime - startTime) / 1_000_000.0;

        System.out.printf("갑옷을 만들 수 있는 경우의 수: %d\n", count);
        System.out.printf("실행 시간: %.4f ms (%.6f sec)\n", elapsedMs, elapsedMs / 1000);
        // System.out.println("갑옷을 만들 수 있는 경우의 수: " + count);
    }

}
