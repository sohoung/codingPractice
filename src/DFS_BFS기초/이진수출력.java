package DFS_BFS기초;

// 설명 : 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하시. 단 재귀함수를 이용해야한다.
// 입력 예시 : 11
// 출력 예시 : 1011
// 재귀함수는 if else 문으로 할 것
public class 이진수출력 {
    public void DFS(int n) {
        if(n==0) {
            return;
        }
        else {
            DFS(n/2);  // n/2로 n을 2로 나눈 나머지의 몫으로 계속 나눠준다.
            System.out.print(n%2);  // n을 2로 나눈 나머지를 출력
        }
    }
    public static void main(String[] args) {
        이진수출력  m = new 이진수출력();
        m.DFS(11);
    }
}
