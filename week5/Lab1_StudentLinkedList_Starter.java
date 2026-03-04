public class Lab1_StudentLinkedList_Starter {
    
    // Student class
    static class Student {
        private String name;
        private String studentId;
        private double gpa;
        
        // TODO: Add constructor
        public Student(String name, String studentId, double gpa){
            this.name = name;
            this.studentId = studentId;
            if(gpa < 0 || gpa > 4) throw new IllegalArgumentException("Invalid Gpa");
            this.gpa = gpa;

        }

        // TODO: Add getters and setters
        public String getName() { return name; }
        public String getStudentId() { return studentId; }
        public double getGpa() { return gpa; }

        public void setName(String name) { this.name = name; }
        public void setStudentId(String studentId) { this.studentId = studentId; }
        public void setGpa(double gpa) { 
            if(gpa < 0 || gpa > 4) throw new IllegalArgumentException("Invalid Gpa");
            this.gpa = gpa; 
        }

        // TODO: Add toString() method
        @Override
        public String toString(){
            return "Student {" + name + ", " + studentId + ", " + gpa + "}";
        }
    }
    
    // Node class for linked list
    static class Node {
        Student student;
        Node next;
        
        // TODO: Add constructor
        public Node(Node next, Student student) {
            this.next = next;
            this.student = student;
        }
    }
    
    // StudentLinkedList class
    static class StudentLinkedList {
        private Node head;
        private int size;
        
        public StudentLinkedList() {
            this.head = null;
            this.size = 0;
        }
        
        // TODO: Implement append method
        public void append(Student student) {
            // Add student to the end of the list
            if(this.head == null){
                this.head = new Node(null, student);
                this.size++;
            }else{
                Node current = this.head;
                while(current.next != null){
                    current = current.next;
                }
                current.next = new Node(null, student);
                this.size++;
            }
        }
        
        // TODO: Implement prepend method
        public void prepend(Student student) {
            // Add student to the beginning of the list
            Node newHead = new Node(this.head, student);
            this.head = newHead;
            this.size++;
        }
        
    // TODO: Implement delete method
        public boolean delete(String studentId) {
            // Remove student by ID, return true if found and removed
            if (this.head == null) {
                return false;
            }

            if (head.student.getStudentId().equals(studentId)) {
                this.head = head.next;
                this.size--;
                return true;
            }

            Node current = this.head;
            while(current.next != null){
                if(current.next.student.getStudentId().equals(studentId)){
                    current.next = current.next.next;
                    this.size--;
                    return true;
                }
                current = current.next;
            }
            return false;
        }
        
        // TODO: Implement find method
        public Student find(String studentId) {
            // Find and return student by ID, or null if not found
            if(this.head != null && this.head.student.getStudentId().equals(studentId)){
                return this.head.student;
            }else{
                Node current = this.head;
                while(current.next != null){
                    if(current.next.student.getStudentId().equals(studentId)){
                        return current.next.student;
                    }
                    current = current.next;
                }
            }
            return null;
        }
        
        // TODO: Implement printAll method
        public void printAll() {
            // Print all students in the list
            if(this.head == null){
                System.out.println("Empty List");
                return;
            }
            Node current = this.head;
            while(current != null){
                System.out.println(current.student);
                current = current.next;
            }
        }
        
        // TODO: Implement getAverageGPA method
        public double getAverageGPA() {
            // Calculate and return the average GPA
            if(this.size == 0) return 0.0;
            double total = 0;
            Node current = this.head;
            while(current != null){
                total += current.student.getGpa();
                current = current.next;
            }
            return total / this.size;
        }
        
        // TODO: Implement getSize method
        public int getSize() {
            // Return the number of students
            return this.size;
        }
    }
    
    // Test your implementation here
    public static void main(String[] args) {
        // TODO: Create a StudentLinkedList
        StudentLinkedList list = new StudentLinkedList();
        // TODO: Add some students
        list.prepend(new Student("James", "123", 2.6));
        list.append(new Student("William", "456", 3));
        list.prepend(new Student("Jerry", "789", 3.6));
        // TODO: Test all your methods

        list.printAll();
        System.out.println(list.getAverageGPA());
        System.out.println(list.find("456"));

        list.delete("456");
        System.out.println("Updated");
        list.printAll();
    }
}