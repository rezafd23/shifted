package tegar;

public class Tegas {
    public static void main(String[] args) {
        int[][] board = new int[4][4];

        // let's loop through array to populate board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
//                if (board[][])
                board[row][col] = col +1;
            }
        }
//        for (int a=0;a<4;a++){
//            if (board[a+1][a]==board[a][a])
//        }
//        System.out.println("Isi array "+board[1][0]);
//        System.out.println("Isi array "+board[1][1]);
//        System.out.println("Isi array "+board[1][2]);
//        System.out.println("Isi array "+board[1][3]);

        // let's loop through array to print each row and column
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[row].length; col++) {
//                board[row][col] = row * col;
//                System.out.print(board[row][col] + "\t");
//            }
//            System.out.println();
//        }
    }

}
