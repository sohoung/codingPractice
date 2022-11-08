package String;
import java.util.ArrayList;
import java.util.Scanner;

// 설명 : 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
// 입력 예시 : teachermode e
// 출력 예시 : 1 0 1 2 1 0 1 2 2 1 0
public class 가장짧은문자거리 {
    public int[] solution(String str, char c) {
        int[] answer = new int[str.length()];  // 문자열 길이만큼 배열 크기를 동적 할당
        int p = 1000;
        for(int i = 0; i < str.length(); i++) {  // 입력받은 str을 기준으로 자신의 왼쪽에 있는 c를 찾는 for문
            if(str.charAt(i) == c) {  // 만약 입력받은 str의 문자열 중에 for문을 수행하는도중 입력받은 c를 만나면 수행되는 if문
                p = 0;                // 자기 자신의 c이므로 p의 값을 0으로 초기화 후 answer 배열에 p의 값을 넣어준다.
                answer[i] = p;
            }
            else {     // 만약 입력받은 str과 c가 만나지 못하였을 경우에 p값을 1증가시키고 answer배열에 p값을 넣어준다.
                p++;
                answer[i] = p;
            }
        }
        p = 1000;   // 이제 입력받은 str에 있는 문자를 기준으로 자신의 오른쪽에 있는 c를 찾는 경우의 for문을 수행하기 위해서 먼저 p를 1000으로 초기화를 시켜준다.
        for(int i = str.length() - 1; i >= 0; i--) {  // 오른쪽 문자 즉 맨 끝의 문자부터 오는 for문이므로 초기값을 맨 끝 인덱스의 값으로 정해주고 0번 인덱스의 값이
            if(str.charAt(i) == c) {                  // 올 때까지 수행하게 설정해준다.
                 p = 0;  // p = 0인 이유는 위의 왼쪽에서 오는 문자를 검색하는 for문에 이미 자신의 인덱스 값이 0이므로 바로 p의 값을 0만 넣어주고 값을 비교하지 않고 끝내준다.
            }
            else {
                p++;
                answer[i] = Math.min(answer[i], p);  // 오른쪽오는 for문에 c와 str의 문자열 중 문자를 만난 경우에는 먼저 배열에 있는 값을 비교하고 더 작은값을
            }                                        // answer 배열에 넣어줘야하므로 Math함수를 사용하여 answer[i]와 p를 비교하여 더 작은 값을 answer[i]의 값에
        }                                            // 넣어준다.
        return answer;
    }
    public static void main(String[] args) {
        가장짧은문자거리 m = new 가장짧은문자거리();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();        // 문자열을 입력받는 경우
        char c = sc.next().charAt(0);  // 문자 1개를 입력받는 경우
        for(int x : m.solution(str,c)) {  // solution이 배열 형태의 return값이므로 향상된 for문으로 값을 출력
            System.out.print(x + " ");
        }
    }
}
