public class Main {
    public static void main(String[] args) {
        int[] north = {120, 150, 100, 80};
        int[] south = {100, 149, 123, 91};
        int[] east =  {123, 111, 102, 89};
        int[] west =  {171, 90,  90,  101};

        int[][] regionsQtrs = {north, south, east, west};

        System.out.println("1. " + mostProfitableRegion(regionsQtrs));
        System.out.println("2. " + mostProfitableRegionPerQ(regionsQtrs));
        System.out.println("3. " + overallTotal(regionsQtrs));
        System.out.println("4. " + deviationFromAverageTotalPerRegion(regionsQtrs));
        System.out.println("5. " + grandTotalPerQtr(regionsQtrs));
    }

    public static String mostProfitableRegion(int[][] regions) {
        int[] regionTotals = new int[regions.length];
        String[] regionsNames = {"North", "South", "East", "West"};
        int largest = 0;

        for (int i = 0; i < regions.length; i++) {
            int sum = 0;
            for (int j = 0; j < regions[i].length; j++) {
                sum += regions[i][j];
            }
            regionTotals[i] = sum;
        }

        for ( int i = 1; i < regionTotals.length; i++ )
        {
            if ( regionTotals[i] > regionTotals[largest] ) largest = i;
        }

        return "The most profitable region is: " +
                regionsNames[largest] + " where total is: " +
                regionTotals[largest];
    }


    public static String mostProfitableRegionPerQ(int[][] regions) {
        String[] regionsNames = {"North", "South", "East", "West"};
        int largestQRegion = 0, largestQ = 0, numberOfQ = 0;

        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < regions[i].length; j++) {
                if ( regions[i][j] > regions[largestQRegion][j] ) {
                    largestQRegion = i;
                    largestQ = regions[i][j];
                    numberOfQ = j + 1;
                }
            }
        }
        return "The Most profitable region/Qtr is in the region: " + regionsNames[largestQRegion] +
                " where in the " + numberOfQ +
                "th where the profit was " + largestQ;
    }


    public static String overallTotal(int[][] regions) {
        int total = 0;
        for (int[] region : regions) {
            int sum = 0;
            for (int i : region) {
                sum += i;
            }
            total += sum;
        }
        return "The overall total is: " + total;
    }


    public static String deviationFromAverageTotalPerRegion(int[][] regions) {
        int[] listOfAverages = new int[regions.length];
        int totalTemp = 0;

        for (int i = 0; i < regions.length; i++) {
            int totalRegionTemp = 0;
            for (int j = 0; j < regions[i].length; j++) {
                totalRegionTemp += regions[i][j];
                totalTemp += regions[i][j];
            }
            listOfAverages[i] = totalRegionTemp / regions[i].length;
        }

        int totalAverage = totalTemp / (regions.length * regions[0].length);

        for (int i = 0; i < listOfAverages.length; i++) {
            listOfAverages[i] = Math.abs(listOfAverages[i] - totalAverage);
        }

        return "Total average is: " + totalAverage +
                " deviation from total average per Region is -" +
                " North: " + listOfAverages[0] +
                " South: " + listOfAverages[1] +
                " East: " + listOfAverages[2] +
                " West: " + listOfAverages[3];
    }


    public static String grandTotalPerQtr(int[][] regions) {
        int[] totalsPerQ = new int[regions[0].length];

        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < regions[i].length; j++) {
                    totalsPerQ[i] += regions[j][i];
                }
            }

        return "first Qs: " + totalsPerQ[0] + " second Qs: " + totalsPerQ[1] + " third Qs: " + totalsPerQ[2] + " forth Qs: " + totalsPerQ[3];
    }
}