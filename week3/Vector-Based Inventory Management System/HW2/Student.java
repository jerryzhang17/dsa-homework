public class Student {
    
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private double gpa;
    private String major;
    private int year; // 1 = Freshman, 2 = Sophomore, 3 = Junior, 4 = Senior

    public Student(String studentId, String firstName, String lastName, String email, double gpa, String major, int year){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        if(gpa < 0 || gpa > 4) throw new IllegalArgumentException("GPA must be between 0 and 4");
        this.gpa = gpa;
        this.major = major;
        if(year < 1 || year > 4) throw new IllegalArgumentException("Year must be between 1 and 4");
        this.year = year;
    }

    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public double getGpa() { return gpa; }
    public String getMajor() { return major; }
    public int getYear() { return year; }

    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setGpa(double gpa) { 
        if(gpa < 0 || gpa > 4) throw new IllegalArgumentException("GPA must be between 0 and 4");
        this.gpa = gpa; }
    public void setMajor(String major) { this.major = major; }
    public void setYear(int year) { 
        if(year < 1 || year > 4) throw new IllegalArgumentException("Year must be between 1 and 4");
        this.year = year; }

    @Override
    public String toString() {
        return "Student {" + "studentId='" + studentId + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + 
                ", email='" + email + '\'' + ", gpa=" + gpa + ", major='" + major + '\'' + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Student)) return false;
        Student that = (Student) obj;
        if (this.studentId == null || that.studentId == null) return false;
        return this.studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return studentId == null ? 0 : studentId.hashCode();
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}