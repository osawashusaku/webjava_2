package jp.co.systena.tigerscave.springtest.Model;

public class Wizard extends Job {
  private String job = "まほうつかい";
  private String msg = "はまほうで攻撃した！";

  public Wizard(String Name) {
    name = Name;
  }

  public String attack() {
    String msg = "はまほうで攻撃した！";
    return msg;
   }
  
  

}
