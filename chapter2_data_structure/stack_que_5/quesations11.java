import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

/**
 * 스택으로 오름차순 수열 만들기 (백준 온라인 저지 1874번)
 * 1부터 N까지의 수를 스택에 push하거나 pop하여 주어진 수열을 만들 수 있는지 확인하고,
 * 가능하다면 push와 pop 연산을 어떤 순서로 수행해야 하는지 출력한다.
 *
 * - 첫째 줄에 수열의 길이 N이 주어진다. (1 ≤ N ≤ 100,000)
 * - 둘째 줄부터 N개의 줄에 수열이 주어진다. (중복 없음, 1부터 N까지의 순열)
 *
 * - 주어진 수열을 만들 수 있다면, 각 연산을 한 줄에 하나씩 출력한다.
 *   '+'는 push 연산, '-'는 pop 연산을 의미한다.
 * - 만들 수 없다면 "NO"를 출력한다.
 *
 * 예시 입력:
 * 8 4 3 6 8 7 5 2 1
 *
 * 예시 출력:
 * + + + + - - + + - + + - - - - -
 *
 * 알고리즘 개념:
 * - 스택 자료구조의 LIFO 특성을 이용하여 문제를 해결한다.
 * - 현재 숫자보다 작거나 같은 수까지 스택에 push한 후, 스택의 top이 현재 숫자와 같으면 pop한다.
 * - 스택의 top이 현재 수보다 크면 수열을 만들 수 없으므로 "NO"를 출력한다.
 */
public class quesations11 {
    public static void main(String[] args) {
        // 스택 연산을 저장할 스택 객체 생성
        Stack<Integer> stack = new Stack<>();

        // 연산 결과(+ 또는 -)를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 생성된 숫자의 중복 여부를 체크하기 위한 HashSet
        HashSet<Integer> used = new HashSet<>();

        // 최종 생성된 입력 수열을 저장할 리스트
        ArrayList<Integer> sequence = new ArrayList<>();

        // 난수 생성을 위한 Random 객체
        Random rand = new Random();

        // 수열의 길이 (1부터 N까지의 순열을 랜덤하게 생성)
        int N = 8;

        // 중복되지 않는 1부터 N까지의 랜덤 순열 생성
        for (int i = 0; i < N; i++) {
            // 1부터 N까지의 수 중에서 랜덤한 수를 생성
            int n = rand.nextInt(N) + 1;

            // 이미 사용된 수가 아니면 수열에 추가
            if (!used.contains(n)) {
                used.add(n);         // 중복 방지를 위해 Set에 기록
                sequence.add(n);     // 순열 리스트에 추가
            }
            // 이미 사용된 숫자라면 다시 반복하여 새로운 난수 생성
            // (i는 증가하지 않기 때문에 정확히 N개의 고유 숫자가 생성됨)
            else {
                i--; // 유효하지 않은 난수였기 때문에 i 감소시켜 반복
            }
        }

        // 스택을 이용해 주어진 sequence를 만들기 위한 연산 기록
        int current = 1; // 다음에 push할 숫자
        boolean isPossible = true; // 수열 생성 가능 여부

        for (int target : sequence) {
            // target에 도달할 때까지 숫자를 스택에 push
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }
            // 스택의 top이 target과 같으면 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 만들 수 없는 경우
                isPossible = false;
                break;
            }
        }

        // 결과 출력
        if (isPossible) {
            System.out.print("입력 수열: ");
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println("\n연산 결과:");
            System.out.print(sb.toString());
        } else {
            System.out.println("NO");
        }

        
    }
}
/**
 * 자바의 스택 LIFO(Last-In-First-In) 구조를 따르는 자료구조이다.
 * 내부적으로 Vector를 상속하여 구현하며, 동기화되어있다.
 * 
 * push(E item) : 스택에 요소 추가.
 * pop() : 스택의 맨 위 요소를 제거하고 반환.
 * peak() : 스택의 맨 위 요소를 제거하지 않고 반환만.
 * isEmpty() : 스택이 비어있는지 확인.
 * search(Object o) : 해당 요소가 스택의 몇 번째 위치에 있는지 반환
 */
