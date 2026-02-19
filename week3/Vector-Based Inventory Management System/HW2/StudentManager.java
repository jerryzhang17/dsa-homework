import java.util.ArrayList;

public class StudentManager {
    
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }
    
    public void addStudent(Student student){
        for (Student s : students){
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println("Duplicate student");
                return;
            }
        }
        students.add(student);
    }

    public boolean removeStudent(String studentId){
        for (int i = 0; i < students.size(); i++) {
                if(students.get(i).getStudentId().equals(studentId)){
                    students.remove(i);
                    return true;
                }
            }
        return false;
    }

    public Student findStudent(String studentId){
        for(Student s  : students){
            if(s.getStudentId().equals(studentId)){
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudentsByMajor(String major){
        ArrayList<Student> majors = new ArrayList<>();
        for(Student s : students){
            if(s.getMajor().equals(major)){
                majors.add(s);
            }
        }
        return majors;
    }

    public ArrayList<Student> getStudentsByYear(int year){
        ArrayList<Student> years = new ArrayList<>();
        for(Student s : students){
            if(s.getYear() == year){
                years.add(s);
            }
        }
        return years;
    }

    public ArrayList<Student> getHonorStudents(double minGpa){
        ArrayList<Student> honors = new ArrayList<>();
        for(Student s : students){
            if(s.getGpa() >= minGpa){
                honors.add(s);
            }
        }
        return honors;
    }

    public double getAverageGpa(){
        double avg = 0;
        double total = 0;

        for(Student s : students){
            total += s.getGpa();
            avg = total / students.size();
        }
        return avg;
    }

    public double getAverageGpaByMajor(String major){
        double avg = 0;
        double total = 0;

        for(Student s : students){
            if(s.getMajor().equals(major)){
                total += s.getGpa();
                avg = total / students.size();
            }
        }
        return avg;
    }

    public void printAllStudents(){
        for(Student s : students){
            System.out.println(s);
        }
    }

    public int getTotalStudents(){
        return students.size();
    }

    public ArrayList<String> getAllMajors(){
        ArrayList<String> majors = new ArrayList<>();

        for(Student s : students){
            majors.add(s.getMajor());
        }
        return majors;
    }
}