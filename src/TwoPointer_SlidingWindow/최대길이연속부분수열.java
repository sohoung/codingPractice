package TwoPointer_SlidingWindow;
import java.util.Scanner;

// 설명 : 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
//       여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
//       만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
//       1 1 0 0 1 1 0 1 1 0 1 1 0 1
//       여러분이 만들 수 있는 1이 연속된 연속부분수열은
//       1 1 0 0 (1 1 1 1 1 1 1 1) 이며 길이는 8입니다.
// 입력 예시 : 14 2
//          1 1 0 0 1 1 0 1 1 0 1 1 0 1
// 출력 예시 : 8
public class 최대길이연속부분수열 {
    public int solution(int[] arr, int n, int k) {
        int answer = 0;
        int cnt = 0;  // 0에서1로 바꾼 횟수
        int lt = 0;   // 배열의 시작 index지점
        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) {  // 문제의 조건에 따라 현재 index의 값이 0이라면 1로 바꾼다.
                cnt++;          // 0에서 1로 바꾸는 횟수가 2회로 제한되어있으므로 cnt를 1증가시킨다.
            }
            while(cnt>k) {      // k가 제한된 횟수이며 만약 0에서 1로 바꾼 횟수가 2를 넘어가게되면 다시 1에서 0으로 바꿔줘야한다.
                if(arr[lt] == 0) {  // arr[lt]의 값이 0이라면 cnt를 1감소시켜주고 lt의 값을 1증가시켜준다.
                    cnt--;
                }
                lt++;  // 0인지점을 찾아줘야하므로 lt를 1증가시켜준다.
            }
            answer = Math.max(answer,rt-lt+1);  // rt-lt+1은 연속된 1의 길이를 구해줘야하므로 연속된 숫자의 마지막 index rt에서 맨 처음 index lt를 빼주고
                                                // 거기에 1을 더해줘야 길이값이 나온다.
        }
        return answer;
    }
    public static void main(String[] args) {
        최대길이연속부분수열 m = new 최대길이연속부분수열();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(arr,n,k));
    }
}
