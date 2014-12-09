import java.util.ArrayList;

public class Converter{

  ArrayList<String> input = new ArrayList<String>();
  ArrayList<Token> stack = new ArrayList<Token>();
  ArrayList<Token> output = new ArrayList<Token>();

  //i think the stack goes here
  public String toPostFix(ArrayList<String> infixExpression){

    input = infixExpression;
    ArrayList<Token> tokens = new ArrayList<Token>();
    String postfixExpression = "";

    for(String s : infixExpression){
      tokens.add(new Token(s));
    }

    for(Token t : tokens){

      System.out.println("");
      System.out.println("dealing with " + t.str);
      System.out.print("stack ");
      for(Token tt : stack){
        System.out.print(tt.str+" ");
      }

      System.out.println("");
      System.out.print("output ");
      for(Token ttt : output){
        System.out.print(ttt.str+" ");
      }
      System.out.println("");

      //if it is a number, simply put it in the output
      if(t.operand){
        output.add(t);

      }else if(t.operator){

          //if the stack is empty
          if(stack.size() == 0){
            stack.add(t);

          }else{

            //if there is an open parenthesis in the stack
            Token onTopOfStack = stack.get(stack.size()-1);
            if(onTopOfStack.str.equals("(")){
              stack.add(t);
            }

           //if operator on the stack has a lower precedence, append the one you are reading to the stack
            else if(t.precedence > onTopOfStack.precedence){
              stack.add(t);
            }else{

              //pop operators out of the stack and append to output,
              //until the operator at the top of the stack is of lower precedence than the token you are reading
              for(int i = stack.size()-1; i >= 0; i-- ){
                onTopOfStack = stack.get(i);
                if(t.precedence < onTopOfStack.precedence){
                  stack.remove(i);
                  output.add(onTopOfStack);
                  //stack.add(t);
                  //break;
                }else if(t.precedence == onTopOfStack.precedence){
                  stack.remove(i);
                  output.add(onTopOfStack);
                  stack.add(t);
                  //stack.add(onTopOfStack);
                  break;
                }else{
                  stack.add(t);
                  break;
                }
              }

            }

          }



        //let's deal with parenthesis
      }else if(t.parenthesis){

        //Whenever you come upon an open parenthesis, always put it on the stack
        if(t.str.equals("(")){
          stack.add(t);
        }

        //Whenever you come upon a closed parenthesis,
        //pop out all the operators on the stack and append them to output until you find the matching parenthesis.
        //Pop out the matching parenthesis and don't add either paren to the output
        //(remember: postfix doesn't have parenthesis!)
        else if(t.str.equals(")")){

          for(int i = stack.size()-1; i >= 0; i-- ){
            Token onTopOfStack = stack.get(i);
            if(!onTopOfStack.str.equals("(")){
              stack.remove(i);
              output.add(onTopOfStack);
            }else{
              stack.remove(i);
              break;
            }
          }

        }

      }

    }

    if(stack.size() != 0){
      for(int i = stack.size()-1; i >= 0; i-- ){
        Token onTopOfStack = stack.get(i);
        stack.remove(i);
        output.add(onTopOfStack);
      }
    }

    for(Token t : output){
      postfixExpression += (t.str + " ");
    }
    System.out.println("postfixExpression "+ postfixExpression);

    return postfixExpression;
  }

  public class Token{

    String str = "";
    boolean operator =  false;
    boolean operand = false;
    int precedence = 0;
    boolean parenthesis = false;

    Token(String s){
      tokenize(s);
      str = s;
    }

    void tokenize(String s){
      char c = s.toCharArray()[0];
      if(Character.isDigit(c)){
        operand = true;
      }else if(c == '(' || c == ')'){
        parenthesis = true;
      }else if(c == '*' || c == '/' || c == '^'){
        operator = true;
        precedence = 2;
      }else if( c == '+' || c == '-' ){
        operator = true;
        precedence = 1;

      }

    }

  }

}