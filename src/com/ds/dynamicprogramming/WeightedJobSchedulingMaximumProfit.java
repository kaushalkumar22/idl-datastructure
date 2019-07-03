package com.ds.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;


public class WeightedJobSchedulingMaximumProfit {

	public static void main(String args[]){
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
        WeightedJobSchedulingMaximumProfit mp = new WeightedJobSchedulingMaximumProfit();
        System.out.println(mp.maximum(jobs));
    }
	private int maximum(Job[] jobs) {
		
		Arrays.sort(jobs, new FinishTimeComparator());
		int T[] = new int[jobs.length];	
		for(int i=0;i<jobs.length;i++){
			T[i]=jobs[i].profit;
		}
		for(int i=1;i<jobs.length;i++){
			for(int j=0;j<i;j++){
				if(jobs[i].start>=jobs[j].end){
					T[i]=Math.max(T[i],T[j]+jobs[i].profit);
				}
			}
		}
		  int maxVal = 0;
	        for (int val : T) {
	            if (maxVal < val) {
	                maxVal = val;
	            }
	        }
	        return maxVal;
		
	}
	private class FinishTimeComparator implements Comparator<Job>{

	    @Override
	    public int compare(Job arg0, Job arg1) {
	        if(arg0.end <= arg1.end){
	            return -1;
	        }else{
	            return 1;
	        }
	    }
	    
	}
	private static class Job{
	    int start;
	    int end;
	    int profit;
	    Job(int start,int end,int profit){
	        this.start= start;
	        this.end = end;
	        this.profit= profit;
	    }
	}
}
