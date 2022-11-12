package HashMap_TreeSet;
import java.util.HashMap;
import java.util.Scanner;

// 설명 : S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
//       아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
// 입력 예시 : bacaAacba
//           abc
// 출력 예시 : 3

public class 모든아나그램찾기 {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character,Integer> am = new HashMap<>();
        HashMap<Character,Integer> bm = new HashMap<>();
        for(char x : b.toCharArray()) {
            bm.put(x,bm.getOrDefault(x,0)+1);
        }
        int lt = 0;
        int L = b.length()-1;
        for(int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i),0)+1);
        }
        for(int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt),am.getOrDefault(a.charAt(rt),0)+1);
            if(am.equals(bm)) {
                answer++;
            }
            am.put(a.charAt(lt),am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }
            lt++;
        }

        return answer;
    }
    public static void main(String[] args) {
        모든아나그램찾기  m = new 모든아나그램찾기();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(m.solution(a,b));
    }
}
