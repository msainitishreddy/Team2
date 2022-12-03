import java.util.Scanner;

public class Math {
    /*
    #################Team - M2#################
    ###########################################
    Developer : Sai Nitish Kumar Reddy Maddela
    Uni ID : 220316811
    Function : Addition operation
    ###########################################
    ###########################################
     */
    public static int add(int x,int y){
        int result = x + y;
        return result;
    }
    /*
    #################Team - M2#################
    ###########################################
    Developer : Sai Nitish Kumar Reddy Maddela
    Uni ID : 220316811
    Function : Addition operation
    ###########################################
    ###########################################
     */
    public static int max(int x,int y){
        int maximum;
        if (x>y){
            maximum = x;
        }
        else{
            maximum = y;
        }
        return maximum;
    }

    public static void main(String[] args){
        System.out.println("Enter two numbers:");
        Scanner kin = new Scanner(System.in);
        int a = kin.nextInt();
        int b = kin.nextInt();
        System.out.println("Addition: "+a+"+"+b+" = "+add(a,b));
        System.out.println("Maximum of "+a+" , "+b+" : "+max(a, b));

    }
}
