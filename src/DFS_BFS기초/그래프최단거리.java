package DFS_BFS기초;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 설명 : 다음 그래프에서 1번 정점에서 ㄱ각 정점으로 가는 최소 이동 간선 수를 구하세요.
// 입력 예시 : 6 9
//          1 3
//          1 4
//          2 1
//          2 5
//          3 4
//          4 5
//          4 6
//          6 2
//          6 5
// 출력 예시 : 2 : 3
//           3 : 1
//           4 : 1
//           5 : 2
//           6 : 2
public class 그래프최단거리 {
    static int n,k;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;  // dis 배열은 현재 정점에서 다음 정점의 최소 이동 간선 수를 넣어주는 배열이다.
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;  // 시작 지점에 체크
        dis[v] = 0; // 시작 지점은 간선 이동이 없으므로 0
        queue.offer(v);
        while(!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv : graph.get(cv)) {
                if(ch[nv] == 0) {  // 체크 배열로 방문하지 않은 정점이라면
                    ch[nv] = 1;    // 체크를 해주고
                    queue.offer(nv); // queue에 넣어준다.
                    dis[nv] = dis[cv] + 1;  // 이동 간선 수는 현재 정점에서 다음 정점으로 한 개의 간선을 이동하므로 1을 증가시켜서 dis[nv]에 넣어준다.
                }
            }
        }
    }
    public static void main(String[] args) {
        그래프최단거리 m = new 그래프최단거리();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 정점의 갯수
        k = sc.nextInt();  // 간선의 갯수
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) {  // n번 리스트까지 객체 생성
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        m.BFS(1);  // 시작 지점 지정
        for(int i = 2; i <=n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
