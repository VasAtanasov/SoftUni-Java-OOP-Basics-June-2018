package L08InheritanceExercises.ex03Mankind;

class Worker extends Human {
    private double salary;
    private double workHours;

    Worker(String firstName, String lastName, double salary, double workHours) {
        super(firstName, lastName);
        this.setSalary(salary);
        this.setWorkHours(workHours);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private void setSalary(double salary) {
        if (salary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.salary = salary;
    }

    private void setWorkHours(double workHours) {
        if (workHours < 1 || workHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHours = workHours;
    }

    private double getDailySalary() {
        return this.getSalary() / 7 / this.getWorkHours();
    }

    private double getSalary() {
        return salary;
    }

    private double getWorkHours() {
        return workHours;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(String.format("Week Salary: %.2f", this.getSalary()))
                .append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.getWorkHours()))
                .append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.getDailySalary()))
                .append(System.lineSeparator());
        return output.toString();
    }
}

