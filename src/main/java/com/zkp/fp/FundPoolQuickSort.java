package com.zkp.fp;

/**
 * 快速排序
 * @param <T>
 */
public class FundPoolQuickSort<T extends Comparable> {

    public void quickSort(T[] a, int low, int high) {
        if (low < high) {
            int q = partion(a, low, high);
            quickSort(a, 0, q - 1);
            quickSort(a, q + 1, high);
        }
    }

    private int partion(T[] a, int low, int high) {
        T base = a[low];
        while (low < high) {
            while (low < high && a[high].compareTo(base) >= 0 ) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low].compareTo(base) <= 0) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = base;
        return low;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] {4,1,3,2,16,9,10,14,8,7};
        FundPoolQuickSort<Integer> fundPoolQuickSort = new FundPoolQuickSort();
        fundPoolQuickSort.quickSort(a, 0, a.length - 1);
        for (int number : a) {
            System.out.println(number);
        }
    }
}
