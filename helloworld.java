public class helloworld{
    public static int[][] solve(int[][] A) {
        int m= A.length-1;
        int n= A[0].length-1;
        int[][] pre = new int[m][n];
        pre[m][n] = A[m][n];
        pre[0][0] = A[0][0];
        for(int i=1; i<n; i++){
            pre[0][i]=pre[0][i-1]+A[0][i];
        }
        for(int i=1; i<m; i++){
            pre[i][0]=pre[i-1][0]+A[i][0];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                pre[i][j]=pre[i][j-1]+pre[i-1][j]-pre[i-1][j-1] + A[i][j];
            }
        }
        int temp = pre[m-1][n-1] - pre[0][n-1] - pre[m-1][0] + pre[0][0];
        System.out.println(temp);
        return pre;
    }
    public static void print(int[][] ans){
        for (int[] a:
                ans) {
            for (int b:
                    a) {
                System.out.print(b+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] A = {{-42},
                {-41},
                {-37},
                {-29},
                {-23}};
        print(A);
        int[][] ans = solve(A);
        print(ans);

    }
}
