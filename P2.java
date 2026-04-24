import java.util.Scanner;
public class P2{
static int[] arr1;
static int[] arr2;
static int[] mergedArr;
static int n1, n2;
static final int MAX=100;
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
input1(sc);
if(arr1==null) return;
input2(sc);
if(arr2==null) return;
merge();
display();
}
public static void input1(Scanner sc){
System.out.print("Enter size of 1st array: ");
n1=sc.nextInt();
if(n1<0||n1>MAX){
System.out.println("Error: Invalid size");
return;
}
arr1=new int[MAX];
System.out.println("Enter elements:");
for(int i=0;i<n1;i++) arr1[i]=sc.nextInt();
}
public static void input2(Scanner sc){
System.out.print("Enter size of 2nd array: ");
n2=sc.nextInt();
if(n2<0||n2>MAX){
System.out.println("Error: Invalid size");
return;
}
arr2=new int[MAX];
System.out.println("Enter elements:");
for(int i=0;i<n2;i++) arr2[i]=sc.nextInt();
}
public static void merge(){
if(n1+n2>MAX){
System.out.println("Error:Overflow");
return;
}
mergedArr=new int[MAX];
for(int i=0;i<n1;i++){
mergedArr[i]=arr1[i];
}
for(int i=0;i<n2;i++){
mergedArr[n1+i]=arr2[i];
}
}
public static void display(){
System.out.print("Array 1: ");
for(int i=0;i<n1;i++){
System.out.print(arr1[i]+" ");
}
System.out.println();
System.out.print("Array 2: ");
for(int i=0;i<n2;i++){
System.out.print(arr2[i]+" ");
}
System.out.println();
if(mergedArr==null) return;
System.out.print("Merged Array: ");
for(int i=0;i<n1+n2;i++){
System.out.print(mergedArr[i]+" ");
}
System.out.println();
}
}
