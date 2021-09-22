package my.familytree;

import java.time.LocalDate;
import java.util.ArrayList;

public class Individual {
  private static int            id;
  private String                name;
  private LocalDate             birth;
  private LocalDate             death;
  private Individual            father;
  private Individual            mother;
  private ArrayList<Individual> children;
  
  /**
   * 
   */
  public Individual() {
    Individual.id++;
    setName("");
    setBirth(null);
    setDeath(null);
    setFather(null);
    setMother(null);
    children = null;
  }
  
  /**
   * 
   * @param n
   * @param dob
   */
  public Individual(String n, String dob) {
    Individual.id++;
    int birth_year  = Integer.parseInt(dob.split("-")[0]);
    int birth_month = Integer.parseInt(dob.split("-")[1]);
    int birth_day   = Integer.parseInt(dob.split("-")[2]);
    setName(n);
    setBirth(LocalDate.of(birth_year, birth_month, birth_day));
    setDeath(null);
    setFather(null);
    setMother(null);
    children = null;
  }

  /**
   * 
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * 
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 
   * @return the birth
   */
  public LocalDate getBirth() {
    return birth;
  }

  /**
   * 
   * @param birth the birth to set
   */
  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  /**
   * 
   * @return the death
   */
  public LocalDate getDeath() {
    return death;
  }

  /**
   * 
   * @param death the death to set
   */
  public void setDeath(LocalDate death) {
    this.death = death;
  }

  /**
   * 
   * @return the father
   */
  public Individual getFather() {
    return father;
  }

  /**
   * 
   * @param father the father to set
   */
  public void setFather(Individual father) {
    this.father = father;
  }

  /**
   * 
   * @return the mother
   */
  public Individual getMother() {
    return mother;
  }

  /**
   * 
   * @param mother the mother to set
   */
  public void setMother(Individual mother) {
    this.mother = mother;
  }

  /**
   * 
   * @return the children
   */
  public ArrayList<Individual> getChildren() {
    return children;
  }

  /**
   * 
   * @param children the children to set
   */
  public void setChildren(ArrayList<Individual> children) {
    this.children = children;
  }
  
  /**
   * 
   * @param child
   */
  public void addChild(Individual child) {
    this.children.add(child);
  }
  
  /**
   * 
   * @param child
   * @return
   */
  public boolean isChild(Individual child) {
    if ((this == child.father) || (this == child.mother)) {
      return true;
    }
    return false;
  }
}
