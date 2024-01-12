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

public class App
{
    public static void main( String[] args )
    {

        long start, end;
        double time;

        /*
        Ejemplo 1
        Input: nums = [1,4,3,9], requiredSum = 8
        Output: False
        */
        int [] nums = {1,4,3,9};

        start = System.nanoTime();
        System.out.println("Start: " + start);

        System.out.println(algorithmSlow(nums, 8));
        //return false

        end = System.nanoTime();
        System.out.println("End: " + end);
        time = end - start;
        System.out.println("Total time:" + time + "\n---------------------------------------");

        /*
        Ejemplo 2
        Input: nums = [1,2,4,4], requiredSum = 8
        Output: True
         */

        int [] nums2 = {1,2,4,4};

        start = System.nanoTime();
        System.out.println("Start: " + start);

        System.out.println(algorithmFast(nums2, 8));
        //return true

        end = System.nanoTime();
        System.out.println("End: " + end);
        time = end - start;
        System.out.println("Total time:" + time);

    }

    //Ejemplo 1: algoritmo de desarrollo rápido pero que tarda más al ejecutarse ya que compara
    //secuencialmente cada elemento del array, se podría haber hecho mas ineficiente con 2 ciclos for
    //pero se pide que se desarrolle en el menor tiempo posible
    static boolean algorithmSlow(int[] nums, int target){

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] + nums[i+1] == target){
                return true;
            }
        }
        return false;
    }

    //Ejemplo 2: algoritmo con más lineas de codigo pero tiene mayor eficiencia al ejecutarse
    // ya que no comparamos secuencialmente, sino que buscamos el complemento del target, y si este
    //se encuentra en el array, retorna true.
    //hace poco realicé en leetcode un ejercicio parecido llamado twoSums, donde utilice un Map utilizando
    //el metodo .containsKey
    //estaba en la duda si en este ejercicio utilizar alguna collection que tenga el metodo .contains
    // pero lo terminé realizando de la siguiente manera.

    static boolean algorithmFast(int[] nums, int target){
        int n;

        for(int i = 0; i < nums.length - 1; i++){
            n = target - nums[i];

            if(nums[i] == n){
                return true;
            }
        }
        return false;
    }
}
