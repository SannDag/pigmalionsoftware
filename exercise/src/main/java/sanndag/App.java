package sanndag;

/*
Dada la siguiente problemática: ¿puede un número X formarse
usando la suma de 2 elementos de un array?
Ejemplo 1
Input: nums = [1,4,3,9], requiredSum = 8
Output: False
Ejemplo 2
Input: nums = [1,2,4,4], requiredSum = 8
Output: True

Desarrolle (en pseudo código o su lenguaje de preferencia):
1. Un algoritmo que resuelva el problema asumiendo que la máquina en donde va a correrse el
programa tiene recursos infinitos, que el tiempo de ejecución no importa y que lo más
importante es realizar el desarrollo en el menor tiempo posible.
2. Un algoritmo que resuelva el problema asumiendo que los recursos son un bien preciado,
que el tiempo de ejecución si importa y que el tiempo de desarrollo no es importante.

Ante cualquier duda o ambigüedad en el enunciado, es libre de hacer todas las suposiciones
necesarias, siempre y cuando las especifique.
*/

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        long start, end;
        double time;

        int targetN, numArr, length;

        System.out.println("Enter the target number: ");
        targetN = sc.nextInt();

        System.out.println("Enter the length to create the array");
        length = sc.nextInt();

        int [] nums = new int[length];

        System.out.println("Enter the numbers to be inserted in the array: ");
        for(int i = 0; i < length; i++){
            System.out.println("Entered number at position:" + "[" + i + "]");
            numArr = sc.nextInt();
            nums[i] = numArr;
        }

        System.out.println("Array elements:");
        for(int i : nums){
            System.out.print(i +" ");
        }

        System.out.println("\n------------EXAMPLE 1------------");
        start = System.nanoTime();
        System.out.println("Start: " + start);

        System.out.println(algorithmSlow(nums, targetN));

        end = System.nanoTime();
        System.out.println("End: " + end);

        time = end - start;
        System.out.println("Total time:" + time + "\n---------------------------------------");

        System.out.println("------------EXAMPLE 2------------");
        start = System.nanoTime();
        System.out.println("Start: " + start);

        System.out.println(algorithmFast(nums, targetN));

        end = System.nanoTime();
        System.out.println("End: " + end);
        time = end - start;
        System.out.println("Total time:" + time);

    }

    /*
    1. Un algoritmo que resuelva el problema asumiendo que la máquina en donde va a correrse el
    programa tiene recursos infinitos, que el tiempo de ejecución no importa y que lo más
    importante es realizar el desarrollo en el menor tiempo posible.
    */
    static boolean algorithmSlow(int[] nums, int target){

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    2. Un algoritmo que resuelva el problema asumiendo que los recursos son un bien preciado,
    que el tiempo de ejecución si importa y que el tiempo de desarrollo no es importante.
    */
    static boolean algorithmFast(int[] nums, int target) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            int n = target - num;

            if (numbers.contains(n)) {
                return true;
            }

            numbers.add(num);
        }

        return false;
    }
}
