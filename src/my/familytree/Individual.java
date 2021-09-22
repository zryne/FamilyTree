package my.familytree;

import java.time.LocalDate;
import java.util.ArrayList;

public class Individual {
  public static int             count;
  private int                   id;
  private String                name;
  private String                gender;
  private LocalDate             birth;
  private LocalDate             death;
  private Individual            father;
  private Individual            mother;
  private ArrayList<Individual> children;
  
  /**
   * 
   */
  public Individual() {
    Individual.count++;
    id = count;
    setName("");
    setGender("");
    setBirth(null);
    setDeath(null);
    setFather(null);
    setMother(null);
    children = new ArrayList<Individual>();
  }
  
  /**
   * 
   * @param n
   * @param dob
   */
  public Individual(String n, String g, String dob) {
    Individual.count++;
    id = count;
    int birth_year  = Integer.parseInt(dob.split("-")[0]);
    int birth_month = Integer.parseInt(dob.split("-")[1]);
    int birth_day   = Integer.parseInt(dob.split("-")[2]);
    setName(n);
    setGender(g);
    setBirth(LocalDate.of(birth_year, birth_month, birth_day));
    setDeath(null);
    setFather(null);
    setMother(null);
    children = new ArrayList<Individual>();
  }

  /**
   * 
   * @return
   */
  public int getId() {
    return id;
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
   * @return the gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender the gender to set
   */
  public void setGender(String gender) {
    this.gender = gender;
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
   * @param child
   */
  public void addChild(Individual child) {
    if (child != null) {
      this.children.add(child);
      
    }
  }
  
  public void removeChild(Individual child) {
    if (child != null) {
      // TODO if child is one of the children of the caller, then remove parent-child relationship.
    }
  }
  
  /**
   * If caller has the specified child. 
   * @param child
   * @return
   */
  public boolean hasChild(Individual child) {
    if (child != null) {
      if ((this == child.father) || (this == child.mother)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * If caller is a child of specified parent.
   * @param parent
   * @return
   */
  public boolean isChildOf(Individual parent) {
    if (parent != null) {
      if (parent.hasChild(this)) {
        return true;
      }
    }
    return false;
  }
}
