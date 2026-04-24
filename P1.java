import java.util.Scanner;
public class P1{
static final int MAXSIZE=100;
static final int MINSIZE=1;
static int[] arr;
static int target;
static int size;
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
readArray(sc);
if(arr != null){
displayArray();
findOccurrences();
}
}
public static void readArray(Scanner sc){
System.out.print("Enter the size of the array: ");
size=sc.nextInt();
if(size > MAXSIZE){
System.out.println("OVERFLOW ERROR");
arr=null;
return;
}else if(size<MINSIZE){
System.out.println("UNDERFLOW ERROR");
arr=null;
return;
}
arr=new int[size];
System.out.println("Enter "+size+" elements:");
for(int i=0;i<size;i++){
arr[i]=sc.nextInt();
}
System.out.print("Enter the element to search for: ");
target=sc.nextInt();
}
public static void displayArray(){
System.out.print("Array Elements: ");
for(int i=0;i<size;i++){
System.out.print(arr[i]+" ");
}
}
public static void findOccurrences(){
int count=0;
boolean found=false;
for(int i=0;i<size;i++){
if(arr[i]==target){
System.out.println("Target found at Index: "+i);
count++;
found=true;
}
}
if(!found){
System.out.println("The element "+target+" does not exist.");
}else{
System.out.println("Total number of occurrences: "+count);
}}}
