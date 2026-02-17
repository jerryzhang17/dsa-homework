public class Student {
    
    String studentId;
    String firstName;
    String lastName;
    String email;
    double gpa;
    String major;
    int year; // 1 = Freshman, 2 = Sophomore, 3 = Junior, 4 = Senior

    public Student(String studentId, String firstName, String lastName, String email, double gpa, String major, int year){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gpa = gpa;
        this.major = major;
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
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setMajor(String major) { this.major = major; }
    public void setYear(int year) { this.year = year; }

    public String toString() { return studentId + " " + firstName + " " + lastName + " " + email + " " + gpa + " " + major + " " + year; }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Student)) return false;
        Student that = (Student) obj;
        return this.studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return studentId == null ? 0 : studentId.hashCode();
    }
}
