  public class Token{

    public String str = "";
    public boolean operator =  false;
    public boolean operand = false;
    public int precedence = 0;
    public boolean parenthesis = false;

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
      }else if(c == '^'){
        operator = true;
        precedence = 3;
      }else if(c == '*' || c == '/'){
        operator = true;
        precedence = 2;
      }else if( c == '+' || c == '-' ){
        operator = true;
        precedence = 1;

      }

    }

  }