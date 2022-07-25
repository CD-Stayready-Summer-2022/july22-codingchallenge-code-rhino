package com.codedifferently;

import java.util.*;

public class Solution {
    /**
     * You will be given an integer called number and an array called possibleFamilyMembers
     * your jobs is to find the number's family members. A family member is any value that's with in
     * 1 of any other number in the family.
     *
     * So for example if the number = 4, and the possibleFamilyMembers is [1,4,3,5]
     * The actualFamilyMembers would be [3,4,5]
     * 3 is 1 away from 4
     * 4 is equal to 4
     * 4 is 1 away from 5
     * while
     * 1 is not included because the closest releation to 1 is 3 and that's 2 away.
     * @param number
     * @param possibleFamilyMembers
     * @return
     */
    public Integer[] numberFamily(Integer number, Integer[] possibleFamilyMembers){
        Arrays.sort(possibleFamilyMembers);
        Map<Integer, Set<Integer>> familes = new HashMap<>();
        Set<Integer> family = new TreeSet<>();
        familes.put(possibleFamilyMembers[0],family);
        for(int j = 0; j <possibleFamilyMembers.length; j++){
            for(int x = j+1; x < possibleFamilyMembers.length; x++){
                Integer currentValue = possibleFamilyMembers[x-1];
                Integer nextValue = possibleFamilyMembers[x];
                if((nextValue - currentValue) <=1){
                    family.add(nextValue);
                    family.add(currentValue);
                }else if((nextValue - currentValue)> 1){
                    family = new TreeSet<>();
                    familes.put(currentValue, family);
                }
            }
        }

        Integer[] response = new Integer[0];
        for(Map.Entry<Integer, Set<Integer>> entry: familes.entrySet()){
            Set<Integer> value = entry.getValue();
            if(value.contains(number)){
                response = new Integer[value.size()];
                System.arraycopy(value.toArray(), 0, response, 0, value.size());
            }
        }
        return response;
    }
}
