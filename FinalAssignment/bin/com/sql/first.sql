CREATE TABLE Instructor (
  Instructor_ID varchar(255) PRIMARY KEY,
  Name varchar(255),
  Address varchar(255),
  Year_of_experience varchar(255),
  Citizenship_Number varchar(255),
  Pan_number varchar(255),
  DOB varchar(255),
  Email_address varchar(255),
  Password varchar(255),
  Module_1 varchar(255),
  Module_2 varchar(255)
);

CREATE TABLE Courses (
  Course_ID varchar(255) PRIMARY KEY,
  Course_name varchar(255)
);

CREATE TABLE Module (
  Course_ID varchar(255),
  Module_name varchar(255),
  Module_code varchar(255),
  PRIMARY KEY (Course_ID, Module_code)
);

CREATE TABLE Student (
  Student_ID varchar(255) PRIMARY KEY,
  Name varchar(255),
  Address varchar(255),
  DOB varchar(255),
  Citizenship_Number varchar(255),
  Email_address varchar(255),
  College_email_address varchar(255),
  College_email_address_password varchar(255),
  Course_ID varchar(255),
  FOREIGN KEY (Course_ID) REFERENCES Courses(Course_ID)
);

CREATE TABLE Assignment (
  Course_ID varchar(255),
  Module_code varchar(255),
  Assignment_Number varchar(255),
  Student_ID varchar(255),
  Instructor_ID varchar(255),
  Submitted varchar(255),
  PRIMARY KEY (Course_ID, Module_code, Assignment_Number),
  FOREIGN KEY (Course_ID) REFERENCES Courses(Course_ID),
  FOREIGN KEY (Module_code) REFERENCES Module(Module_code),
  FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID),
  FOREIGN KEY (Instructor_ID) REFERENCES Instructor(Instructor_ID)
);

CREATE TABLE Course_Administrator (
  login_email varchar(255) PRIMARY KEY,
  login_psw varchar(255)
);