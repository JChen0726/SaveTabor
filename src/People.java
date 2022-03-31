import java.awt.*;

public class People {
    int hello = 0, count = 1;
    Point point;
    boolean isStudent;
    boolean isTeacher;
    public People(Point point, boolean isStudent, boolean isTeacher){
        this.point = point;
        this.isStudent = isStudent;
        this.isTeacher = isTeacher;
    }
    public Point getPosition(){
        return point;
    }
    public void setPosition(Point newPoint){
        this.point = newPoint;
    }
    public boolean getIdentity_student(){
        if(isStudent==true) return true;
        else return false;
    }}