package jzOffer;

public class Solution13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited,m,n,k,0,0);
    }

    public int dfs(boolean[][] visited, int m, int n, int k, int i, int j){
        if(i >= m || j >= n || visited[i][j] || bitsum(i) + bitsum(j) > k) return 0;
        visited[i][j] = true;
        return 1 + dfs(visited,m,n,k,i+1,j) + dfs(visited,m,n,k,i,j+1);
    }

    public int bitsum(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
