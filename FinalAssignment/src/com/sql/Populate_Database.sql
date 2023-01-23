-- Insert the name of the course in the Course column
INSERT INTO Courses (Course_ID, Course_name) VALUES ('CS101', 'BSC. (Hons) in Computer Science');
INSERT INTO Courses (Course_ID, Course_name) VALUES ('IBM101', 'BSC. (Hons) in International Business Management');

-- Insert the name of the module in the Module column
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Academic Skills and Team-Based Learning', '4CI018');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Introductory Programming And Problem Solving', '4CS001');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Computational Mathematics', '4MM013');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Embedded System Programming', '4CS016');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Concepts and Technologies of AI', '5CS037');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Object-Oriented Design and Programming', '5CS019');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Numerical Methods and Concurrency', '5CS021');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Collaborative Development', '5CS024');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Distributed and Cloud System Programming', '5CS022');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Human - Computer Interaction', '5CS020');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'High Performance Computing', '6CS005');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Big Data', '6CS030');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Project and Professionalism', '6CS007');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Artificial Intelligence and Machine Learning', '6CS012');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Complex Systems', '6CS014');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('CS101', 'Internet Software Architecture', '4CS017');

-- Insert the name of the student in the Student column
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S1', 'Ram Sharma', '789 Elm St', '03/03/1990', '1112223333', 'ramsharma@example.com', 'ramsharma@college.com', 'password123', 'CS101');
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S2', 'Sita Devi', '456 Park Ave', '02/02/1995', '0987654321', 'sitadevi@example.com', 'sitadevi@college.com', 'password456', 'IBM101');
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S3', 'Hari Sharma', '123 Main St', '01/01/1995', '1112223333', 'harisharma@example.com', 'harisharma@college.com', 'password789', 'CS101');
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S4', 'Ganga Devi', '789 Elm St', '04/04/1992', '0987654321', 'gangadevi@example.com', 'gangadevi@college.com', 'password111', 'IBM101');
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S5', 'Krishna Pandey', '789 Elm St', '05/05/1995', '1112223333', 'krishnapandey@example.com', 'krishnapandey@college.com', 'password222', 'CS101');
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S6', 'Saraswoti Sharma', '456 Park Ave', '06/06/1994', '0987654321', 'saraswotisharma@example.com', 'saraswotisharma@college.com', 'password321', 'IBM101');
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S7', 'Bikram Shah', '789 Elm St', '07/07/1997', '1112223333', 'bikramshah@example.com', 'bikramshah@college.com', 'password456', 'CS101');
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S8', 'Kamala Sharma', '123 Main St', '08/08/1996', '0987654321', 'kamalasharma@example.com', 'kamalasharma@college.com', 'password654', 'IBM101');
INSERT INTO Student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('S9', 'Rajesh Pandey', '789 Elm St', '09/09/1995', '1112223333', 'rajeshpandey@example.com', 'rajeshpandey@college.com', 'password789', 'IBM101');

-- Insert the name of the module in the Module column
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'Introduction to International Business', 'IBM10101');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'Marketing Management', 'IBM10102');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'Global Business Environment', 'IBM10103');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'Cross-Cultural Management', 'IBM10104');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'Business Research Methods', 'IBM10105');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Financial Management', 'IBM10106');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Human Resource Management', 'IBM10107');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Marketing', 'IBM10108');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Business Law', 'IBM10109');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Business Strategy', 'IBM10110');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Business Ethics', 'IBM10111');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Business Negotiation', 'IBM10112');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Business Project', 'IBM10113');
INSERT INTO Module (Course_ID, Module_name, Module_code) VALUES ('IBM101', 'International Business Dissertation', 'IBM10114');


-- Insert marks for students in CS101
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '4CI018', 'CS101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '4CS001', 'CS101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '4MM013', 'CS101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '4CS016', 'CS101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS037', 'CS101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS019', 'CS101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS021', 'CS101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS024', 'CS101', 60);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS022', 'CS101', 50);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS020', 'CS101', 40);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '6CS005', 'CS101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '6CS030', 'CS101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '6CS007', 'CS101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '6CS012', 'CS101', 60);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '6CS014', 'CS101', 50);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '4CS017', 'CS101', 40);

INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '4CI018', 'CS101', 50);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '4CS001', 'CS101', 60);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '4MM013', 'CS101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '4CS016', 'CS101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '5CS037', 'CS101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '5CS019', 'CS101', 62);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '5CS021', 'CS101', 52);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '5CS024', 'CS101', 42);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '5CS022', 'CS101', 89);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '5CS020', 'CS101', 79);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '6CS005', 'CS101', 69);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '6CS030', 'CS101', 59);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '6CS007', 'CS101', 49);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '6CS012', 'CS101', 44);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '6CS014', 'CS101', 99);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '4CS017', 'CS101', 89);

INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '4CI018', 'CS101', 50);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '4CS001', 'CS101', 60);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '4MM013', 'CS101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '4CS016', 'CS101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '5CS037', 'CS101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '5CS019', 'CS101', 62);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '5CS021', 'CS101', 52);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '5CS024', 'CS101', 42);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '5CS022', 'CS101', 89);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '5CS020', 'CS101', 79);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '6CS005', 'CS101', 69);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '6CS030', 'CS101', 59);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '6CS007', 'CS101', 49);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '6CS012', 'CS101', 44);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '6CS014', 'CS101', 99);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S5', '4CS017', 'CS101', 89);

INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '4CI018', 'CS101', 65);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '4CS001', 'CS101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '4MM013', 'CS101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '4CS016', 'CS101', 95);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '5CS037', 'CS101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '5CS019', 'CS101', 72);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '5CS021', 'CS101', 62);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '5CS024', 'CS101', 52);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '5CS022', 'CS101', 89);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '5CS020', 'CS101', 79);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '6CS005', 'CS101', 69);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '6CS030', 'CS101', 59);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '6CS007', 'CS101', 49);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '6CS012', 'CS101', 44);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '6CS014', 'CS101', 99);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S7', '4CS017', 'CS101', 89);


-- Insert the marks of the students in IB101
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10101', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10102', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10103', 'IBM101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10104', 'IBM101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10105', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10106', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10107', 'IBM101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10108', 'IBM101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10109', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10110', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10111', 'IBM101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10112', 'IBM101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10113', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10114', 'IBM101', 80);

INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10101', 'IBM101', 60);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10102', 'IBM101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10103', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10104', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10105', 'IBM101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10106', 'IBM101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10107', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10108', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10109', 'IBM101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10110', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10111', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10112', 'IBM101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10113', 'IBM101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S4', 'IBM10114', 'IBM101', 95);

INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10101', 'IBM101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10102', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10103', 'IBM101', 60);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10104', 'IBM101', 65);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10105', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10106', 'IBM101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10107', 'IBM101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10108', 'IBM101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10109', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10110', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10111', 'IBM101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10112', 'IBM101', 90);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10113', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S6', 'IBM10114', 'IBM101', 75);

INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10101', 'IBM101', 45);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10102', 'IBM101', 55);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10103', 'IBM101', 65);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10104', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10105', 'IBM101', 85);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10106', 'IBM101', 95);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10107', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10108', 'IBM101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10109', 'IBM101', 60);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10110', 'IBM101', 50);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10111', 'IBM101', 40);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10112', 'IBM101', 30);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10113', 'IBM101', 20);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S8', 'IBM10114', 'IBM101', 10);

INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10101', 'IBM101', 72);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10102', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10103', 'IBM101', 68);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10104', 'IBM101', 61);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10105', 'IBM101', 64);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10106', 'IBM101', 80);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10107', 'IBM101', 77);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10108', 'IBM101', 70);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10109', 'IBM101', 63);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10110', 'IBM101', 66);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10111', 'IBM101', 69);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10112', 'IBM101', 72);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10113', 'IBM101', 75);
INSERT INTO Marks (Student_ID, Module_code, Course_ID, Marks) VALUES ('S9', 'IBM10114', 'IBM101', 78);

-- Add values to the instructor table
INSERT INTO Instructor (Instructor_ID, Name, Address, Year_of_experience, Citizenship_Number, Pan_number, DOB, Email_address, Password) VALUES ('I1', 'Vishnu', 'Vaikunth', '15', '123456789', 'ABCDEFG', '01/01/1980', 'vishnu@example.com', 'password1');
INSERT INTO Instructor (Instructor_ID, Name, Address, Year_of_experience, Citizenship_Number, Pan_number, DOB, Email_address, Password) VALUES ('I2', 'Shiva', 'Kailash', '20', '234567890', 'HIJKLMN', '02/02/1975', 'shiva@example.com', 'password2');
INSERT INTO Instructor (Instructor_ID, Name, Address, Year_of_experience, Citizenship_Number, Pan_number, DOB, Email_address, Password) VALUES ('I3', 'Brahma', 'Saraswati', '10', '345678901', 'OPQRSTU', '03/03/1985', 'brahma@example.com', 'password3');
INSERT INTO Instructor (Instructor_ID, Name, Address, Year_of_experience, Citizenship_Number, Pan_number, DOB, Email_address, Password) VALUES ('I4', 'Krishna', 'Vrindavan', '12', '456789012', 'VWXYZAB', '04/04/1970', 'krishna@example.com', 'password4');
INSERT INTO Instructor (Instructor_ID, Name, Address, Year_of_experience, Citizenship_Number, Pan_number, DOB, Email_address, Password) VALUES ('I5', 'Rama', 'Ayodhya', '8', '567890123', 'CDEFGHI', '05/05/1990', 'rama@example.com', 'password5');

