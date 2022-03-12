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
public class FireDragon extends Dragon
{
  public int fireShots;

  /*
  *@param n
  *@param mhp
  */
  public FireDragon(String n, int mHp)
  {
    super(n, mHp);
    fireShots = 3;
  }

  /*
  *@param n
  *@param mhp
  */
  public int fireShot()
  {
    
    if (fireShots > 0)
    {
      int damage = (int)(Math.random()*(5) + 5);
      fireShots = fireShots - 1;
      return damage;
    }

    return 0;
  }

  @Override
  public String toString()
  {
    return super.toString() + "\n   Fire Shots remaining: " + fireShots;
  }
}
