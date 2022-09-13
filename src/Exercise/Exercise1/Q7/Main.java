package Exercise.Exercise1.Q7;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args){
        for(int i = 1; i <= 20; i++){
            System.out.println("for; "+fiboFor(i)+" while; "+fiboWhile(i)+" recursive; "+fiboRecursive(i));
        }
    }

    public static int fiboWhile(int index){
        ArrayList<Integer> fibo = new ArrayList<>();
        int i = 2;
        fibo.add(0);
        fibo.add(1);
        if(index == 1 || index == 2){
            return fibo.get(index - 1);
        }

        while(i < index){
            fibo.add(fibo.get(i-1) + fibo.get(i-2));
            i++;
        }
        return fibo.get(i-1);
    }

    public static int fiboFor(int index){
        ArrayList<Integer> fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);

        if(index == 1 || index == 2){
            return fibo.get(index - 1);
        }

        for(int i = 2; i < index; i++ ){
            fibo.add(fibo.get(i-1) + fibo.get(i-2));
        }
        return fibo.get(fibo.size()-1);
    }

    public static Integer fiboRecursive(Integer index){
        ArrayList<Integer> fibo = new ArrayList<>();
        Integer i1;
        fibo.add(0);
        fibo.add(1);
        if(index-1 == 0 || index-1 == 1){
            return fibo.get(index-1);
        }else{
            i1 = fiboRecursive(index-1) + fiboRecursive(index-2) ;
            fibo.add(i1);
            return i1;
        }
    }
}
