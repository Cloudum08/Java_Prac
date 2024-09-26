//Given two sorted arrays, the task is to merge them in a sorted manner.


import java.util.*;

class MergedArrays
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of two arrays:");
    
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
    
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        
        System.out.println("Enter the array1 ele:");
    
        for(int i=0; i<n1; i++)
        {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the array2 ele:");
        for(int i=0; i<n2; i++)
        {
            arr2[i] = sc.nextInt();
        }
        
        int mergedArr[] = merge(arr1, arr2);
        System.out.println("Merged Array: " + Arrays.toString
        (mergedArr));
    }
    public static int[] merge(int arr1[], int arr2[])
    {
        int a = arr1.length;
        int b = arr2.length;
        int arr3[] = new int[a+b];
        
        int i = 0, j = 0, k = 0;
        while (i < a && j < b)
        {
            if(arr1[i] < arr2[j])
            {
                arr3[k] = arr1[i];
                k++;
                i++;
            }
            else
            {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
        
        while (i<a)
        {
            arr3[k] = arr1[i];
            k++;
            i++;
        }
        
        while (j<b)
        {
            arr3[k] = arr2[j];
            k++;
            j++;
        }
        
        return arr3;
    }
}