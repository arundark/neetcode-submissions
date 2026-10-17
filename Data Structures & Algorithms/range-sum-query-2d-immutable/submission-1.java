class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length + 1][matrix[0].length + 1];

        for(int i=1; i<=matrix.length;i++){
            for(int j =1; j<=matrix[0].length;j++){
               int top = prefix[i-1][j];
               int left = prefix[i][j-1];
               int topLeft = prefix[i-1][j-1];
               prefix[i][j] = top+left+matrix[i-1][j-1]-topLeft;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
       int top = prefix[row1][col2+1];
       int left = prefix[row2+1][col1];
       int topLeft = prefix[row1][col1];

        return prefix[row2+1][col2+1]-top-left+topLeft;
    }
}
