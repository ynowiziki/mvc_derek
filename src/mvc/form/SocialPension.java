package mvc.form;

import java.util.Date;

public class SocialPension extends SuperForm{
	private String name = "";
	private Date beginDate;
	private Date endData;
	private double totalPensionToDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SocialPension [name=" + name + ", beginDate=" + beginDate
				+ ", endData=" + endData + ", totalPensionToDate="
				+ totalPensionToDate + "]";
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndData() {
		return endData;
	}

	public void setEndData(Date endData) {
		this.endData = endData;
	}

	public double getTotalPensionToDate() {
		return totalPensionToDate;
	}

	public void setTotalPensionToDate(double totalPensionToDate) {
		this.totalPensionToDate = totalPensionToDate;
	}

}
