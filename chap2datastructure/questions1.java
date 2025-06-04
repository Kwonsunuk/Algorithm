// N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
// 1번째 줄에 숫자의 개수 N(1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.

import java.util.Random;

public class questions1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(100) + 1; // 1~100 사이 숫자의 개수
        StringBuilder sb = new StringBuilder();
        // 공백 없이 붙은 숫자 n개를 문자열로 생성 (예: 54321)
        for (int i = 0; i < n; i++) {
            int digit = rand.nextInt(9) + 1; // 1~9 범위 숫자 생성 (0 제외)
            sb.append(digit);
        }
        String numbers = sb.toString();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers.charAt(i) - '0'; // 문자 → 숫자 변환
        }
        System.out.println("숫자의 개수: " + n);
        System.out.println("숫자들: " + numbers);
        System.out.println("총합: " + sum);
    }
}
