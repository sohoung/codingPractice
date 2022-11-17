package SortingandSearching;
import java.util.Scanner;

// 설명 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
//       정렬하는 방법은 삽입정렬입니다.
// 입력 예시 : 6
//          11 7 5 6 10 9
// 출력 예시 : 5 6 7 9 10 11
public class 삽입정렬 {
    public int[] solution(int[] arr , int n) {
        
        return arr;
    }
    public static void main(String[] args) {
        삽입정렬  m = new 삽입정렬();
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
