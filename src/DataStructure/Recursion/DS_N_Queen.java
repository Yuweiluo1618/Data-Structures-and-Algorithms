package DataStructure.Recursion;

public class DS_N_Queen {
    int maxQueen = 8;
    int column = 8;
    int[] array = new int[maxQueen];
    static int countMethod;

    public static void main(String[] args) {
        DS_N_Queen queen = new DS_N_Queen();
        queen.putQueen(0);
        System.out.println(countMethod);

    }

    public void putQueen(int n){
        if( n == maxQueen){
            countMethod++;
            printQueen();
            return;
        }

        //put queen to 8 column
        for(int i = 0; i < column; i++){
            array[n] = i;
            if(judge(n)){
                putQueen(n+1);
            }
        }
    }

    public boolean judge(int n){
        for(int i = 0; i < n; i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    public void printQueen(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
