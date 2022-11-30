package DFS_BFS기초;
import java.util.ArrayList;
import java.util.Scanner;

// 설명 : 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
// 입력 예시 :5 9
//          1 2
//          1 3
//          1 4
//          2 1
//          2 3
//          2 5
//          3 4
//          4 2
//          4 5
// 출력 예시 : 6
// * 인접 행렬로 할 경우 모든 경우의 수를 돌아서 답을 찾아야한다. 즉 정점이 10000개라면 10000x10000을 해야한다는 소리이다.
//   하지만 인접 리스트로 이 문제를 접근 할 경우 정점끼리의 방향을 알고 있는 상태이므로 정점끼리의 갈 수 있는 방향만 ArrayList에 넣어준다.
//   이럴경우 인접행렬은 방향이 맞지 않는 경우까지 for문으로 찾아줘야하지만 인접리스트의 경우에는 갈 수 있는 방향만을 for문으로 찾아가기 때문에 메모리의 사용량이 훨씬 더 적어진다.
public class 경로탐색_인접리스트 {
    static int n, k, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;  // Integer를 저장할 수 있는 ArrayList타입의 ArrayList를 선언만 한다.
    static int[] ch;   // 체크 배열
    public void DFS(int v) {
        if(v==n) {
            answer++;
        }
        else {
            for(int nv : graph.get(v)) {  // v번 정점에서 다음 뻗어갈 v를 찾아야하므로 next v의 nv와 get(v)는 v번 ArrayList를 향상된 for문으로 돌아준다.
                                          // ArrayList는 Collections 프레임워크이기 때문에 향상된 for문을 사용할 수 있다.
                if(ch[nv] == 0) {  // nv를 ch배열로 보았을 때 만약 방문을 하지 않았다면
                    ch[nv] = 1;    // 체크를 해주고 백트래킹을 사용하기 때문에 체크를 풀어주고 뒤로 다시가서 다른 길을 찾아주어야한다.
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        경로탐색_인접리스트  m = new 경로탐색_인접리스트();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 정점의 갯수
        k = sc.nextInt();  // 간선의 갯수
        graph = new ArrayList<ArrayList<Integer>>();  // ArrayList를 저장할 수 있는 ArrayList 객체를 생성
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());  // 정수를 저장할 수 있는 ArrayList를 n번까지 생성한다. 즉 정점의 갯수+1만큼 생성하고 0번 ArrayList는 버린다.
        }
        ch = new int[n+1];
        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);  // a번 ArrayList에 b를 넣어준다. 즉 a번 List에 b의 정점을 넣는다.
        }
        ch[1] = 1;
        m.DFS(1);
        System.out.println(answer);
    }
}
