package 동적계획법;
import java.util.Scanner;

// 설명 : 철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
//       철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
//       철수가 개울을 건너는 방법은 몇 가지일까요?
// 입력 예시 : 7
// 출력 예시 : 34
public class 돌다리건너기 {
    static int[] dy;
    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n+1; i++) {  // 마지막 돌다리에서 건너편 땅까지 가는 방법도 구해우어야하니까 실행 횟수를 n+1까지 실행할 수 있도록 조건을 걸어준다.
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n+1];
    }
    public static void main(String[] args) {
        돌다리건너기  m = new 돌다리건너기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+2];
        // 배열의 크기를 n+2로 잡은 이유는 문제의 조건은 돌다리를 건너는 방법이므로 마지막 돌다리에서 건너편 땅까지 가는 방법이다. 즉 마지막 돌다리에서도 건너편 땅까지 가는 방법을 구해야 하는 것이다.
        // 이 말은 solution 함수의 for문에서 for문의 실행 횟수에 대한 조건을 걸어 줄 때 마지막 돌다리에서 건너편 땅까지 가는 방법도 구해야하므로 전의 계단 오르기보다 1번 더 답을 구해야한다.
        System.out.println(m.solution(n));
    }
}
