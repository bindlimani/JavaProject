import javax.swing.*;

class InputView
{  
   Model model;
   OutputView output;
   //Ne konstruktor i jepim adresen e njejte model dhe Controller.model
   public InputView()
   {model=Controller.model;}
   
   int euro2,euro1,cent50,cent20,cent10,cent5,cent2,cent1;
   int coffeeQuantity,teaQuantity;
   
   
   public void insertMoney()
   {
      try{
         euro2 = Integer.parseInt(JOptionPane.showInputDialog("Write the amount of 2 euro coins:").trim());    
         euro1 = Integer.parseInt(JOptionPane.showInputDialog("Write the amount of 1 euro coins:").trim());
         cent50 = Integer.parseInt(JOptionPane.showInputDialog("Write the amount of 50 cent coins:").trim());
         cent20 = Integer.parseInt(JOptionPane.showInputDialog("Write the amount of 20 cent coins:").trim());
         cent10 = Integer.parseInt(JOptionPane.showInputDialog("Write the amount of 10 cent coins:").trim());
         cent5 = Integer.parseInt(JOptionPane.showInputDialog("Write the amount of 5 cent coins:").trim());
         if(euro2<0 || euro1<0 || cent50<0 || cent20<0 || cent10<0 || cent5<0)
         {JOptionPane.showMessageDialog(null,"Please do not write negative values.");
            insertMoney();
         } 
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, "Please write a valid numerical value."); insertMoney();}
      Controller.output.repaint();
   }
    
   public void printCheckMoney()
   {
      if(model.checkMoney()==false)
      {JOptionPane.showMessageDialog(null,"You dont have enough money");}
   }
   
   public void insertCoffeeQuantity()
   {  
      try{
         coffeeQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many cups of coffee do you want?").trim());
         if(coffeeQuantity<0)
         {JOptionPane.showMessageDialog(null,"Please write a non negative value");insertCoffeeQuantity();}
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, "Please write a valid value");
         insertCoffeeQuantity();}
      
      model.toPay();
      if(model.checkCoffeeQuantity() == true && model.checkMoney()==true)
      {
         printCheckMoney();
         Controller.output.repaint();
      }
      else if(model.checkCoffeeQuantity() == true && model.checkMoney()==false)
      {JOptionPane.showMessageDialog(null, "You dont have enough money. Please take back the money you inserted."); transferToChange();coffeeQuantity=0;
         String again = JOptionPane.showInputDialog("Do you want to try again?"); 
         again = again.toLowerCase(); again = again.trim();
         if(again.equals("yes")){startAgain();} 
         else{System.exit(0);}
                     
      }
      else
      {JOptionPane.showMessageDialog(null, "There is not enough coffee left.");
         insertCoffeeQuantity();;}
   }
   
   public void insertTeaQuantity()
   {
      try{
         teaQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many cups of tea do you want?").trim());
         if(teaQuantity<0)
         {JOptionPane.showMessageDialog(null, "Please write a non negative value.");
            insertTeaQuantity();}
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null, "Please write a valid value.");insertTeaQuantity();}
      model.toPay();
      if(model.checkTeaQuantity() == true && model.checkMoney()==true)
      {  
         printCheckMoney();
         Controller.output.repaint();
      }
      else if(model.checkTeaQuantity() == true && model.checkMoney()==false)
      {JOptionPane.showMessageDialog(null, "You dont have enough money. Please take back the money you inserted."); transferToChange(); teaQuantity=0;
         String start_again = JOptionPane.showInputDialog("Do you want to try again?"); 
         start_again = start_again.toLowerCase(); start_again = start_again.trim();
         if(start_again.equals("yes")){startAgain();} 
         else{System.exit(0);}
      }
      else
      {JOptionPane.showMessageDialog(null, "There is not enough tea left.");
         insertTeaQuantity();}
   }
   
   public void order()
   {
      String s = JOptionPane.showInputDialog("What do you want to order?Coffee or tea?");
      s = s.toLowerCase(); s = s.trim();
      if(s.equals("coffee"))
      {System.out.println("Coffee");
         insertCoffeeQuantity();
         System.out.println(model.payment);
         nextStep();
      }
      else if (s.equals("tea"))
      {System.out.println("Tea");
         insertTeaQuantity();
         nextStep();
      }
      else
      {JOptionPane.showMessageDialog(null, "The product you asked for \n is not found.");
         order();}
   }
   
   public void startAgain()
   {
      model.reset();
      insertMoney();
      model.sumOfMoney();
      order();
   }
   
   public void nextStep()
   {
      String next = JOptionPane.showInputDialog("Your order was completed. \n Do you want to order, finish, reset or leave?");
      next = next.toLowerCase(); next = next.trim();
      if(next.equals("order")){order();}
      else if(next.equals("finish"))
      {  
         if(model.checkMoney()==true)
         {  
            model.pay();
            model.coffeeLeft -= coffeeQuantity;
            model.teaLeft -= teaQuantity;
            JOptionPane.showMessageDialog(null, "Please take your change.You have " + Controller.output.formatMoney(model.change) + " left");
         }
         else
         {JOptionPane.showMessageDialog(null, "You dont have enough money.");nextStep();}
         
      }
      else if(next.equals("reset"))
      {  
         JOptionPane.showMessageDialog(null, "Please take your money back");
         transferToChange();
         startAgain();
      }
      else if(next.equals("leave"))
      {
         transferToChange();
         Controller.output.repaint();
         JOptionPane.showMessageDialog(null, "Please take your money back.");
         model.reset();
      }
      else
      {
         JOptionPane.showMessageDialog(null, "You didnt choose any option.");
         nextStep();
      }
      Controller.output.repaint();
   }
   
   public void transferToChange()
   {
      model.changeEuro2 = euro2; euro2=0;
      model.changeEuro1 = euro1; euro1=0;
      model.changeCent50 = cent50; cent50=0;
      model.changeCent20 = cent20; cent20=0;
      model.changeCent10 = cent10; cent10=0;
      model.changeCent5 = cent5; cent5=0;
      Controller.output.repaint();
   }
   
}
