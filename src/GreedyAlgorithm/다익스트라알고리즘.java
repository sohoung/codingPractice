package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 설명 : 가중치 방향 그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요. (경로가 없으면 impossible를 출력한다.)
// 입력 예시 : 6 9
//           1 2 12   : 1번 정점에서 2번 정점까지의 가중치가 12라는 의미
//           1 3 4
//           2 1 2
//           2 3 5
//           2 5 5
//           3 4 5
//           4 2 2
//           4 5 5
//           6 4 5
// 출력 예시
// 2 : 11
// 3 : 4
// 4 : 9
// 5 : 14
// 6 : impossible
// 다익스트라 알고리즘을 사용할 경우 간선의 가중치 값이 무조건 양수로 나와야한다. 음수가 있으면 사용 불가 0은 상관 없다.
// 다익스트라 알고리즘 : 한 정점에서 모든 정점까지의 최단 거리를 각각 구하는 알고리즘(최단 경로 문제)

class Edge implements Comparable<Edge> {
    public int vex;  // 정점
    public int cost; // 간선의 가중치
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;  // cost에 의해 오른차순 정렬
    }
}
public class 다익스트라알고리즘 {
    static int n,k;
    static ArrayList<ArrayList<Edge>> graph;
    static int dis[];
    // dis[i]의 의미는 1번 정점에서 i번째 정점까지 가는 최소 이동 경로를 저장하는 배열이다. index번호를 정점의 번호로 생각하고 배열 생성을 해준다.
    public void solution(int v) {
        PriorityQueue<Edge> p = new PriorityQueue<>();  // Edge형 PriorityQueue 객체 생성
        p.offer(new Edge(v,0));   // 먼저 시작으로 1번 정점에서 1번 정점까지 가는 가중치는 0으로 시작한다.
        dis[v] = 0;  // 1번 정점에서 v번 정점까지의 최소 이동 경로를 저장
        while(!p.isEmpty()) {  // 다익스트라 알고리즘
            Edge tmp = p.poll(); // poll하는 기준은 compareTo로 재정의 했듯이 cost 비용을 기준으로 작은 값을 poll해준다. 오름차순이므로
            int now = tmp.vex;         // int now에 현재의 정점을 넣어주고
            int nowCost = tmp.cost;    // int nowCost에는 현재의 간선의 가중치를 넣어준다.
            if(nowCost > dis[now]) {
                continue;
                // Edge tmp = p.poll()을 해줄때 재정읟된 기준으로 빼는 상황에서 만약 cost의 값이 문제의 조건보다 더 좋은 값을 했지만 값이 바뀌지 않았을 경우
                // 더 안좋은 cost 값으로 해봤자 똑같은 결과이므로 아래의 for문을 수행할 필요가 없다. 즉 nowCost 값이 현재 dis 배열에 있는 값 보다 크다면 아래의 for문을 수행할 필요가 없다는 의미이다.
            }
            for(Edge o : graph.get(now)) {  // 1번 정점과 연결된 정점과 가중치를 하나하나 대입한다.
                // ex) 1번 정점과 연결된 것은 2번 정점과 3번 정점이다. 즉 2번 정점과 2번 정점까지 가는 가중치와 3번 정점과 3번 정점까지 가는 가중치를 대입하여서 아래의 if문을 수행
                if(dis[o.vex] > nowCost + o.cost) {
                    // dis의 최솟값을 구하기 위해서 먼저 들어가 있는 dis 배열의 값과 nowCost + o.cost를 더한 값이 현재 들어가 있는 값보다 작다면
                    dis[o.vex] = nowCost + o.cost;
                    // 최솟값이므로 dis 배열 안에 있는 값을 nowCost + o.cost의 값으로 바꿔준다.
                    p.offer(new Edge(o.vex, nowCost + o.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        다익스트라알고리즘 m = new 다익스트라알고리즘();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 정점의 갯수
        int k = sc.nextInt();  // 간선의 갯수
        graph = new ArrayList<ArrayList<Edge>>();  // Edge라는 객체를 저장할 수 있는 ArrayList
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());  // 먼저 시작되는 정점의 갯수에 대한 ArrayList 객체를 생성해준다.
        }
        dis = new int[n+1];  // index 번호를 정점의 번호로 보기 때문에 배열의 크기를 n+1로 잡아준다.
        Arrays.fill(dis,Integer.MAX_VALUE);
        // fill 함수로 dis 배열에 있는 모든 값들을 Integer.MAX_VALUE로 값을 초기화해준다. 이유는 Integer.MAX_VALUE로 값을 초기화 하였을 때
        // 결국 최솟값을 구하는 것이므로 1번 정점부터 가지 못하는 정점은 그대로 Integer.MAX_VALUE 값이 그대로 있을 것이다.
        // 1번 정점부터 가지 못한 정점을 판별하기 위한 것으로 하기 위해서이다.
        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();    // a번 정점
            int b = sc.nextInt();    // b번 정점까지
            int c = sc.nextInt();    // a번 정점에서 b번 정점으로 가는 가중치
            graph.get(a).add(new Edge(b,c));
            // ArrayList이므로 get으로 접근해야한다. a번 정점 객체로 접근해서 a번 정점에서 b번 정점까지의 가중치를 ArrayList인 arr에 add해준다.
        }
        m.solution(1);  // 1번 정점에서 출발
        for(int i = 2; i <= n; i++) {  // 2번 정점부터 탐색해야하므로 int i는 2부터 시작하고 index 번호를 정점의 번호로 보기 때문에 i를 n까지 되도록 수행한다.
            if(dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            }
            else System.out.println(i+ " : impossible");
            // if(dis[i] != Integer.MAX_VALUE라는 것은 dis 배열은 처음 값을 초기화 할 때 Integer.MAX_VALUE로 초기화를 한다.
            // 만약 1번 정점부터 간선의 가중치를 찾기 위해 탐색을 하였지만 만약 1번 정점부터 갈 수 없는 정점이 있다면 그 값은 MAX_VALUE로 계속 저장되어있을 것이다.
            // 즉 이미 Integer.MAX_VALUE로 초기화가 되어있기 때문에 if문이 false라면 1번 정점부터 갈 수 없는 정점이라는 소리이므로 출력문이 impossible이 된다.
        }
    }
}
