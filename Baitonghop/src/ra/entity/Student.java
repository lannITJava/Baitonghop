package ra.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Student implements IEntity<Student> , Serializable {
    private String studentId;
    private String studentName;
    private Date birthday;
    private int age;
    private boolean sex;
    private float htmlMark;
    private float cssMark;
    private float javascriptMArk;
    private float avgMark;
    private String rank;

    public Student() {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.age = age;
        this.sex = sex;
        this.htmlMark = htmlMark;
        this.cssMark = cssMark;
        this.javascriptMArk = javascriptMArk;
        this.avgMark = avgMark;
        this.rank = rank;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getHtmlMark() {
        return htmlMark;
    }

    public void setHtmlMark(float htmlMark) {
        this.htmlMark = htmlMark;
    }

    public float getCssMark() {
        return cssMark;
    }

    public void setCssMark(float cssMark) {
        this.cssMark = cssMark;
    }

    public float getJavascriptMArk() {
        return javascriptMArk;
    }

    public void setJavascriptMArk(float javascriptMArk) {
        this.javascriptMArk = javascriptMArk;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public void inputData(Scanner scanner, List<Student> studentList) {
        System.out.println("NHập mã sinh viên: ");
        boolean checkStudentId = true;
        do {
            this.studentId = scanner.nextLine();
            boolean isExit = false;
                for (Student stu: studentList) {
                    if (stu.getStudentId().equals(this.studentId)){
                        isExit = true;
                        break;
                    }
                }
            if (isExit){
                System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại");
            }else {
                if (this.studentId.length()==4){
                    if (this.studentId.charAt(0)=='S'){
                        checkStudentId= false;
                    }else {
                        System.err.println("Mã sinh viên phải bắt đầu bằng chữ S, vui lòng nhập lại");
                    }
                }else {
                    System.err.println("Mã sinh viên phải gồm 4 ký tự, vui lòng nhập lại");
                }
            }
        }while (checkStudentId);
        System.out.println("Nhập tên sinh viên: ");
        boolean checkStudentName = true;
        do {
            this.studentName= scanner.nextLine();
            if (this.studentName.length()>=10 && this.studentName.length()<=50){
                checkStudentName= false;
            }else {
                System.err.println("Tên sinh viên có từ 10-50 ký tự,vui lòng nhập lại");
            }
        }while (checkStudentName);
        this.birthday= Student.validateDate(scanner);
        this.sex = Student.inputBoolean(scanner);
        System.out.println("Nhập điểm HTML: ");
        boolean checkHtml = true;
        do {

            try {
                this.htmlMark = Float.parseFloat(scanner.nextLine());
                if (this.htmlMark>=0 && this.htmlMark<=10){
                    checkHtml= false;
                }else {
                    System.err.println("Điểm html có giá trị trong khoảng 0-10, vui lòng nhập lại");
                }
            }catch (NumberFormatException ex){
                System.err.println("Điển html phải là số nguyên, vui lòng nhập lại");
            }catch (Exception ex1){
                System.err.println("Xảy ra lỗi trong quá trình xử lý, vui lòng nhập lại");
            }
        }while (checkHtml);
        System.out.println("Nhập điểm CSS: ");
        boolean checkCss = true;
        do {

            try {
                this.cssMark = Float.parseFloat(scanner.nextLine());
                if (this.cssMark>=0 && this.cssMark<=10){
                    checkCss= false;
                }else {
                    System.err.println("Điểm css có giá trị trong khoảng 0-10, vui lòng nhập lại");
                }
            }catch (NumberFormatException ex){
                System.err.println("Điển css phải là số nguyên, vui lòng nhập lại");
            }catch (Exception ex1){
                System.err.println("Xảy ra lỗi trong quá trình xử lý, vui lòng nhập lại");
            }
        }while (checkCss);
        System.out.println("Nhập điểm JAVASCRIPT: ");
        boolean checkJavascript = true;
        do {

            try {
                this.javascriptMArk = Float.parseFloat(scanner.nextLine());
                if (this.javascriptMArk>=0 && this.javascriptMArk<=10){
                    checkJavascript= false;
                }else {
                    System.err.println("Điểm javascript có giá trị trong khoảng 0-10, vui lòng nhập lại");
                }
            }catch (NumberFormatException ex){
                System.err.println("Điển javascript phải là số nguyên, vui lòng nhập lại");
            }catch (Exception ex1){
                System.err.println("Xảy ra lỗi trong quá trình xử lý, vui lòng nhập lại");
            }
        }while (checkJavascript);
    }

    @Override
    public void displayData() {
        String displaySex = this.sex ? "Nam" : "Nữ" ;
        System.out.printf("Mã sinh viên: %s - Tên sinh viên: %s - Ngày tháng năm sinh: %D\n", this.studentId,this.studentName,this.birthday);
        System.out.printf("Tuổi sinh viên: %d - Giới tính: %b\n",this.age,this.sex);
        System.out.printf("Điểm html: %1f - Điểm css: %1f - Điểm javascript: %1f\n", this.htmlMark, this.cssMark, this.javascriptMArk);
        System.out.printf("Điểm trung bình: %1f - Xếp loạ: %s\n", this.avgMark, this.rank);
    }

    @Override
    public void calAge() {
        Date now = new Date();
        this.age = now.getYear() - this.birthday.getYear();
    }

    @Override
    public void calAvgMark_Rank() {
        this.avgMark = (htmlMark+cssMark+javascriptMArk)/3;
        if (this.avgMark<5){
            this.rank= "Yếu";
        }else if (this.avgMark<7){
            this.rank="Trung bình";
        }else if (this.avgMark<8){
            this.rank = "Khá";
        }else if (this.avgMark<9){
            this.rank = "Giỏi";
        }else {
            this.rank = "Xuất sắc";
        }
    }
    public static Date validateDate(Scanner scanner){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập vào ngày tháng năm sinh: ");
        do {
            try{
                Date birthDay = sdf.parse(scanner.nextLine());
                Calendar cal = Calendar.getInstance();
                cal.setTime(birthDay);
                if (cal.get(Calendar.YEAR)<2005){
                    return birthDay;
                }else {
                    System.err.println("Năm sinh phải nhỏ hơn 2005, vui lòng nhập lại");
                }
            }catch (ParseException pa){
                System.err.println("Dữ liệu không đúng định dạng dd-MM-yyyy, vui lòng nhập lại");
            }catch (Exception ex){
                System.err.println("Xảy ra lỗi trong qúa trình xử lý, vui lòng nhệp lại");
            }
        }while (true);
    }
    public static boolean inputBoolean(Scanner scanner){
        System.out.println("Nhập vào giới tính sinh viên: ");
        do {
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false")){
                return Boolean.parseBoolean(str);
            }else {
                System.err.println("Dữ liệu không phải kiểu Boolean, vui lòng nhập lại");
            }
        }while (true);
    }
//    public static int calAge(Date birth, Date currentDate){
//        return Period.between(birth,currentDate).getYears();
//    }
}
