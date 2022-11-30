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
// * 방문한 노드를 또 방문하는 것은 없다.
public class 경로탐색_인접행렬 {
    static int n, k, answer = 0;
    static int[][] graph;  // 입력받은 그래프를 2차원 배열로 표현
    static int[] ch;  // 방문 했는지에 대한 체크 배열
    public void DFS(int v) {
        if(v==n) {  // 종점에 왔을 때
            answer++;
        }
        else {
            for(int i = 1; i <= n; i++) {
                if(graph[v][i] == 1 && ch[i] == 0) {  // 한 번도 방문하지 않고 graph배열에 있는 방향이라면
                    ch[i] = 1;  // 값을 넣어주고 체크
                    DFS(i);     // 백 트래킹
                    ch[i] = 0;  // 백 트래킹을 해줄 때 체크를 풀어줘야 다른 방향으로 갈 수 있다. 체크를 풀어주지 않으면 이미 체크된 지점이라고 판단하고
                                // if문을 수행하지 않을 수 있다.
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
