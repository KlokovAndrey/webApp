package com.web.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Person {

    private String firstName = "";
    private String secondName = "";
    private String thirdName;
    private int age;
    private int salary;
    private String email;
    private String placeWork;

    public void writeToFile(){
        try(FileWriter writer = new FileWriter("person.txt", true)) {
            if(firstName == "" || secondName == "") return;
            writer.write(firstName+secondName + '\n');
            writer.write(secondName+ '\n');
            writer.write(firstName + '\n');
            writer.write(thirdName + '\n');
            writer.write("" + age + '\n');
            writer.write("" + salary + '\n');
            writer.write(email + '\n');
            writer.write(placeWork + '\n' + '\n');
            writer.flush();
        }
        catch(IOException ex){

            ex.printStackTrace();
        }
    }


    public boolean search() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("person.txt"));
            String line;
            boolean flag = false;
            String str = firstName+secondName;
            while ((line = reader.readLine()) != null) {
                if(line.equals(str)){
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
            reader.readLine();
            reader.readLine();
            thirdName = reader.readLine();
            age = Integer.parseInt(reader.readLine());
            salary = Integer.parseInt(reader.readLine());
            email = reader.readLine();
            placeWork = reader.readLine();
            return true;
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return false;
    }

//    public boolean search() {
//        try (FileReader reader = new FileReader("person.txt")) {
//            char[] buf = new char[256];
//            int c;
//            String str = firstName + secondName;
//            while (buf != str.toCharArray()) {
//                while ((c = reader.read(buf)) > 0) {
//
//                    if (c < 256) {
//                        buf = Arrays.copyOf(buf, c);
//                    }
//                }
//            }
//            str = "]";
//            while (buf != str.toCharArray()) {
//
//                while ((c = reader.read(buf)) > 0) {
//
//                    if (c < 256) {
//                        buf = Arrays.copyOf(buf, c);
//                    }
//                }
//            }
//
//        } catch (IOException ex) {
//
//            System.out.println(ex.getMessage());
//        }
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }
}
