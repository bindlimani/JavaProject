/**Klasa Model permban metodat qe merren me perpunimin e te dhenave */
class Model 
{  //Po krijojme nje objekt inputview qe ka adrese te njejt me ate qe eshte krijuar nga Controller
   InputView input;
   /** Te githe sasite e monedhave qe kane qene ne fillim ne aparat */
   private int inEuro2,inEuro1,inCent50,inCent20,inCent10,inCent5;
   private int initialMoney;
   int euro2,euro1,cent50,cent20,cent10,cent5;
   int total;
   int changeEuro2,changeEuro1,changeCent50,changeCent20,changeCent10,changeCent5,p;
   /** Sasia e kafes dhe qajit ne aparat */
   int coffeeLeft = 25;
   int teaLeft = 14;
   final int COFFEEPRICE = 50;
   final int TEAPRICE = 40;
   //Moneyinserted shuma e monedhave nga inputview total initialMoney+moneyInserted, payment sa duhet paguar dhe change=moneyinserted-payment
   int moneyInserted;
   int payment;
   int change;
   public Model()
   {  //Po i japim disa vlera fillestare te sasie se monedhave qe i ka aparati
      inEuro2 = 4; inEuro1=1; inCent50 = 12; inCent20 = 4; inCent10 = 15; inCent5 = 9;
      //Llogaritet shuma e tyre
      initialMoney = 200*inEuro2 + 100*inEuro1 + 50*inCent50 + 20*inCent20 + 10*inCent10 + 5*inCent5;
   }
   
   public void init(InputView v)
   {input=v;}
   
   //checkCoffeeQuantity shikon se a ka sasi te mjaftueshme te kafes aparati dhe kthen true apo false
   
   public void sumOfMoney()
   {
      euro2 = inEuro2 + input.euro2;
      euro1 = inEuro1 + input.euro1;
      cent50 = inCent50 + input.cent50;
      cent20 = inCent20 + input.cent20;
      cent10 = inCent10 + input.cent10;
      cent5 = inCent5 + input.cent5;
      //Llogariet shuma e monedhave totale dhe i shoqerohet ndryshores total
      moneyInserted = 200*input.euro2 + 100*input.euro1 + 50*input.cent50 + 20*input.cent20 +10*input.cent10 + 5*input.cent5;
      total = initialMoney + moneyInserted;
   }
   
   public boolean checkCoffeeQuantity()
   {
      if(input.coffeeQuantity<=coffeeLeft)
      {return true;}
      else
      {return false;}
   }
   
   public boolean checkTeaQuantity()
   {
      if(input.teaQuantity<=teaLeft)
      {return true;}
      else
      {return false;}
   }
   
   public boolean checkMoney()
   {
      if(moneyInserted>=payment)
      {return true;}
      else
      {return false;}
   }
   
   public void toPay()
   {
      payment = COFFEEPRICE*input.coffeeQuantity + TEAPRICE*input.teaQuantity;
   }
   
   public void pay()
   {
      change = moneyInserted - payment;
      p=change;
      changeEuro2 = p/200;
      p=p%200;
      changeEuro1 = p/100;
      p=p%100;
      changeCent50 = p/50;
      p=p%50;
      changeCent20 = p/20;
      p=p%20;
      changeCent10 = p/10;
      p=p%10;
      changeCent5 = p/5;
      p=p%5;
      euro2 -= changeEuro2; euro1 -= changeEuro1; cent50 -= changeCent50;
      cent20 -= changeCent20; cent10 -= changeCent10; cent5 -= changeCent5;
   }
   
   public void reset()
   {
      input.euro2=0;input.euro1=0;input.cent50=0;input.cent20=0;input.cent10=0;input.cent5=0;
      changeEuro2=0;changeEuro1=0;changeCent50=0;changeCent20=0;changeCent10=0;changeCent5=0;
      total -= moneyInserted;
      moneyInserted = 0;
      payment = 0;
   }
   
   public void transferToChange()
   {
      changeEuro2 = euro2; euro2=0;
      changeEuro1 = euro1; euro1=0;
      changeCent50 = cent50; cent50=0;
      changeCent20 = cent20; cent20=0;
      changeCent10 = cent10; cent10=0;
      changeCent5 = cent5; cent5=0;
      Controller.output.repaint();
   }
   
}