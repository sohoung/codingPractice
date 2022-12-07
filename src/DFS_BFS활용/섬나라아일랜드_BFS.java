package DFS_BFS활용;
import java.text.DateFormatSymbols;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 설명 : N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
//       각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
//       섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
// 입력 예시 : 7
//           1 1 0 0 0 1 0
//           0 1 1 0 1 1 0
//           0 1 0 0 0 0 0
//           0 0 0 1 0 1 1
//           1 1 0 1 1 0 0
//           1 0 0 0 1 0 0
//           1 0 1 0 1 0 0
// 출력 예시 : 5

public class 섬나라아일랜드_BFS {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};  // 12시,3시,6시,9시의 4방향과 각 대각선을 합친 8방향에 대한 x좌표 탐색
    static int[] dy = {0,1,1,1,0,-1,-1,-1};  // 12시,3시,6시,9시의 4방향관 각 대각선을 합친 8방향에 대한 y좌표 탐색
    static int n, answer = 0;
    Queue<Point> Q = new LinkedList<>();
    public void BFS(int x, int y, int[][] board) {
        Q.add(new Point(x,y));  // Queue에 현재 지점을 넣어준다.
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();  // Point형 변수 tmp에 현재 지점의 Q를 넣어주고
            for(int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];  // static으로 잡아놓은 dx배열을 이용해서 8방향 탐색
                int ny = tmp.y + dy[i];  // static으로 잡아놓은 dy배열을 이용해서 8방향 탐색
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {  // 경계값을 넘어가지 않고 현재지점을 기준으로 8방향 중 한 곳이라도 섬이 있다면
                    board[nx][ny] = 0;  // 그 지점을 0으로 만들어주고
                    Q.add(new Point(nx,ny));  // Q에 넣어주고 nx와 ny를 매개변수로 Point에 넘겨준다.
                }
            }
        }
    }
    public void solution(int[][] board) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    answer++;         // 처음 탐색했을 때 섬이 발견되면 육지를 카운트해주는 answer을 1증가시켜준다.
                    board[i][j] = 0;  // 처음 발견된 지점을 0으로 만들어주고
                    BFS(i,j,board);   // 다음 8방향 탐색을 위한 BFS 탐색을 하도록 i,j,board를 매개변수로 BFS에 넘겨준다.
                }
            }
        }
    }
    public static void main(String[] args) {
        섬나라아일랜드_BFS m = new 섬나라아일랜드_BFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        m.solution(arr);
        System.out.println(answer);
    }
}
