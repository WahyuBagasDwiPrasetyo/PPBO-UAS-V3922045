abstract class Employee {
    private String name;
    private int age;
    private static int totalEmployees;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public abstract void displayInfo();

    public void divide(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        int result = num1 / num2;
        System.out.println("Result: " + result);
    }

    public static int getTotalEmployees() {
        // Implementasi penghitungan jumlah total karyawan
        return totalEmployees;
    }

    public static void staticMethod() {
        // Implementasi metode statis
        System.out.println("This is a static method.");
    }
}

final class Manager extends Employee {
    private String department;

    public Manager(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        // Encapsulation: Menggunakan setter untuk mengatur nilai atribut private
        Manager manager = new Manager("John Doe", 30, "Finance");
        manager.setName("Jane Doe");
        manager.setAge(35);

        // Abstraction: Memanggil metode displayInfo() yang merupakan abstraksi dari informasi yang ditampilkan
        manager.displayInfo();

        // Reflection: Mendapatkan informasi tentang kelas dan memanggil metode menggunakan refleksi
        try {
            Class<?> managerClass = Class.forName("Manager");
            Manager newManager = (Manager) managerClass.getDeclaredConstructor(String.class, int.class, String.class)
                    .newInstance("Mary Smith", 40, "HR");
            newManager.displayInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Static: Mengakses variabel statis dan memanggil metode statis langsung dari kelas
        System.out.println("Total Employees: " + Employee.getTotalEmployees());
        Employee.staticMethod();

        // Exception Handling: Menangkap dan mengelola pengecualian saat memanggil metode divide()
        try {
            manager.divide(10, 2);
            manager.divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
