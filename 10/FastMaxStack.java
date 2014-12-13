public class FastMaxStack<T> implements MaxStack<T> {

  private final Maximizer<T> maximizer;
  private ListNode<T> top;
  private FastMaxStack<T> max;

  public SlowMaxStack(Maximizer<T> maximizer) {
    this.maximizer = maximizer;
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }

  @Override
  public void push(T value) {
    top = top.pushValue(value);

    if(max.isEmpty()){
      max.push(value);
    }else{
      if(maximizer.getMax(max.top, top).equals(top)){
        max.pop();
        max.push(value);
      }
    }
  }

  @Override
  public T pop() {
    T value = top.value;
    top = top.next;
    return value;
  }

  @Override
  //the big O is n
  stack a;
  public T getMaxSoFar() {
    return max.top;
  }

}