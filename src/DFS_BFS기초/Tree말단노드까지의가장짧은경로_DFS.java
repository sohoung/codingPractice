package DFS_BFS기초;

// 설명 : 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세여.
//       각 경로의 길이는 루트노드에서 말단 노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 갯수로 하겠습니다.
// 말단 노드 : 자식 노드가 없는 노드


public class Tree말단노드까지의가장짧은경로_DFS {
    Node root;
    public int DFS(int L, Node root) {
        if(root.lt == null && root.rt == null) {  // 루트가 말단 노드인지 확인하는 if문
            return L;
        }
        else {  // 말단 노드가 아닌 경우
            return Math.min(DFS(L+1,root.lt), DFS(L+1, root.rt));
        }
    }
    public static void main(String[] args) {
        Tree말단노드까지의가장짧은경로_DFS  m = new Tree말단노드까지의가장짧은경로_DFS();
        m.root = new Node(1);
        m.root.lt = new Node(2);
        m.root.rt = new Node(3);
        m.root.lt.lt = new Node(4);
        m.root.lt.rt = new Node(5);
        System.out.println(m.DFS(0,m.root));
    }
}
