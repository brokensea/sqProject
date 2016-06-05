package sqUeb6WuerfelTest;

import java.io.IOException;

import sqUeb6Wuerfel.WuerfelCountArray;
import sqUeb6Wuerfel.Wuerfelspiel;

public class NormalMainTest 
{
	private WuerfelCountArray[] arryWuerfel;
	public static void main(String []args) throws IOException
	{
		  Wuerfelspiel wur = new Wuerfelspiel();
		  wur.instalNeuArray(6);
		  wur.printAktuellPunkt();
		  
		  
		  wur.wuerfeln();
		  wur.printAktuellPunkt();
		  wur.changeDieStatusInEinRund();
		  
		  
		  wur.printAktuellFixSituation();
		  
		  //TODO Die Code funktioniert bis countPunktFixtiert

		  
		  wur.countPunktGesamtInEinRund();
		  wur.countGesamtPunkt(0);
		  
		  wur.countPunktFixtiert();
		  
		  wur.addZuKonton( 0, "Willy");
		  wur.printAktuellPunkt();
		  
	}

}
