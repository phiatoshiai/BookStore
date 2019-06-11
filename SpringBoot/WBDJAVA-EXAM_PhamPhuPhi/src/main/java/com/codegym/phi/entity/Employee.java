package com.codegym.phi.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @NotNull(message = "Vui lòng nhập ID")
    private int id;

    @Column(name = "name")
    @NotNull(message = "Vui lòng điền tên")
    private String name;

    @Column(name = "date")
    @NotNull
    private String date;

    @Column(name = "sex")
    @NotNull(message = "Vui lòng chọn giới tính")
    private String sex;

    @Column(name = "phone")
    @Pattern(regexp = "(0[7|8|9])+([0-9]{8})\\b", message = "Vui lòng nhập 10 số điện thoại đúng định dạng: 07/08/09 + ...")
    @NotNull
    private String phone;

    @Column(name = "idcard")
    @NotNull
    @Pattern(regexp = "[0-9]{9}", message = "Số chứng minh nhân dân có 9 kí tự số")
    private String idCard;

    @Column(name = "email")
    @Email(message = "Email cần nhập phải đúng định dạng @ mail . com")
    @NotNull
    private String email;

    @Column(name = "address")
    @NotNull(message = "Vui lòng nhập địa chỉ")
    private String address;

    @NotNull(message = "Vui lòng lựa chọn Nhóm nhân ")
    @Column(name = "groupemp")
    private String groupemp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public String setIdCard(String idCard) {
        return this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroupemp() {
        return groupemp;
    }

    public void setGroupemp(String groupemp) {
        this.groupemp = groupemp;
    }
}
