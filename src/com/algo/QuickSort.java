package com.algo;

public class QuickSort {

	/**
	 * @param args
	 */
	
	static long  totalComparisions =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in= new In("G:/data/QuickSort.txt");
		
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
		
		
		//totalComparisions = totalComparisions+inputArray.length -1;
		
		int partitionIndex = PartitionAroundPivot(inputArray, pivotIndex);
		
	//	if(partitionIndex==0 && inputArray.length==2) return inputArray;
		// Get first part
		int[] firstPart = null;
		if(partitionIndex>0){
			 firstPart = new int[partitionIndex];
			for(int i=0;i<firstPart.length;i++){
				firstPart[i] = inputArray[i];
				
			}
			
			totalComparisions = totalComparisions+ firstPart.length;
					
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
		
		
		totalComparisions = totalComparisions+secondPart.length;
		
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
		/*if(inputArray.length ==2){
			if(inputArray[0]< inputArray[1]) return 0;
			else
				return 1;
			
		}
		
		int firstElement = inputArray[0];
		int secondElement= inputArray[inputArray.length-1];
		int middleElement =-1;
		int middleElementIndex=0;
		if(inputArray.length % 2 ==0){
			middleElement = inputArray[inputArray.length/2 -1];
			middleElementIndex= inputArray.length/2 -1;
		}
		else{
			middleElement= inputArray[inputArray.length/2 ];
			middleElementIndex = inputArray.length/2 ;
		}
		//int[] elementsArray = new int[]{firstElement, secondElement};
		
		if(firstElement<secondElement && firstElement>middleElement) return 0;
		if(firstElement>secondElement && firstElement<middleElement) return 0;
		
		if(secondElement<firstElement && secondElement>middleElement) return inputArray.length-1;
		if(secondElement>firstElement && secondElement<middleElement) return inputArray.length-1;
		
		if(middleElement<firstElement && middleElement>secondElement) return middleElementIndex;
		if(middleElement>firstElement && middleElement<secondElement) return middleElementIndex;
		*/
		
			
		// compute the median..
		// return the very first Element
		return inputArray.length-1;
	//	return 0;
		
	}
	
	public static int PartitionAroundPivot(int[] inputArray,  int pivotIndex)
	{
		
		
		int pivotElement = inputArray[pivotIndex];
		
		 if (pivotIndex !=0) {
			 inputArray[pivotIndex]= inputArray[0];
			 inputArray[0] = pivotElement;
			 pivotIndex=0;
			 
		 }
		
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
