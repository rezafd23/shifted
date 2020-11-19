package day3.tugas2;

public class MainLatihan{
    public static void main (String[] args){
        if (args[0].equalsIgnoreCase("1")){
            int volKubus=hitungVolume(Integer.parseInt(args[1]));
            System.out.println("Volume Kubus adalah "+volKubus);
        }
        else if (args[0].equalsIgnoreCase("2")){
            double volBola=hitungVolume(Double.parseDouble(args[1]));
            System.out.println("Volume Bola adalah "+volBola);
        }
        
        else if (args[0].equalsIgnoreCase("3")){
            printArray(Integer.parseInt(args[1]));
        }
    }
    private static int hitungVolume(int alas){
        int volume=alas*alas*alas;
        return volume;
    }
    private static double hitungVolume(double alas){
        double volume=(4/3)*3.14*Math.pow(alas,3);
        return volume;
    }
    private static void printArray(int length){
        if(length==2){
            String[][] arr = { 
            { "satu", "dua", "tiga", "empat" },
            { "enam", "lima" }
            };
            for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < arr[i].length; j++) { 
            System.out.print(arr[i][j] + " ");
         }
         System.out.println(); 
         }
        }
        else if(length==3){
             System.out.println("Masuk 3"); 
            String[][] arr = { 
            { "satu", "dua", "tiga", "empat" },
            { "enam", "lima" },
            { "tujuh", "delapan","Sembilan","Sepuluh" },
            };
            for (int i = 0; i < arr.length; i++) { 
                for (int j = 0; j < arr[i].length; j++) { 
                    System.out.print(arr[i][j] + " ");
                }
                    System.out.println(); 
            }
        }
        
    }
}

// arr[0] = new String[4];
// 	arr[1] = new String[2];
// 	arr[0][] = {satu, dua, tiga, empat}

// 	-> satu, dua, tiga, empat,
// 	-> lima, enam,
	
// 	- java CommandLine 3 3
	
// 	new arr[3][]
	
// 	satu, dua, tiga, empat,
// 	lima, enam,
// 	tujuh, delapan, sembilan,