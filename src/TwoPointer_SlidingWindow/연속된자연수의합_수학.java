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
// 수학적으로 푸는방법
public class 연속된자연수의합_수학 {
    public int solution(int n) {
        int answer = 0;
        int cnt = 1;  // 연속된 자연수의 갯수
        n--;
        while(n>0) {
            cnt++;
            n = n - cnt;
            if(n%cnt == 0) {  // n을 cnt로 나눈 나머지가 0이라면 이것은 연속된 자연수의 합이 가능하므로 answer에 1증가
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        연속된자연수의합_수학  m = new 연속된자연수의합_수학();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(m.solution(n));
    }
}
