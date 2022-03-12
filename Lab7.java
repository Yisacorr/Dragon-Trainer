/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg7;

/**
 *
 * @author Yisacor
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
   {
    System.out.println("What is your name, challenger?");

    String name = CheckInput.getString();
    //String name = "Testing"; //place holder for the mean time
    
    System.out.println("Welcome to dragon training, " + name);
    System.out.println("You must defeat 3 dragons");

    Dragon Deadly = new Dragon("DeadlyNadder",10);
    FireDragon Gronckle = new FireDragon("Gronckle", 20);
    FlyingDragon Timber = new FlyingDragon("Timberjack", 15);
    
    int choice;
    int secondChoice;
    int userHP = 50; //player's Hp
    boolean statusCheck = true;
    
    do{
      System.out.println("\n"+ name +" HP: " + userHP );
      if (Deadly.getHp() != 0){
         System.out.println("1. Attack Deadly Nadder: " + Deadly.getHp() + "/10");
      }
      if (Gronckle.getHp() != 0){
        System.out.println("2. Attack " + Gronckle.toString()); 
      }
      if (Timber.getHp() != 0){
          System.out.println("3. Attack " + Timber.toString());      
      }
      
      
      if(Deadly.getHp() <= 0){ 
          choice = CheckInput.getIntRange(2,3);
      }
      if (Gronckle.getHp() <= 0){
          choice = CheckInput.getIntRange(1,3);
          while (choice ==2){
              System.out.print("Timberjack is already Dead, try option 1 or 3.");
              choice = CheckInput.getIntRange(1,3);
          }
      }
      if (Timber.getHp() <= 0){
          choice = CheckInput.getIntRange(1,2);
      }
      else choice = CheckInput.getIntRange(1,3);
      
      
      switch(choice)
      {
        // Deadly Nadder
        case 1:
          System.out.println("\nAttack with:");
          System.out.println("1. Arrow (1 D12)");
          System.out.println("2. Sword (2 D6)"); 

          secondChoice = CheckInput.getIntRange(1,2);

          if (secondChoice == 1)
          {
              Deadly.takeDamage(arrow());
              int randm = (int)(Math.random() * (3) + 1);
              if (randm == 1 && statusCheck ){
                userHP = DeadlyNadderAttackBack(userHP);
              }
              else if (randm == 2 && statusCheck ){
                userHP = TimberAttackBack(userHP);
              }
              else if (randm == 3 && statusCheck ){
                userHP = GronckleAttackBack(userHP);
              }
          }
          else if (secondChoice == 2)
          {
              Deadly.takeDamage(sword());
              int randm = (int)(Math.random() * (3) + 1);
              if (randm == 1 && statusCheck ){
                userHP = DeadlyNadderAttackBack(userHP);
              }
              else if (randm == 2 && statusCheck ){
                userHP = TimberAttackBack(userHP);
              } 
              else if (randm == 3 && statusCheck ){
                userHP = GronckleAttackBack(userHP);
              }
          }

          break;  

        // Gronckle
        case 2:
          System.out.println("\nAttack with:");
          System.out.println("1. Arrow (1 D12)");
          System.out.println("2. Sword (2 D6)");

          secondChoice = CheckInput.getIntRange(1,2);

          if (secondChoice == 1)
          {
              Gronckle.takeDamage(arrow());
              int randm = (int)(Math.random() * (3) + 1);
              if (randm == 1 && statusCheck )
                userHP = DeadlyNadderAttackBack(userHP);
                
              else if (randm == 2 && statusCheck )
                userHP = TimberAttackBack(userHP);
                
              else if (randm == 3 && statusCheck )
                userHP = GronckleAttackBack(userHP);
          }
          else if (secondChoice == 2)
          {
              Gronckle.takeDamage(sword());
              int randm = (int)(Math.random() * (3) + 1);
              if (randm == 1 && statusCheck ){
                userHP = DeadlyNadderAttackBack(userHP);
              }
              else if (randm == 2 && statusCheck ){
                userHP = TimberAttackBack(userHP);
              }
              else if (randm == 3 && statusCheck ){
                userHP = GronckleAttackBack(userHP);
              }
          }
          break;

        //Timberjack
        case 3:
          System.out.println("\nAttack with:");
          System.out.println("1. Arrow (1 D12)");
          System.out.println("2. Sword (2 D6)");

          secondChoice = CheckInput.getIntRange(1,2);

          if (secondChoice == 1)
          {
              Timber.takeDamage(arrow());
              int randm = (int)(Math.random() * (3) + 1);
              if (randm == 1 && statusCheck ){
                userHP = DeadlyNadderAttackBack(userHP);
              }
              else if (randm == 2 && statusCheck ){
                userHP = TimberAttackBack(userHP);
              }
              else if (randm == 3 && statusCheck ){
                userHP = GronckleAttackBack(userHP);
              }
          }
          else if (secondChoice == 2)
          {
              Timber.takeDamage(sword());
              int randm = (int)(Math.random() * (3) + 1);
              if (randm == 1 && statusCheck ){
                userHP = DeadlyNadderAttackBack(userHP);
              }
              if (randm == 2 && statusCheck ){
                userHP = TimberAttackBack(userHP);
              }
              if (randm == 3 && statusCheck ){
                userHP = GronckleAttackBack(userHP);
              }
          }
          break;
        default:
      }
      
      
      if (userHP <= 0)
      {
        statusCheck = false;
        System.out.println("Oh no you lost all your hp");
      }
      if (Deadly.getHp() <= 0 & Timber.getHp() <= 0 & Gronckle.getHp() <= 0)
      {
        statusCheck = false;
        System.out.println("Congratulations You slayed all the dragons");
      }
      
    
    } while(statusCheck);
      
  }

  public static int arrow()
  {
    int damage = (int)(Math.random() * (12) + 1);
    System.out.println("You hit the dragon with an arrow.");
    return damage;
  }

  public static int sword()
  {
    int d1 = (int)(Math.random() * (6) + 1);
    int d2 = (int)(Math.random() * (6) + 1);
    int damage = d1 + d2;
    System.out.println("You slash the dragon with your sword");
    return damage;
  }
  

  public static int DeadlyNadderAttackBack(int userhP){
      Dragon Deadly = new Dragon("DeadlyNadder",10);
      System.out.println("Deadly Nadder smashes you with its tail.");
      return userhP-=Deadly.attack();
  } 
  public static int TimberAttackBack(int userhP){
      
      
      FireDragon Timber = new FireDragon("Timberjack", 20);
      
      int rand = (int)(Math.random() * (2) + 1);
      if (rand ==1){
        System.out.println("Timberjack smashes you with its tail.");
        return userhP-=Timber.attack();
      }
      else if (rand ==2){
        System.out.println("Timberjack swoops down and knocks you over.");
        return userhP-=Timber.fireShot();
      }
      return 0;    
  }  
  public static int GronckleAttackBack(int userhP){
      
      
      FlyingDragon Gronckle = new FlyingDragon("Gronckle", 15);
      
      int rand = (int)(Math.random() * (2) + 1);
      if (rand ==1){
        System.out.println("Gronckle smashes you with its tail.");
        return userhP-=Gronckle.attack();
      }
      else if (rand ==2){
        System.out.println("Gronckle spews fire at you.");
        return userhP-=Gronckle.SwoopAttack();
      }
      return 0;    
  }  
}



