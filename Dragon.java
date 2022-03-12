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
public class Dragon 
{
  private String name;
  private int hp;
  private int maxHp;

  /*
  *@param n
  *@param mhp
  */
  public Dragon (String n, int mHp)
  {
    name = n;
    maxHp = mHp;
    hp = mHp; 

  }
  /*
  *
  *@return
  */
  public String getName(){
    return name;
    }

  /*
  *
  *@return
  */
  public int getHp()
  {
    return hp;
  }

  /*
  *
  *@return
  */
  public int attack()
  {
    int damage = (int)(Math.random()*(5) + 3);
    return damage;
  }
  
  /*
  *
  *@param d
  */
  public void takeDamage(int d)
  {
    hp = hp - d;
    if (hp < 0)
    {
      hp = 0;
    }
  }
  
  @Override
  public String toString(){
    return (name + " hp (" + hp + "/" + maxHp + ")");
  }
} 
