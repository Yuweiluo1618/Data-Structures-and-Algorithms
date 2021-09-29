package DataStructure.Recursion;

public class DS_Maze_Puzzle {
    public static void main(String[] args) {
        //创建迷宫
        int[][] map = new int[8][7];
        //设置障碍
        for(int i = 0;i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        findWayOut(map,1,1);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static boolean findWayOut(int[][] map, int i, int j){
        if(map[6][5] == 2){
            return true;
        }
        if(map[i][j] == 0){
            map[i][j] = 2;
            if(findWayOut(map, i+1,j)){
                return true;
            }else if(findWayOut(map,i,j+1)){
                return true;
            }else if(findWayOut(map,i-1,j)){
                return true;
            }else if(findWayOut(map,i,j-1)){
                return true;
            }else {
                map[i][j] = 3;
                return false;
            }
        }else{
            //map[i][j] == 1,2,3
            return false;
        }
    }
}
