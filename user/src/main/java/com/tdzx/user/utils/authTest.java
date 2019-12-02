package com.tdzx.user.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class authTest {
    Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception{
        int[] arr = {8,4,2,9,4,5,3,7};
        //URLUtils u = clone();
        //冒泡
        /*for (int k =0;k<arr.length-1;k++){
            for (int n = 0;n<arr.length-k;n++){
                if (n!=arr.length-1 && arr[n]>arr[n+1]){
                    int stamp = arr[n];
                    arr[n] = arr[n+1];
                    arr[n+1] = stamp;
                }
            }
        }*/


        //二分法(快速排序)


        for (int i=0;i<arr.length;i++){
            System.err.println(arr[i]);
        }
    }
}
