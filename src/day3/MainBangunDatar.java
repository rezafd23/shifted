package day3;

public class MainBangunDatar {
    public static void main(String[] args) {
        BangunDatar bangunDatar = new BangunDatar();
        if (args[0].equalsIgnoreCase("1")) {
            bangunDatar.hitungLuas(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("2")) {
            bangunDatar.hitungLuas(Float.parseFloat(args[1]));
        } else if (args[0].equalsIgnoreCase("3")) {
            bangunDatar.hitungLuas(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else if (args[0].equalsIgnoreCase("4")) {
            bangunDatar.hitungUmur(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        }
    }
}
//}


