package DFS_BFS기초;
import java.util.LinkedList;
import java.util.Queue;

// 설명 : 이진트리에서 루트 노드 1에서 말단 노드까지의 거리 중 가장 짧은 거리를 구하는 프로그램을 작성하세요.
//       각 경로의 길이는 루트 노드에서 말단 노드까지 가는데 이동한느 횟수를 즉 간선의 갯수를 구하세요.

public class Tree말단노드까지의가장짧은경로_BFS {
    Node root;
    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();  // Node를 저장하는 Queue 객체 생성
        Q.offer(root);
        int L = 0;  // 레벨
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if(cur.lt == null && cur.rt == null) {  // 현재의 노드가 말단 노드일 경우
                    return L;
                }
                if(cur.lt != null) {  // 말단 노드가 아니면 Q에 offer 해준다.
                    Q.offer(cur.lt);
                }
                if(cur.rt != null) {  // 말단 노드가 아니면 Q에 offer 해준다.
                    Q.offer(cur.rt);
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Tree말단노드까지의가장짧은경로_BFS m = new Tree말단노드까지의가장짧은경로_BFS();
        m.root = new Node(1);
        m.root.lt = new Node(2);
        m.root.rt = new Node(3);
        m.root.lt.lt = new Node(4);
        m.root.lt.rt = new Node(5);
        System.out.println(m.BFS(m.root));
    }
}
