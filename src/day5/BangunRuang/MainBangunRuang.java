package day5.BangunRuang;

public class MainBangunRuang {
    public static void main(String[] args) {
        BangunRuang ruang = new BangunRuang();
        ruang.setPanjang(12);
        ruang.setLebar(10);
        ruang.setTinggi(5);
        ruang.setJari(14);

        System.out.println("Volume Bangun Ruang");
        int volBalok = ruang.hitungVolume(ruang.getPanjang(),ruang.getLebar(),ruang.getLebar());
        System.out.println("Volume Balok "+volBalok);
        int volKubus = ruang.hitungVolume(ruang.getPanjang());
        System.out.println("Volume Kubus "+volKubus);
        double volBola = ruang.hitungVolume(ruang.getJari());
        System.out.println("Volume Bola "+volBola);
        System.out.println("============================");
        ruang.hitungSummary(volBalok,volKubus,volBola);
        ruang.hitungAverage(volBalok,volKubus,volBola);
    }
}
