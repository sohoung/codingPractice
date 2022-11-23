package DFS_BFS기초;

// 설명 : 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 더하여 다음 숫자가 되는 것을 말한다.
//       입력은 피보나치 수열의 총 항의 수이다.
// 입력 예시 : 10
// 출력 예시 : 1 1 2 3 5 8 13 21 34 55
// 재귀 함수는 for문보다 성능이 좋지 않다. 이유는 스택프레임으로 돌아가기 때문에 메모리낭비도 많이 일어나고 재귀함수 자체가 무겁다.
// 현재 이 코드는 별로 좋지 않은 코드이다.
public class 피보나치재귀 {
    public int DFS(int n) {
        if(n==1) return 1;
        else if(n==2) return 1;
        else {
            return DFS(n-2) + DFS(n-1);
        }
    }
    public static void main(String[] args) {
        피보나치재귀  m = new 피보나치재귀();
        int n = 10;
        for(int i = 1; i <= n; i++) {
            System.out.print(m.DFS(i) +  " ");
        }
    }
}
