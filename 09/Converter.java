import java.util.ArrayList;

public class Converter{

  ArrayList<String> input = new ArrayList<String>();
  ArrayList<String> stack = new ArrayList<String>();
  ArrayList<String> output = new ArrayList<String>();

  //i think the stack goes here
  public ArrayList<String> toPostFix(ArrayList<String> infixExpression){

    input = infixExpression;
    ArrayList<String> postfixExpression = new ArrayList<String>();

    for(int i = 0; i < input.size(); i++){
      String s = input.get(i);
      char c = s.toCharArray()[0];
      if(Character.isDigit(c)){
        output.add(s);
      }else if(c == ')'){
        stack.remove('(');
        stack.put into output
      }else{
        stack.add(s);
      }

      postfixExpression.add(infixExpression.get(i));
    }

    return postfixExpression;
  }

  public boolean isParenthesis(char c){

  }

}