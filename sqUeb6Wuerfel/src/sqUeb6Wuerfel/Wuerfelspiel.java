package sqUeb6Wuerfel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
public class Wuerfelspiel 
{

/** MaDeng
 * @pdOid a099daf7-b926-4e81-9eaf-8bdb665d66b2 */

   
   private int punktWiily;
  
   private int punktBernd;
   
   private WuerfelCountArray[] arryWuerfel;
 
   
   public WuerfelCountArray[] getArryWuerfel() {
	return arryWuerfel;
}

final static int NumberRound= 10;
   private int roundNow;
   
   
   public int wuerfelEinMal(){
	   int n;
	   n = (int)(Math.random()*6+1);
       return n;
   }
   
   //TODO hier n <= 6
   public WuerfelCountArray[] instalNeuArray(int n)
   {
	   WuerfelCountArray[] arr= new WuerfelCountArray[n];
	   for(int i = 0; i <= arr.length-1; i++)
	   {
		   arr[i] = new WuerfelCountArray(false,0);
	   }
	   this.arryWuerfel = arr;
	   return arr;
   }
   
   public WuerfelCountArray[] wuerfeln()
   {
	   for(int i = 0; i <= arryWuerfel.length-1; i++)
	   {
		   arryWuerfel[i].setWert(wuerfelEinMal());
	   }
	   return arryWuerfel;
   }
   
  
   public String changPlayer(String player) throws IOException {
      // TODO: implement
	   boolean b = istBeendet();
	   if(b)
	   return nextPlayer(player);
	return player;
	   
   }
   
   public String nextPlayer(String player)
   {
	   if(player =="Wiily")
		   return "Bernd";
	   return "Wiily";
   }
   
   public boolean istBeendet() throws IOException
   {
	   System.out.println("willst du Beenden");
	   char ch = (char)System.in.read();  
	   if(ch == 'y')
		   return true;
	   return false;
   }
   
   //TODO hier ist bis 04062016 getestet
   public int countPunktGesamtInEinRund()
   {
	   int sum =0;
	   if(isPunktVerlieren(arryWuerfel))
	   {
		   sum = countPunktFixtiert() + countPunktWithThree();
	   }
	   System.out.println("GesamtInEinRund is " +sum);
	   return sum;
	  
   }
  
   public int countGesamtPunkt( int punktGesamt) {
     int sum;
     sum = countPunktGesamtInEinRund();
     sum += punktGesamt; 
     return sum;
   }
   
  
   public int countPunktFixtiert() {
      // TODO: implement
	   int sum = 0;
	   for(int i = 0; i <= arryWuerfel.length-1; i++)
	   {
		  if(arryWuerfel[i].isFixieren() == true)
			 switch (arryWuerfel[i].getWert())
			 {
			 	case 1: sum += 100;
			 	case 5: sum += 50;
			 }
	   }
	  System.out.println("countPunktFixtiert is " +sum);
	  return sum;
   }
   
   public int countPunktWithThree()
   {
	   int count1 =0;
	   int count5 =0;
	   int j=0;
	   for(int i = 0; i <= arryWuerfel.length-1; i++)
	   {
		  if(arryWuerfel[j].isFixieren() == false)
			   if(arryWuerfel[j].getWert() == 1)
				   count1 +=1;
		  if(arryWuerfel[j].getWert() == 5)
			   count1 +=5;
		  j++;
	   }
	   if(count1 >= 3) return 1000;
	   if(count5 >= 3) return 500;
	return 0;
   }
   
   
   
   
   
   
   public void changeDieStatus(int position) throws IOException {
	  	  System.out.println("do you want : " + arryWuerfel[position].getWert() + " fixieren");
		  System.out.println("hierWaite ");
		  
		  Scanner s = new Scanner(System.in);
		  String a = s.nextLine();
		  if(a.equals("yes")){
				  arryWuerfel[position].setFixieren(true);
				  System.out.println("fixieren next ");	  
		  }
		  else
		  {
			arryWuerfel[position].setFixieren(false);
		  	System.out.println("not fixieren next ");
		  	System.out.println(a);
		  }
		  return;
   }
	   
      
   
   
   public void changeDieStatusInEinRund() throws IOException {
		  printAktuellPunkt();
		  for(int i = 0; i <= arryWuerfel.length-1; i++)
		  {
			  changeDieStatus(i);
		  }
		 
	      return;
   }
   
   /*
   public void changeDieStatus() throws IOException {
	  printAktuellPunkt();
	  for(int i = 0; i <= arryWuerfel.length-1; i++)
	  {
		  System.out.println("do you want : " + arryWuerfel[i].getWert() + " fixieren");
		  
		  System.out.println("hierWaite ");
		  Scanner s = new Scanner(System.in);
		  String a = s.nextLine();
		  if(a.equals("yes")){
				  arryWuerfel[i].setFixieren(true);
				  System.out.println("fixieren next ");	  
		  }
		  else
		  {
			arryWuerfel[i].setFixieren(false);
		  	System.out.println("not fixieren next ");
		  	System.out.println(a);
		  }
		  
	  }
	   
      return;
   }
   */
  
   public void addZuKonton(int punktGesamt, String player) throws IOException
   {
	   if(isPunktVerlieren(arryWuerfel) && istBeendet())
	   {
		   switch (player)
		   {
		   		case "Willy":
		   			this.punktWiily =+ this.countGesamtPunkt( punktGesamt);
		   			return;
		   			
		   		case "Bernd":
		   			this.punktBernd =+ this.countGesamtPunkt( punktGesamt);
		   			return;
		   			
		   }
	   }	
   }
   
   
   public boolean isPunktVerlieren(WuerfelCountArray[] arr) {
	   int j=0;
	   for(int i = 0; i <= arr.length-1; i++)
	   {
		  if(arr[j].isFixieren() == false)
			  if(arr[j].getWert() == 5 || arr[j].getWert() == 1)
				  return false;
	   }			   	  
      return true;
   }
   
  
   public void punktKontonLeer() {
      this.punktBernd = 0;
      this.punktWiily = 0;
   }
   
   
   public void printAktuellPunkt() 
   {
	  System.out.println("punktWiily ist :" + this.punktWiily + "punktBernd ist:"+this.punktBernd); 
	  System.out.println("arryWuerfel ist");
	  for(int i = 0; i <= arryWuerfel.length-1; i++)
	   {
		  System.out.println(arryWuerfel[i].getWert());
	   }
   }
   public void printAktuellFixSituation()
   {
	   System.out.println("fixieren Situation now is:  ");
	   for(int i = 0; i <= arryWuerfel.length-1; i++)
	   {
		   if(arryWuerfel[i].isFixieren() == true)
			   System.out.println("position "+ i +" " +
					   				arryWuerfel[i].getWert() +"  is Fix !");
	   }			   	  
   }
   
   
   public void roundLaufen()
   {
	   roundNow +=1;
   }
 
   public boolean entScheideObBeendet() 
   {
      if(NumberRound - roundNow == 0)
      return true;
	return false;
   }

}
