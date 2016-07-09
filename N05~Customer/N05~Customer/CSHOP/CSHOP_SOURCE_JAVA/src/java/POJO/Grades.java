package POJO;
// Generated Dec 13, 2015 9:20:51 PM by Hibernate Tools 4.3.1



import java.util.Date;


public class Grades  implements java.io.Serializable {


     private int idGrades;
     private String name;
     private Date dateAdded;
     private Date dateUpdated;
     

    public Grades() {
    }

    public Grades(int idGrades, String name, Date dateAdded, Date dateUpdated) {
       this.idGrades = idGrades;
       this.name = name;
       this.dateAdded = dateAdded;
       this.dateUpdated = dateUpdated;
      
    }

    /**
     * @return the idGrades
     */
    public int getIdGrades() {
        return idGrades;
    }

    /**
     * @param idGrades the idGrades to set
     */
    public void setIdGrades(int idGrades) {
        this.idGrades = idGrades;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateAdded
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * @param dateAdded the dateAdded to set
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * @return the dateUpdated
     */
    public Date getDateUpdated() {
        return dateUpdated;
    }

    /**
     * @param dateUpdated the dateUpdated to set
     */
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
   
     
}


