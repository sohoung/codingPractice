package DFS_BFS기초;

// 피보나치 재귀를 재귀 함수로 할 때 메모이제이션을 사용해서 더 빠르게 구하는 코드
// 피보나치는 코딩 인터뷰에서 많이 나온다.
// 피보나치를 for문과 재귀로 작성하고 성능은 for문이 더 좋고 이유는 재귀는 함수가 하나 호출 될 때마다 스택프레임(매개변수, 지역변수, 복귀주소, 많은 호출)을 사용해서 메모리 낭비가 너무 심하기 때문이다.
// for문은 프레임없이 함수 하나의 프레임 하나만 생성되기 때문에 성능은 for문이 더 좋다.

public class 메모이제이션 {
    static int[] fibo;  // 값을 저장할 fibo 배열
    public int DFS(int n) {
        if(fibo[n] > 0) return fibo[n];
        // 이미 저장되어 있는 값을 사용하면 아래로 뻗지 않고 값을 그대로 가지고 와서 더욱 더 빠르다.
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n-2) + DFS(n-1);

        }
    }
    public static void main(String[] args) {
        메모이제이션  m = new 메모이제이션();
        int n = 100;
        fibo = new int[n+1];  // 0번 index를 사용하지 않기 때문에 배열의 크기를 n+1로 잡아준다.
        m.DFS(n);
        for(int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
