class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int row = 0; row < 9; row++) {
            if (!isValidRow(board, row)) {
                return false;
            }
        }
        
        // Check each column
        for (int col = 0; col < 9; col++) {
            if (!isValidColumn(board, col)) {
                return false;
            }
        }
        
        // Check each 3x3 sub-box
        for (int box = 0; box < 9; box++) {
            if (!isValidBox(board, box)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int col = 0; col < 9; col++) {
            char c = board[row][col];
            if (c != '.') {
                int num = c - '1';
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int row = 0; row < 9; row++) {
            char c = board[row][col];
            if (c != '.') {
                int num = c - '1';
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        return true;
    }
    
    private boolean isValidBox(char[][] board, int box) {
        boolean[] seen = new boolean[9];
        int startRow = (box / 3) * 3;
        int startCol = (box % 3) * 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[startRow + i][startCol + j];
                if (c != '.') {
                    int num = c - '1';
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }
        return true;
    }
}