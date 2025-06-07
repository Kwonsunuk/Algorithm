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

/*
         * Random 클래스의 nextXXX() 메서드와 Math.random()은 모두 난수를 생성하지만 차이점이 있다.
         *
         * 1. Math.random()
         *    - 반환값: 0.0 이상 1.0 미만의 double
         *    - 정적(static) 메서드로 객체 생성 없이 간단히 사용 가능
         *    - 시드(seed) 설정 불가능 → 테스트 재현 어려움
         *    - 간단한 난수 생성에 적합
         *
         * 2. Random 클래스 (java.util.Random)
         *    - 객체를 생성하여 사용하며, 다양한 타입의 난수 제공 (int, double, boolean 등)
         *    - 시드 설정 가능: new Random(시드값) → 테스트 반복 시 유용
         *    - 반복 생성보다는 한 번만 만들고 재사용하는 것이 좋음
         *    - 실무에서는 다양한 상황에 더 유연하게 대응 가능
         *
         * 일반적으로 단순한 double 값이 필요한 경우 Math.random()을,
         * 정밀 제어가 필요하거나 다양한 타입의 난수가 필요한 경우 Random 클래스를 사용하는 것이 좋다.
         */