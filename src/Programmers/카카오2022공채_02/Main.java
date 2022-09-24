package Programmers.카카오2022공채_02;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1, 1, new int[]{1}, new int[]{0}));
        
    }
    
}

class Solution {
    static int deliverIndex=0, pickupIndex=0;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        for(int i=0; i<n; i++) {
            if(deliveries[i] > 0) {
                deliverIndex = i+1;
            }
            if(pickups[i] > 0) {
                pickupIndex = i+1;
            }
        }

        while(deliverIndex != 0 || pickupIndex != 0) {
            int dcap = cap, pcap = cap;

            answer += (Math.max(deliverIndex, pickupIndex))*2;

            while(dcap > 0 && deliverIndex > 0) {
                if(deliveries[deliverIndex-1] > 0) {
                    if(deliveries[deliverIndex-1] <= dcap) {
                        dcap -= deliveries[deliverIndex-1];
                        deliveries[deliverIndex-1] = 0;
                        if(deliverIndex == 1) {
                            deliverIndex = 0;
                            break;
                        }
                        deliverIndex--;
                    }else {
                        deliveries[deliverIndex-1] -= dcap;
                        dcap = 0;
                    }
                }else {
                    if(deliverIndex == 1) {
                        deliverIndex = 0;
                        break;
                    }
                    deliverIndex--;
                }
            }
            if(deliverIndex > 0) {
                while(deliveries[deliverIndex-1] == 0) {
                    if(deliverIndex == 1) {
                        deliverIndex = 0;
                        break;
                    }
                    deliverIndex--;
                }
            }
           

            while(pcap > 0 && pickupIndex > 0) {
                if(pickups[pickupIndex-1] > 0) {
                    if(pickups[pickupIndex-1] <= pcap) {
                        pcap -= pickups[pickupIndex-1];
                        pickups[pickupIndex-1] = 0;
                        if(pickupIndex == 1) {
                            pickupIndex = 0;
                            break;
                        }
                        pickupIndex--;
                    }else {
                        pickups[pickupIndex-1] -= pcap;
                        pcap = 0;
                    }
                }else {
                    if(pickupIndex == 1) {
                        pickupIndex = 0;
                        break;
                    }
                    pickupIndex--;
                }
            }
            if(pickupIndex > 0) {
                while(pickups[pickupIndex-1] == 0) {
                    if(pickupIndex == 1) {
                        pickupIndex = 0;
                        break;
                    }
                    pickupIndex--;
                }
            }
        }

        return answer;
    }
}