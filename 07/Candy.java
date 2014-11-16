public class Candy extends DessertItem{

  protected double weight;
  protected static double pricePerPound;

  public Candy(String _n, double _ppp, int _w){
    super(_n);
    pricePerPound = _ppp;
    weight = _w;
  }

  public int getCost(){
    return  (int)Math.round(weight * pricePerPound);
  }
}