package friends;

import java.util.StringTokenizer;


public class Vertex {

    //the person's name
    String name;
    
    // are they a student?
    boolean student;
    
    //what school do they go to? (null if none)
    String school;
    
    Edge head;
    
    int dfsnum;
    int back;
    
    double distance;
    
    Vertex previous;
    
    
    public Vertex(String info){
        
        String newname = "";
        String newstudent = "";
        String newschool = "";
        StringTokenizer st = new StringTokenizer(info, "|");
    
        
        newname = st.nextToken();
        newstudent = st.nextToken();
        if(st.hasMoreTokens())
        {
            newschool = st.nextToken();
        }

        this.name = newname;
        this.student = false;
        this.school = null;
        this.distance = Double.MAX_VALUE;
        if(newstudent.equals("y"))
        {
            this.student = true;
            this.school = newschool;
        }
            
    }
    
    public Vertex(Vertex old){
    	this.name = old.name;
        this.student = old.student;
        this.school = old.school;
        this.distance = old.distance;
        this.head = null;
    }
    
    public void printName(){
        
        System.out.println(this.name);
        return;
    }
    
    public void printSchool(){
        if(this.school != null)
        {
            System.out.println(this.school);
        }
        return;
    }
    
    public void printAll(){
        System.out.println(name + ", " + school + ", " + student);
    }
    
}
