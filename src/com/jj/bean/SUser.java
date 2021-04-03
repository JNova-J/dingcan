package com.jj.bean;

public class SUser {
    private Integer id;
    private String username;
    private String password;
    private String pusername;
    private String email;
    private String address;
    private String phone;
    private Integer role;

    public SUser() {
    }

    public SUser(Integer id, String username, String password, String pusername, String email, String address, String phone,Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.pusername =pusername;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.role=role;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPusername() {
        return pusername;
    }

    public void setPusername(String pusername) {
        this.pusername = pusername;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "SUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pusername='" + pusername + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                '}';
    }
}
