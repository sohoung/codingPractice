package DFS_BFS기초;

public class 피보나치재귀2 {
    static int[] fibo; // 값을 저장할 fibo 배열
    public int DFS(int n) {
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n-2) + DFS(n-1);
            // 배열로 하여서 배열에 값을 저장하고 배열에 저장된 값을 그대로 불러오면 전에 만든 피보나치재귀보다 훨씬 더 빠르고 좋다. 즉 배열에 값을 저장하고 저장되어있는 값을 바로 return하는 형식이다.
        }
    }
    public static void main(String[] args) {
        피보나치재귀2 m = new 피보나치재귀2();
        int n = 20;
        fibo = new int[n+1];  // 0번 index를 사용하지 않기 때문에 배열의 크기를 n+1로 잡아준다.
        m.DFS(n);
        for(int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
