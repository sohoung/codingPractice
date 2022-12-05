package DFS_BFS활용;
import java.util.Scanner;

// 설명 : 주어진 공식을 이용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
// 입력 예시 1 : 5 3
// 출력 예시 1 : 10
// 입력 예시 2 : 33 19
// 출력 예시 2 : 818809200

public class 조합수_메모이제이션 {
    int[][] dy = new int[35][35];  // 2차원 배열의 크기를 35로 잡은 이유는 문제의 조건 중 n은 33까지 들어온다고 했으므로 여유롭게 35로 잡았다.
    public int DFS(int n, int r) {
        if(dy[n][r] > 0) {  // 만약 이미 dy배열에 저장되어있는 값이라면 재귀를 뻗지 말고 그 값을 그대로 사용하라는 if문이다. 즉 메모를 해놓은 메모이제이션 방법으로 시간복잡도를 줄인다는 이야기이다.
            return dy[n][r];
        }
        if(n == r || r == 0) {  // return 값이 1인 경우
            return 1;
        }
        else {
            return dy[n][r] = DFS(n-1, r-1) + DFS(n-1,r);
            // dy[n][r]에 DFS(n-1,r) + DFS(n-1,r)의 값을 저장한다. 이유는 메모이제이션을 사용하기 위해서 값을 메모하듯이 저장해주는것이다.
        }
    }
    public static void main(String[] args) {
        조합수_메모이제이션  m = new 조합수_메모이제이션();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(m.DFS(n,r));
    }
}
