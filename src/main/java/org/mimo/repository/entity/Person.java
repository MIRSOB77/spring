package org.mimo.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.parser.DateParser;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mimo.utils.ChatRole;
import org.mimo.utils.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.datetime.DateFormatter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mirsad on 22.02.2015.
 */
@Entity
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"eMail", "nickname"})
)
public class Person {
    public Person(String nickname, String firstName, String lastName, String eMail, Gender gender, ChatRole role, String birth)
            throws ParseException {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.gender = gender;
        this.role = role;
        this.birth = new DateFormatter().parse(birth, Locale.getDefault());
    }

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "first_name")
    @NotEmpty
    String firstName;

    @Column(name = "last_name")
    @NotEmpty
    String lastName;

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}")
    String password;

    @NotNull
    @Email
    String eMail;

    @Column
    @NotNull
    Gender gender;

    @NotNull
    @Column
    java.util.Date birth;

    @Column
    @NotEmpty
    String nickname;

    @Column
    ChatRole role = ChatRole.COMMON;

    @JsonIgnore
    @Column
    Boolean online;

    @JsonIgnore
    @Column
    String ssoToken;

    @OneToMany(mappedBy = "receiver")
    List<ChatMessage> inBoxMessages;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ChatRole getRole() {
        return role;
    }

    public void setRole(ChatRole role) {
        this.role = role;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSsoToken(String ssoToken) {
        this.ssoToken = ssoToken;
    }
}

