import java.util.ArrayList;

public class Converter{

  //i think the stack goes here
  public LinkedStack<Token> toPostFix(String input){

    ArrayList<String> infixExpression = new ArrayList<String>();
    ArrayList<Token> tokens = new ArrayList<Token>();
    LinkedStack<Token> stack = new LinkedStack<Token>();
    LinkedStack<Token> output = new LinkedStack<Token>();

    //format the input
    infixExpression = ExpressionParser.parse(input);

    //tokenize the infixexpressiong
    for(String s : infixExpression){
      tokens.add(new Token(s));
    }

    for(Token t : tokens){

      //if it is a number, simply put it in the output
      if(t.operand){
        output.push(t);

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

          while(!stack.top().str.equals("(")){
            output.push(stack.top());
            stack.pop();
          }
          //get rid of the "("
          stack.pop();
        }


      //let's deal with operators
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

              //keep putting stuffs into the output
              while(t.precedence < stack.top().precedence){
                output.push(stack.top());
                stack.pop();
              }

              //until we find a same precedence operator
              if(t.precedence == stack.top().precedence){
                output.push(stack.top());
                stack.pop();
                stack.push(t);
              }
              //or lower operator
              else{
                stack.push(t);
              }

            }
          }
       }

    }

    while(!stack.isEmpty()){
        output.push(stack.top());
        stack.pop();
    }

    return output;
  }

}