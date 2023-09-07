package ra.model;


import org.springframework.validation.Errors;



public class User {
    private Long id;
    private String Firstname;
    private String lastname;
    private int Age;
    private String phone;
    private String Email;

    public User() {
    }

    public User(Long id, String firstname, String lastname, int age, String phone, String email) {
        this.id = id;
        Firstname = firstname;
        this.lastname = lastname;
        Age = age;
        this.phone = phone;
        Email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean supports(Class<?> clazz) {
        return false;
    }

    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(user.Firstname.trim().equals("")){
            errors.rejectValue("firstname", "invalid.empty");
        } else if (!user.Firstname.matches("(^[a-zA-Z0-9._#?!@$%^&*-]{5,45}$)")) {
            errors.rejectValue("firstname", "invalid.name");
        } else if (user.lastname.trim().equals("")){
            errors.rejectValue("lastname", "invalid.empty");
        }  else if (!user.lastname.matches("(^[a-zA-Z0-9._#?!@$%^&*-]{5,45}$)")) {
            errors.rejectValue("lastname", "invalid.name");
        } else if (!user.phone.matches("(^0\\d{9}$)")){
            errors.rejectValue("phone", "invalid.tel");
        } else if (!user.Email.matches("(^[A-Za-z0-9]+[A-Za-z0-9._%+-]*@[a-z]+(\\.[a-z]+)$)")){
            errors.rejectValue("email", "invalid.email");
        } else if (user.Age<18){
            errors.rejectValue("age", "invalid.age");
        }
    }
}
