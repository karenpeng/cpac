import java.util.Scanner;

public class MakeTree{

  static Converter converter = new Converter();

  public static void main(String[] args){
    Scanner conIn = new Scanner(System.in);

    String line = null;          // string to be evaluated
    String more = null;          // used to stop or continue processing

    do
    {
      // Get next expression to be processed.
      System.out.println("Enter a infix expression to be evaluated: ");
      line = conIn.nextLine();

      // Obtain and output result of expression evaluation.
      try
      {

        LinkedStack<Token> postfix = converter.toPostFix(line);
        //System.out.println("converted to postfix: "+postfix);
        //double result = evaluate(postfix);
        make(postfix);
        //System.out.println("answer is: "+result);

      }
      catch (PostFixException error)
      {
        // Output error message.
        System.out.println();
        System.out.println("Error in expression - " + error.getMessage());
      }

      // Determine if there is another expression to process.
      System.out.println();
      System.out.print("Evaluate another expression? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();
    }
    while (more.equalsIgnoreCase("y"));

    System.out.println("Program completed.");
  }

  public static void make(LinkedStack<Token> expression){

    LinkedStack<Token> reverse = new LinkedStack<Token>();
    LLNode expressionNode = expression.top;
    while(expressionNode != null){
      Token wat = (Token)expressionNode.getInfo();
      reverse.push((Token)expressionNode.getInfo());
      expressionNode = expressionNode.getLink();
    }

    LinkedStack<Node> hold = new LinkedStack<Node>();

    LLNode n = reverse.top;

    while(n != null){
      //hold.push(n);
      Token abc = (Token)n.getInfo();

      if(abc.operand){
        Node nn = new Node(abc.str);
        hold.push(nn);
      }else if(abc.operator){
        Node node1 = hold.top();
        hold.pop();
        Node node2 = hold.top();
        hold.pop();
        Node nn = new Node(abc.str, node1, node2);
        hold.push(nn);
      }
      n = n.getLink();
    }

    System.out.println("");
    Tree test = new Tree();
    test.build(hold.top());
    test.prefix();
    test.infix();
    test.postfix();
    System.out.println(test.evaluate());

  }


}