package jp.co.systena.tigerscave.springtest.Model;

public class Fighter extends Job{
  private String job = "戦士";
  private String msg = "は剣で攻撃した！";

  public Fighter(String Name) {
      name = Name;
  }

    public String attack() {
     String msg = "は剣で攻撃した！";
     return msg;
    }

    public String getJob() {
      return this.job;
    }



}
