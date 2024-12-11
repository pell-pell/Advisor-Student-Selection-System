package com.example.model;

import java.sql.Date;

public class Candidate {
    private String candidateId;
    private String name;
    private Date birthDate;
    private String idCard;
    private String region;
    private String undergraduateMajor;
    private String undergraduateSchool;
    private String schoolType;
    private String email;
    private String phone;
    private String resume;
 // 无参构造函数
    public Candidate() {
    }

    // 全参构造函数
    public Candidate(String candidateId, String name, Date birthDate, String idCard, String region,
                     String undergraduateMajor, String undergraduateSchool, String schoolType, String email,
                     String phone, String resume) {
        this.candidateId = candidateId;
        this.name = name;
        this.birthDate = birthDate;
        this.idCard = idCard;
        this.region = region;
        this.undergraduateMajor = undergraduateMajor;
        this.undergraduateSchool = undergraduateSchool;
        this.schoolType = schoolType;
        this.email = email;
        this.phone = phone;
        this.resume = resume;
    }

    // Getter和Setter方法
    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUndergraduateMajor() {
        return undergraduateMajor;
    }

    public void setUndergraduateMajor(String undergraduateMajor) {
        this.undergraduateMajor = undergraduateMajor;
    }

    public String getUndergraduateSchool() {
        return undergraduateSchool;
    }

    public void setUndergraduateSchool(String undergraduateSchool) {
        this.undergraduateSchool = undergraduateSchool;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
    //重写toString方法
    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId='" + candidateId + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", idCard='" + idCard + '\'' +
                ", region='" + region + '\'' +
                ", undergraduateMajor='" + undergraduateMajor + '\'' +
                ", undergraduateSchool='" + undergraduateSchool + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }
}
