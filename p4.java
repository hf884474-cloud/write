import java.util.Scanner;

public class p4{
static int[] arr;
static int n;
static final int MAXSIZE=100;

public static void main(String[] args){
Scanner sc=new Scanner(System.in);
inputArray(sc);
if(arr==null) return;
System.out.println("Before Deletion:");
displayArray();
deleteAtEnd();
System.out.println("Current Array:");
displayArray();
}

public static void inputArray(Scanner sc){
System.out.print("Enter array size: ");
n=sc.nextInt();
if(n<=0){
System.out.println("Underflow Error");
return;
}else if(n>MAXSIZE){
System.out.println("Overflow Error");
return;
}
arr=new int[MAXSIZE];
System.out.println("Enter "+n+" elements:");
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
}
}

public static void deleteAtEnd(){
if(n==0){
System.out.println("Underflow Error");
return;
}
n=n-1;
}

public static void displayArray(){
if(n==0){
System.out.println("Current Array is empty");
return;
}
for(int i=0;i<n;i++){
System.out.print(arr[i]+" ");
}
System.out.println();
}
}
