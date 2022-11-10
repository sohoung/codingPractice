package TwoPointer_SlidingWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 설명 : A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
// 입력 예시 : 5
//          1 3 9 5 2
//          5
//          3 2 5 7 8
// 출력 예시 : 2 3 5
public class 공통원소구하기 {
    public ArrayList<Integer> solution(int[]a, int n, int[] b, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);  // 먼저 문제를 풀기위해서는 각각의 배열을 sort로 정렬해준다. 문제의 출력값도 오름차순 정렬로 출력이기때문에 정렬을 먼저 해준다.
        Arrays.sort(b);
        int p1 = 0, p2 = 0;  // 각각의 배열의 시작 index를 지정해준다.
        while(p1 < n && p2 < k) {  // while의 조건문으로 p1과 p2중 한 곳이라도 먼저 탐색이 끝나면 바로 while문을 나가도록 해준다.
            if(a[p1] == b[p2]) {  // a배열과 b배열의 값이 같다면 answer에 값을 넣어주고 각각의 index 값을 1증가시켜준다.
                answer.add(a[p1++]);
                p2++;
            }
            else if(a[p1] < b[p2]) {
                // a배열의 값이 b배열의 값보다 작다면 작은 값에 있는 index 값을 1증가시켜준다. 큰 값을 올리면 탐색에서 같은 숫자를 못 찾을 수 있기 때문이다.
                p1++;
            }
            else {// 마찬가지로 b배열의 값이 a배열의 값보다 작다면 index의 값을 1증가시켜준다.
                p2++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        공통원소구하기 m = new 공통원소구하기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] b = new int[k];
        for(int i = 0; i < k; i++) {
            b[i] = sc.nextInt();
        }
        for(int x : m.solution(a,n,b,k)) {
            System.out.print(x + " ");
        }
    }
}
