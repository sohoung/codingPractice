package DFS_BFS활용;
import java.security.cert.PolicyNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 설명 : 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
//       경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
//       출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
//       격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
//       출발 0 0 0 0 0 0
//         0 1 1 1 1 1 0
//         0 0 0 1 0 0 0
//         1 1 0 1 0 0 0
//         1 1 0 0 0 0 1
//         1 1 0 1 1 0 0
//         1 0 0 0 0 0 도착
//       위와 같은 경로가 최단 경로의 길이는 12이다.
// 입력 예시 : 0 0 0 0 0 0 0
//           0 1 1 1 1 1 0
//           0 0 0 1 0 0 0
//           1 1 0 1 0 1 1
//           1 1 0 1 0 0 0
//           1 0 0 0 1 0 0
//           1 0 1 0 0 0 0
// 출력 예시 : 12

class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 미로의최단거리통로 {
    static int[] dx = {-1,0,1,0};  // 12시, 3시, 6시, 9시 좌표 배열 먼저 생성
    static int[] dy = {0,1,0,-1};  // 12시, 3시, 6시, 9시 좌표 배열 먼저 생성
    static int[][] board,dis;      // board와 최단 거리를 저장할 dis 배열을 전역을 생성
    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();  // Queue 객체 생성
        Q.offer(new Point(x,y));  // 처음 지점인 Point(x,y)를 Q에 넣어준다.
        board[x][y] = 1;    // 시작 지점을 갔으므로 1을 넣어준다.
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();  // 시작 지점을 Point형 tmp에 넣어준다.
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];  // 위에 생성한 좌표 배열을 이용해서 nx인 다음 x좌표에 값을 더해주어서 12시, 3시, 6시, 9시의 값을 넣어준다.
                int ny = tmp.y + dy[i];  // 위에 생성한 좌표 배열을 이용해서 ny인 다음 y좌표에 값을 더해주어서 12시, 3시, 6시, 9시의 값을 넣어준다.
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    // 1<=nx<=7, 1<=ny<=7이면 경계값을 넘어가지 않고 board[nx][ny]가 0이면 벽이 없다는 말이므로 갈 수 있다는 통로라는 말이다.
                    board[nx][ny] = 1;  // 위의 if문이 true라면 갈 수 있는 통로이므로 1을 넣어주고
                    Q.offer(new Point(nx,ny));  // Q에 넣어준다.
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;  // 그래프 최단 거리와 비슷한 활용
                    // 그 다음 최단 거리를 구해야 하므로 dis[nx][ny]에 현재 지점인 dis[tmp.x]tmp.y]에 +1을 해주어서 그 다음 지점으로 넘어갔다는 것을 카운트 해준다.
                }
            }
        }
    }
    public static void main(String[] args) {
        미로의최단거리통로  m = new 미로의최단거리통로();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for(int i = 1; i <= 7; i++) {
            for(int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        m.BFS(1,1);
        if(dis[7][7] == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(dis[7][7]);
        }
    }
}
