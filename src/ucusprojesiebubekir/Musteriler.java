package ucusprojesiebubekir;

import java.util.*;

public class Musteriler {

    private String isimSoyisim;
    private String kullaniciAdi;
    private String sifre;
    protected static int ucusNumarasi = 1000;
    Scanner scan = new Scanner(System.in);
    HashMap<String, String> kullanicilar = new HashMap<>();


    public String getIsimSoyisim() {
        return isimSoyisim;
    }

    public void setIsimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public static int getUcusNumarasi() {
        return ucusNumarasi;
    }

    public static void setUcusNumarasi(int ucusNumarasi) {
        Musteriler.ucusNumarasi = ucusNumarasi;
    }

    public boolean kayitVarmi() {
        boolean flag = false;
        System.out.println("Lutfen kullanici adinizi giriniz");
        String username = scan.next();
        if (!kullanicilar.containsKey(username)) {
            System.out.println("Username hatali lutfen tekrar deneyiniz.");
            kayitVarmi();
        } else {
            System.out.println("Lutfen sifrenizi giriniz");
            String password = scan.next();
            if (kullanicilar.get(username).equals(password)) {
                System.out.println("Basariyla giris yaptiniz!");
                flag = true;
            } else {
                while (!kullanicilar.get(username).equals(password)) {
                    System.out.println("Hatali sifre tusladiniz lutfen tekrar deneyiniz");
                    password = scan.next();
                }
            }
        }
        return flag;
    }

    public void musteriKaydi() {
        System.out.println("Lutfen kayit olmak icin bir kullanici adi giriniz ve sifrenizi giriniz");
        String username = scan.next();
        //String password = scan.next(); 78 ile bağlantılı
        if (kullanicilar.containsKey(username)) {
            System.out.println("Girdiginiz username kayitli lutfen baska bir username giriniz");
            musteriKaydi();
        } else {
            kullanicilar.put(username, scan.next()); // 72 ve 78'den ziyade kisa bir yazilim sekli
            //kullanicilar.put(username, password);
            System.out.println("Kayit isleminiz basariyla tamamlanmistir.");
        }
    }


}
