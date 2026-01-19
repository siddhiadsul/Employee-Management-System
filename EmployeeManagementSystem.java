package level2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class EmployeeManagementSystem {
    public static void main(String[] args) {
         Scanner in=new Scanner(System.in);
         ArrayList<Employee> employeeList=new ArrayList<>();

         int choice;
        System.out.println("===Employee Management System===");

        while(true){
            System.out.println("\nMenu");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.println("Enter your choice");
            choice=in.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter Employee ID: ");
                    int id=in.nextInt();

                    in.nextLine();
                    System.out.println("Enter Employee Name: ");
                    String name =in.nextLine();

                    System.out.println("Enter Employee Salary: ");
                    double salary=in.nextDouble();

                    Employee emp=new Employee(id,name,salary);
                    employeeList.add(emp);

                    System.out.println("Employee added successfully!!");
                    break;
                case 2:
                    if(employeeList.isEmpty()){
                        System.out.println("No Employee found..");
                    }
                    else{
                        System.out.println("\n----Employee List----");
                        for(Employee e:employeeList){
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    if(employeeList.isEmpty()){
                        System.out.println("No Employee is available to update.");
                        break;
                    }
                    System.out.println("Enter employee ID to update: ");
                    int updateID=in.nextInt();

                    in.nextLine();

                    boolean found= false;
                    for(Employee e:employeeList){
                        if(e.getID()==updateID){
                            System.out.println("Enter new name: ");
                            String newName=in.nextLine();

                            System.out.println("Enter new Salary: ");
                            double newSalary=in.nextDouble();

                            e.setName(newName);
                            e.setSalary(newSalary);

                            System.out.println("Employee updated successfully!");
                            found=true;

                            break;

                        }
                    }
                    if(!found){
                        System.out.println("Employee ID"+updateID+"not found.");
                    }
                    break;
                case 4:
                    if(employeeList.isEmpty()){
                        System.out.println("No Employee is available to Delete.");
                        break;
                    }
                    System.out.println("Enter employee ID to Delete: ");
                    int deleteID=in.nextInt();

                  Employee employeeToDelete=null;


                    for(Employee e:employeeList){
                        if(e.getID()==deleteID){
                            employeeToDelete=e;
                            break;
                        }
                    }
                    if(employeeToDelete!=null){
                        employeeList.remove(employeeToDelete);
                        System.out.println("Employee deleted successfullu!!!");
                    }else{
                        System.out.println("Employee ID"+deleteID+"not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Program!");
                    in.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
            }

        }
    }
}
