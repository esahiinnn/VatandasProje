package vatandasProjeBilal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vatandas {
	static Scanner scan = new Scanner(System.in);
	static Map<Integer, VatandasBilgileri> arsiv = new HashMap<>();
	
	/*
	 saveInfo() method olusturun:
	 1)Kullanicidan bircok kimlik numarasi(4 haneli), isim, adres ve telefon alin.
	 2)Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin.
	 3)Ayni kimlik numarasi ile bilgi girilmesine engel olun.
​
	 getInfo() method olusturun:
	 1)Kimlik numarasini girerek kullanicinin bilgilerine ulasin.
	 2)Olmayan kimlik numarasi girilirse kullaniciya hata mesaji verin.
​
	 removeInfo() method olusturun:
	 1)Kimlik numarasini girerek data silin.
	 2)Girilen kimlik numarasi yoksa kullaniciya hata mesaji verin.
	 3)Collection bos ise kullaniciya hata mesaji verin.
​
	 selectOption() method olusturun:
	 1)Yukaridaki 3 methodu programi sonlandirana kadar secme hakki verin
	*/
	
	public void selectOption() {
		
		System.out.println("Lutfen yapmak istediginiz islemi seciniz");
		System.out.println("====== SECIM PANELI ======");
		System.out.println("1- EKLE");
		System.out.println("2- GORUNTULE");
		System.out.println("3- SIL");
		System.out.println("Q- CIKIS");
		String key = scan.next().toUpperCase();
		
		switch (key) {
			case "1":
				saveInfo();
				selectOption();
				break;
			case "2":
				getInfo();
				break;
			case "3":
				removeInfo();
				break;
			case "Q":
				System.out.println("Iyi gunler dileriz");
				break;
			default:
				System.out.println("Yanlis secim yaptiniz lutfen yeniden deneyin");
			break;
		}
	}
	
	public void saveInfo(){
		Scanner scan = new Scanner(System.in);
		System.out.println("4 haneli kimlik numaranizi giriniz");
		int kimlikNo = scan.nextInt();
		
		int count=0;
		if (arsiv.containsKey(kimlikNo)) {
			System.out.println("Girdiginiz kimlik numarasi zaten kayitlidir");
			count++;
			saveInfo();
			if (count==3) {
				System.out.println("3 kez yanlis giris yaptiniz ");
				
			} 
			
		} else {
			scan.nextLine();
			
			System.out.println("Lutfen sirasiyla isim ve soyisminizi giriniz");
			String isim = scan.nextLine();
			
			
			System.out.println("Lutfen adresinizi giriniz");
			String adres = scan.next();
			
			System.out.println("Lutfen telefonunuzu giriniz");
			String telNo= scan.next();
			
			VatandasBilgileri vatandas = new VatandasBilgileri(isim, adres, telNo);
			arsiv.put(kimlikNo, vatandas);
		}
		
	}
	
	public void getInfo() {
		
		System.out.println("Lutfen kimlik numarinizi girin");
		int kimlikNo = scan.nextInt();
		if (arsiv.containsKey(kimlikNo)) {
			System.out.println(kimlikNo + " kimlik numarali kisinin bilgileri " + arsiv.get(kimlikNo));
		} else {
			System.out.println("Yanlis bir kimlik numarasi girdiniz");
		}	
		selectOption();
	}
	
	public void removeInfo() {
		System.out.println("Lutfen silmek istediginiz kimlik numaranizi giriniz");
		int kimlikNo = scan.nextInt();
		if (arsiv.containsKey(kimlikNo)) {
			arsiv.remove(kimlikNo);
			System.out.println("Silme isleminiz basariyla gerceklestirilmistir");
		} else if(arsiv.isEmpty()){
			System.out.println("Hicbir kayit bulunamamaktadir");
		} else {
			System.out.println("Girdiginiz kimlik numarasina dair bir kayit bulunamamaktadir");
		}
		selectOption();
	}
		
}
