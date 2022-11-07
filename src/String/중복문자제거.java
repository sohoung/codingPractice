package String;
// 설명 : 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
//       중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
// 입력 예시 : ksekkset
// 출력 예시 : kset


import java.util.Scanner;

public class 중복문자제거 {
    public String solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) {  // indexOf()함수는 받은 문자열에서 주어진 문자를 체크하면서 제일 처음 만난 문자의 인덱스값을 반환해준다.
                                                   // 즉 맨 처음의 문자는 자신의 인덱스 번호를 반환하지만 그 다음 중복된 문자를 뒤에서 만났을 경우 반환되는 인덱스 값을
                                                   // 처음만난 인덱스의 값으로 반환해준다.
                answer += str.charAt(i);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        중복문자제거 m = new 중복문자제거();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
