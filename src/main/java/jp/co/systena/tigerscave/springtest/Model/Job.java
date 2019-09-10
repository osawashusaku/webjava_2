package jp.co.systena.tigerscave.springtest.Model;

public abstract class Job {
    String name;

    public String getName() {
      return this.name;
    }

    public void setName(String Name) {
      this.name = Name;
    }

    public abstract String attack();

}
