package com.amazon.heap.ops;

public class Solution {

	public static void main(String[] args) {
		int[] A = {2,4,3,1,6,5};
		Heap heap = new Heap(6);
		Data[] D = heap.createHeap(A);
		for(Data data : D){
			System.out.print(data.getValue() + " ");
		}
		Data pop = heap.pop();
		System.out.println("\ndata popped : " + pop.getValue());
		Data[] afterPOp = heap.getHeap();
		for(Data data : afterPOp){
			System.out.print(data.getValue() + " ");
		}
	}
}

class Data{
	int value;

	public Data(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

class Heap{

	Data[] heap;
	int maxSize;
	int noOfElements;

	public Heap(int maxSize) {
		this.maxSize = maxSize;
		heap = new Data[maxSize];
		noOfElements = 0;
	}
	

	public Data[] createHeap(int[] A){
		if(A.length <= maxSize){
//			for(int arr : A){
				for(int i = 0; i < maxSize; i++){
				Data d = new Data(A[i]);
				insertInHeap(d);
			}
			return heap;
		}
		throw new RuntimeException("Array Size is greater than heap max size");
	}

	public void insertInHeap(Data data){
		heap[noOfElements] = data;
		noOfElements++;
		heapifyInsert(noOfElements-1);
	}
	
	public void heapifyInsert(int index){
		int parentNode = (index % 2 == 0 ) ? (index/2) - 1 : index/2;
		if(parentNode < 0){
			return;
		}
		Data newNode = heap[index];
		if(heap[parentNode].getValue() > heap[index].getValue()){
			return;
		}else{
			heap[index] = heap[parentNode];
			heap[parentNode] = newNode;
			heapifyInsert(parentNode);
		}
	}
	
	public Data pop(){
		Data returnData = heap[0];
		heap[0] = heap[noOfElements-1];
		noOfElements--;
		heapifyPop(0);
		return returnData;
	}

	public void heapifyPop(int index) {
		int largerData;
		Data root = heap[index];
		while(index < (noOfElements/2)){
			int leftData = index * 2  + 1;
			int rightData  = leftData  + 1;
			if(rightData < noOfElements && heap[rightData].getValue() > heap[leftData].getValue()){
				largerData = rightData;
			}else{
				largerData = leftData;
			}

			if(heap[index].getValue() >= heap[largerData].getValue()){
				break;
			}
			heap[index] = heap[largerData];
			heap[largerData] = root;
			index = largerData;
		}
	}

	public Data[] getHeap() {
		return heap;
	}

	public void setHeap(Data[] heap) {
		this.heap = heap;
	}

}