package Array;
import java.util.Scanner;

// 설명 : 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
//       2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
// 입력 예시 : 10
// 출력 예시 : 1 1 2 3 5 8 13 21 34 55
public class 피보나치수열 {
     public int[] solution(int n) {
         int[] answer = new int[n];
         answer[0] = 1;  // 피보나치 수열의 특성에 맞게 첫 번째 숫자는 1이다.
         answer[1] = 1;  // 피보나치 수열의 특성에 맞게 두 번째 숫자는 1이다.
         for(int i = 2; i < n; i++) {  // 앞의 2개의 숫자는 미리 값이 들어가있으므로 처음 시작 index를 2로 지정해준다.
             answer[i] = answer[i-1] + answer[i-2];  // 피보나치 수열은 앞의 2개의 숫자를 합한 숫자가 피보나치 수열이다.
         }                                           // 2개의 앞의 숫자를 더한 숫자를 더한 값을 i 번째 index로 값을 넣어준다.
         return answer;
     }
    public static void main(String[] args) {
        피보나치수열 m = new 피보나치수열();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int x : m.solution(n)) {
            System.out.print(x + " ");
        }
    }
}
