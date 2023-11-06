package servlet.model.vo;

public class Criteria {
	private int page;
	private int amount;
	
	public Criteria() {
		this(1, 30);
	}

	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}

