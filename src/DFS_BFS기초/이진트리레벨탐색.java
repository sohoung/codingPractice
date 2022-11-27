package DFS_BFS기초;

// 설명 : 이진트리 레벨탐색을 연습하세요
// 입력 예시 :
// 츨력 예시 :
// 레벨탐색은 BFS라고 하면 Queue를 이용한 레벨탐색을 한다.

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}
public class 이진트리레벨탐색 {
    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);  // add도 사용 가능
        int L = 0;  // root Node의 레벨은 0
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for(int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if(cur.lt != null) {  // 현재 cur노드의 왼쪽 자식이 있다면 Queue에 값을 넣어준다.
                    Q.offer(cur.lt);
                }
                if(cur.rt != null) {  // 현재 cur노드의 오른쪽 자식이 있다면 Queue에 값을 넣어준다.
                    Q.offer(cur.rt);
                }
            }
            L++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        이진트리레벨탐색  m = new 이진트리레벨탐색();
        m.root = new Node(1);
        m.root.lt = new Node(2);
        m.root.rt = new Node(3);
        m.root.lt.lt = new Node(4);
        m.root.lt.rt = new Node(5);
        m.root.rt.lt = new Node(6);
        m.root.rt.rt = new Node(7);
        m.BFS(m.root);
    }
}
