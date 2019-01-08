import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Dijkstra_Shortest_Reach_2{

  static int[][] nodes;

 public static void calculate_Deikstra(int[][]ways,int curr,int length){
int min2=0;
int min1=100001;                                                                 
min2=0;
ways[0][curr]=0;
 for(int i=1;i<length+1;i++){
     if(ways[curr][i]<100001){
         if(ways[i][0]>ways[curr][0]+ways[curr][i])
         {ways[i][0]=ways[curr][0]+ways[curr][i];}
         ways[curr][i]=100001;ways[i][curr]=100001;
             }
if((min1>ways[i][0])&(ways[0][i]!=0)){min1=ways[i][0];min2=i;}
 }
 curr=min2;
 if(min2>0){calculate_Deikstra(ways,min2,length);min2=0;min1=100001;}
}
static int[] shortestReach(int n, int[][] nod, int s) {
 
    int [] res= new int[n-1];
     Arrays.fill(res,0);
       int l=0;
       for(int i=1;i<nod[s].length;i++){
           if(i!=s){
               res[l]=nod[i][0];
             if(res[l]==100001){res[l]=-1;}  
                l++;
               }
        }       
  return res;}

   
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
          for(int i = 0; i < t; i++)
        {
           st = new StringTokenizer(br.readLine());
           int n = Integer.parseInt(st.nextToken());
           int m = Integer.parseInt(st.nextToken());
            
             nodes=new int[n+1][n+1];
             for(int[]row:nodes){
                   Arrays.fill(row,100001);
                }

            for(int j = 0; j <m; j++)
            {
                st = new StringTokenizer(br.readLine());
                int ed0 = Integer.parseInt(st.nextToken());
                int ed1 = Integer.parseInt(st.nextToken());
                int ed2 = Integer.parseInt(st.nextToken());
               if(nodes[ed0][ed1]>ed2){
                 nodes[ed0][ed1]=ed2;
                 nodes[ed1][ed0]=ed2;
            }   
            }        
            
           int  s = Integer.parseInt(br.readLine());
       
                       nodes[s][0]=0;
              calculate_Deikstra(nodes,s,n);  
              int[] result = shortestReach(n,nodes,s);
              for (int j = 0; j < result.length; j++) {
               System.out.print(result[j]+" ");

            }
System.out.println(" ");
     
        }
      }
}
