package HashMap_TreeSet;
import java.util.HashMap;
import java.util.Scanner;

// 설명 : S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
//       아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
// 입력 예시 : bacaAacba
//           abc
// 출력 예시 : 3

public class 모든아나그램찾기 {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        
        return answer;
    }
    public static void main(String[] args) {
        모든아나그램찾기  m = new 모든아나그램찾기();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(m.solution(str1,str2));
    }
}
