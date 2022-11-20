package SortingandSearching;
import java.util.Arrays;
import java.util.Scanner;

// 설명 : 현수네 반에는 N명의 학생들이 있습니다.
//       선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
//       만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
//       N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
// 입력 예시 : 8
//          20 25 52 30 39 33 43 33
// 출력 예시 : D
public class 중복확인 {
    public String solution(int n , int[] arr) {
        String answer = "U";
        Arrays.sort(arr);  // 먼저 비교하기 쉽게 오름차순 정렬을 해준다.
        for(int i = 0; i < n-1; i++) {
            if(arr[i] == arr[i+1]) {  // 오름차순 정렬이므로 현재의 항과 다음항을 비교하여 같으면 무조건 return값이 "D"로 해주어야한다.
                return "D";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        중복확인  m = new 중복확인();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(n,arr));
    }
}
