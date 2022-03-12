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
public class FlyingDragon extends Dragon{
  public int swoops;
  public FlyingDragon(String n, int mHp)
  {
    super(n, mHp);
    swoops = 5;
  }

   public int SwoopAttack(){
    if (swoops > 0){
        int damage = ((int)(Math.random()*(6) + 5));
        swoops-=1;
        return damage;
    }
    
    return 0;

  }

  @Override
  public String toString()
  {
    return super.toString() + "\n   Swoop attacks remaining: " + swoops;
  } 
  
}
