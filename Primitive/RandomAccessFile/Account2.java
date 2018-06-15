//Andrew McKeown
package package2;

import java.io.IOException;
import java.io.Serializable;

public class Account2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -158888326395424592L;
	private String name;
	private int accNum;
	private double credLim;
	
	public Account2(String nm, int num, double lim){
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
	//custom WriteObject
	private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(name);
        stream.writeInt(accNum);
        stream.writeDouble(credLim);
    }
    //custom readObject
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        name = (String) stream.readObject();
        accNum = stream.readInt();
        credLim = stream.readDouble();
    }
}

