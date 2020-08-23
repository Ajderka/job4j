public class Test2 {
    static int B;
    static int H;
    static boolean flag;

    private boolean flag () {
        boolean result = false;
        if (B >= -100 && B <= 100 && H>= -100 && H <= 100) {
            result = true;
        }
        return result;
    }


    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class

