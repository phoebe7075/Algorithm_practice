package Beakjoon.old.bj11279;


import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(100);

        for(int i=0; i< N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 0) {
                heap.add(a);
            }else {
                heap.remove();
            }
        }
    }
}

class Heap {
    private int[] arr;
    private int size;
    private int capacity = 20;

    public Heap() {
        this.arr = new int[capacity];
        this.size = 0;
    }

    public Heap(int cp) {
        this.arr = new int[cp];
        this.size = 0;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeftChild(int index) {
        return index * 2;
    }

    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    private void resize(int newCapacity) {

        // 새로 만들 배열
        int[] newArray = new int[newCapacity];

        for(int i = 1; i <= size; i++) {
            newArray[i] = arr[i];
        }
        this.arr = null;
        this.arr = newArray;
    }

    public void add(int v) {
        if(size + 1 == arr.length) {
            resize(arr.length * 2);
        }

        Maxheapify(size+1, v);
        size++;
    }

    public void Maxheapify(int idx, int v) {
        while (idx > 1) {
            int parent = arr[getParent(idx)];
            if (parent > v) {
                break;
            }

            arr[idx] = parent;
            idx = getParent(idx);
        }

        arr[idx] = v;
    }

    public void remove() {
        if (size == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(arr[1]);
        arr[1] = 0;
        int target = arr[size];
        arr[size] = 0;
        size--;
        int parent = 1;
        int child ;
        while ((child = getLeftChild(parent)) <= size) {
            int right = getRightChild(parent);
            int cval = arr[child];

            if(right <= size && cval < arr[right]) {
                child = right;
                cval = arr[child];
            }

            if(target > cval) {
                break;
            }

            arr[parent] = cval;
            parent = child;
        }

        arr[parent] = target;
    }
}
