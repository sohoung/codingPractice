package DFS_BFS기초;

// 설명 : 자연수 N이 주어지면 1부터 N까지의 원소를 가지는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
// 입력 예시 : 3
// 출력 예시 : 1 2 3
//           1 2
//           1 3
//           1
//           2 3
//           2
//           3

public class 부분집합구하기 {
    static int n;  // static으로 만든 이유는 static 메서드가 접근을 해야 하기 때문에 static으로 만들었다.
    static int[] ch;  // 체크 배열로 숫자를 부분집합을 사용 할 것인가 하지 않을 것인갈에 대한 체크 배열
    public void DFS(int L) {
        if(L == n+1) {
            String tmp = "";
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1) {
                    tmp += (i+" ");
                }
            }
            if(tmp.length() > 0) {  // 공집합 일 때 출력하지 않으므로 tmp의 길이가 0보다 클 때만 출력
                System.out.println(tmp);
            }
        }
        else {
            ch[L] = 1;  // 왼쪽으로 뻗으면 부분집합으로 사용한다는 의미로 1을 넣어주고
            DFS(L+1);  // 왼쪽 자식 노드로 뻗는다.
            ch[L] = 0;  // 오른쪽으로 뻗으면 부분집합으로 사용하지 않는다는 의미이므로 0을 넣어준다.
            DFS(L+1);  // 오른쪽 자식 노드로 뻗는다.
        }
    }
    public static void main(String[] args) {
        부분집합구하기 m  = new 부분집합구하기();
        n = 3;
        ch = new int[n+1];  // 배열의 크기를 n+1로 잡은 이유는 index 번호를 원소 번호 그대로 사용하기 때문에 0은 없으므로 1더 크게 만들어서 index 번호 그대로 사용하게 한다.
        m.DFS(1);
    }
}
