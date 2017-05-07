package com.course.entity;

public class Coursemess {
    private String courseNo;

    private String techNo;

    private String courseTime;

    private String courseScore;

    private String courseDescribe;

    private String courseName;

    private int courseNumber;
    
    private Studentmess studentmess;
    
    private Teachermess teachermess;
    
    private String courseStatus;
    
    private int courseSumno;
    
    public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
    }

    public String getTechNo() {
        return techNo;
    }

    public void setTechNo(String techNo) {
        this.techNo = techNo == null ? null : techNo.trim();
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }

    public String getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(String courseScore) {
        this.courseScore = courseScore == null ? null : courseScore.trim();
    }

    public String getCourseDescribe() {
        return courseDescribe;
    }

    public void setCourseDescribe(String courseDescribe) {
        this.courseDescribe = courseDescribe == null ? null : courseDescribe.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

	public Studentmess getStudentmess() {
		return studentmess;
	}

	public void setStudentmess(Studentmess studentmess) {
		this.studentmess = studentmess;
	}

	public Teachermess getTeachermess() {
		return teachermess;
	}

	public void setTeachermess(Teachermess teachermess) {
		this.teachermess = teachermess;
	}

	public int getCourseSumno() {
		return courseSumno;
	}

	public void setCourseSumno(int courseSumno) {
		this.courseSumno = courseSumno;
	}
	
}