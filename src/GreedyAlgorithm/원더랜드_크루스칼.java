package GreedyAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
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
// 크루스칼 알고리즘 : 최소 비용 신장 트리를 찾는 알고리즘으로 변의 갯수를 E, 꼭짓점의 갯수를 V라고 하면 크루스칼 알고리즘의 시간복잡도는 O(E log V)의 시간복잡도를 가진다.
// Union & Find : 상호 배타적으로 이루어진 집합을 효율적으로 표현하기 위해 만들어진 자료구조이다. 이 자료구조가 서로 다른 두 개의 집합을 병합하는 Union 연산과
//                집합의 원소가 어떠한 집합에 속해있는지 찾는 Find 연산을 지원하기 때문에 Unio & Find 라는 이름이 붙어지게 되었다.
// Find 연산 : Find 연산이 수행되면 재귀적으로 트리를 거슬러 올라가 최상위 노드의 값을 반환한다.
// 트리 형태로 구현된 Disjoint Set에서 최상위 노드는 각 집합과 1대 1 대응되므로, Find 연산을 통해 각 집합을 알 수 있게 된다. 이 과정에서 상수 시간에 가까운 정도의 시간이 걸린다고 알려져 있다.
// Union 연산 : Union 연산이 수행되면, 먼저 Find 연산을 수행한 후 두 개의 최상위 노드의 부모를 다른 하나의 최상위 노드로 바꾸어 트리를 병합시킨다.
// 이 과정에서 시간에 영향을 미치는 것은 Find 연산 뿐이므로, 시간복잡도는 Find 연산과 동일하다는 것을 알 수 있다.
// 트리의 정점의 갯수가 n개라면 간선의 갯수는 n-1개이다.

class edge implements Comparable<edge> {
    public int v1;    // 정점 1
    public int v2;    // 정점 2
    public int cost;  // 정점간의 가중치

    edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(edge o) {
        return this.cost - o.cost;  // 간선이 작은 것부터 오름차순으로 정렬
        }
    }
public class 원더랜드_크루스칼 {
    static int[] unf;
    public static int Find(int v) {  // Find 함수  * 암기 *
        if (v == unf[v]) {
            return v;
        }
        else {
            return unf[v] = Find(unf[v]);
        }
    }

    public static void Union(int a, int b) {  // Union 함수  * 암기 *
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

        public static void main (String[]args){
            원더랜드_크루스칼 m = new 원더랜드_크루스칼();
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();  // 정점의 갯수
            int k = sc.nextInt();  // 간선의 갯수
            unf = new int[n + 1];
            ArrayList<edge> arr = new ArrayList<>();  // edge 객체를 저장하는 ArrayList
            for (int i = 1; i <= n; i++) {
                unf[i] = i;
            }
            for(int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                arr.add(new edge(a,b,c));
            }
            int answer = 0;
            Collections.sort(arr);  // Override로 재정의된 기준으로 arr을 정렬시켜준다.
            for(edge o : arr) {
                int fv1 = Find(o.v1);
                int fv2 = Find(o.v2);
                if(fv1 != fv2) {
                    // fv1과 fv2가 같지 않다는 말은 같은집합 즉 회로가 아니고 트리로 판별되므로 answer에 o.cost를 누적합해준다.
                    // o.cost는 간선의 가중치 중에서 최소합을 구해야하므로 가중치가 작은것부터 차례대로 회로인지 아닌지를 판별하여 회로가 아니라고 하면 가중치 값을 누적합해준다.
                    answer += o.cost;
                    Union(o.v1, o.v2);
                    // Union 함수로 v1과 v2를 합해준다.
                    // 만약 간선의 갯수가 엄청 많이 들어온다고 하면 int cnt를 선언해주고 if(fv1 != fv2)가 true 일 때마다 cnt를 1씩 증가시켜주어서
                    // 트리이기 때문에 간선의 갯수는 n-1개이므로 if(cnt == n-1)의 조건문을 걸어주어서 if문이 true가 된다면 break 시켜준다.
                }
            }
            System.out.println(answer);
        }
    }