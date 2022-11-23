package DFS_BFS기초;
import java.util.Scanner;

// 설명 : 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하시요.
// 입력 예시 : 3
// 출력 예시 : 1 2 3
// 재귀함수 : 자기 자신을 호출하는 함수
public class 재귀함수 {

    public void DFS(int n) {
        if(n==0) return;
        else {
            DFS(n - 1);  // 자기 자신을 호출하는 코드
            System.out.print(n + " ");
        }
    }
    public static void main(String[] args) {
        재귀함수 m = new 재귀함수();
        m.DFS(3);
    }
}
