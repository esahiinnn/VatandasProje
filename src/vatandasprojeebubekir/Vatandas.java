package vatandasprojeebubekir;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Vatandas {
    Map<Integer, VatandasBilgileri> vatandaslar = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    /*
		 saveInfo() method olusturun:
		 1)Kullanicidan bircok kimlik numarasi(4 haneli), isim, adres ve telefon alin.
		 2)Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin.
		 3)Ayni kimlik numarasi ile bilgi girilmesine engel olun.

		 getInfo() method olusturun:
		 1)Kimlik numarasini girerek kullanicinin bilgilerine ulasin.
		 2)Olmayan kimlik numarasi girilirse kullaniciya hata mesaji verin.

		 removeInfo() method olusturun:
		 1)Kimlik numarasini girerek data silin.
		 2)Girilen kimlik numarasi yoksa kullaniciya hata mesaji verin.
		 3)Collection bos ise kullaniciya hata mesaji verin.

		 selectOption() method olusturun:
		 1)Yukaridaki 3 methodu programi sonlandirana kadar secme hakki verin
		*/


        /*
        saveInfo() method olusturun:
		 1)Kullanicidan bir kimlik numarasi(4 haneli), isim, adres ve telefon alin.
		 2)Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin.
		 3)Ayni kimlik numarasi ile bilgi girilmesine engel olun.
         */
        public void saveInfo(){
            int count = 0;

            System.out.println("Lutfen kimlik numaranizi giriniz");
            int kimlikNo = scan.nextInt();
            if(vatandaslar.containsKey(kimlikNo)){
                System.out.println("Girdiginiz kimlik numarasi mevcut lutfen baska bir kimlik numarasi giriniz");
                count++;
                if(count == 3){
                    System.out.println("3 defa hatali giris yaptiniz hesabiniz bloke oldu");
                }else{
                    saveInfo();
                }
            }else{
                System.out.println("Lutfen Isim ve Soyisminizi giriniz");
                String isimSoyisim = scan.nextLine();
                System.out.println("Lutfen adres'inizi giriniz");
                String adres = scan.next();
                System.out.println("Lutfen telefon numaranizi giriniz");
                String telefonNo = scan.next();

                VatandasBilgileri vatandas = new VatandasBilgileri(isimSoyisim, adres, telefonNo);
                vatandaslar.put(kimlikNo, vatandas);
            }

        }

        /*
            getInfo() method olusturun:
            1)Kimlik numarasini girerek kullanicinin bilgilerine ulasin.
            2)Olmayan kimlik numarasi girilirse kullaniciya hata mesaji verin.
         */
        public void getInfo(){
            System.out.println("Lutfen bilgisini gormek istediginiz kisinin kimlik numarasini giriniz");
            int kimlikNumarasi = scan.nextInt();
            if(vatandaslar.containsKey(kimlikNumarasi)){
                System.out.println(vatandaslar.get(kimlikNumarasi));
            }else{
                System.out.println("Girdiginiz kimlik numarasi mevcut degildir lutfen tekrar deneyiniz");
                getInfo();
            }
        }


        /*
        removeInfo() method olusturun:
		 1)Kimlik numarasini girerek data silin.
		 2)Girilen kimlik numarasi yoksa kullaniciya hata mesaji verin.
		 3)Collection bos ise kullaniciya hata mesaji verin.
         */
        public void removeInfo(){
            int count = 0;
            do{
            System.out.println("Lutfen silmek istediginiz kisinin kimlik numarasini giriniz");
            int kimlikNo = scan.nextInt();

            if(vatandaslar.containsKey(kimlikNo)){
                vatandaslar.remove(kimlikNo);
                System.out.println("Girdiginiz kimlik numarasina sahip olan kisinin bilgileri basariyla silinmistir!");
                break;
            }else{
                count++;
                if(count == 3){
                    System.out.println("3 defa hatali giris yaptiniz hesabiniz bloke oldu");
                    break;
                }else{
                    System.out.println("Girdiginiz kimlik numarasi mevcut degildir lutfen tekrar deneyiniz");
                }

            }

        }while(true);


    }
}
