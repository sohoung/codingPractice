package String;
import java.util.Scanner;

// 설명 : 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
//       문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
//       단 반복횟수가 1인 경우 생략합니다.
// 입력 예시 : KKHSSSSSSSE
// 출력 예시 : K2HS7E
// 입력 예시 : KSTTTSEEKFKKKDJJGG
// 출력 예시 : KST3SE2KFK3DJ2G2
public class 문자열압축 {
    public String solution(String str) {
        String answer = "";
        str = str + " ";  // 맨 끝 문자의 확인을 위한 공백을 하나 더 추가해준다.
        int cnt = 1;  // 중복된 문자의 숫자를 count해주기위한 int형 변수
        for(int i = 0; i < str.length()-1; i++) {  // 뒤의 공백이 있으므로 반복횟수를 1번 더 적게해주어서 indexOutOfBoundException를 피해준다.
            if(str.charAt(i) == str.charAt(i+1)) {  // 문제의 조건처럼 만약 index i지점과 i+1의 지점이 같다면 cnt를 1증가시켜준다.
                cnt++;
            }
            else {
                answer += str.charAt(i);  // 만약 뒤의 문자가 현재 i지점의 문자와 같지 않다면 answer에 i지점의 문자를 누적합해준다.
                if(cnt>1) {  // 조건중에 1은 생략하여도 상관없다고 하였으므로 1보다 큰 숫자로 조건을 걸어준다. 만약 cnt가 1보다 큰 수일 경우 answer에 String.valueOf로
                             // int형 cnt변수를 String화 시켜준다.
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        문자열압축  m = new 문자열압축();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
