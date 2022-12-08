package DFS_BFS활용;
import java.util.ArrayList;
import java.util.Scanner;

// 설명 : N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
//       각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
//       행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
//       도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
//       피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
//       집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
//       예를 들어, 도시의 지도가 아래와 같다면
//       0 1 0 0
//       0 0 2 1
//       0 0 1 0
//       1 2 0 2
//       (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
//       최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
//       도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
//       시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
//       도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
// 입력 예시 : 4 4
//           0 1 2 0
//           1 0 2 1
//           0 2 1 2
//           2 0 1 2
// 출력 예시 : 6
public class 피자배달거리 {
    static int n,k,len,answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz,hs;
    public void DFS(int L, int s) {
        if(L == k) {  // 조합이 완성 되었을 때
            int sum = 0;  // 도시의 피자배달거리
            for(Point h : hs) {  // 입력된 집에 좌표 대응
                int dis = Integer.MAX_VALUE;  // 최솟 값을 구해야 하므로 Intger.MAX_VALUE사용
                for(int i : combi) {  // 조합의 index 번호가 i에 하나하나 대응
                    dis = Math.min(dis,Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                    // 집의 x좌표와 피자집의 x좌표를 빼주고 절댓값을 해주어서 집이 하나 결정되면 살아남은 피자집을 모두 비교해서 거리들 중에서 제일 최소 거리를 구한다.
                    // 즉 대응된 하나의 집에 대한 피자 배달 거리를 구한다.
                }
                sum += dis;  // 도시의 피자 배달 거리
            }
            answer = Math.min(answer, sum);  // 최솟 값을 구해야 하므로 Math.min함수로 answer와 sum 중 더 작은 값으로 answer에 갱신
        }
        else {
            for(int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        피자배달거리  m = new 피자배달거리();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();  // 살려야하는 피자집 갯수
        pz = new ArrayList<>();  // 피자집에 대한 ArrayList 객체 생성
        hs = new ArrayList<>();  // 집에 대한 ArrayList 객체 생성
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if(tmp == 1) {  // 집 일때
                    hs.add(new Point(i,j));
                }
                if(tmp == 2) {  // 피자 집 일때
                    pz.add(new Point(i,j));
                }
            }
        }
        len = pz.size();  // 도시에 있는 피자집에 갯수
        combi = new int[k];  // len Combi k 를구한다
        m.DFS(0,0);
        System.out.println(answer);
    }
}
