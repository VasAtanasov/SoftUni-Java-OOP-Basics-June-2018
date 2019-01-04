package L05Encapsulation.ex03ValidationData;

class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(ErrorMessages.AGE_ERROR);
        }
        this.age = age;
    }

    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(ErrorMessages.LAST_NAME_ERROR);
        }
        this.lastName = lastName;
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException(ErrorMessages.FIRST_NAME_ERROR);
        }
        this.firstName = firstName;
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException(ErrorMessages.SALARY_ERROR);
        }
        this.salary = salary;
    }

    int getAge() {
        return this.age;
    }

    void increaseSalary(double bonus) {
        if (this.age > 30) {
            this.salary += this.salary * bonus / 100;
        } else {
            this.salary += this.salary * bonus / 200;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, this.salary);
    }
}
