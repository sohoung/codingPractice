//package DFS_BFS기초;
//
//// 설명 : 이진트리를 전위와 후위로 출력하세요.
//
//class node {
//    int data;  // 데이터 값
//    node lt,rt;  // 왼쪽 자식의 노드 주소와 오른쪽 자식의 노드 주소를 저장하는 변수
//    public node(int val) {
//        data = val;
//        lt=rt=null;  // 객체가 생성되는 순간에는 lt와 rt는 null 값이다.
//    }
//}
//public class 이진트리순회 {
//    node root;
//    public void DFS(node root) {
//        if(root==null) return;
//        else {
//            // System.out.print(root.data + " ");   전위
//            DFS(root.lt);
//            // System.out.print(root.data + " ");   중위
//            DFS(root.rt);
//            // System.out.print(root.data + " ");   후위
//        }
//    }
//    public static void main(String[] args) {
//        이진트리순회  m = new 이진트리순회();
//        m.root = new node(1);
//        m.root.lt = new node(2);
//        m.root.rt = new node(3);
//        m.root.lt.lt = new node(4);
//        m.root.lt.rt = new node(5);
//        m.root.rt.lt = new node(6);
//        m.root.rt.rt = new node(7);
//        m.DFS(m.root);
//    }
//}
