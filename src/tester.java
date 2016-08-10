import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Thiago Lira on 23/07/2016.
 */


public class tester {
    public static void main (String[] args) throws FileNotFoundException {


        Scanner s = new Scanner(new File("quicksort.txt"));

        int [] tall = new int [10000];
        int i = 0;
        while(s.hasNextInt())
        {
            tall[i++] = s.nextInt();
        }

        s.close();



        sorts.quickSort(tall,0,9999);

        sorts.printArray("Coco",tall);

        //sorts.mergeSort(tall);

        //System.out.println(sorts.getInversions());


    }
}
