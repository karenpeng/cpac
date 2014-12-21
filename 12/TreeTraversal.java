public class TreeTraversal
//demonstrates three traversal methods
//preorder
//inorder
//postorder

{
  public static void main(String [] args)
  {
    // Tree t = new Tree();
    // t.build();
    // System.out.println("preorder traversal");
    // t.prefix();
    // System.out.println("inorder traversal");
    // t.infix();
    // System.out.println("postorder traversal");
    // t.postfix();
  }
}

class Node
{
  Node left;
  Node right;
  Object element;

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
    t.left = new Node(o);
  }

  private void rightChild(Node t, Object o)
  //create a right child for node t
  {
    t.right = new Node(o);
  }

  public void build(Node t)
  {
    root = t;
  }

  public void prefix()  //used as a driver for real prefix method
  {
    prefix(root);
    System.out.println();
  }

  private void prefix(Node t)
  {
    if(t != null)
    {
      System.out.print(t);
      prefix(t.left);
      prefix(t.right);
    }
  }

  public void infix()  //used as a driver for real prefix method
  {
    infix(root);
    System.out.println();
  }

  private void infix(Node t)
  {
    if(t != null)
    {
      infix(t.left);
      System.out.print(t);
      infix(t.right);
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
    if(t.left == null)
      return Double.parseDouble((String)t.element);
    else
    {
      double left = evaluate (t.left);
      double right = evaluate (t.right);
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
      case '^':
        return Math.pow(left, right);
      }
    }
    return 0.0;  //we will never get here

  }

}
