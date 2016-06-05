package sqUeb6Wuerfel;

public class WuerfelCountArray 
{
	private boolean isFixieren;
	private int wert;
	
	public WuerfelCountArray(boolean isFixieren, int wert) {
		this.isFixieren = isFixieren;
		this.wert = wert;
	}

	public boolean isFixieren() {
		return isFixieren;
	}

	public void setFixieren(boolean isFixieren) {
		this.isFixieren = isFixieren;
	}

	public int getWert() {
		return this.wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}
}
