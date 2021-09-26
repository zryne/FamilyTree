/**
 * 
 */
package my.familytree;

/**
 * @author zryne
 *
 */
import java.time.LocalDate;
import java.util.ArrayList;

public class Individual {
  public static int             count;
  private int                   id;
  private String                name;
  private Gender                gender;
  private LocalDate             birth;
  private LocalDate             death;
  private Individual            father;
  private Individual            mother;
  private ArrayList<Individual> children;
  
  /**
   * Default constructor
   */
  public Individual() {
    count++;
    id = count;
    setName("");
    setGender(Gender.U);
    setBirth(null);
    setDeath(null);
    setFather(null);
    setMother(null);
    children = new ArrayList<Individual>();
  }
  
  /**
   * Constructor with name, gender and date-of-birth.
   * @param n   name of the individual
   * @param dob date of birth of the individual
   */
  public Individual(String n, Gender g, String dob) {
    count++;
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
   * Get unique individual identifier.
   * @return the id
   */
  public int getId() {
    return id;
  }
  
  /**
   * Get the name. 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the gender.
   * @return the gender
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * Set the gender.
   * @param gender the gender to assign
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * Get the date of birth. 
   * @return the birth date
   */
  public LocalDate getBirth() {
    return birth;
  }

  /**
   * Set the date of birth. 
   * @param birth the birth date to assign
   */
  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  /**
   * Get the date of death. 
   * @return the death
   */
  public LocalDate getDeath() {
    return death;
  }

  /**
   * Set the date of death. 
   * @param death the death date to assign
   */
  public void setDeath(LocalDate death) {
    this.death = death;
  }

  /**
   * Get the father. 
   * @return the father
   */
  public Individual getFather() {
    return father;
  }

  /**
   * Set as father. 
   * @param father the father to assign
   */
  public void setFather(Individual father) {
    this.father = father;
  }

  /**
   * Get the mother. 
   * @return the mother
   */
  public Individual getMother() {
    return mother;
  }

  /**
   * Set as mother. 
   * @param mother the mother to assign
   */
  public void setMother(Individual mother) {
    this.mother = mother;
  }

  /**
   * Get the children list.
   * @return list of children
   */
  public ArrayList<Individual> getChildren() {
    return children;
  }
  
  /**
   * Set as child.
   * @param child the individual to add as child
   */
  public void addChild(Individual child) {
    if (child != null) {
      if (!this.hasChild(child)) {
        children.add(child);
      }
      
      // Add parent relation from child
      if (this.gender == Gender.M) {
        child.setFather(this);
      } else if (this.gender == Gender.F) {
        child.setMother(this);
      } else {
      }
    }
  }
  
  /**
   * Set as parent.
   * @param parent the individual to add as parent
   */
  public void addParent(Individual parent) {
    if (parent != null) {
      parent.addChild(this);
    }
  }
  
  /**
   * Remove from children list.
   * @param child the individual to remove from children
   */
  public void removeChild(Individual child) {
    if (child != null) {
      // TODO if child is one of the children of the caller, then remove parent-child relationship.
      ArrayList<Individual> temp_list = this.getChildren();
      for (int i = 0; i < temp_list.size(); i++) {
        if (temp_list.get(i) == child) {
          temp_list.remove(i);
          child.removeParent(this);
          break;
        }
      }
    }
  }
  
  public void removeParent(Individual parent) {
    if (parent != null) {
      if (parent.gender == Gender.M ) {
        this.setFather(null);
      } else if (parent.gender == Gender.F ) {
        this.setMother(null);
      } else {
      }
    }
  }
  
  /**
   * Get the number of children.
   * @return number of children
   */
  public int childrenCount() {
    return children.size();
  }
  
  /**
   * If caller has the specified child. 
   * @param child The individual to check as offspring
   * @return true/false
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
   * @param parent The individual to check as parent
   * @return true/false
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
