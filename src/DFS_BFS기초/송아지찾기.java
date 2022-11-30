package DFS_BFS기초;

// 설명 :현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
//      현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
//      송아지는 움직이지 않고 제자리에 있다.
//      현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
//      최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
// 입력 예시 : 5 14
// 출력 예시 : 3


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {
    int answer = 0;
    int[] dis = {1,-1,5};  // 이동하는 거리 배열
    int[] ch; // 먼저 방문한 곳은 다시 방문하지 않도록 해주는 체크 배열
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e) {
        ch= new int[10001];  // 좌표가 1 ~ 10000까지이기 때문에
        ch[s] = 1;  // 출발지점 체크
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();  // 레벨에 있는 원소의 갯수
            for(int i = 0; i < len; i++) {
                int x = Q.poll();
                for(int j = 0; j < 3; j++) {
                    int nx = dis[j] + x;  // 지점에 dis의 배열 값들을 하나하나씩 더한다
                    if(nx == e) {
                        return L+1;  // nx는 x의 자식 노드이기 때문에 x의 레벨 값보다 1 증가한 레벨값으로 return 해주어야 한다.
                    }
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {  // if조건문이 true인 경우 방문을 하지 않은 경우이다.
                        ch[nx] = 1;   // 현재 방문을 했으므로 ch 체크 배열에 값을 넣는다.
                        Q.offer(nx);  // Q에 값을 넣는다.
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        송아지찾기  m = new 송아지찾기();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(m.BFS(s,e));
    }
}
