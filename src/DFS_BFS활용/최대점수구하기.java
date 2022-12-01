package DFS_BFS활용;
import java.util.Scanner;

// 설명 : 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
//       각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
//       제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
//       (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
// 입력 예시 : 5 20
//           10 5
//           25 12
//           15 8
//           6 3
//           7 4
// 출력 예시 : 41
public class 최대점수구하기 {
    static int answer = Integer.MIN_VALUE, n, k;
    public void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if(time > k) {
            return;
        }
        if(L == n) {  // 부분집합 완성
            answer = Math.max(answer,sum);  // answer에다가 Math.max(answer,sum)으로 answer와 sum의 값을 비교해서 더 큰 값으로 answer에 값 갱신
        }
        else {
            DFS(L+1,sum+ps[L],time+pt[L],ps,pt);  // 문제를 맞혔을 때 즉 부분집합에 넣을 때
            DFS(L+1,sum,time,ps,pt);                        // 문제를 틀렸을 때 즉 부분집합에 넣지 않을 때
        }
    }
    public static void main(String[] args) {
        최대점수구하기  m = new 최대점수구하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 점수
        k = sc.nextInt();  // 시간
        int[] a = new int[n]; // 점수 배열
        int[] b = new int[n]; // 시간 배열
        for(int i = 0; i < n; i++) {  // 점수 배열에 값 입력
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        m.DFS(0,0,0,a,b);
        System.out.println(answer);
    }
}
