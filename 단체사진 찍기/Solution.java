class Solution {
    int answer;
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public void dfs(String names, boolean visit[], String[] data){
        if(names.length() == 7){
            if(check(names,data)){
                answer++;
            }
            return;
        }
        for(int i=0; i<8; i++){
            if(!visit[i]){
                visit[i] = true;
                String name = names + friends[i];
                dfs(name, visit, data);
                visit[i] = false;
            }
        }
    }
    public boolean check(String names, String [] datas){
        for(String data : datas){
            int p1 = names.indexOf(data.charAt(0));
            int p2 = names.indexOf(data.charAt(2));
            char op = data.charAt(3);
            int index = data.charAt(4) - '0';
             if (op == '=') {
                if (!(Math.abs(p1 - p2) == index+1)) return false;
            } else if (op == '>') {
                if (!(Math.abs(p1 - p2) > index+1)) return false;
            } else if (op == '<') {
                if (!(Math.abs(p1 - p2) < index+1)) return false;
            }
        }
        return true;
    }
    public int solution(int n, String[] data) {
        boolean visit[] = new boolean[8];
        dfs("",visit,data);
        return answer;
    }
}