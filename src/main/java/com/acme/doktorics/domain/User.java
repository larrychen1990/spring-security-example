package com.acme.doktorics.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    private String location;
    private Integer age;
    private Date birthdate;
    @JoinTable
    private List<String> rights = new ArrayList<String>();

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<UserRight> getRights() {
        List<UserRight> rights = new ArrayList<UserRight>();
        for (String item : this.rights) {
            rights.add(UserRight.parse(item));
        }
        return rights;
    }

    public void setRights(List<UserRight> userRight2) {
        for (UserRight item : userRight2) {
            if (this.rights.add(item.getRight()))
            {
                this.rights.add(item.getRight());
            }
        }

    }

    public enum UserRight {

        ADMIN_ROLE("ADMIN_ROLE"),
        USER_ROLE("USER_ROLE");

        private String right;

        private UserRight(String right)
        {
            this.right = right;
        }

        public String getRight() {
            return right;
        }

        public void setRight(String right) {
            this.right = right;
        }

        public static UserRight parse(String name) {
            UserRight right = null; // Default
            for (UserRight item : UserRight.values()) {
                if (item.getRight() == name) {
                    right = item;
                    break;
                }
            }
            return right;
        }

    }

}
