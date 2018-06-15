//Andrew McKeown
package programming3_assignment3;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -969790865390877752L;
	private String name;
	private int accNum;
	private double credLim;
	
	public Account(String nm, int num, double lim){
		this.setName(nm);
		this.setAccNum(num);
		this.setCredLim(lim);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public double getCredLim() {
		return credLim;
	}

	public void setCredLim(double credLim) {
		this.credLim = credLim;
	}
	
	public String toString(){
		return name+" has account number "+accNum+" and credit limit of �"+credLim;
	}
}
