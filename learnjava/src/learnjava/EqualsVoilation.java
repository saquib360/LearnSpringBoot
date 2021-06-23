package learnjava;

public class EqualsVoilation {

	public static void main(String[] args) {
		Money cash = new Money(42, "USD");
		WrongVoucher voucher = new WrongVoucher(42, "USD", "Amazon");

		System.out.println(voucher.equals(cash)); 
		System.out.println(cash.equals(voucher));

	}

}
class Money {
    int amount;
    String currencyCode;
    public Money(int i, String string) {
		System.out.println("avc");
	}
    public Money() {
    	System.out.println("defaultavc");
	}
	@Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Money))
            return false;
        Money other = (Money)o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
          || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
        return this.amount == other.amount && currencyCodeEquals;
    }
}
class WrongVoucher extends Money {

    private String store;

    public WrongVoucher(int i, String string, String string2) {
    	System.out.println("wrong");
	}
    public WrongVoucher() {
    	System.out.println("Defaultwrong");
    	
	}


	@Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WrongVoucher))
            return false;
        WrongVoucher other = (WrongVoucher)o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
          || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
        boolean storeEquals = (this.store == null && other.store == null)
          || (this.store != null && this.store.equals(other.store));
        return this.amount == other.amount && currencyCodeEquals && storeEquals;
    }

    // other methods
}