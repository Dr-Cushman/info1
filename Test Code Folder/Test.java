public class Test {
    public void printStudent(Student s) {
        
        System.out.println(s.getDetails());
    }

    public static void main(String[] args) {
        Test test = new Test();
        Student student = new Student();

        test.printStudent(student);
    }
}
