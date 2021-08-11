package com.demo.base;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String args[]){

        List list = new ArrayList();


        Thread thread = new Thread(() -> {

            System.out.println("lhasldf");
        });
        thread.start();
        try {
            synchronized(thread){
                thread.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(thread){
            thread.notify();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0;i<5;i++){
            try{
                Thread.sleep(100);

                System.out.println("sleep"+Thread.currentThread().getName());

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhhh"+Thread.currentThread().getName());
            });
        }

    }
}


class Solution {

    private boolean dp[][];
    public List<List<String>> partition(String s) {
        int len = s.length();
        this.dp = new boolean[len][len];

        //动态规划预处理，生成回文判断表
        for(int right = 0; right<len;right++){
            for(int left = 0; left <= right; left++){
                if(s.charAt(left) == s.charAt(right)&&(right-left<=2||dp[left+1][right-1])){
                    dp[left][right] = true;
                }
            }
        }

        //回溯法检索所有的回文串
        List<List<String>> resultList = new ArrayList<>();
        doBackTrace(s,0,len,new ArrayList<>(),resultList);
        return resultList;
    }

    private void doBackTrace(String s,int start,int len, List<String> tempList,List<List<String>> resultList){
        //到尾了，代表切割完全成功
        if(start == len){
            resultList.add(new ArrayList<>(tempList));
        }
        //继续切割和缩小问题规模
        for(int end = start; end < len; end++){
            if(this.dp[start][end] == true){
                tempList.add(s.substring(start,end+1));//注意substring是剪到第二个参数之前
                doBackTrace(s,end+1,len,tempList,resultList);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}

class Solution2 {
    public static void main(String args[]){
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findKthNumber(10,2));
    }
    public int findKthNumber(int n, int k) {
        long prefix = 1,p=1;

        while(p<k){
            long count = getCount(prefix,n);
            if(p+count > k){
                p++;
                prefix*=10;
            }
            else{
                p+=count;
                prefix++;
            }
        }

        return (int)prefix;
    }

    private long getCount(long prefix,long n){
        long count = 0;
        for(long pre= prefix,next =prefix+1; pre <= n; pre*=10,next*=10){
            count+=Math.min(n+1,next)-pre;
        }
        return count;
    }

}

class solution3{
    public static void quickSort(int[] arr,int low,int high){

        if(low>=high){
            return;
        }
        int temp = arr[low];
        int i=low,j=high;
        while(i<j){

            //从后往前，比temp大的，也就是temp<=item的，不用动，继续放在后面就行
            while(temp <= arr[j] && i<j){
                j--;
            }
            while(temp >= arr[i] && i<j){
                i++;
            }
            //如果是因为i=j结束的，显然是没有必要交换的
            if(i<j){
                int k = arr[i];
                arr[i] = arr[j];
                arr[j] = k;
            }
        }

        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);
    }
    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Solution4 {

    public static void main(String[] args){
        System.out.println("hhhh");
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
        wordBreak2("leetcode",wordDict);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s,0,s.length(),wordDict);

    }

    private static boolean dfs(String s,int left,int length, List<String> wordDict){
        if(left == length-1){
            return true;
        }
        if(left > length-1){
            return false;
        }
        for(String word : wordDict){
            int wordLen = word.length();
            if(wordLen+left-1 < length){

                int sameCount;
                for(sameCount = 0; sameCount < wordLen; sameCount++){
                    if(word.charAt(sameCount) != s.charAt(left+sameCount)){
                        break;
                    }
                }
                if(sameCount == wordLen){
                    if(true == dfs(s,left+wordLen,length,wordDict)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        Set<String> wordSet= new HashSet(wordDict);
        dp[0] = true;//代表字符串长度为零的情况

        //切割子串，判断子串是否完全可分割，移动right，从而逐步扩大子串
        for(int len = 1;len <=s.length();len++){
            //寻找子串切割点，显然切割点前是已知的可分割断，所以我们只需要判断剩下的一段是否可分割就行。

            for(int cur = 0; cur <len; cur++){

                if(dp[cur]==true && wordSet.contains(s.substring(cur,len))){

                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

class Solution5 {

    public static void main(String[] args){
        int[] temp = {1,2,3,4,5,6,7};
        rotate2(temp,3);
    }
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
            System.out.println(Arrays.toString(newArr));
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k==0){
            return;
        }
        //if(len-k > k){
        int[] temp=Arrays.copyOfRange(nums,len-k,len);
        //System.out.println(Arrays.toString(temp));
        int moveIndex = k;
        for(int i = 0; i < k; i++,moveIndex++){
            //System.out.printf("len:%d, i:%d len-k:%d moveIndex:%d\n",len,i,len-k,moveIndex);
            nums[moveIndex] = nums[i];
        }
        for(int i = 0; i < k; i++){
            nums[i] = temp[i];
        }
        //}

    }
}