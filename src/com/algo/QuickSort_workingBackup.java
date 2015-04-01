/*package com.algo;

public class QuickSort {

	*//**
	 * @param args
	 *//*
	
	static long  totalComparisions =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in= new In("G:/data/10.txt");
		
		int[] fileResults =in.readAllInts();
		
		
		int[] inputArray = new int[]{3,9,8,4,6,10,2,5,7,1};
		
		int result[] = QuickSort(fileResults);
		
		int m=0;
		System.out.println(totalComparisions);
		m++;
		
		

	}
	
	public static int[] QuickSort(int[] inputArray)
	{
		if (inputArray.length ==1 )return inputArray;
		
		int pivotIndex= ChoosePivot(inputArray);
		
		
		totalComparisions = totalComparisions+inputArray.length -1;
		
		int partitionIndex = PartitionAroundPivot(inputArray, pivotIndex);
		
	//	if(partitionIndex==0 && inputArray.length==2) return inputArray;
		// Get first part
		int[] firstPart = null;
		if(partitionIndex>0){
			 firstPart = new int[partitionIndex];
			for(int i=0;i<firstPart.length;i++){
				firstPart[i] = inputArray[i];
				
			}
			
			//totalComparisions = totalComparisions+ firstPart.length;
					
			firstPart = QuickSort(firstPart);
			
		//	if(partitionIndex==0 && inputArray.length==2 ) return inputArray;
		}
		
		// pre-process second part
		
		int lengthSecondPart = inputArray.length -partitionIndex-1;
		int[] secondPart =null;
		if(lengthSecondPart>0){
		int inputArrayPointer = partitionIndex+1;
		
		secondPart = new int[lengthSecondPart];
		
		// copy the elements accordingly
		for(int j= 0; j<lengthSecondPart;j++){
			
			secondPart[j] = inputArray[inputArrayPointer++];
			
		}
		
		
	//	totalComparisions = totalComparisions+secondPart.length;
		
		secondPart =QuickSort(secondPart);
		}
		
		//copy first array to main inputArray
		if(firstPart != null){
			for(int a=0; a<firstPart.length;a++)
			{
				inputArray[a] = firstPart[a];
			}
		}
				
		//copy second Array to main inputArray
		
		if(secondPart!=null){
			
			int incrementPointer = partitionIndex+1;
			for(int a=0; a<secondPart.length;a++){
				inputArray[incrementPointer++] = secondPart[a];
			}
			
		}
		
		return inputArray;
	}
	public static int ChoosePivot(int[] inputArray)
	{
		// return the very first Element
		return 0;
		
	}
	
	public static int PartitionAroundPivot(int[] inputArray,  int pivotIndex)
	{
		
		
		int pivotElement = inputArray[pivotIndex];
		
		// if (pivotIndex !=0) then swap the pivot element with element at location zero
		
		int i= 1;
		
		for(int j=1 ; j< inputArray.length;j++){
			
			if(inputArray[j]< pivotElement){
				// Swap
				int locVal = inputArray[i];
				inputArray[i] =inputArray[j];
				inputArray[j] =locVal;
				
				
				i++;				
			}
					
		}
		// final Swap between pivot
		
		inputArray[pivotIndex] = inputArray[i-1];
		
		inputArray[i-1] = pivotElement;
		// now translate the element 
		// return the partition Index
		return i-1;
		
		
		
		
	}
	

}
*/