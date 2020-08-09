package com.emysilva.model;

public class Member {
    private int memberId;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String memberType;
    private int priority;



    public Member(String memberType, int priority) {
        this.memberType = memberType;
        this.priority = priority;
    }


    public Member(int memberId, String firstname, String lastname, String emailAddress, String memberType, int priority) {
        this.memberId = memberId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.memberType = memberType;
        this.priority = priority;
    }



    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", memberType='" + memberType + '\'' +
                ", priority=" + priority +
                '}';
    }
}
