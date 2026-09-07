class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> temp = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(!temp.add(board[i][j])) {
                    return false;
                }
                temp.add(board[i][j]);
            }
            temp = new HashSet<>();
        }

        temp = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[j][i] == '.') {
                    continue;
                }
                if(!temp.add(board[j][i])) {
                    return false;
                }
                temp.add(board[j][i]);
            }
            temp = new HashSet<>();
        }

        int x = 0;
        int y = 0;
        temp = new HashSet<>();
        while(x > -1 && y > -1 && x < 9 && y < 9) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(board[x + i][y + j] == '.') {
                        continue;
                    }
                    if(!temp.add(board[x + i][y + j])) {
                        return false;
                    }
                    temp.add(board[x + i][y + j]);
                }
            }
            temp = new HashSet<>();
            int[] result = cube(x, y);
            x = result[0];
            y = result[1];
        }

        return true;
    }

    public int[] cube(int x, int y) {
        y+=3;
        if(x == 9) {
            x = -1;
            y = -1;
        } else if(y == 9) {
            x += 3;
            y = 0;
        }
        return new int[]{x, y};
    }


}
