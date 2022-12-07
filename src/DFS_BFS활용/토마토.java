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
    // static으로 잡은 이유는 BFS도 접근하지만 Main에다가 출발점들을 넣어야하므로 Main도 접근해야하므로 static으로 잡았다.
    public void BFS() {
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];  // 미리 static으로 만들어놓은 dx배열로 12시,3시,6시,9시에 대한 x좌표 탐색
                int ny = tmp.y + dy[i];  // 미리 static으로 만들어놓은 dy배열로 12시,3시,6시,9시에 대한 y좌표 탐색
                if(nx >= 0 && nx < n && ny >= 0 && ny < k && board[nx][ny] == 0) {
                    // 경계값을 넘어가지 않고 익은 토마토를 기준으로 12시,3시,6시,9시의 토마토들이 익지 않았다면 실행
                    board[nx][ny] = 1;  // 익은 토마토를 기준으로 12시,3시,6시,9시에 있는 토마토는 그 다음날 익은 토마토로 변하므로 익은 토마토라는 것을 알기위해 1을 넣어준다.
                    Q.offer(new Point(nx,ny));
                    day[nx][ny] = day[tmp.x][tmp.y] + 1;  // 익은 토마토들의 날짜를 계산하기 위한 day배열에 +1을 해준다음 값을 넣는다.
                }
            }
        }
    }
    public static void main(String[] args) {
        토마토  m = new 토마토();
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();  // 열
        n = sc.nextInt();  // 행
        board = new int[n][k];  // 문제의 조건대로 토마토 상자를 입력받은 n과 k에 따른 배열 크기 할당
        day = new int[n][k];    // 익은 토마토들의 날짜를 계산하기 위한 배열로 입력받은 n과 k에 따른 배열 크기 할당
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                board[i][j] = sc.nextInt();  // 이중 for문으로 board 배열에 값을 넣어준다.
                if(board[i][j] == 1) {  // board 배열의 값을 입력받을 때 익은 토마토가 들어온다면 바로 Q에 넣어준다.
                    Q.offer(new Point(i,j));
                }
            }
        }
        m.BFS();
        boolean flag = true;  // 문제의 조건 중 익지 않은 토마토가 있다면 -1을 출력하라고 했으므로 만약에 -1을 출력하여야 한다면 -1을 출력하기 위한 boolean형 변수
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                if(board[i][j] == 0){  // 위의 for문들로 토마토들이 더 이상 변하는 값이 없을 때 익지 않은 토마토가 있다면 flag를 false로 바꿔주고 -1을 출력해준다.
                    flag = false;
                }
            }
        }
        if(flag) {  // 익지 않은 토마토가 있다면 if문이 false이므로 아래의 코드는 실행하지 않는다.
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < k; j++) {
                    answer = Math.max(answer,day[i][j]);  // answer와 day[i][j]의 값을 비교하여서 더 큰 것을 answer에 넣어준다.
                }
            }
            System.out.print(answer);
        }
        else {
            System.out.print(-1);  // if문이 false이므로 answer의 답을 구할 수 없다. 즉 익지 않은 토마토가 있다는 것이므로 -1을 출력
        }
    }
}
