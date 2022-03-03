class Solution {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static int realKey[][];
    static int realLock[][];
    static int keyLen;
    static int lockLen;
    //회전 함수
    public static void rotate(){
            for(int i=0; i<lockLen/2; i++){
            	for(int k=0; k<lockLen-i-i-1;k++) {
                    int temp = realLock[i][i];
                    int direction = 0;
                    int curX = i;
                    int curY = i;
                    //배열돌리기로 회전
                    while(direction < 4){
                        int nx = curX + dx[direction];
                        int ny = curY + dy[direction];
                        if(nx<i || ny<i || nx>=lockLen-i || ny>=lockLen-i){
                            direction++;
                            continue;
                        }
                        realLock[curX][curY] = realLock[nx][ny];
                        curX = nx;
                        curY = ny;
                    }
                    realLock[i][i+1] = temp;
            	}
        }
    }
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        realKey = key;
        realLock = lock;
        keyLen = key.length;
        lockLen = lock.length;
        //몇번 반복해야할지 지정한 size
        int size = 1;
        if( lockLen > 1){
            size += (keyLen-1)*2;
            size += lockLen - keyLen;
        }
        //4방향 회전
        Loop1:
        for(int ro=0; ro<4; ro++){
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    //넓은 임시 맵 생성
                    int temp[][] = new int[lockLen+(keyLen-1)*2][lockLen+(keyLen-1)*2];
                    boolean flag = false;
                    //임시 맵에 자물쇠 정보 저장
                    for(int w=keyLen-1; w<lockLen+keyLen-1; w++){
                        for(int h=keyLen-1; h<lockLen+keyLen-1; h++){
                            temp[w][h] += realLock[w-(keyLen-1)][h-(keyLen-1)];
                        }
                    }
                    //임시맵에 키정보 저장
                    kLoop:
                    for(int w=0;w<keyLen; w++){
                        for(int h=0; h<keyLen; h++){
                            temp[w+i][h+j] += key[w][h];
                        }
                    }
                    //자물쇠가 열렸는지 확인
                    checkLoop:
                    for(int w=keyLen-1; w<lockLen+keyLen-1; w++){
                        for(int h=keyLen-1; h<lockLen+keyLen-1; h++){
                        	if(temp[w][h] != 1) {
                        		flag = true;
                        		answer = false;
                        		break checkLoop;
                        	}
                        }
                    }
                    if(!flag) {
                    	answer = true;
                    	break Loop1;
                    }
                }
            }
            rotate();
        }
        return answer;
    }
}