-- Add values to the course admininstrator table
INSERT INTO course_administrator (login_email, login_psw) VALUES ('diwash@mainali.com', 'diwash');

-- Add values to the Assignment table
INSERT INTO Assignment (Course_ID, Module_code, Assignment_Number, Student_ID, Instructor_ID, Submitted)
VALUES ('IBM101', 'IBM10101', 'A1', 'S1', 'I1', 'yes'),
('IBM101', 'IBM10101', 'A2', 'S2', 'I2', 'yes'),
('IBM101', 'IBM10102', 'A3', 'S3', 'I3', 'yes'),
('IBM101', 'IBM10103', 'A4', 'S4', 'I4', 'yes'),
('IBM101', 'IBM10104', 'A5', 'S5', 'I5', 'yes'),
('IBM101', 'IBM10105', 'A6', 'S6', 'I1', 'yes'),
('IBM101', 'IBM10106', 'A7', 'S7', 'I2', 'yes'),
('IBM101', 'IBM10107', 'A8', 'S8', 'I3', 'yes'),
('IBM101', 'IBM10108', 'A9', 'S1', 'I4', 'yes'),
('IBM101', 'IBM10109', 'A10', 'S2', 'I5', 'yes'),
('IBM101', 'IBM10110', 'A11', 'S3', 'I1', 'yes'),
('IBM101', 'IBM10111', 'A12', 'S4', 'I2', 'yes'),
('IBM101', 'IBM10112', 'A13', 'S5', 'I3', 'yes'),
('IBM101', 'IBM10113', 'A14', 'S6', 'I4', 'yes'),
('IBM101', 'IBM10114', 'A15', 'S7', 'I5', 'yes'),
('CS101', '4CI018', 'A16', 'S8', 'I1', 'no'), 
('CS101', '4CS001', 'A17', 'S1', 'I2', 'no'), 
('CS101', '4MM013', 'A18', 'S2', 'I3', 'no');

-- Add values to the Instructor_Course table
INSERT INTO Instructor_Course (Instructor_ID, Course_ID)
VALUES ('I1', 'CS101'),
       ('I2', 'CS101'),
       ('I3', 'IBM101'),
       ('I4', 'IBM101'),
       ('I5', 'CS101');


-- Add values to the Instructor_Module table
INSERT INTO Instructor_Module (Instructor_ID, Module_code, Course_ID)
VALUES ('I1', '4CI018', 'CS101'),
       ('I2', '4CS001', 'CS101'),
       ('I3', 'IBM10101', 'IBM101'),
       ('I4', 'IBM10102', 'IBM101'),
       ('I5', '5CS037', 'CS101'),
       ('I1', '5CS019', 'CS101'),
       ('I2', '5CS021', 'CS101'),
       ('I3', 'IBM10103', 'IBM101'),
       ('I4', 'IBM10104', 'IBM101'),
       ('I5', '5CS020', 'CS101');

-- Add values to the student_course table
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S1', 'CS101');
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S3', 'CS101');
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S5', 'CS101');
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S7', 'CS101');
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S2', 'IBM101');
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S4', 'IBM101');
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S6', 'IBM101');
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S8', 'IBM101');
INSERT INTO student_course (Student_ID, Course_ID) VALUES ('S9', 'IBM101');

-- Add values to the student_module table
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S1', '4CI018', 'CS101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S1', '4CS001', 'CS101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S1', '5CS037', 'CS101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S1', '5CS019', 'CS101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S1', '5CS021', 'CS101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S1', '5CS020', 'CS101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S2', 'IBM10101', 'IBM101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S2', 'IBM10102', 'IBM101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S2', 'IBM10103', 'IBM101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S2', 'IBM10104', 'IBM101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S3', '4CI018', 'CS101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S3', '4CS001', 'CS101');
INSERT INTO student_module (Student_ID, Module_code, Course_ID) VALUES ('S3', '5CS037', 'CS101');

-- Add values to the report table
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '4CI018', 'CS101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '4CS001', 'CS101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS037', 'CS101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS019', 'CS101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS021', 'CS101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S1', '5CS020', 'CS101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10101', 'IBM101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10102', 'IBM101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10103', 'IBM101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S2', 'IBM10104', 'IBM101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '4CI018', 'CS101', 100);
INSERT INTO report (Student_ID, Module_code, Course_ID, Marks) VALUES ('S3', '4CS001', 'CS101', 100);