package vatandasProjeBilal;

public class VatandasBilgileri {

	private String isim;
	private String adres;
	private String telefon;
	
	
	public VatandasBilgileri(String isim, String adres, String telefon) {
		this.isim = isim;
		this.adres = adres;
		this.telefon = telefon;
	}

	
	public String getIsim() {
		return isim;
	}
	
	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "isim = " + isim + ", adres = " + adres + ", telefon = "
				+ telefon ;
	}
	
	
}



