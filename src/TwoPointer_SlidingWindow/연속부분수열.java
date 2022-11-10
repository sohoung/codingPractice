package TwoPointer_SlidingWindow;
import java.util.Scanner;

// 설명 : N개의 수로 이루어진 수열이 주어집니다.
//       이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
//       만약 N=8, M=6이고 수열이 다음과 같다면
//       1 2 1 3 1 1 1 2
//       합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
// 입력 예시 : 8 6
//          1 2 1 3 1 1 1 2
// 출력 예시 : 3
public class 연속부분수열 {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0; // 연속된 수열의 합
        int lt = 0;  // 연속된 수열의 시작 index
        for(int rt = 0; rt < n; rt++) {  // rt를 초깃값으로 rt가 n까지가면 for문 종료
            sum += arr[rt];  // 처음에 for문을 수행할 때 sum에 arr[rt]값을 누적합
            if(sum == k) {  // if문으로 sum과 입력받은 k의 값이 같은지 판별
                answer++;   // 만약 같다면 answer의 값 1증가
            }
            while(sum>=k) {  // while문으로 해주는 이유는 arr[lt]의 값을 빼도 다시 sum이 입력받은 k의 값보다 높을 수 있기 때문에 while문으로 sum이 k의 값보다
                             // 더 적어질 때까지 수행한다.
                sum -= arr[lt++];  // sum이 k보다 값이 높다면 lt index의 값을 빼주고 lt의 값을 1증가시켜준다. 이 방법은 SlidingWindow랑 같은 방법이다.
                if(sum==k) {  // while문의 조건으로 sum이 k와 같아질때도 true값을 반환하므로 if문으로 sum과 k의 값이 같다면 answer의 값을 1증가시켜준다.
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        연속부분수열 m = new 연속부분수열();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(n,k,arr));
    }
}
