public class Test {
    public static void main(String[] args) {
        int[][] ar = {
                { 1, 2, 3 }, //0,2 //0,0
                { 4, 5, 6 }, //1,1  //1,1
                { 9, 8, 9 }  //2,0  //2,2
        };
            int sum1=0;
        for (int i = 0; i<ar.length;i++){
            for (int j = 0; j<ar[i].length;j++){
            if(i==j){
                sum1 = sum1+ar[i][j];
            }

            }
            System.out.println();
        }
        System.out.println(sum1);

        int sum2=0;
        for (int i = 0; i<ar.length;i++){
            for (int j = 0; j<ar.length;j++){
                if (i+j==2){
                    sum2 += ar[i][j];
                }
            }
        }
        System.out.println(sum2);

        int Diff = sum1-sum2;
       // System.out.println("For Difference :"+(-Diff));
        System.out.println("For Difference :"+Math.abs(Diff)); // to find mode
    }
}
