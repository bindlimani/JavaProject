import javax.swing.*;
import java.awt.*;

class OutputView extends JPanel
{  Model model;
   InputView input;
   public OutputView()
   {
      model = Controller.model;
      input = Controller.input;
      JFrame frame = new JFrame();
      frame.setSize(450,450);
      frame.setVisible(true);
      frame.getContentPane().add(this);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   /*public void showInitialMoney(Graphics g)
   {
      g.drawString("Initial 2 Euro Coins:" + model.inEuro2, 250, 40);
      g.drawString("Initial 1 Euro Coins:" + model.inEuro1, 250, 60);
      g.drawString("Initial 50 Cent Coins:" + model.inCent50, 250, 80);
      g.drawString("Initial 20 Cent Coins:" + model.inCent20, 250, 100);
      g.drawString("Initial 10 Cent Coins:" + model.inCent10, 250, 120);
      g.drawString("Initial 5 Cent Coins:" + model.inCent5, 250, 140);
   }
   */
   private void showInsertedMoney(Graphics g)
   {
      g.drawString("Inserted 2 Euro Coins:" + input.euro2, 20,40);
      g.drawString("Inserted 1 Euro Coins:" + input.euro1, 20,60);
      g.drawString("Inserted 50 Cent Coins:" + input.cent50, 20,80);
      g.drawString("Inserted 20 Cent Coins:" + input.cent20, 20,100);
      g.drawString("Inserted 10 Cent Coins:" + input.cent10, 20,120);
      g.drawString("Inserted 5 Cent Coins:" + input.cent5, 20,140);
   }
   
   private void showTotalInCoins(Graphics g)
   {
      g.drawString("Total 2 Euro Coins:" + model.euro2, 20, 160);
      g.drawString("Total 1 Euro Coins:" + model.euro1, 20, 180);
      g.drawString("Total 50 Cent Coins:" + model.cent50, 20, 200);
      g.drawString("Total 20 Cent Coins:" + model.cent20, 20, 220);
      g.drawString("Total 10 Cent Coins:" + model.cent10, 20, 240);
      g.drawString("Total 5 Cent Coins:" + model.cent5, 20, 260);
   }
   
    private void showChangeInCoins(Graphics g)
   {
      g.drawString("Change left in 2 Euro Coins:" + model.changeEuro2, 20, 240);
      g.drawString("Change left in 1 Euro Coins:" + model.changeEuro1, 20, 260);
      g.drawString("Change left in 50 Cent Coins:" + model.changeCent50, 20, 280);
      g.drawString("Change left in 20 Cent Coins:" + model.changeCent20, 20, 300);
      g.drawString("Change left in 10 Cent Coins:" + model.changeCent10, 20, 320);
      g.drawString("Change left in 5 Cent Coins:" + model.changeCent5, 20, 340);
   }
   public String formatMoney(int a)
   {
      String s = (a/100)+"€"+(a%100)+"c";
      return s;
   }
   
   private void kuponi(Graphics g)
   {
      g.drawString("Kuponi fiskal",265,210);
      g.drawString(input.coffeeQuantity + " cups of coffee" + "    " + model.COFFEEPRICE+"c",265,240);
      g.drawString("=" + formatMoney(input.coffeeQuantity*model.COFFEEPRICE),265,260);
      g.drawString(input.teaQuantity + " cups of tea" + "    " + model.TEAPRICE+"c",285,290);
      g.drawString("=" + formatMoney(input.teaQuantity*model.TEAPRICE),265,310);
      g.drawString("Your total is " + formatMoney(model.payment),265,330);
      g.drawString("Your change is " + formatMoney(model.change),265,350);
      g.drawString("Have a nice day!",265,370);
   }
   
   public void paintComponent(Graphics g)
   {  g.setColor(Color.white);
      g.fillRect(0,0,400,400);
      g.setColor(Color.black);
      //g.drawLine(0,145,400,145);
      g.drawRect(250,180,150,200);
      kuponi(g);
      g.drawString("Coffee left: " + model.coffeeLeft, 20, 360);
      g.drawString("Tea left: " + model.teaLeft, 20, 380);
      g.drawString("Your ordered:" + input.coffeeQuantity + " cups of coffee and " + input.teaQuantity + " cups of tea.",20,20);
      g.drawString("Coffee price: " + model.COFFEEPRICE + "c",280,80);
      g.drawString("Tea price: " + model.TEAPRICE + "c",280,100);
      showInsertedMoney(g);
      showChangeInCoins(g);
   }
}