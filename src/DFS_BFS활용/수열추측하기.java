package DFS_BFS활용;
import java.util.Scanner;

// 설명 : 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
//       예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
//       3 1 2 4
//        4 3 6
//         7 9
//          16
//       N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
//       단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
// 입력 예시 : 4 16
// 출력 예시 : 3 1 2 4
public class 수열추측하기 {
    static int[] b,p,ch;  // 순열을 저장하는 배열과  순열을 사용하기 때문에 체크 배열도 값이 전역으로 배열을 잡아준다.
    static int n,f;
    boolean flag = false;  // 남아 있는 재귀들을 다 return 시키기 위한 boolean형 flag 변수
    int[][] dy = new int[35][35];  // 메모이제이션을 사용하기 위한 dy 2차원 배열
    public int combi(int n, int r) {  // 메모이제이션 사용
        if (dy[n][r] > 0) {  // 만약 dy[n][r]에 값이 있다면 재귀를 뻗지 말고 그 값을 그대로 가져와서 return 시켜줘라
            return dy[n][r];
        }
        if (n == r || r == 0) {  // return 값이 애초에 1일 때
            return 1;
        } else {  // 메모이제이션을 사용하기 위해서 dy[n][r]에 combi(n-1,r-1) + combi(n-1,r)의 값을 넣ㄹ어준는 단계
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }
    public void DFS(int L, int sum) {
        if(flag) return;
        // 만약 if(L == n)이 true이고 if(sum == f)가 true이면 답을 찾았지만 답을 출력하고나서도 남아있는 재귀들을 계속 호출하는 것을 방지하기위해
        // flag가 true이면 무한 루프로 남아 있는 재귀를 모두 return 시킨다.
        if(L == n) {
            if(sum == f) {  // sum이 입력받은 final변수와 같다면 답이므로 향상된 for문으로 답을 차례대로 조건에 맞게 출력해준다.
                for(int x : p) {
                    System.out.print(x + " ");
                }
                flag = true;  // 남아있는 재귀를 모두 return 시키기 위한 flag를 true로 바꿔준다.
            }
        }
        else {
            for(int i = 1; i <= n; i++) {  // 변수 i를 index번호를 보지 않고 순열에 사용하는 수 그대로 사용한다고 생각하고 for문을 수행
                if(ch[i] == 0){  // 순열에서 했던것과 같이 만약 체크 배열에 체크가 안되어있으면 체크를 해주고 값을 넣어주고 레벨증가시킨다음 백트래킹으로 체크를 풀어준다.
                    ch[i] = 1;
                    p[L] =  i;
                    DFS(L+1,sum+(b[L] * p[L]));
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        수열추측하기  m = new 수열추측하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];  // index 번호를 순열에 사용하는 수 그대로 사용하기 때문에 n+1로 배열 크기 할당
        for(int i = 0; i < n; i++) {
            b[i] = m.combi(n-1,i);
        }
        m.DFS(0,0);
    }
}
