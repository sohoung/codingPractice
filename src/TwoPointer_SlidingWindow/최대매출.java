package TwoPointer_SlidingWindow;
import java.util.Scanner;

// 설명 : 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
//       만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
//       12 15 11 20 25 10 20 19 13 15
//       연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
// 입력 예시 : 10 3
//          12 15 11 20 25 10 20 19 13 15
// 출력 예시 : 56

public class 최대매출 {
    public int solution(int n, int[] arr, int k) {
        int answer = 0;
        int sum = 0;  // 입력받은 숫자에 따른 연속된 수의 합을 저장하는 변수
        for(int i = 0; i < k; i++) {  // 먼저 처음으로 연속된 k번째의 숫자까지 sum에 누적합해준다.
            sum += arr[i];
        }
        answer = sum;
        for(int i = k; i < n; i++) {  // 시작지점을 k번째로 하고 sum에 k번째 index의 숫자를 더하고 제일 처음 숫자를 뺀 값을 sum에 누적합해준다.
            // 창문을 만들듯이 하나를 더하고 하나를 지우는 형식으로 수행한다.
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);  // 값이 더 큰 것을 answer에 넣는다.
        }
        return answer;
    }
    public static void main(String[] args) {
        최대매출  m = new 최대매출();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(m.solution(n,arr,k));
    }
}
