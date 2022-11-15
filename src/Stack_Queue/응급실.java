package Stack_Queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 설명 : 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
//       응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
//       이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.
//       • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
//       • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
//       즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
//       현재 N명의 환자가 대기목록에 있습니다.
//       N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
//       대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.
// 입력 예시 : 5 2
//          60 50 70 80 90
// 출력 예시 : 3
// 입력 예시 : 6 3
//          70 60 90 60 60 60
// 출력 예시 : 4

class Person {  // 환자의 순서와 우선순위에 대한 class Person
    int id;  // 순서
    int priority;  // 우선순위
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}
public class 응급실 {
    public int solution(int n, int[] arr, int k) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i = 0; i < n; i++) {  // Person객체를 이용하여 Q에 환자의 순서와 우선순위를 차례대로 삽입
            Q.offer(new Person(i,arr[i]));
        }
        while(!Q.isEmpty()) {
            Person tmp = Q.poll();  // Q의 데이터를 poll로 가져와 Person형 객체 tmp에 값을 넣어준다.
            for(Person x : Q) {  // 현재의 환자와 대기목록의 환자의 우선순위를 비교하기 위해서 향상된 for문을 사용한다.
                if(x.priority > tmp.priority) {  // 현재의 환자 우선순위보다 대기목록의 환자중에서 우선순위가 높은 환자가 있다면 현재의 환자를 다시 뒤로 넘기고 tmp값을 null로 바꿔주고 break해준다.
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {  // tmp가 null이 아니란 말은 어떤 환자가 진료를 받을 수 있다는 소리이다. 진료를 받는 환자가 있을 때마다 count를 해줘야하므로 answer을 먼저 1증가시키고
                answer++;
                if(tmp.id == k) { // 만약 입력받은 k번째의 순서와 tmp.id 즉 현재 진료를 받을 수 있는 환자의 순서가 같다면 이것이 구하려고 하는 답이므로 answer에 값을 넣어준다.
                    return answer;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        응급실  m = new 응급실();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(n,arr,k));
    }
}
