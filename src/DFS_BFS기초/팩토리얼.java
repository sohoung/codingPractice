package DFS_BFS기초;

// 설명 : 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하시오.
// 입력 예시 : 5
// 출력 예시 : 120
public class 팩토리얼 {
    public int DFS(int n) {
        if(n==1) {
            return 1;
        }
        else {
            return n*DFS(n-1);  // n-1로 n의 값을 1씩 줄여준다. 즉 DFS(5)를 하면 5*DFS(4)를 하고 DFS(4)로 인해서 4*DFS(3)이 된다.
        }
    }
    public static void main(String[] args) {
        팩토리얼  m = new 팩토리얼();
        System.out.println(m.DFS(5));
    }
}
