package Array;
import java.util.Scanner;

// 설명 : N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
//       같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
//       즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
// 입력 예시 : 5
//          87 89 92 100 76
// 출력 예시 : 4 3 2 1 5
public class 등수구하기 {
    public int[] solution(int[] arr, int n) {
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int cnt = 1;        // 등수를 저장하기 위한 변수
            for(int j = 0; j < n; j++) {
                if(arr[i] < arr[j]) {  // 만약 i index 점수가 j index 점수보다 낮다면 등수가 내려가야하므로 cnt를 1증가시켜준다.
                    cnt++;
                }
                answer[i] = cnt;     // 증가시킨 cnt를 answer에 넣어준다.
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        등수구하기  m = new 등수구하기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : m.solution(arr,n)) {
            System.out.print(x + " ");
        }
    }
}
