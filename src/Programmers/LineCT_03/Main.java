package Programmers.LineCT_03;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s[] = {"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"};
        String p[] = {"development","marketing","hometask"};
        String x[] = {"recruitment","education","officetask"};
        int ans[] = solution(3,p,x,s);
        System.out.println(ans);
    }
    static boolean[] teams;
    static public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        ArrayList<Integer> arr = new ArrayList<>();
        teams = new boolean[num_teams];

        for(int i=0; i<employees.length; i++) {
            String[] tmp = employees[i].split(" ");
            String[] my = new String[tmp.length-1];
            for(int j=1; j<tmp.length; j++) {
                my[j-1] = tmp[j];
            }

            boolean flag = isRemote(remote_tasks,my);

            if(!flag) {
                teams[Integer.parseInt(tmp[0])-1] = true;
            }else {
                arr.add(i+1);
            }
        }


        for(int i=0; i<num_teams; i++) {
            if(!teams[i]) {
                for(int j=0; j<employees.length; j++) {
                    if(employees[j].charAt(0)-'0' == i+1){
                        for(int k = 0; k<arr.size(); k++) {
                            if(arr.get(k) == j+1) {
                                arr.remove(k);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        int answer[] = new int[arr.size()];
        int idx = 0;
        for(int x : arr) {
            answer[idx++] = x;
        }
        Arrays.sort(answer);
        return answer;
    }


    static public boolean isRemote(String[] tasks, String[] myTask){
        for(int i=0; i<myTask.length; i++) {
            boolean flag = false;
            for(int j=0; j<tasks.length; j++) {
                if(myTask[i].equals(tasks[j])) flag = true;
            }
            if(!flag) return false;
        }
        return true;
    }
}
