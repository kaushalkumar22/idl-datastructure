package com.ds.leetcode.problemset;

import java.util.ArrayList;
import java.util.List;

public class Skyline {
	private int greater(int a, int b)
    {
        if (a > b) return a;
        return b;
    }
     
    // given two skylines, merge them
    private List<int[]> mergeSkylines(List<int[]> skylineListLower, List<int[]> skylineListHigher)
    {
        int h1 = 0, h2 = 0;
        int newIndex = 0;
        List<int[]> skylineMerged = new ArrayList<int[]>();;
     
        while (true)
        {
            if (skylineListLower.isEmpty() || skylineListHigher.isEmpty())
            {
                break;
            }
             
            // first key points from both the skylines
            int [] stripe1 = skylineListLower.get(0);
            int [] stripe2 = skylineListHigher.get(0);
             
            // 0: 'x' co-ordinate, 1: height
            int [] mergedStripe = new int[2];
             
            // comparing 'x' co-ordinates of current key points of skyline-1 and skyline-2 
            if (stripe1[0] < stripe2[0]) // key point from skyline-1 is chosen 
            {
                mergedStripe[0] = stripe1[0];
                mergedStripe[1] = stripe1[1];
             
                // if 'y' co-ordinate for key point from skyline-1 is less than last seen height of skyline-2
                // then we need to update merged key point's 'y' co-ordinate to last seen height of skyline-2
                if (stripe1[1] < h2)
                {
                    mergedStripe[1] = h2;
                }
                 
                // update the last seen height for skyline-1
                // note that last seen height for skyline-2 is not updated 
                h1 = stripe1[1];
                 
                // move to next key point for this skyline
                skylineListLower.remove(0);
            }
            else if (stripe2[0] < stripe1[0])
            {
                mergedStripe[0] = stripe2[0];
                mergedStripe[1] = stripe2[1];
                 
                if (stripe2[1] < h1)
                {
                    mergedStripe[1] = h1;
                }
                 
                // update the last seen height of skyline-2
                // note that last seen height of skyline-
                h2 = stripe2[1];
                 
                skylineListHigher.remove(0);
            }
             
            // if 'x' co-ordinates of key points for both skylines are same
            // then choose the key point with greater 'y' value
            // advance key points for both and hence update last seen height for both
            else
            {
                mergedStripe[0] = stripe2[0];
                mergedStripe[1] = greater(stripe1[1], stripe2[1]);
                 
                h1 = stripe1[1];
                h2 = stripe2[1];
                 
                skylineListLower.remove(0);
                skylineListHigher.remove(0);
            }
             
            skylineMerged.add(mergedStripe);
        }
         
        if (skylineListLower.isEmpty())
        {
            while (!skylineListHigher.isEmpty())
            {
                skylineMerged.add(skylineListHigher.remove(0));
            }
        }
        else
        {
            while (!skylineListLower.isEmpty())
            {
                skylineMerged.add(skylineListLower.remove(0));
            }
        }
         
        // remove redundant key points from merged skyline 
        int current = 0;
        while (current < skylineMerged.size())
        {
            boolean dupeFound = true;
            int i = current + 1;
            while ((i < skylineMerged.size()) &&  dupeFound)
            {
                if (skylineMerged.get(current)[1] == skylineMerged.get(i)[1])
                {
                    dupeFound = true;
                    skylineMerged.remove(i);
                }
                else
                {
                    dupeFound = false;
                }
            }
            current += 1;
        }
         
        return skylineMerged;
    }
 
    private List<int[]> getSkyline(int low, int high, int[][]buildings)
    {
        List<int[]> skyLineList = new ArrayList<int[]>();
 
        // invalid case
        if (low > high)
        {
            return skyLineList;
        }
        // base case: if there is only one building, only two key points define the skyline for it
        else if (low == high)
        {
            int x1 = buildings[low][0];
            int x2 = buildings[low][1];
            int h  = buildings[low][2];
             
            int[] element1 = {x1, h}; // first key point
            int[] element2 = {x2, 0}; // second key point
             
            skyLineList.add(element1);
            skyLineList.add(element2);
             
            return skyLineList;
        }
        // general case
        else
        {
            int mid = (low + high) / 2;
             
            // get the skyline for lower half
            List<int[]> skylineListLower = getSkyline(low, mid, buildings);
          
            // get the skyline for upper half
            List<int[]> skylineListHigher = getSkyline(mid+1, high, buildings); 
             
            // merge skylines for these two halves
            return mergeSkylines(skylineListLower, skylineListHigher);  
        }
    }
     
    public List<int[]> getSkyline(int[][] buildings) 
    {
        return getSkyline(0, buildings.length-1, buildings);
    }
     
    public static void main(String[] args)
    {
        int[][] buildings = { {2,9,10}, {3,6,15}, {5,12,12}, {13,16,10}, {13,16,10}, {15,17,5}};
         
        Skyline slnForSkyline = new Skyline();
         
        List<int[]> skyLine = slnForSkyline.getSkyline(buildings);
         
        System.out.println("Skyline for given buildings would look like: ");
        for (int i = 0;  i < skyLine.size(); i++)
        {
            System.out.println(skyLine.get(i)[0]+","+skyLine.get(i)[1]);
        }
    }
}
