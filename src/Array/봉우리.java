package Array;
import java.util.Scanner;

// 설명 : 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
//       각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
//       격자의 가장자리는 0으로 초기화 되었다고 가정한다.
//       만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
// 입력 예시 : 5
//          5 3 7 2 3
//          3 7 1 6 1
//          7 2 5 3 4
//          4 3 6 4 1
//          8 7 3 5 2
// 출력 예시 : 10
public class 봉우리 {
    int[] dx = {-1,0,1,0};  // 행의 좌표를 지정하는 배열
    int[] dy = {0,1,0,-1};  // 열의 좌표를 지정하는 배열
    public int solution(int[][] arr, int n) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                boolean flag = true;  // 현재 지점의 숫자가 봉우리인지 아닌지를 판별해주는 boolean형 변수
                for(int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];  // 현재 지점의 숫자에서 행의 범위에 있는 숫자
                    int ny = j + dy[k];  // 현재 지점의 숫자에서 열의 범위에 있는 수자
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        // 주의할 점으로 arr[nx][ny] >= arr[i][j]를 먼저 if문으로 판별하기전에 컴퓨터가 코드를 읽을 때는 앞에서부터 읽으므로
                        // 경계선을 먼저 걸러줘야한다. 경계선을 걸러주지 않으면 IndexOutOfBoundException 오류가 나오게 되므로 먼저 nx와 ny의 범위를 정해주고
                        // 문제의 조건에 맞게 현재 지점의 숫자가 봉우리인지 아닌지 판별해준다.
                        flag = false;  // 만약 for문 수행도중 자신의 숫자보다 더 높은 숫자가 하나라도 나오면 현재지점의 숫자는 봉우리가 아니므로 바로 for문을 나올 수 있게
                        break;         // break를 걸어준다.
                    }
                }
                if(flag) {             // 현재 지점의 숫자가 봉우리라면 answer의 값을 1증가시켜준다.
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        봉우리  m = new 봉우리();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(m.solution(arr,n));
    }
}
