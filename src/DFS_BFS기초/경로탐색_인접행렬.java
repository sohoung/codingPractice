package DFS_BFS기초;
import java.util.Scanner;

// 설명 : 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
// 입력 예시 : 5 9
//           1 2
//           1 3
//           1 4
//           2 1
//           2 3
//           2 5
//           3 4
//           4 2
//           4 5
// 출력 예시 : 6
public class 경로탐색_인접행렬 {
    static int n, k, answer = 0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v) {
        if(v==n) {
            answer++;
        }
        else {
            for(int i = 1; i <= n; i++) {
                if(graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        경로탐색_인접행렬 m = new 경로탐색_인접행렬();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 정점의 갯수
        k = sc.nextInt();  // 간선의 갯수
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        m.DFS(1);
        System.out.println(answer);
    }
}
