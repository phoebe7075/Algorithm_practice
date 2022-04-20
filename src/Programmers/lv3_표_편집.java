package Programmers;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Stack;

public class lv3_표_편집 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
    }
}
class Solution {
    public String solution(int n, int k, String[] cmd) {
        int cursor = k;
        DLList list = new DLList(n);
        list.list[n-1].down = -1;
        Stack<DLList.Node> stack = new Stack<>();

        for(String command : cmd) {
            if(command.charAt(0) == 'C') {
                DLList.Node tmp = list.list[cursor];
                stack.push(tmp);
                tmp.state = 'X';

                if(tmp.up != -1 ) list.list[tmp.up].down = tmp.down;
                if(tmp.down != -1 ) list.list[tmp.down].up = tmp.up;
                cursor = tmp.down != -1 ? tmp.down : tmp.up;
            }else if (command.charAt(0) == 'U') {
                int num = Integer.parseInt(command.substring(2));
                for(int i=0; i<num; i++) {
                    cursor = list.list[cursor].up;
                }
            }else if (command.charAt(0) == 'D') {
                int num = Integer.parseInt(command.substring(2));
                for(int i=0; i<num; i++) {
                    cursor = list.list[cursor].down;
                }
            }else {
                DLList.Node tmp = stack.pop();
                list.list[tmp.x].state = 'O';

                if(tmp.up != -1 ) list.list[tmp.up].down = tmp.x;
                if(tmp.down != -1 ) list.list[tmp.down].up = tmp.x;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(DLList.Node x : list.list) {
            sb.append(x.state);
        }

        return sb.toString();
    }


}

class DLList {
    Node[] list;

    DLList(int n) {
        list = new Node[n];
        for(int i=0; i<n; i++) {
            list[i] = new Node(i, i-1, i+1);
        }
    }

    class Node {
        int x;
        int up, down;
        char state = 'O';
        Node (int x, int up, int down) {
            this.x = x;
            this.up = up;
            this.down = down;
        }
    }
}

