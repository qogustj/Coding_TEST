//package start;
//
//import java.io.*;
//import java.util.*;
//class Main {
//    static int n;
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        List<Integer> arr = new ArrayList<>();
//
//        for(int i=0;i<n;i++){
//            arr.add(Integer.parseInt(st.nextToken()));
//        }
//        int cnt =1;
//        while(!arr.isEmpty()){
//            if(arr.contains(-arr.get(cnt))){
//                arr.remove(arr.get(cnt));
//            }
//        }
//
//        int left = 0;
//        int right = n-1;
//        while(left<=right){
//            int mid = (right-left)/2;
//            if(Math.abs(arr[left])==Math.abs(arr[right])){
//                left++;
//                right--;
//
//            }else if(Math.abs(arr[left])>Math.abs(arr[right])){
//
//            }
//        }
//    }
//}
