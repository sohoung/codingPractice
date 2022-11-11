package TwoPointer_SlidingWindow;
import java.util.Scanner;

// 설명 : N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
//       만약 N=15이면
//       7+8=15
//       4+5+6=15
//       1+2+3+4+5=15
//       와 같이 총 3가지의 경우가 존재한다.
// 입력 예시 : 15
// 출력 예시 : 3
public class 연속된자연수의합 {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;  // 입력받은 n과 비교할 sum
        int lt = 0;   // arr배열의 시작 index
        int k = n/2+1;  // 연속된 자연수의 합 중에서 제일 큰 숫자는 입력받은 n을 2로나눈 몫에 1을 더한 값이 제일 큰 값이다.
        int[] arr = new int[k];  // 배열 동적 할당
        for(int i = 0; i < k; i++) {  // for문으로 arr배열에 값을 입력
            arr[i] = i+1;
        }
        for(int rt = 0; rt < k; rt++) {  // 문제를 푸는 for문으로 two pointer알고리즘으로 포인터 2개를 이용하여
                                         // sum과 n의 값을 비교하여 각 if문을 사용하여 경우의 수를 구한다.
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while(sum>=n) {
                sum -= arr[lt++];
                if(sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        연속된자연수의합 m = new 연속된자연수의합();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(m.solution(n));
    }
}
