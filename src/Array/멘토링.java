package Array;
import java.util.Scanner;

// 설명 : 현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
//       멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
//       선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
//       만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
//       M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
// 입력 예시 : 4 3
//          3 4 1 2
//          4 3 2 1
//          3 1 4 2
// 출력 예시 : 3
public class 멘토링 {
    public int solution(int[][] arr, int n, int y) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {  // 학생번호
            for(int j = 1; j <= n; j++) {  // 학생번호
                int cnt = 0;  // 문제의 조건에 따라 멘토 멘티가 될 수 있는 경우의 수
                for(int k = 0; k < y; k++) {  // 테스트 횟수
                    int pi = 0, pj = 0;  //
                    for(int s = 0; s < n; s++) {
                        if(arr[k][s] == i) {
                            pi = s;
                        }
                        if(arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if(pi<pj) {  // 문제의 조건에 따라 pi의 등수가 pj의 등수보다 낮으면 pj가 멘토가 되는 상황이 만들어지므로 cnt를 1증가
                        cnt++;
                    }
                }
                if(cnt==y) {     // 문제에서 모든 테스트에서 멘토가 멘티보다 성적이 좋아햐하므로 테스트 횟수와 성적이 높은 경우가 동일해야 멘토 멘티의 짝이 가능해진다.
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        멘토링 m = new 멘토링();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 등수
        int y = sc.nextInt();  // 테스트 횟수
        int[][] arr = new int[y][n];
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(m.solution(arr,n,y));
    }
}
