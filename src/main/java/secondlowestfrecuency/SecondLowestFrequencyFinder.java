package secondlowestfrecuency;

import java.util.*;

public class SecondLowestFrequencyFinder {

    public static int secondLowest(int[] integers) {

        Map<Integer, Integer> frequencies = getDistinctFrequencies(integers);

        int lowestFrequency = Integer.MAX_VALUE;
        int secondLowestFrequency = Integer.MAX_VALUE;
        List<Integer> lowestFrequencyIntegers = new ArrayList<>();
        List<Integer> secondLowestFrequencyIntegers = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {

            int frequency = entry.getValue();
            int integer = entry.getKey();

            if(frequency == secondLowestFrequency) {
                secondLowestFrequencyIntegers.add(integer);
                continue;
            }

            if(frequency == lowestFrequency) {
                lowestFrequencyIntegers.add(integer);
                continue;
            }

            if(frequency < lowestFrequency) {

                secondLowestFrequency = lowestFrequency;
                secondLowestFrequencyIntegers = lowestFrequencyIntegers;
                lowestFrequency = frequency;
                lowestFrequencyIntegers = new ArrayList<>();
                lowestFrequencyIntegers.add(integer);

            } else if(frequency < secondLowestFrequency) {

                secondLowestFrequency = frequency;
                secondLowestFrequencyIntegers.clear();
                secondLowestFrequencyIntegers.add(integer);
            }
        }

        if(!secondLowestFrequencyIntegers.isEmpty())
            return getSecondLowest(secondLowestFrequencyIntegers);
        else
            return getSecondLowest(lowestFrequencyIntegers);
    }


    private static Map<Integer, Integer> getDistinctFrequencies(int[] integers) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for(int integer : integers) {
            frequencies.put(integer, frequencies.getOrDefault(integer, 0) + 1);
        }
        return frequencies;
    }


    private static int getSecondLowest(List<Integer> integers) {

        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;

        for(int integer : integers) {
            if(integer < lowest) {
                lowest = integer;
            } else if(integer < secondLowest) {
                secondLowest = integer;
            }
        }

        return integers.size() > 1 ? secondLowest : lowest;
    }
}
