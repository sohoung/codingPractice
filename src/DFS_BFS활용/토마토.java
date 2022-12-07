package DFS_BFS활용;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 설명 : 현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
//       토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
//       창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
//       익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
//       하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
//       토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
//       토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
//       며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
// 입력 예시 : 6 4
//           0 0 -1 0 0 0
//           0 0 1 0 -1 0
//           0 0 -1 0 0 0
//           0 0 0 0 -1 1
// 출력 예시 : 4

public class 토마토 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board, day;
    static int n, k;
    static Queue<Point> Q = new LinkedList<>();
    public void BFS() {
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx,ny));
                    day[nx][ny] = day[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        토마토  m = new 토마토();
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();  // 열
        n = sc.nextInt();  // 행
        board = new int[n][k];
        day = new int[n][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; i++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) {
                    Q.offer(new Point(i,j));
                }
            }
        }
        m.BFS();
        boolean flag = true;
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                if(board[i][j] == 0){
                    flag = false;
                }
            }
        }
        if(flag) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < k; j++) {
                    answer = Math.max(answer,day[i][j]);
                }
            }
            System.out.print(answer);
        }
        else {
            System.out.print(-1);
        }
    }
}
