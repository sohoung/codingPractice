package Array;
import java.util.ArrayList;
import java.util.Scanner;

//  설명 : 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
//        선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
// 입력 예시 : 8
//          130 135 148 140 145 150 150 153
// 출력 예시 : 5
public class 보이는학생 {
    public int solution(int[] arr, int n) {
        int answer = 1;    // 문제의 조건과 관계없이 맨 앞의 학생은 무조건 선생님이 보이므로 만저 answer에 값을 1로 선언해준다.
        int max = arr[0];  // 비교하기위하여 앞의 학생중에서 제일 키가 큰 학생을 구별하기위한 변수이다.
        for(int i = 1; i < n; i++) {  // 맨 앞의 학생은 제외이므로 시작 index를 1로 설정해준다.
            if(max < arr[i]) {  // 만약 max보다 더 큰 학생이 있다면 선생님이 보이므로 answer를 1증가시켜주고 max를 그 학생으로 갱신시켜준다.
                answer++;
                max = arr[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        보이는학생 m = new 보이는학생();
        Scanner sc = new Scanner((System.in));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(arr,n));
    }
}
