package Stack_Queue;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 설명 : 정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
//       정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.
//       정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
//       왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.
//       그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
//       그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.
//       한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.
//       그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
//       이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.
//       예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.
//       이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.
//       N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
// 입력 예시 : 8 3
// 출력 예시 : 7
// Queue자료구조 -> First In First Out(FIFO)
// Queue 함수 -> 데이터 삽입 : offer(), 데이터 반환 : poll()
// Queue 함수 -> 데이터 확인 : contains()
public class 공주구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();  // Queue의 객체 생성은 이렇게 LinkedList로 한다.
        for(int i = 1; i <= n; i++) {
            Q.offer(i);  // Queue에 1부터 n끼지의 데이터를 차례대로 삽입
        }
        while(!Q.isEmpty()) {  // while문으로 Q가 비어있지 않을때 수행하도록 조건을 걸어주고 Q가 비어있다면 while문의 수행을 멈추도록 해준다.
            for(int i = 1; i < k; i++) {  // for문으로 Q에서 k-1번째까지의 숫자를 다시 Q에 넣어주고 k번째의 데이터는 Q에서 poll()해준다.
                Q.offer(Q.poll());
            }
            Q.poll();
            if(Q.size() == 1) {  // Q가 size가 1이 되었을 때 문제의 조건에 맞는 출력문이 나오므로 if문으로 Q의 size가 1이면 answer에 남아있는 Q의 값을 poll()해준다.
                answer = Q.poll();  // poll()은 pop()와 같이 값을 다시 return해준다. 즉 answer에 poll()로 값을 넣어준 것처럼 데이터를 바로 넣어줄 수 있다는 말이다.
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        공주구하기 m = new 공주구하기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(m.solution(n,k));
    }
}
