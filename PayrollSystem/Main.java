import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }

    abstract double calculatesalary();

    @Override
    public String toString(){
        return "Employee[name="+name+",id="+id+",+Salary="+calculatesalary()+"]";
    }
}

class Fulltimeemployee extends Employee{
    private double monthlysalary;

    public Fulltimeemployee(String name, int id, double monthlysalary){
        super(name, id);
        this.monthlysalary=monthlysalary;
    }

    @Override
    public double calculatesalary(){
        return monthlysalary;
    }
}

class ParttimeEmployee extends Employee{

    private int hoursworked;
    private double hourlyrate;

    public ParttimeEmployee(String name, int id, int hoursworked,double hourlyrate){
        super(name, id);
        this.hoursworked=hoursworked;
        this.hourlyrate=hourlyrate;

    }

    @Override
    public double calculatesalary(){
        return hoursworked*hourlyrate;
    }

}

class Payrollsystem{
    private ArrayList<Employee> employeelist;
    
    public Payrollsystem(){
        employeelist=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeelist.add(employee);
    }


    public void removeEmployee(int id){
        Employee employeetoremove=null;
        for(Employee employee: employeelist){
            if(employee.getId()==id){
                employeetoremove=employee;
            }
        }
        if(employeetoremove!=null){
            employeelist.remove(employeetoremove);
        }
    }

    public void displayEmployee(){
        for(Employee employee:employeelist){
            System.out.println(employee);
        }
    }

}

public class Main{
    public static void main(String[] args) {
        Payrollsystem payroll= new Payrollsystem();
        Fulltimeemployee emp1= new Fulltimeemployee("Virat", 18, 100000);
        ParttimeEmployee temp1 = new ParttimeEmployee("Rohit", 45, 8, 450);

        payroll.addEmployee(emp1);
        payroll.addEmployee(temp1);

        System.out.println("Initial Employee details: ");
        payroll.displayEmployee();

        System.out.println("Removing Employees..");
        payroll.removeEmployee(18);

        System.out.println("Remaining Details: ");
        payroll.displayEmployee();

    }
}