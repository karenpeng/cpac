public class Checkout{

  protected int size;
  protected DessertItem[] dessertItems;
  protected int amount;
  protected int sum;
  protected final double taxRate;

  Checkout(){
    size = 100;
    dessertItems = new DessertItem[size];
    amount = 0;
    sum = 0;
    taxRate = DessertShoppe.TAX_RATE;
  }

  public void enterItem(DessertItem d){
    dessertItems[amount] = d;
    amount ++;
  }

  public int numberOfItems(){
    return amount;
  }

  public int totalCost(){
    sum = 0;
    for(int i = 0; i < amount; i ++){
      sum += dessertItems[i].getCost();
    }
    return sum;
  }

  public int totalTax(){
    return (int)(Math.round(sum * taxRate / 100));
  }

  public void clear(){
    for(DessertItem d : dessertItems){
      d = null;
    }
    amount = 0;
    sum = 0;
  }

  public String toString(){
    String result = "Thank You! \n";

    result += DessertShoppe.STORE_NAME + "\n";

    result += "Purchase: ";

    String totalPay = DessertShoppe.cents2dollarsAndCents( totalCost()+totalTax() );
    if(totalPay.length() > DessertShoppe.COST_WIDTH){
      totalPay = totalPay.substring(0, DessertShoppe.COST_WIDTH);
    }
    result += "$" + totalPay;
    return result;
  }

}