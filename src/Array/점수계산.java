package Array;
import java.util.Scanner;

// 설명 : OX 문제는 맞거나 틀린 두 경우의 답을 가지는 문제를 말한다.
//       여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해서 다음과 같이 점수 계산을 하기로 하였다.
//       1번 문제가 맞는 경우에는 1점으로 계산한다. 앞의 문제에 대해서는 답을 틀리다가 답이 맞는 처음 문제는 1점으로 계산한다.
//       또한, 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산한다.
//       예를 들어, 아래와 같이 10 개의 OX 문제에서 답이 맞은 문제의 경우에는 1로 표시하고, 틀린 경우에는 0으로 표시하였을 때,
//       점수 계산은 아래 표와 같이 계산되어, 총 점수는 1+1+2+3+1+2=10 점이다.
//       시험문제의 채점 결과가 주어졌을 때, 총 점수를 계산하는 프로그램을 작성하시오.
// 입력 예시 : 10
//          1 0 1 1 1 0 0 1 1 0
// 출력 예시 : 10
public class 점수계산 {
    public int solution(int n,int[] arr) {
        int answer = 0;
        int cnt = 0;    // for문을 수행하면서 1을 만나면 answer에 합해야하는 수를 저장하는 변수
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {  // for문을 수행하면서 1을 만났을 때 cnt를 1증가시키고 증가된 cnt를 answer에 누적합한다.
                cnt++;
                answer += cnt;
            }
            else {
                cnt = 0;       // 만약 수행하면서 1이아닌 다른 것을 만난다면 cnt만 0으로 초기화시켜준다.
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        점수계산 m = new 점수계산();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(n,arr));
    }
}
