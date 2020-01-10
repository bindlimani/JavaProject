class Controller
{  public static Model model;
   public static InputView input;
   public static OutputView output;
   public static void main(String[] args)
   {  model = new Model();
      input = new InputView();
      output = new OutputView();
      model.init(input);
      input.insertMoney();
      model.sumOfMoney();
      input.order();
   }
}