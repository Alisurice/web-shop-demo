package com.demo.base;

import java.util.Arrays;

public class test2 {
}

class Solution6 {
    public static void main(String[] args){
        int[] arr = {3,2,1,5,6,4};
        findKthLargest(arr, 2);
        System.out.println(arr[1]);

    }

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1,k);
        return nums[k-1];
    }

    public static void quickSort(int[] nums,int start, int end, int k){
        if(start >= end){
            return;
        }
        int i = start;
        int j = end;
        int temp = nums[start];
        while(i < j ){
            while(temp >= nums[j] &&i < j){
                j--;
            }
            while(nums[i] >= temp && i < j){
                i++;
            }
            if(i < j){
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }

        nums[start] = nums[i];
        nums[i] = temp;

        if(i == k-1){
            return ;
        }
        if (k - 1 < i) {
            System.out.println(nums.toString());
            quickSort(nums, start, i - 1, k);
        } else {
            System.out.println(nums.toString());
            quickSort(nums, i + 1, end, k);
        }


    }
}

class Solution7 {
    public static void main(String[] args){
        int[] arr = {3,2,1,5,6,4};
        findKthLargest(arr, 2);
        System.out.println(arr[1]);

    }

    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums,heapSize);
        for(int i = 0; i<k; i++){
            System.out.println("a:"+ Arrays.toString(nums));
            swap(nums,0, heapSize-1);
            System.out.println("b:"+Arrays.toString(nums));
            --heapSize;
            maxHeapify(nums,0,heapSize);
            System.out.println("c:"+Arrays.toString(nums));
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] nums, int heapSize){
        for(int i = heapSize/2; i>=0; i--){
            maxHeapify(nums, i, heapSize);
        }
    }

    //其实就是用来下沉元素的。
    //调整父子节点中的最大值，让最大值上浮，并在上浮后调整孙节点，保证子树仍然是堆结构
    public static void maxHeapify(int[] a, int i, int heapSize){
        //biggest的节点可能是左节点、右节点，也可能是他们的父节点，即i
        int leftNode = i*2+1, rightNode = i*2+2, biggestNode = i;
        if(leftNode <heapSize && a[leftNode]>a[biggestNode]){
            biggestNode = leftNode;
        }
        if(rightNode < heapSize && a[rightNode]>a[biggestNode]){
            biggestNode = rightNode;
        }
        if(biggestNode != i){
            swap(a, i, biggestNode);
            //经过父子节点的交换，子节点可能不再是孙节点中的最大值，所以要重新遍历重新调整位置。
            //显然的，这里只有一个分支被调整了，所以直接以修改了的子节点作为父节点i，进一步调整堆就行
            maxHeapify(a, biggestNode, heapSize);
        }
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
