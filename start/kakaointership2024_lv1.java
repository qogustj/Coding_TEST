//package start;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import java.util.*;
//class Solution {
//    public int solution(String[] friends, String[] gifts) {
//        Map<String,Integer> map = new HashMap<>();
//        int size = friends.length+1;
//        int[][] arr = new int[size][size];
//        for(int i=0; i<friends.length; i++){
//            map.put(friends[i], i);
//        }
//
//        for(int i=0; i<gifts.length; i++){
//            String[] two = gifts[i].split(" ");
//            arr[map.get(two[0])][map.get(two[1])]++;
//        }
//
//        int max =0;
//        int[] answer = new int[size];
//        for(int i=1;i<size;i++){
//            for(int j=i;j<size; j++){
//                //i가 준게 받은거보다 많으면
//                if(arr[i][j]>arr[j][i]){
//                    answer[i]++;
//                }
//            }
//        }
//        for(int i =0; i<size; i++){
//            max = Math.max(max, answer[i]);
//        }
//        return max;
//    }
//}