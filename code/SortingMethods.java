import java.util.Arrays; 

public class SortingMethods {
    // TODO: add your code here
    
    public static void main(String args[]){
   
         /* TestCases:
         * null 
         * single number 
         * Orderd oddnumber
         * reverse orderred oddnumber 
         * orderred even number 
         * reverse ordered even number 
         * random 
         * same number; 
         */
        
        int[]arr0 = {} ;
        int[]arr1 = {1}; 
        int[]arr2 = {1,2,3,4,5};
        int[]arr3 = {5,4,3,2,1};
        int[]arr4 = {1,2,3,4,5,6};
        int[]arr5 = {6,5,4,3,2,1};
        int[]arr6 = {6,4,1,3,2,5};
        int[]arr7 = {6,3,3,6}; 
        //int[] arr = {1} ;
        dualSelectionSort(arr0) ; 
        dualSelectionSort(arr1) ;
        dualSelectionSort(arr2) ;
        dualSelectionSort(arr3) ;
        dualSelectionSort(arr4) ; 
        dualSelectionSort(arr5) ;
        dualSelectionSort(arr6) ;
        dualSelectionSort(arr7) ;
    }
    /*
     * look at index0 what is the smallest one then put that in index 0 
     */ 
    
    public static void dualSelectionSort(int[] unsorted) throws IllegalArgumentException{
        /*
        if (unsorted == null || unsorted.length == 0){
            throw new IllegalArgumentException("Array is null or empty"); 
           
            
        } */ 
        
        System.out.println("Begining : " + Arrays.toString(unsorted)); 
        
        for (int i = 0 ; i < ((unsorted.length )+1)/2 ; i++){
            int small = unsorted[i] ;
            int indexOfSmall = i; 
            int big = unsorted[i];
            int indexOfBig = i; 
           
            for (int j = i ; j < unsorted.length - i ; j++){
             
                
                if (unsorted[j ] < small){
                    small = unsorted[j];
                    indexOfSmall = j; 
                    
                }
                
                if (unsorted[j] > big){
                    big = unsorted[j]; 
                    indexOfBig = j;
                    //System.out.println("index of big " + indexOfBig);
                }
                
            }

           
            if (unsorted[i] != unsorted[indexOfSmall]){
                System.out.println("Swapping1: " + unsorted[i] + " and " + unsorted[indexOfSmall]); 
                swap (unsorted, i, indexOfSmall) ;
                if (i == indexOfBig){
                    indexOfBig = indexOfSmall; 
                }
            }
            int second = unsorted.length-(i +1); 
            if (unsorted[second] != unsorted[indexOfBig] &&  unsorted[second] !=big){
                System.out.println(Arrays.toString(unsorted)) ;
                System.out.println("Swapping2: " + unsorted[second] + " and " + unsorted[indexOfBig]); 
                swap (unsorted, unsorted.length-(i + 1) , indexOfBig); 
            }
            System.out.println("Run " + i + " :" + Arrays.toString(unsorted)); 
           
        }
        
        System.out.println("End: " + Arrays.toString(unsorted)); 
        System.out.println("");
        System.out.println("");
        
    }
    
    public static int[] swap(int a[], int i, int j){
        int swapa = a[i]; 
        
        a[i] = a[j];
        a[j] = swapa; 

        return a; 
    }
}

