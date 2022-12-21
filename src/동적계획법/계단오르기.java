package 동적계획법;
import java.util.Scanner;

// 설명 : 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
//       1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
//       그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
// 입력 예시 : 7
// 출력 예시 : 21
// Dynamic Programming(동적 계획법) : 최적화 이론의 한 기술이며 특정범위까지의 값을 구하기 위해서 그것과 다른 범위까지의 값을 이용하여 효율적으로 값을 구하는 알고리즘 설계기법이다.
//                                 동적 계획법은 "어떤 문제를 풀기 위해 그 문제를 더 작은 문제의 연장선으로 생각하고, 과거에 구한 해를 활용하는" 방식의 알고리즘을 총칭한다.
// Memoization(메모이제이션) : 프로그램이 동일한 계산을 반복적으로 할 때 이전에 계산한 값을 메모리에 저장함으로써 동일한 계산의 반복 수행을 제거하여 프로그램 실행 속도를 빠르게 해주는 기술이다.
//                         Dynamic Programming인 동적 계획법에서 핵심인 기술이다.
public class 계단오르기 {
    static int[] dynamic;
    public int solution(int n) {
        dynamic[1] = 1;    // 피보나치 수열과 비슷한 문제
        dynamic[2] = 2;    // 피보나치 수열과 비슷한 문제
        for(int i = 3; i <= n; i++) {
            dynamic[i] = dynamic[i-1] + dynamic[i-2];
        }
        return dynamic[n];
    }
    public static void main(String[] args) {
        계단오르기  m = new 계단오르기();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();  // 계단의 갯수
        dynamic = new int[n+1];
        System.out.println(m.solution(n));
    }
}
