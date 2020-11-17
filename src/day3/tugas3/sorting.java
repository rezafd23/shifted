public class sorting{
    public static void main(String[] args){

        int[] arrParam={21,23,26,12,15};//Input array
        
        System.out.println("Tugas Nomor 1: ");
        System.out.print("Data Input: ");
        for(int num:arrParam){//for each looping untuk print isi input array
            System.out.print(num+", ");
        }
        System.out.println("");
        
        int[] b=bubleSort(arrParam);//buat local variabel array integer b yang berisi hasil bubble sort dari variabel array integer arrParam
        System.out.println("Tugas Nomor 2: ");
        System.out.print("Data Setelah Disortir: ");
        for(int num:b){//for each looping untuk print isi array b hasil bubble sort
            System.out.print(num+", ");
        }
        System.out.println("");
        System.out.println("Tugas Nomor 3: ");
        binarySearch(b);//panggil method binary search untuk mencari posisi nilai

    }

    private static int[] bubleSort(int[]a){//method bubble sort
        for (int i=0;i<a.length-1;i++){//looping for berdasarkan panjang array parameter
            for(int j=0;j<a.length-1-i;j++){//looping berdasarkan panjang array dikurangi 1 dan nilai i
                if(a[j+1]<a[j]){//membandingkan nilai array apakah lebih kecil atau lebih besar antara index awal dan selanjutnya
                    int temp = a[j];//memasukan nilai array pada local variabel "temporary" temp
                    a[j]=a[j+1];//set nilai pada array a[j]
                    a[j+1]=temp;//pindahkan nilai dari temp pada array
                }
            }
        }
        return a;//return array
    }

    private static void binarySearch(int[] a){//method binary search
        int target = 23; //nilai yang dicari
        int left = 0;//local variabel
        int middle;//local variabel
        int right = a.length - 1;//local variabel
        while (left <= right) {//looping ketika nilai variabel left lebih kecil samadengan right
            middle = (left + right) / 2;//tentukan nilai variabel middle/ tentukan nilai tengahnya
            if (a[middle] == target) {//cek apakah nilai dari array dengan index nilai tengah sama dengan nilai target
                System.out.println("Element found at index " + middle);//print index
                break;
            } else if (a[middle] < target) {//cek apakah nilai dari array dengan index nilai tengah kurang dari nilai target
                left = middle + 1;//set nilai left dengan nilai middle +1
            } else if (a[middle] > target) {//cek apakah nilai dari array dengan index nilai tengah lebih dari nilai target
                right = middle - 1;//set nilai left dengan nilai middle -1
            }
        }
    }
}