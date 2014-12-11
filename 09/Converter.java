import java.util.ArrayList;

public class Converter{

  //i think the stack goes here
  public String toPostFix(String input){

    ArrayList<String> infixExpression = new ArrayList<String>();
    ArrayList<Token> tokens = new ArrayList<Token>();
    ArrayListStack<Token> stack = new ArrayListStack<Token>();
    String output = "";

    infixExpression = ExpressionParser.parse(input);

    //tokenize the infixexpressiong
    for(String s : infixExpression){
      tokens.add(new Token(s));
    }

    for(Token t : tokens){

      //if it is a number, simply put it in the output
      if(t.operand){
        output += (t.str+" ");

      }else if(t.operator){

          //if the stack is empty
          if(stack.isEmpty()){
            stack.push(t);

          }else{

            //if there is an open parenthesis in the stack
            if(stack.top().str.equals("(")){
              stack.push(t);
            }

            else{

              //pop operators out of the stack and append to output,
              //until the operator at the top of the stack is of lower precedence than the token you are reading

              //that's how i implement 'util', iterate it until you should stop

              // for(int i = stack.stack.size()-1; i >= 0; i-- ){
              //   Token onTopOfStack = stack.top();
              //   if(t.precedence < onTopOfStack.precedence){
              //     stack.pop();
              //     output.add(onTopOfStack);
              //     //stack.add(t);
              //     //break;
              //   }else if(t.precedence == onTopOfStack.precedence){
              //     stack.pop();
              //     output.add(onTopOfStack);
              //     stack.push(t);
              //     //stack.add(onTopOfStack);
              //     break;
              //   }else{
              //     //if operator on the stack has a lower precedence,
              //     //append the one you are reading to the stack
              //     stack.push(t);
              //     break;
              //   }
              // }

              while(t.precedence < stack.top().precedence){
                output += (stack.top().str+" ");
                stack.pop();
              }

              if(t.precedence == stack.top().precedence){
                output += (stack.top().str+" ");
                stack.pop();
                stack.push(t);
              }else{
                stack.push(t);
              }

            }
          }


        //let's deal with parenthesis
      }else if(t.parenthesis){

        //Whenever you come upon an open parenthesis, always put it on the stack
        if(t.str.equals("(")){
          stack.push(t);
        }

        //Whenever you come upon a closed parenthesis,
        //pop out all the operators on the stack and append them to output until you find the matching parenthesis.
        //Pop out the matching parenthesis and don't add either paren to the output
        //(remember: postfix doesn't have parenthesis!)
        else{

          // for(int i = 0 ; i < stack.stack.size()-1; i++ ){
          //   Token onTopOfStack = stack.top();
          //   if(!onTopOfStack.str.equals("(")){
          //     stack.pop();
          //     output.add(onTopOfStack);
          //   }else{
          //     stack.pop();
          //     break;
          //   }
          // }
          while(!stack.top().str.equals("(")){
            output += (stack.top().str+" ");
            stack.pop();
          }
          //get rid of the "("
          stack.pop();

        }

      }

    }

    while(!stack.isEmpty()){
        output += (stack.top().str+" ");
        stack.pop();
    }

    return output;
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