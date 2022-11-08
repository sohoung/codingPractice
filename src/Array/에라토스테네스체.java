package Array;
import java.util.Scanner;

// 설명 : 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
//       만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
// 입력 예시 : 20
// 출력 예시 : 8
public class 에라토스테네스체 {
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n+1];  // 현재 있는 수가 소수인지 아닌지 체크하는 배열이다. 크기를 n+1로 하는 이유는 index번호를 숫자로 생각하기 때문이다.
        for(int i = 2; i <= n; i++) {  // 초깃값이 2인 이유는 0과 1은 소수가 아니기 때문에 바로 패스해준다.
            if(ch[i] == 0) {  // 배열의 값이 0이라면 소수이므로 answer의 값을 1증가시켜준다.
                answer++;
                for(int j = i; j <= n; j = j+i) {  // j=j+i는 i의 배수를 체크해주면서 소수가 아닌 것들을 지워주면서 가기 때문이다.
                                                   // i의 배수들은 i를 약수로 가지는 수이기 때문에 소수가 될 수 없다.
                    ch[j] = 1;                     // 소수가 아닌 수를 체크하기 위해서 1을 배열에 값으로 넣어준다.
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
         에라토스테네스체 m = new 에라토스테네스체();
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        System.out.println(m.solution(n));
    }
}
