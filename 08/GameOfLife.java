import java.util.ArrayList;

public class GameOfLife{

  protected static final int M = 25;
  protected static final int N = 75;

  protected char[][] world = new char[M+1][N+1];
  protected ArrayList<char[][]> generations = new ArrayList<char[][]>();

  private final String[] fileNames = {
    "data/life1.dat",
    "data/life2.dat",
    "data/life3.dat",
    "data/life4.dat",
    "data/life5.dat"
  };
  protected FileStringReader fileStringReader;

  public GameOfLife(int index){
    //the file is chosen by user.. no need to use random to choose.

    //be careful random()*5 [0,5) will be round to 0||1||2||3||4||5 and 5 is out of bounce
    //int index = (int)Math.round(Math.random()*4);
    fileStringReader = new FileStringReader(fileNames[index]);
    init();
  }

  public void init(){

    //make borders
    for(int i = 0 ; i < N+1 ; i ++){
      world[0][i] = world[M][i] = '.';
    }
    for(int i = 0 ; i < M+1 ; i ++){
      world[i][0] = world[i][N] = '.';
    }

    //initianize the board according to a data file
    for(int i = 0; i < M; i ++){
      String line = fileStringReader.readLine();
      for(int j = 0; j < N; j ++){
          world[i+1][j+1] = line.charAt(j);
          //System.out.println(world[i+1][j+1]);
      }
    }

    //code below will print out lines plus an extra line with value null
    //apparently there's difference between while and do while
    /*
    while(fileStringReadr.readLine()!=null){
      String line = fileStringReader.readLine();
      System.out.println(line);
    }
    */

    //code below won't print out null but missing some lines, index prints out to be 13 instead of 25
    //don't know why
    /*
    int index = 0;
    do{
        String line = fileStringReader.readLine();
        System.out.println(line.length());
        for(int i = 0; i < line.length(); i++){
          world[index][i] = line.charAt(i);
        }
        index ++;
    }
    while(fileStringReader.readLine()!=null);
    */

    fileStringReader.close();

    generations.add(world);
  }

  public int neighborNum(char[][] world, int row, int column){
    int neighbors = 0;
    //up
    neighbors += world[row-1][column] == 'X' ? 1 : 0;
    //down
    neighbors += world[row+1][column] == 'X' ? 1 : 0;
    //left
    neighbors += world[row][column-1] == 'X' ? 1 : 0;
    //right
    neighbors += world[row][column+1] == 'X' ? 1 : 0;
    //up left
    neighbors += world[row-1][column-1] == 'X' ? 1 : 0;
    //up right
    neighbors += world[row-1][column+1] == 'X' ? 1 : 0;
    //down left
    neighbors += world[row+1][column-1] == 'X' ? 1 : 0;
    //down right
    neighbors += world[row+1][column+1] == 'X' ? 1 : 0;

    return neighbors;
  }

  public boolean isEmpty(char[][] generation){
    int x = 0;
    for(int i = 1; i < M; i++){
      for(int j = 1; j < N; j++){
         if(generation[i][j] == 'X'){
            x++;
            break;
         }
      }
    }
    return x == 0;
  }

  public void evolve(){
    //the next generation
    char[][] next = new char[M+1][N+1];

    //evolve
    for(int i = 1; i< M; i++){
      for(int j = 1; j < N; j++){
        if(world[i][j] == 'X'){
          if(neighborNum(world, i, j) == 2 || neighborNum(world, i, j) == 3){
            next[i][j] = 'X';
          }else{
            next[i][j] = '.';
          }
        }else{
           if(neighborNum(world, i, j) == 3){
            next[i][j] = 'X';
          }else{
            next[i][j] = '.';
          }
        }
      }
    }

    //make borders
    for(int i = 0 ; i < N+1 ; i ++){
      next[0][i] = next[M][i] = '.';
    }
    for(int i = 0 ; i < M+1 ; i ++){
      next[i][0] = next[i][N] = '.';
    }

    //see if it needs to terminate
    checkTerminate(world, next);

    //save each generation in an arrayList
    generations.add(next);
    //replace the world
    world = next;
  }

  public void checkTerminate(char[][] current, char[][] next){
    if(current == next){
      System.out.println("The whole world is stuck, bye-bye.");
      System.exit(1);
    }
    if(isEmpty(next)){
      System.out.println("R.I.P. all the organism.");
      System.exit(1);
    }
  }

  public void report(){
    for(int k = 0; k <generations.size(); k++){
      System.out.println("Generation #"+k);
      for(int i = 1; i < M; i++){
        for(int j = 1; j < N; j++){
          System.out.print(generations.get(k)[i][j]);
        }
        System.out.println("");
      }
      System.out.println("");
    }
  }

}