package 동적계획법;
import java.util.Arrays;
import java.util.Scanner;


// 설명 : 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
//       각 단위의 동전은 무한정 쓸 수 있다.
// 입력 예시 : 3
//           1 2 5
//           15
// 출력 예시 : 3
// 냅색 알고리즘 : 구하고자 하는 값을 계속 업데이트해가면서 최적의 값 구하는 문제에 사용된다. 배낭 알고리즘이라고도 하며
public class 동전교환_냅색알고리즘 {
    static int n,k;
    static int[] dy;
    public int solution(int[] coin) {
        Arrays.fill(dy,Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = coin[i]; j <= k; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]] + 1);
                // dy[j-coin[i]]라는 의미는 먼저 coin배열은 입력 받은 동전의 종류를 저장하기 위한 배열이다. 저장된 코인의 종류에 의해서 dy[j-coin[i]]에서 coin[i]에 들어있는
                // 코인의 종류를 무조건 1개를 쓴다는 가정이다. 그러므로 코인을 무조건 1개 쓰여야하므로 뒤에 +1를 해준다.
            }
        }
        return dy[k];
    }
    public static void main(String[] args) {
        동전교환_냅색알고리즘 m = new 동전교환_냅색알고리즘();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 동전의 갯수
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        k = sc.nextInt();  // 거슬러 줄 금액
        dy = new int[k+1];
        System.out.println(m.solution(arr));
    }
}
