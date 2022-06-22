import java.util.*;
class Solution {
    public static boolean tableVisit[][];
    static ArrayList<ArrayList<int[]>> list;
    static int n;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int result = 0;
    public static void findBlock(int x, int y, int table[][]){
        ArrayList<int[]> cList = new ArrayList<>();
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        tableVisit[x][y] = true;
        // cList.add(new int[]{x,y});
        xList.add(x);
        yList.add(y);
        q.add(new int[]{x,y});
        int minX = x;
        int minY = y;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n || tableVisit[nx][ny] || table[nx][ny] == 0) continue;
                q.add(new int[]{nx,ny});
                // cList.add(new int[]{nx,ny});
                xList.add(nx);
                yList.add(ny);
                tableVisit[nx][ny] = true;
                minX = Math.min(minX,nx);
                minY = Math.min(minY,ny);
            }
        }
        for(int i=0; i<xList.size(); i++){
            int nx = xList.get(i);
            int ny = yList.get(i);
            if(nx !=0) nx -= minX;
            if(ny !=0) ny -= minY;
            cList.add(new int[]{nx,ny});
        }
        list.add(cList);
    }
    public static void canSet(ArrayList<int[]> block, int [][] map){
        for0:
        for(int m=0; m<4; m++){
            // System.out.println("m: "+m);
        for1:
        for(int i=0; i<n; i++){
            for2:
            for(int j=0; j<n; j++){
                int minX = 0;
                int minY = 0;
                ArrayList<Integer> xList = new ArrayList<>();
                ArrayList<Integer> yList = new ArrayList<>();
                Queue<int[]> q = new LinkedList<>();
                for(int arr[] : block){
                    // System.out.println((arr[1]+j)+" "+(arr[0]+i));
                    if(arr[1]+j > n)break for2;
                    if(arr[0]+i > n)break for1;
                    if(m==0){
                        // System.out.println((arr[0]+i)+" "+(arr[1]+j));
                    q.add(new int[]{arr[0]+i,arr[1]+j});
                    }
                    if(m > 0){
                        int xy[] = rotate(arr[0]+i,arr[1]+j,m);
                        int x1 = xy[0];
                        int y1 = xy[1];
                        if(x1<0) minX = Math.min(x1,minX);
                        if(y1<0) minY = Math.min(y1,minY);
                        // System.out.println(m+"mmm "+(x1)+" "+(y1));
                        q.add(new int[]{x1,y1});
                    }
                }
                // System.out.println("zzzzzzzzzz"+minX+" "+minY);
                if(minX<0)minX-= j;
                if(minY<0)minY-=i;
                // System.out.println(q.size()+"size11111");
                while(!q.isEmpty()){
                    int cur[] = q.poll();
                    // System.out.println("ffdsa"+minX+"asdasdzx"+minY);
                    int x = cur[0]+Math.abs(minX);
                    int y = cur[1]+Math.abs(minY);
                    // System.out.println(x+" zaaaaz "+y+" "+q.size());
                    if(x>=n ) x=n-1;
                    if(y>=n) y=n-1;
                    // int z1 = x;
                    // int z2 = y;
                    // if(m==1){
                    //     int temp = z1;
                    //     z1 = -z2;
                    //     z2 = temp;
                    //     z1 += minY;
                    //     z2 += minX;
                    //     System.out.println("thisis"+" "+z1+" "+z2);
                    // }
                    // if(m > 0){
                    //     int xy[] = rotate(x,y,m,minX,minY);
                    //     x = xy[0];
                    //     y = xy[1];
                    // }
                    // System.out.println(x+" "+y+" "+map[x][y]+"chek!!");
                    if(map[x][y] == 1) {
                        for(int a=0; a<xList.size(); a++){
                                // System.out.println("hi");
                                map[xList.get(a)][yList.get(a)] = 0;
                            }
                        continue for2;
                    }
                    else{
                        xList.add(x);
                        yList.add(y);
                        map[x][y] = 1;
                    }
                    // System.out.println("end");
                }
                for(int k=0; k<xList.size(); k++){
                    for(int d=0; d<4; d++){
                        int nx = xList.get(k)+dx[d];
                        int ny = yList.get(k)+dy[d];
                        if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                        if(map[nx][ny] == 0) {
                            for(int a=0; a<xList.size(); a++){
                                // System.out.println("hi");
                                map[xList.get(a)][yList.get(a)] = 0;
                            }
                            continue for2;
                        }
                    }
                }
                result+=xList.size();
                return;
            }
        }//for1
        }//for0
    }
    public static int[] rotate(int a, int b, int m){
        int arr[] = new int[2];
        if(m==1){
            int temp = a;
            a = -b;
            b = temp;
        }
        else if(m==2){
            int temp = -a;
            a = b;
            b = temp;
        }
        else{
            int temp = a;
            a = -b;
            b = temp;
            temp = a;
            a = -b;
            b = temp;
        }
        arr[0] = a;
        arr[1] = b;
        return arr;
    }
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        n = table.length;
        list = new ArrayList<>();
        tableVisit = new boolean[table.length][table.length];
        for(int i=0; i<table.length; i++){
            for(int j=0; j<table.length; j++){
                if(table[i][j] == 1 && !tableVisit[i][j]){
                    findBlock(i,j,table);
                }
            }
        }
        for(ArrayList<int[]> i : list){
            // System.out.println("haha");
            // for(int j[] : i){
            //     System.out.println(j[0]+" "+j[1]);
            // }
            canSet(i, game_board);
        }
        return result;
    }
}