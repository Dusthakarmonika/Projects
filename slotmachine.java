import java.util.Scanner;
import java.util.Random;

public class slotmachine {
public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  int balance = 100;
  int bet;
  int payout;
  String[] row;
  System.out.println("********************************");
  System.out.println(" welcome to the java slot ");
  System.out.println(" symbols : @ # $ % ^");
  System.out.println("********************************");

  while( balance > 0 ){
    System.out.println(" current balance : $ " + balance );
    System.out.print(" place the bet amount : ");
    bet = scanner.nextInt();

    if( bet > balance ){
      System.out.println(" insufficient balance buddy ");
    }
    else if( bet < 0 ){
      System.out.println(" the bet should be greater than 0 ");
    }
    else{
      balance -= bet;
    }
    System.out.println(" spinning........");
     row = spinRow();
     printRow(row);
    payout =  getpayout( row, bet );

    if( payout > 0){
      System.out.print(" you won $ " + payout );
      balance += payout;
    }
    else{
      System.out.println(" you lost this round ");
    }

  }
}
static String[] spinRow(){
  String[] symbols = { "@","#","$"};
  String[] row = new String[3];
  Random random = new Random();
  
  for( int i = 0; i < 3; i++){
    row[i] = symbols[random.nextInt(symbols.length)];

  }
  System.out.println( row[0]+ row[1]+ row[2]);
  return row;

}  
static void printRow( String[] row ){
  System.out.print(" " + String.join(" | ", row ));
}
static int getpayout( String[] row, int bet ){
  if( row[0].equals(row[1]) && row[1].equals(row[2]) ){
    return switch( row[0]){
      case "@" -> bet * 3;
      case "#" -> bet * 4;
      case "$" -> bet * 5;
      default -> 0;
      
    };
  }
return 0;
}
}
