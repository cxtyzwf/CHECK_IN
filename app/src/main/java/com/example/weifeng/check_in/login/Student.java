package com.example.weifeng.check_in.login;

public class Student {
    public StudentBean getStudent() {
        return studentBean;
    }

    public void setStudent(StudentBean student) {
        this.studentBean = student;
    }

    StudentBean studentBean;

    public static class StudentBean{
        String stuId;
        String stuPassword;

        public String getStuId() {
            return stuId;
        }

        public void setStuId(String stuId) {
            this.stuId = stuId;
        }

        public String getStuPassword() {
            return stuPassword;
        }

        public void setStuPassword(String stuPassword) {
            this.stuPassword = stuPassword;
        }

        public StudentBean (String stuId, String stuPassword) {
            this.stuId = stuId;
            this.stuPassword = stuPassword;
        }
    }


}
