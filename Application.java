import java.util.*;

class Date
{
  int d,m,y;
  Scanner sc = new Scanner(System.in);
  Date()
  {
    int i;

    System.out.print("Date - ");
    while(true)
    {
      while(true)
      {
        try
        {
           i = sc.nextInt();
           break;
         }
         catch(InputMismatchException ex)
         {
           System.out.println("Please enter an integer:");
           String dump1 = sc.next();
         }

       }
       if(i<=0 || i>31)
       {
         System.out.print("Enter a valid date (1-31) - ");
         continue;
       }
       else
       break;
     }

    this.d = i;
    System.out.print("Month - ");
    while(true)
    {
      while(true)
      {
        try
        {
           i = sc.nextInt();
           break;
         }
         catch(InputMismatchException ex)
         {
           System.out.println("Please enter an integer:");
           String dump1 = sc.next();
         }

       }
       if(i<=1 || i>12)
       {
         System.out.print("Enter a valid month (1-12) - ");
         continue;
       }
       else
       break;
     }

    this.m = i;
    System.out.print("Year - ");
    while(true)
    {
      while(true)
      {
        try
        {
           i = sc.nextInt();
           break;
         }
         catch(InputMismatchException ex)
         {
           System.out.println("Please enter an integer:");
           String dump1 = sc.next();
         }

       }
       if(i<=1949 || i>2050)
       {
         System.out.print("Enter a valid year (1950-2050) - ");
         continue;
       }
       else
       break;
     }

    this.y = i;
  }
  public String disp()
  {
    return this.d+"-"+this.m+"-"+this.y;
  }
}
class Student
{
  Scanner sc = new Scanner(System.in);
  String name,add;
  int id;
  long mobile;
  Date doj,dob;
  char gender;

  Student()
  {
    System.out.print("Enter Student name : ");
    this.name = sc.nextLine();
    System.out.print("Enter id of Student : ");
    int i = 0;
    while(true)
    {
      try
      {
         i = sc.nextInt();
         break;
       }
       catch(InputMismatchException ex)
       {
         System.out.print("Please enter an integer:");
         String dump1 = sc.next();
       }
     }
     this.id = i;
    System.out.print("Enter gender : ");
    this.gender = sc.next().charAt(0);
    System.out.print("Enter address of Student : ");
    String dump = sc.nextLine();
    this.add = sc.nextLine();
    System.out.print("Enter mobile no : ");
    long ll = 0;
    while(true)
    {
      try
      {
         ll = sc.nextLong();
         break;
       }
       catch(InputMismatchException ex)
       {
         System.out.print("Please enter a valid mobile no : ");
         String dump2 = sc.next();
       }
     }
    this.mobile = ll;
    System.out.print("Enter date of birth of Student (dd mm yyyy) : ");
    this.dob = new Date();
    System.out.print("Enter date of joining (dd mm yyyy) : ");
    this.doj = new Date();
  }
  public void displayData()
  {

    System.out.format("%5s %15s %7c %20s %20s %15s %15s",this.id, this.name, this.gender, this.add, this.mobile, this.dob.disp(), this.doj.disp());
    System.out.println();

  }
}


class Application
{
  static ArrayList<Student> StudentList = new ArrayList<>();

  public static boolean valid(int id)
  {
    for(int i=0;i<StudentList.size();i++)
    {
      Student obj = StudentList.get(i);
      if(obj.id==id)
      return true;
    }
    return false;
  }

  public static int getStudentobj(int id)
  {
    int i;
    for( i=0;i<StudentList.size();i++)
    {
      Student obj = StudentList.get(i);
      if(obj.id==id)
      break;
      //return i;
    }
    return i;
  }
  public static void printAll()
  {
    System.out.println("------------------------------------------------------------------------------------------------------------------");
    System.out.printf("%5s %10s %10s %15s %20s %15s %15s", "STUDENT ID", "Name", "Gender", "Address", "Mobile" , "DoB" , "DoJ");
    System.out.println();
    System.out.println("------------------------------------------------------------------------------------------------------------------");
    for(int i=0;i<StudentList.size();i++)
    {
      Student obj = StudentList.get(i);
      obj.displayData();
    }
  }
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("STUDENT MANAGEMENT SYSTEM");
    System.out.println("--------------------------");
    boolean set = true;
    while(set)
    {
      System.out.println("Enter your choice : ");
      System.out.println();
      System.out.println("1.Add Student details");
      System.out.println("2.View Single Student details");
      System.out.println("3.View all Student details");
      System.out.println("4.Update Student details");
      System.out.println("5.Delete Student details");
      System.out.println("6.Quit");
      System.out.println();
      int option = 0,a;
      System.out.println();
      while(true)
      {
        try
        {
           a = sc.nextInt();
           break;
         }
         catch(InputMismatchException ex)
         {
           System.out.println("Please enter an integer:");
           String dump1 = sc.next();
         }

       }
      option = a;
      switch(option)
      {
        case 1:
          System.out.println("Please enter the required details : ");
          Student obj = new Student();
          StudentList.add(obj);
          System.out.println("New Student details added successfully");
          break;
        case 2:
          if(StudentList.size()==0)
          {
            System.out.println("No data to Display");
            break;
          }
          System.out.print("Enter Student ID to display : ");
          int i=0;
          boolean flag = true;
          while(flag)
          {
            while(true)
            {
              try
              {
                 i = sc.nextInt();
                 break;
               }
               catch(InputMismatchException ex)
               {
                 System.out.println("Please enter an integer:");
                 String dump1 = sc.next();
               }

             }
            int id = i;
            if(valid(id))
            {
              int index = getStudentobj(id);
              Student ob = StudentList.get(index);
              System.out.println("------------------------------------------------------------------------------------------------------------------");
              System.out.printf("%5s %10s %10s %15s %20s %15s %15s", "STUDENT ID", "Name", "Gender", "Address", "Mobile" , "DoB" , "DoJ");
              System.out.println();
              System.out.println("--------------------------------------------------------------------------------------------------------------");
              ob.displayData();
              flag = false;
            }
            else
            {
              System.out.print("Please enter a valid id which is in Student Data : ");
            }
          }
          break;
        case 3:
          printAll();
          break;
        case 4:
          if(StudentList.size()==0)
          {
            System.out.println("No data to UPDATE");
            break;
          }
          System.out.println("Enter Student ID to UPDATE:");
          boolean f1 = true;
          while(f1)
          {

            int id = sc.nextInt();
            if(valid(id))
            {
              int index = getStudentobj(id);
              Student ob = new Student();
              StudentList.set(index,ob);
              System.out.println("Student details updated successfully");
              f1 = false;
            }
            else
            {
              System.out.print("Please enter a valid id : ");
            }
          }
          break;
        case 5:
          if(StudentList.size()==0)
          {
            System.out.println("No data to DELETE");
            break;
          }
          System.out.println("Enter Student ID to DELETE:");
          boolean f2 = true;
          while(f2)
          {
            int id = sc.nextInt();
            if(valid(id))
            {
              int index = getStudentobj(id);
              StudentList.remove(index);
              System.out.println("Student details DELETED successfully");
              f2 = false;
            }
            else
            {
              System.out.print("Please enter a valid id : ");
            }
          }
          break;
        case 6:
          System.out.println("You have successfully quitted the program application:");
          System.out.println("*******************************************************");
          System.out.println("---------------THANK YOU---------------");
          set = false;
          break;
        default :
          System.out.println("Please enter a valid option (1-6)");
          break;
      }
      System.out.println();

    }
    System.out.println("End of program");

  }
}
