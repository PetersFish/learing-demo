package cn.peter.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Peter Yu 2018/9/6 16:53
 *
 * 思路：
 *
 * 1. 初始化
 * i = 0
 * j = length - 1
 * key = arr[0]
 *
 * arr[j]同key比较，如果arr[j] < key， arr[j]和arr[i]交换位置(此时key的index = j)，不然不作为，j--
 * arr[i]同key比较，如果arr[i] > key， arr[j]和arr[i]交换位置(此时key的index = i)，不然不作为, i++
 * 当i == j时，完成第一次快排
 *
 */
public class QuickSortDemo {
    static int count = 0;
    static int swapCount = 0;

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5  };
        arr = suffleArray(arr);
        System.out.println("old:"+Arrays.toString(arr));


        quickSort(arr);
        System.out.println("new:"+Arrays.toString(arr));
        System.out.println("count:"+count);
        System.out.println("swapCount:"+swapCount);
    }

    private static Integer[] suffleArray(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        Collections.shuffle(list);
        arr = list.toArray(arr);
        return arr;
    }

    public static void quickSort(Integer[] arr){
        int i = 0;
        int j = arr.length - 1;
        quickSort(arr, i, j);
    }

    private static void quickSort(Integer[] arr, int i, int j) {
        if (i >= j) {
            return;
        }
        int begin = i;
        int end = j;
        int key = arr[i];

        OUTER: while (true){
            while (true) {
                if (arr[j] < key) {
                    swap(arr, i , j);
                    break;
                }
                --j;
                ++count;
                if (i == j) {
                    break OUTER;
                }
            }
            while (true) {
                if (arr[i] > key) {
                    swap(arr, i , j);
                    break;
                }
                ++i;
                ++count;
                if (i == j) {
                    break OUTER;
                }
            }
        }

        // 分别对左侧和右侧进行递归
        quickSort(arr, begin, i-1);
        quickSort(arr, i+1, end);

    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        ++swapCount;
    }
}
