package Array;
import java.util.Scanner;

// 설명 : 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
//       N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
// 입력 예시 : 5
//          10 13 10 12 15
//          12 39 30 23 11
//          11 25 50 53 15
//          19 27 29 37 27
//          19 13 30 13 19
// 출력 예시 : 155
public class 격자판최대합 {
    public int solution(int[][] arr, int n) {
        int answer = 0;
        int sum1,sum2;
        for(int i = 0; i < n; i++) {
            sum1=sum2=0;
            for(int j = 0; j < n; j++) {
                sum1 += arr[i][j];  // *행의 합
                sum2 += arr[j][i];  // *열의 합
            }
            answer = Math.max(answer, sum1);   // answer와 sum1의 값을 비교하여 더 큰 값을 answer에 넣는다.
            answer = Math.max(answer, sum2);   // answer와 sum2의 값을 비교하여 더 큰 값을 answer에 넣는다.
        }
        sum1=sum2=0;    // 이제 2개의 대각선 합을 구해야 하므로 다시 sum1과 sum2를 초기화시킨다.
        for(int i = 0; i < n; i++) {
            sum1 += arr[i][i];         // 왼쪽에서 오른쪽으로 내려오는 대각선의 합
            sum2 += arr[i][n-i-1];     // 오른쪽에서 왼쪽으로 내려오는 대각선의 합
        }
        answer = Math.max(answer,sum1);  // answer와 sum1을 비교하여 더 큰 값을 answer에 넣는다.
        answer = Math.max(answer,sum2);  // answer와 sum2를 비교하여 더 큰 값을 answer에 넣는다.
        return answer;
    }
    public static void main(String[] args) {
        격자판최대합  m = new 격자판최대합();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(m.solution(arr,n));
    }
}
