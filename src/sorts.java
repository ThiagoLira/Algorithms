import java.util.Arrays;

/**
 * Created by Thiago Lira on 23/07/2016.
 */
public  abstract class sorts {


    public static double getInversions() {
        return inversions;
    }


    private static double inversions = 0;

    public static int[] mergeSort (int [] array) {
        //base case for recursion
        if (array.length ==1 ){
            return array;
        }

        //split array in half
        int[] a = Arrays.copyOfRange(array,0,array.length/2);
        int[] b = Arrays.copyOfRange(array,array.length/2 ,array.length);
        //recursion
        a = mergeSort(a);
        b = mergeSort(b);

        return merge(a,b);
    }

    private static int[] merge (int [] a,int [] b){
        int[] c = new int[a.length + b.length];
        int ai = 0;
        int bi = 0;
        for (int i =0 ; i<c.length;i++){

            if(a.length==ai){
                c[i] = b[bi];
                bi++;
            }
            else if(b.length==bi){
                c[i] = a[ai];
                ai++;
            }

            else if(a[ai]<b[bi]){

                c[i] = a[ai];
                ai++;
            }
            else {

                inversions= inversions + a.length-ai;
                c[i] = b[bi];
                bi++;
            }

        }




        return c;
    }


    public static void printArray(String name, int[] myList){
        System.out.print("O array "+ name + " eh composto por: ");
        for (int i = 0; i < myList.length; i++) {
            System.out.print(myList[i] + " ");
        }
        System.out.println(" ");
    }



    public static void quickSort(int [] array,int ini, int fim){

        if(ini < fim){

            int pivotPosition = partitionArray(array,ini,fim);

            quickSort(array,ini,pivotPosition-1);
            quickSort(array,pivotPosition+1,fim);

        }
    }



    private static int choosePivot(int[] array,int ini,int fim){
        //always return first element as pivot
        return ini;
    }


    public static final void swap (int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private static int partitionArray(int[] array,int min, int max){

        //choose first element as pivot
        int pivot = min;


        //put pivot in first position
        swap(array,pivot,min);



        int leftWall,iter;

        leftWall = min;

        for (iter=min+1;iter<max;iter++){

            if(array[iter]<array[pivot]){
                leftWall++;
                swap(array,leftWall,iter);
            }
        }

        //put pivot in rightful position
        swap(array,leftWall,min);


        return (leftWall);

    }

}
