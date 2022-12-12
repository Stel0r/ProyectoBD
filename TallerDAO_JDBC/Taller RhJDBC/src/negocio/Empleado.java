package negocio;
/**
 * Clase que encapsula los datos del Empleado (DTO)
 * @author Alba Consuelo Nieto.
 */
public class Empleado {
    private int     employee_id;
    private String  first_name;
    private String  last_name;
    private String  email;
    private String  job_id;
    private String  hire_date;
    private Double  salary;
    public Empleado() {   
    }

    public void setEmployee_id(int empleado_id) {
        this.employee_id = empleado_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setFirst_name(String nombre) {
        this.first_name = nombre;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String apellido) {
        this.last_name = apellido;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }
}


