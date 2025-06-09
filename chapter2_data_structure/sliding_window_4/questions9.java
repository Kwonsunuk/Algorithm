/**
 * DNA 비밀번호
 * DNA 문자열이 주어질 때, 특정 길이의 부분 문자열(슬라이딩 윈도우)을 골라서 그 안에
 * A, C, G, T 문자가 각각 최소한 몇 개 이상 포함되어야 한다는 조건을 만족하는 경우의 수를 구하는 문제이다.
 *
 * 첫 줄: 문자열 길이 |S|와 비밀번호로 사용할 부분 문자열의 길이 |P| (1 <= |P| <= |S| <= 1_000_000)
 * 두 번째 줄: 길이 S인 DNA 문자열 (A, C, G, T로만 구성됨)
 * 세 번째 줄: 부분 문자열에 포함돼야 할 A, C, G, T 각각에 대해 최소 요구 개수 (공백 구분된 4개의 정수)
 */
public class questions9 {
    public static void main(String[] args) {
        // 입력값 설정 (테스트용)
        int S = 4;
        int P = 2;
        String dna = "GATA";
        int[] required = { 1, 0, 0, 1 }; // A, C, G, T에 대한 최소 개수
        int[] current = new int[4]; // 현재 윈도우 안의 A, C, G, T 개수

        int result = 0; // 조건을 만족하는 비밀번호 수

        // 초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            add(dna.charAt(i), current);
        }

        if (isValid(required, current))
            result++;

        // 슬라이딩 윈도우 이동
        for (int i = P; i < S; i++) {
            add(dna.charAt(i), current); // 새로 들어온 문자
            remove(dna.charAt(i - P), current); // 나간 문자
            if (isValid(required, current))
                result++;
        }

        System.out.println("가능한 비밀번호 수: " + result);
    }

    // 문자 추가
    private static void add(char c, int[] current) {
        switch (c) {
            case 'A':
                current[0]++;
                break;
            case 'C':
                current[1]++;
                break;
            case 'G':
                current[2]++;
                break;
            case 'T':
                current[3]++;
                break;
        }
    }

    // 문자 제거
    private static void remove(char c, int[] current) {
        switch (c) {
            case 'A':
                current[0]--;
                break;
            case 'C':
                current[1]--;
                break;
            case 'G':
                current[2]--;
                break;
            case 'T':
                current[3]--;
                break;
        }
    }

    // 현재 윈도우가 조건을 만족하는지 확인
    private static boolean isValid(int[] required, int[] current) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i])
                return false;
        }
        return true;
    }
}