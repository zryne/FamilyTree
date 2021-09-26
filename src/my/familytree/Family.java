/**
 * 
 */
package my.familytree;

/**
 * @author zryne
 *
 */
public class Family {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Individual p01 = new Individual("Dad", Gender.M, "1975-01-01");
    Individual p02 = new Individual("Mom", Gender.F, "1980-02-10");
    Individual p03 = new Individual("Bro", Gender.M, "2010-03-20");
    Individual p04 = new Individual("Sis", Gender.F, "2015-04-30");
    
    p01.addChild(p03);
    p01.addChild(p04);
    p02.addChild(p03);
    p02.addChild(p04);

    Individual fm[] = new Individual[] {p01, p02, p03, p04};
    System.out.println("# | Name | G | DoB        | DoD | Parents  | Children");
    System.out.println("--+------+---+------------+-----+----------+---------");
    for(Individual i : fm) {
      System.out.println(  i.getId() + " | "
                         + i.getName() + "  | "
                         + i.getGender() + " | "
                         + ((i.getBirth() == null) ? "N/A" : i.getBirth().toString()) + " | "
                         + ((i.getDeath() == null) ? "N/A" : i.getDeath().toString()) + " | "
                         + ((i.getFather() == null) ? "N/A" : i.getFather().getName()) + ", "
                         + ((i.getMother() == null) ? "N/A" : i.getMother().getName()) + " | "
                         + ((i.getChildren().size() == 0) ? "None" : i.getChildren().size()) 
                        );
    }
        
    System.out.println("Family members = " + Individual.count);
    
    p01.removeChild(p04);
    
    System.out.println("# | Name | G | DoB        | DoD | Parents  | Children");
    System.out.println("--+------+---+------------+-----+----------+---------");
    for(Individual i : fm) {
      System.out.println(  i.getId() + " | "
                         + i.getName() + "  | "
                         + i.getGender() + " | "
                         + ((i.getBirth() == null) ? "N/A" : i.getBirth().toString()) + " | "
                         + ((i.getDeath() == null) ? "N/A" : i.getDeath().toString()) + " | "
                         + ((i.getFather() == null) ? "N/A" : i.getFather().getName()) + ", "
                         + ((i.getMother() == null) ? "N/A" : i.getMother().getName()) + " | "
                         + ((i.getChildren().size() == 0) ? "None" : i.getChildren().size()) 
                        );
    }
        
    System.out.println("Family members = " + Individual.count);
  }
}
