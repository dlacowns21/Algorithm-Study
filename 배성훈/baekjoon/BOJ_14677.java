import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class BOJ_14677 extends FI1 {
    static int max;
    static String s;
    static int n;
    static Set<String> set=new HashSet<>();

    public static void main(String[] args)throws IOException {
        initFI();
        n=nextInt();
        s=next();
        play();
        System.out.println(max);
    }

    // 1. left
    // 2. right
    // 3. flag
    // 4. count
    private static void play(){
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{0,s.length()-1,0,0});
        set.add(0+","+(s.length()-1));

        while(!q.isEmpty()){
            int[] info=q.poll();

            int left=info[0];
            int right=info[1];
            int flag=info[2];
            int count=info[3];

            max=Math.max(max,count);

            if(left>right) return;

            if(flag==0){
                if(s.charAt(left)=='B'){
                    String key=(left+1)+","+right;
                    if (!set.contains(key)) {
                        set.add(key);
                        q.add(new int[]{left+1,right,1,count+1});
                    }
                }
                if(s.charAt(right)=='B'){
                    String key=left+","+(right-1);
                    if (!set.contains(key)) {
                        set.add(key);
                        q.add(new int[]{left,right-1,1,count+1});
                    }
                }
            }else if(flag==1){
                if(s.charAt(left)=='L'){
                    String key=(left+1)+","+right;
                    if (!set.contains(key)) {
                        set.add(key);
                        q.add(new int[]{left+1,right,2,count+1});
                    }
                }
                if(s.charAt(right)=='L'){
                    String key=left+","+(right-1);
                    if (!set.contains(key)) {
                        set.add(key);
                        q.add(new int[]{left,right-1,2,count+1});
                    }
                }
            }else if(flag==2){
                if(s.charAt(left)=='D'){
                    String key=(left+1)+","+right;
                    if(!set.contains(key)){
                        set.add(key);
                        q.add(new int[]{left+1,right,0,count+1});
                    }
                }
                if(s.charAt(right)=='D'){
                    String key=left+","+(right-1);
                    if (!set.contains(key)) {
                        set.add(key);
                        q.add(new int[]{left,right-1,0,count+1});
                    }
                }
            }

        }
    }
}