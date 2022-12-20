package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 설명 : 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
//       원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
//       아래의 그림은 그 한 예를 설명하는 그림이다.
//       위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.
// 입력 예시 : 9 12
//           1 2 12
//           1 9 25
//           2 3 10
//           2 8 17
//           2 9 8
//           3 4 18
//           3 7 55
//           4 5 44
//           5 6 60
//           5 7 38
//           7 8 35
//           8 9 15
// 출력 예시 : 196
// 최소 스패닝 트리 : 한 그래프의 스패닝 트리 중에서 가중값의 합이 제일 적은 것
// 스패닝 트리 : 그래프 안에 있는 모든 정점을 다 포함하면서 트리가 되는 연결된 부분 그래프이다.

public class 원더랜드_프림 {
    public static void main(String[] args) {
        원더랜드_프림  m = new 원더랜드_프림();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Edge>> arr = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Edge>());
        }
        int[] ch = new int[n+1];
        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.get(a).add(new Edge(b,c));  // a라는 정점에서 b라는 정점까지 가는 가중치 값을 c
            arr.get(b).add(new Edge(a,c));  // b라는 정점에서 a라는 정점까지 가는 가중치 값을 c
            // 무방향 그래프이기 때문에 a에서 b로도 갈 수 있고 b에서 a로 갈 수 있기 때문에 arr.get(b).add(new EDge(a,c))도 포함시켜야한다.
        }
        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();  // Edge 객체를 저장하는 PriorityQueue 객체 생성
        pq.offer(new Edge(1,0));  // 처음 시작 정점
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();  // 처음 pq에 들어있는 값을 tmp에 넣어준다.
            int ev = tmp.vex;  // ev는 endvertex로 도착 정점을 뜻한다.
            if(ch[ev] == 0) {
                // ch 배열의 값은 모두 0으로 초기화되어있고 ch 배열의 값이 1이면 이미 집합 관계를 형성한 정점이고 0의 값을 가지면 아직 집합 관계를 형성하지 않는 정점이라는 뜻이다.
                ch[ev] = 1;
                // 아직 집합 관계를 가지지 않은 정점을 가지고 트리를 만들어야한다. 그러므로 cost를 기준으로 재정의된 값을 가지고 pq 안에 있는 cost 값들 중에서 제일 작은 값을 가지고 오지만
                // 만약 그 정점이 이미 집합 관계를 가지고 있으면 그 값은 바로 버려준다.
                answer += tmp.cost;  // 만약 집합 관계를 가지지 않은 정점이라면 그 가중치 값은 제일 작은 값이 pq에서 poll 되어지므로 answer에 cost를 누적합해준다.
                for(Edge o : arr.get(ev)) {
                    // 이제 다시 도착 정점에서 가지를 뻗어나가야하므로 향상된 for문으로 도착 정점에서 뻗어 갈 수 있는 가지를 모두 탐색해서 pq에 넣어준다.
                    if(ch[o.vex] == 0) {
                        // ch[o.vex] == 0 이라는 뜻은 도착 정점에서 뻗어갈 수 있는 정점들 중에서 만약 이미 집합 관계가 형성된 정점이 있다면 그 정점은 이미 뻗어갈 수 없는 정점이므로
                        // 그 정점은 pass 해버린다는 의미이다.
                        pq.offer(new Edge(o.vex, o.cost));
                        // 그 다음 다시 위로 올라가 Edge tmp에서 재정의된 기준으로 cost 값이 가장 작은 값을 tmp에 넣어주고 똑같은 방식으로 pq가 모두 비워질때까지 진행해준다.
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
