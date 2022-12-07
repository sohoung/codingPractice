package DFS_BFS활용;
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
public class 섬나라아일랜드_DFS {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};  // 12시,3시,6시,9시의 4방향과 각 대각선을 합친 8방향에 대한 x좌표 탐색
    static int[] dy = {0,1,1,1,0,-1,-1,-1};  // 12시,3시,6시,9시의 4방향관 각 대각선을 합친 8방향에 대한 y좌표 탐색
    static int n,answer = 0;
    public void DFS(int x, int y, int[][] board) {
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];  // 다음 x좌표를 위한 int형 nx 변수 생성
            int ny = y + dy[i];  // 다음 y좌표를 위한 int형 ny 변수 생성
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {  // 각 x와 y좌표에 대한 경계값을 넘어가지 않고 board[nx][ny]로 다음 지점이 섬이라면
                board[nx][ny] = 0;  // 그 다음 지점인 섬에 대한 값을 0으로 만들어주고
                DFS(nx,ny,board);  // 다시 DFS 탐색을 위한 인자로 nx와 ny와 board 배열을 매개변수로 넘겨준다.
            }
        }
    }
    public void solution(int[][] board) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {  // 탐색하는 도중 섬을 만났다면
                    answer++;           // 먼저 육지를 발견했으므로 answer에 1을 증가시켜주고
                    board[i][j] = 0;    // 출발지점을 변경해주어야 다시 다른 탐색을 할 때 중복으로 답이 증가되지 않는다.
                    DFS(i,j,board);     // DFS 탐색으로 근처 8방향이 섬인지 바다인지를 확인하기 위해 현 지점 i,j와 board 배열을 매개변수로 넘겨준다.
                }
            }
        }
    }
    public static void main(String[] args) {
        섬나라아일랜드_DFS  m = new 섬나라아일랜드_DFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 격자의 크기
        int[][] arr = new int[n][n];  // board 배열을 매개변수로 넘겨주기 위한 처음 격자판
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        m.solution(arr);
        // 먼저 solution으로 처음 격자판에 섬이 있는지 탐색하고 만약 탐색도중에 섬이 나왔다면 DFS 탐색으로 8방향에 바다인지 섬인지를 탐색하는 순서로 진행
        System.out.println(answer);
    }
}
