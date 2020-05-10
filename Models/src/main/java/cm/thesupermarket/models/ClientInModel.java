/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.models;

import java.util.Date;
import org.apache.commons.lang.Validate;

/**
 *
 * @author ryank
 */
public class ClientInModel {

    private Long id;
    private String name;
    private String firstname;
    private Date birthday;
    private int age;
    private int phone;
    private String email;
    private String password;
    private Long countryId;
    private Long sexId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Validate.isTrue(id > 0, "Json data can't contains empty or null element");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validate.isTrue(name != null && !name.isEmpty(), "Json data can't contains empty or null element");
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        Validate.isTrue(firstname != null && !firstname.isEmpty(), "Json data can't contains empty or null element");
        this.firstname = firstname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        Validate.isTrue(birthday != null, "Json data can't contains empty or null element");
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Validate.isTrue(age > 0, "Json data can't contains empty or null element");
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        Validate.isTrue(phone > 0, "Json data can't contains empty or null element");
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validate.isTrue(email != null && !email.isEmpty(), "Json data can't contains empty or null element");
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Validate.isTrue(!password.isEmpty() && password != null, "Json data can't contains empty or null element");
        this.password = password;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        Validate.isTrue(countryId > 0, "Json data can't contains empty or null element");
        this.countryId = countryId;
    }

    public Long getSexId() {
        return sexId;
    }

    public void setSexId(Long sexId) {
        Validate.isTrue(sexId > 0, "Json data can't contains empty or null element");
        this.sexId = sexId;
    }

}
