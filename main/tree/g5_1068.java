package main.tree;

import java.io.*;
import java.util.*;

public class g5_1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());

        int root = 0;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num==-1){
                root = i;
            }else{
                list.get(num).add(i);
            }
        }

        int remove = Integer.parseInt(br.readLine());

        if(remove == root){
            System.out.print(0);
            System.exit(0);
        }
        for(List<Integer> m : list){
            if(m.contains(remove)){
                m.remove((Integer) remove);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(root);
        boolean[] visit = new boolean[n];
        int result=0;
        while (!q.isEmpty()){
            Integer current = q.poll();

            List<Integer> nums = list.get(current);

            if(!nums.isEmpty()){
                for(int k : nums){
                    if(!visit[k]){
                        visit[k] = true;
                        q.offer(k);
                    }
                }
            }else {
                result++;
            }
        }
        System.out.print(result);
    }
}
