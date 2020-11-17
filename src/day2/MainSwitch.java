package day2;

public class MainSwitch {
//    public static void main(String[] args) {

//        String month = "August";
//
//        int returnedMonthNumber =
//                StringSwitchingDemo.getMonthNumber(month);
//
//        if (returnedMonthNumber == 0) {
//            System.out.println("Invalid month");
//        } else {
//            System.out.println(returnedMonthNumber);
//        }

//    }
//public static void main(String[] args) {
//
//    int[] arrayOfInts =
//            { 32, 87, 3, 589,
//                    12, 1076, 2000,
//                    8, 622, 127 };
//    int searchfor = 12;
//
//    int i;
//    boolean foundIt = false;
//
//    for (i = 0; i < arrayOfInts.length; i++) {
//        if (arrayOfInts[i] == searchfor) {
//            foundIt = true;
////            break;
//        }
//    }
//    if (foundIt) {
//        System.out.println("Found " + searchfor + " at index " + i);
//    } else {
//        System.out.println(searchfor + " not in the array");
//    }
//}

//    public static void main(String[] args) {
//
//        int[][] arrayOfInts = {
//                { 32, 87, 3, 589 },
//                { 12, 1076, 2000, 8 },
//                { 622, 127, 77, 955 }
//        };
//        int searchfor = 12;
//
//        int i;
//        int j = 0;
//        boolean foundIt = false;
//        search://
//        for (i = 0; i < arrayOfInts.length; i++) {
//            for (j = 0; j < arrayOfInts[i].length;
//                 j++) {
//                if (arrayOfInts[i][j] == searchfor) {
//                    foundIt = true;
////                    break;
//                    break search;//break akan mengakhiri search
//                }
//            }
//        }
//
//        if (foundIt) {
//            System.out.println("Found " + searchfor + " at " + i + ", " + j);
//        } else {
//            System.out.println(searchfor + " not in the array");
//        }
//    }

    public static void main(String[] args) {

//        String searchMe = "peter piper picked a " + "peck of pickled peppers";
//        int max = searchMe.length();
//        int numPs = 0;
//
//        for (int i = 0; i < max; i++) {
//            // interested only in p's
//            if (searchMe.charAt(i) != 'p')
//                continue;
//
//            // process p's
//            numPs++; // numPs = numPs + 1
//        }
        String a="20-10-1997";
        String[] b=a.split("-");
        System.out.println("Found " + b[0]);
        System.out.println("Found " + b[1]);
        System.out.println("Found " + b[2]);
//        System.out.println("Found " + b.substring(3,4));
    }

}

