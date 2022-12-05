package DFS_BFS활용;
import java.util.Scanner;

// 설명 : 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
//       출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
//       격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
//       출발 0 0 0 0 0 0
//         0 1 1 1 1 1 0
//         0 0 0 1 0 0 0
//         1 1 0 1 0 0 0
//         1 1 0 0 0 0 1
//         1 1 0 1 1 0 0
//         1 0 0 0 0 0 도착
//       위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
// 입력 예시 : 0 0 0 0 0 0 0
//          0 1 1 1 1 1 0
//          0 0 0 1 0 0 0
//          1 1 0 1 0 1 1
//          1 1 0 0 0 0 1
//          1 1 0 1 1 0 0
//          1 0 0 0 0 0 0
// 출력 예시 : 8

public class 미로탐색 {
    static int[] dx = {-1,0,1,0};  // 붕우리 문제와 같이 x 좌표를 먼저 만들어준다.
    static int[] dy = {0,1,0,-1};  // 봉우리 문제와 같이 y 좌표를 먼저 만들어준다.
    static int[][] board;
    static int answer = 0;
    public void DFS(int x, int y) {
        if(x == 7 && y == 7) {  // 종착점인 도착점에 오면 갈 수 있는 방법이므로 answer을 1증가
            answer++;
        }
        else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];  // 12시, 3시, 6시, 9시의 좌표 값 입력
                int ny = y + dy[i];  // 12시, 3시, 6시, 9시의 좌표 값 입력
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {  // 경계 값을 넘어가지 않고 board에 0이 되어있으면 갈 수 있는 방향이므로
                    board[nx][ny] = 1;  // 길로 갈 수 있는 곳이면 체크하고
                    DFS(nx,ny);         // 그 다음 nx와 ny를 매개변수로 넘기고
                    board[nx][ny] = 0;  // 백트래킹으로 갔던 길을 다시 사용해야하므로 0으로 체크를 풀어준다.
                }
            }
        }
    }

    public static void main(String[] args) {
        미로탐색  m = new 미로탐색();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for(int i = 1; i <= 7; i++) {
            for(int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        m.DFS(1,1);
        System.out.println(answer);
    }
}
