package 동적계획법;
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


public class 최대점수구하기_냅색알고리즘 {
    public static void main(String[] args) {
        최대점수구하기_냅색알고리즘  m = new 최대점수구하기_냅색알고리즘();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 문제의 갯수
        int k = sc.nextInt();  // 제한 시간
        int[] dy = new int[k+1];
        for(int i = 0; i < n; i++) {
            int ps = sc.nextInt();  // 문제를 풀면 얻는 점수
            int pt = sc.nextInt();  // 문제를 풀기 위한 시간
            for(int j = k; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j-pt] + ps);
                // dy[j-pt] + ps에서 ps를 더해주는 이유는 pt라는 문제 푸는 시간이라는 것이 있다. 이것은 이 문제를 무조건 푼다는 가정으로 생기는 코드이다.
                // 즉 pt에 대한 문제를 무조건 푼다는 가정이 있으므로 그 문제에 대한 점수를 받아야 한다는 것이다. 그러므로 무조건 그 문제는 푼다는 가정이라는 결론이 있으므로 그 문제에 대한 점수인 ps를
                // 더해준다.
            }
        }
        System.out.println(dy[k]);
    }
}
