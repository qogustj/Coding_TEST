package start;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao2023 {
        public int[] solution(String today, String[] terms, String[] privacies) {
            Map<String, Integer> map = new HashMap<>();
            for (String term : terms) {
                String[] t = term.split(" ");
                map.put(t[0],Integer.parseInt(t[1]));
            }

            LocalDate day = LocalDate.parse(today.replace(".","-"));
            List<Integer> answerList = new ArrayList<>();

            int cnt =0;
            for (String privacy : privacies) {
                String[] privacyStr = privacy.split(" ");
                LocalDate privacyday = LocalDate.parse(privacyStr[0].replace(".","-"));
                String term = privacyStr[1];

                LocalDate expirationDate = privacyday.plusMonths(map.get(term));

                if(day.compareTo(expirationDate)>=0){
                    answerList.add(cnt+1);
                }
                cnt++;
            }
            return answerList.stream().mapToInt(Integer::intValue).toArray();
        }
}
