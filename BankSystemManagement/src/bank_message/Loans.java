package bank_message;

public class Loans {
	
	private String loans;
	private int periods;
	private String money;
	
	
	
	public Loans(String loans, int periods, String money) {
		super();
		this.loans = loans;
		this.periods = periods;
		this.money = money;
	}
	
	
	public String getLoans() {
		return loans;
	}
	public void setLoans(String loans) {
		this.loans = loans;
	}
	public int getPeriods() {
		return periods;
	}
	public void setPeriods(int periods) {
		this.periods = periods;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Loans [loans=" + loans + ", periods=" + periods + ", money=" + money + "]";
	}
	
	

}
