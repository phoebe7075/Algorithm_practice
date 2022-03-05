package Beakjoon.bj10875;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static long N;
    static int T;
    static int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int d = 0;
    static ArrayList<Node> snake = new ArrayList<>();
    static Node head;
    static long ans = 0;
    static int direct[];
    static long[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        s = br.readLine().split(" ");
        T = Integer.parseInt(s[0]);
        head = new Node(N,N);
        snake.add(new Node(N, N));
        int time, direction;
        direct = new int[T+1];
        times = new long[T+2];
        times[0] = 0;
        for(int i=0; i<T; i++) {
            s = br.readLine().split(" ");
            time = Integer.parseInt(s[0]);
            if(s[1].equals("L")) {
                direction = -1;
            }else {
                direction = 1;
            }
            direct[i] = d;
            times[i+1] = times[i]+time;

            Node next = new Node(0,0);
            next.x = head.x + (dir[d][0]*time);
            next.y = head.y + (dir[d][1]*time);
            snake.add(new Node(next.x, next.y));
            d = ((d+4) + direction)%4;
            head.x = next.x; head.y = next.y;
        }
        direct[T] = d;

        if(snake.get(T).x >= 0 && snake.get(T).x <= 2*N && snake.get(T).y >= 0 && snake.get(T).y <= 2*N) {
            if(direct[T] == 0) {
                times[T+1] = times[T] + (2*N+1 - snake.get(T).y);
                snake.add(new Node(snake.get(T).x,2*N+1));
            }else if(direct[T] == 1) {
                times[T+1] = times[T] + (2*N+1 - snake.get(T).x);
                snake.add(new Node(2*N+1,snake.get(T).y));
            }else if(direct[T] == 2) {
                times[T+1] = times[T] + snake.get(T).y+1;
                snake.add(new Node(snake.get(T).x,-1));
            }else if(direct[T] == 3) {
                times[T+1] = times[T] + snake.get(T).x +1;
                snake.add(new Node(-1,snake.get(T).y));
            }
        }

        for(int i=1; i<=T+1; i++) {
            long t = collision(i,snake.get(i),snake.get(i-1));
            if(t != Integer.MAX_VALUE) {
                ans = times[i-1] + t;
                break;
            }

            if(snake.get(i).x < 0) {
                ans= times[i] - Math.abs(snake.get(i).x) +1;
                break;
            }else if(snake.get(i).x > 2*N) {
                ans= times[i] - Math.abs(snake.get(i).x - 2*N) +1;
                break;
            }else if (snake.get(i).y < 0) {
                ans= times[i] - Math.abs(snake.get(i).y) +1;
                break;
            }else if(snake.get(i).y > 2*N) {
                ans= times[i] - Math.abs(snake.get(i).y - 2*N) +1;
                break;
            }
        }

        System.out.println(ans);
    }


    static long collision(int t, Node now, Node pre) {
        int direction = direct[t-1];
        long time = Integer.MAX_VALUE;
        if(direction == 1) {
            if(pre.y == N && (now.x >= N && pre.x < N)) {
                time = N - pre.x;
            }
        }else if(direction == 3) {
            if(pre.y == N && (pre.x > N && now.x <= N)) {
                time = pre.x-N;
            }
        }
        for(int i=1; i<t; i++) {
            if(direction == 0) {
                if(pre.y < snake.get(i-1).y && snake.get(i-1).y <= now.y) {
                    if(direct[i-1] == 1) {
                        if(snake.get(i-1).x < pre.x && pre.x <=snake.get(i).x) {
                            if (Math.abs(snake.get(i-1).y - pre.y) < time) {
                                time = Math.abs(snake.get(i-1).y - pre.y);
                            }
                        }
                    }else if (direct[i-1] == 3) {
                        if(snake.get(i).x <= pre.x && pre.x <snake.get(i-1).x) {
                            if (Math.abs(snake.get(i-1).y - pre.y) < time) {
                                time = Math.abs(snake.get(i-1).y - pre.y);
                            }
                        }
                    }

                    if(pre.x == snake.get(i-1).x) {
                        if(direct[i-1] == 0) {
                            if(snake.get(i-1).y - pre.y < time) {
                                time = snake.get(i-1).y - pre.y;
                            }
                        }else if (direct[i-1] == 2) {
                            if(snake.get(i).y - pre.y < time) {
                                time = snake.get(i).y - pre.y;
                            }
                        }
                    }
                }
            }else if (direction == 2) {
                if(now.y <= snake.get(i-1).y && snake.get(i-1).y < pre.y) {
                    if(direct[i-1] == 1) {
                        if(snake.get(i-1).x < pre.x && pre.x <=snake.get(i).x) {
                            if(Math.abs(snake.get(i-1).y - pre.y) < time) {
                                time = Math.abs(snake.get(i-1).y - pre.y);
                            }
                        }
                    }else if (direct[i-1] == 3) {
                        if(snake.get(i).x <= pre.x && pre.x <snake.get(i-1).x) {
                            if(Math.abs(snake.get(i-1).y - pre.y) < time) {
                                time = Math.abs(snake.get(i-1).y - pre.y);
                            }
                        }
                    }

                    if(pre.x == snake.get(i-1).x) {
                        if(direct[i-1] == 0) {
                            if(pre.y - snake.get(i).y < time) {
                                time = pre.y - snake.get(i).y;
                            }
                        }else if (direct[i-1] == 2) {
                            if(pre.y - snake.get(i-1).y < time) {
                                time = pre.y - snake.get(i-1).y;
                            }
                        }
                    }
                }
            }else if(direction == 1) {
                if(pre.x < snake.get(i-1).x && snake.get(i-1).x <= now.x) {
                    if(direct[i-1]==0) {
                        if(snake.get(i-1).y < pre.y && pre.y <= snake.get(i).y) {
                            if(Math.abs(snake.get(i-1).x - pre.x) < time) {
                                time = Math.abs(snake.get(i-1).x - pre.x);
                            }
                        }
                    }else if(direct[i-1]==2) {
                        if(snake.get(i).y <= pre.y && pre.y < snake.get(i-1).y) {
                            if(Math.abs(snake.get(i-1).x - pre.x) < time) {
                                time = Math.abs(snake.get(i-1).x - pre.x);
                            }
                        }
                    }

                    if(pre.y == snake.get(i-1).y) {
                        if(direct[i-1] == 1) {
                            if(snake.get(i-1).x - pre.x < time) {
                                time = snake.get(i-1).x - pre.x;
                            }
                        }else if (direct[i-1] == 3) {
                            if(snake.get(i).x - pre.x < time) {
                                time = snake.get(i).x - pre.x;
                            }
                        }
                    }
                }
            }else if(direction==3) {
                if(now.x <= snake.get(i-1).x && snake.get(i-1).x < pre.x) {
                    if(direct[i-1]==0) {
                        if(snake.get(i-1).y < pre.y && pre.y <= snake.get(i).y) {
                            if(Math.abs(snake.get(i-1).x - pre.x) < time) {
                                time = Math.abs(snake.get(i-1).x - pre.x);
                            }
                        }
                    }else if(direct[i-1]==2) {
                        if(snake.get(i).y <= pre.y && pre.y < snake.get(i-1).y) {
                            if(Math.abs(snake.get(i-1).x - pre.x) < time) {
                                time = Math.abs(snake.get(i-1).x - pre.x);
                            }
                        }
                    }

                    if(pre.y == snake.get(i-1).y) {
                        if(direct[i-1] == 1) {
                            if(pre.x - snake.get(i).x < time) {
                                time = pre.x - snake.get(i).x;
                            }
                        }else if (direct[i-1] == 3) {
                            if(pre.x - snake.get(i-1).x < time) {
                                time = pre.x - snake.get(i-1).x;
                            }
                        }
                    }
                }
            }
        }

        return time;
    }
}

class Node{
    long x, y;

    public Node(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
