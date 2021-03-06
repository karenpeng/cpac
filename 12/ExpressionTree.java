public class ExpressionTree
//creates an expression tree
//prints infix expression
//prints postfix expression
//evaluates the expression (postorder)
{
  public static void main(String [] args)
  {
    // Tree expressionTree = new Tree();
    // expressionTree.build();
    // System.out.println("inorder traversal");
    // expressionTree.infix();
    // System.out.println("postorder traversal");
    // expressionTree.postfix();
    // System.out.println ("evaluates to: " + expressionTree.evaluate());
  }
}

class Node
{
  Object element;
  Node left;
  Node right;

  public Node (Object o)
  {
    this (o, null, null);
  }

  public Node (Object o, Node l, Node r)
  {
    element = o;
    left = l;
    right = r;
  }

  public String toString()
  {
    return "" + element;
  }
}

class Tree
{

  private Node root;

  public Tree ()
  {
    root = null;
  }

  private void leftChild(Node t, Object o)
  //create a left child for node t
  {
    t.left =  new Node(o);
  }

  private void rightChild(Node t, Object o)
  //create a right child for node t
  {
    t.right =  new Node(o);
  }

  public void build(Node t)
  {
    root =  t;
  }

  public void infix()  //used as a driver for real infix method
  {
    infix(root);
    System.out.println();
  }

  private void infix(Node t)
  {
    if(t.left != null)  //assume all operators are binary operands
    {
      System.out.print("(");
      infix(t.left);
    }
    System.out.print(t );
    if(t.left != null)  //assume all operators are binary operands
    {
      infix(t.right);
      System.out.print(")");
    }
  }

  public void postfix()  //used as a driver for real postfix method
  {
    postfix(root);
    System.out.println();
  }

  private void postfix(Node t)
  {
    if(t != null)
    {
      postfix(t.left);
      postfix(t.right);
      System.out.print(t);
    }
  }

  public double evaluate()
  {
    return evaluate(root);
  }

  private double evaluate(Node t)
  {
    // if(t.element instanceof String){
    //   System.out.print("ouch");
    // }
    char tt = ((String)t.element).toCharArray();
    if(t.left == null)  //assume binary operators
      return tt - '0';
    else
    {
      double left = evaluate (t.left);
      double right = evaluate (t.right);
      switch (tt)
      {
      case '+':
        return left + right;
      case '-':
        return left - right;
      case '*':
        return left * right;
      case '/':
        return left / right;
      case '^':
        return Math.pow(left, right);
      }
    }
    return 0.0;  //we will never get here
  }

  public int evaluate()
  {
    return evaluate(root);
  }

  private int evaluate(Node t)
  {
    if(t.left == null)
      return Double.parseDouble((String)t.element);
    else
    {
      int left = evaluate (t.left);
      int right = evaluate (t.right);
      switch (((String)t.element).toCharArray()[0])
      {
      case '+':
        return left + right;
      case '-':
        return left - right;
      case '*':
        return left * right;
      case '/':
        return left / right;
      }
    }
    return 0;  //we will never get here

}

