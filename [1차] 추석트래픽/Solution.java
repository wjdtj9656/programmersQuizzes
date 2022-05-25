import java.util.*;
class Date implements Comparable<Date>{
    int hour;
    int min;
    int sec;
    int time;
    public Date(int hour, int min, int sec,int time){
        this. hour = hour;
        this. min = min;
        this. sec = sec;
        this. time = time;
    }
    public int compareTo(Date o1){
        if(this.min == o1.min && this.hour == o1.hour){
            return this.sec - o1.sec;
        }
        if(this.hour == o1.hour){
            return this.min - o1.min;
        }
        return this.hour - o1.hour;
    }
}
class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        ArrayList<Date> list = new ArrayList<>();
        for(int i=0; i<lines.length; i++){
            StringTokenizer st = new StringTokenizer(lines[i],": ");
            st.nextToken();
            int hour = Integer.parseInt(st.nextToken())*60*60*1000;
            int min = Integer.parseInt(st.nextToken())*60*1000;
            double sec = Double.parseDouble(st.nextToken())*1000;
            int realSec = (int)sec;
            
            String s = st.nextToken();
            s = s.substring(0,s.length()-1);
            double time = Double.parseDouble(s)*1000;
            
            int realTime = (int)time;
            list.add(new Date(hour, min, realSec, realTime));
        }
        int result = 0;
        //리스트를 순서대로 돌면서 차이 체크!
        for(int i=0; i<list.size(); i++){
            Date now = list.get(i);
            int max = 1;
            int nowTime = now.hour + now.min + now.sec+1000-1;
            for(int j=i+1; j<list.size(); j++){
                Date now2 = list.get(j);
                int temp=0;
                int nextTime = now2.hour + now2.min + now2.sec - now2.time+1;
                temp = nowTime - nextTime; 
                //겹친다는 뜻
                if(temp >= 0){
                    max++;
                }
            }
            result = Math.max(result,max);
        }
        return result;
    }
}