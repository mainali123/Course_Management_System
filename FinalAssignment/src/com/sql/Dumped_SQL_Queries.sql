-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2023 at 03:35 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `course_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

CREATE TABLE `assignment` (
  `Course_ID` varchar(255) NOT NULL,
  `Module_code` varchar(255) NOT NULL,
  `Assignment_Number` varchar(255) NOT NULL,
  `Student_ID` varchar(255) DEFAULT NULL,
  `Instructor_ID` varchar(255) DEFAULT NULL,
  `Submitted` varchar(255) DEFAULT 'no'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assignment`
--

INSERT INTO `assignment` (`Course_ID`, `Module_code`, `Assignment_Number`, `Student_ID`, `Instructor_ID`, `Submitted`) VALUES
('CS101', '4CI018', 'A16', 'S8', 'I1', 'no'),
('CS101', '4CI018', 'A20', 'S1', 'I2', 'no'),
('CS101', '4CS001', 'A17', 'S1', 'I2', 'no'),
('CS101', '4MM013', 'A18', 'S2', 'I3', 'no'),
('IBM101', 'IBM10101', 'A1', 'S1', 'I1', 'yes'),
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
('IBM101', 'IBM10114', 'A15', 'S7', 'I5', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `Course_ID` varchar(255) NOT NULL,
  `Course_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`Course_ID`, `Course_name`) VALUES
('CS101', 'BSC. (Hons) in Computer Science'),
('IBM101', 'BSC. (Hons) in International Business Management');

-- --------------------------------------------------------

--
-- Table structure for table `course_administrator`
--

CREATE TABLE `course_administrator` (
  `login_email` varchar(255) NOT NULL,
  `login_psw` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course_administrator`
--

INSERT INTO `course_administrator` (`login_email`, `login_psw`) VALUES
('diwash@mainali.com', 'diwash');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `Instructor_ID` varchar(255) NOT NULL DEFAULT current_timestamp(),
  `Name` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Year_of_experience` varchar(255) DEFAULT NULL,
  `Citizenship_Number` varchar(255) DEFAULT NULL,
  `Pan_number` varchar(255) DEFAULT NULL,
  `DOB` varchar(255) DEFAULT NULL,
  `Email_address` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`Instructor_ID`, `Name`, `Address`, `Year_of_experience`, `Citizenship_Number`, `Pan_number`, `DOB`, `Email_address`, `Password`) VALUES
('I1', 'Vishnu', 'Vaikunth', '15', '123456789', 'ABCDEFG', '01/01/1980', 'vishnu@example.com', 'password1'),
('I2', 'Shiva', 'Kailash', '20', '234567890', 'HIJKLMN', '02/02/1975', 'shiva@example.com', 'password2'),
('I3', 'Brahma', 'Saraswati', '10', '345678901', 'OPQRSTU', '03/03/1985', 'brahma@example.com', 'password3'),
('I4', 'Krishna', 'Vrindavan', '12', '456789012', 'VWXYZAB', '04/04/1970', 'krishna@example.com', 'password4'),
('I5', 'Rama', 'Ayodhya', '8', '567890123', 'CDEFGHI', '05/05/1990', 'rama@example.com', 'password5');

-- --------------------------------------------------------

--
-- Table structure for table `instructor_course`
--

CREATE TABLE `instructor_course` (
  `Instructor_ID` varchar(255) NOT NULL,
  `Course_ID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instructor_course`
--

INSERT INTO `instructor_course` (`Instructor_ID`, `Course_ID`) VALUES
('I1', 'CS101'),
('I2', 'CS101'),
('I3', 'IBM101'),
('I4', 'IBM101'),
('I5', 'CS101');

-- --------------------------------------------------------

--
-- Table structure for table `instructor_module`
--

CREATE TABLE `instructor_module` (
  `Instructor_ID` varchar(255) NOT NULL,
  `Module_code` varchar(255) NOT NULL,
  `Course_ID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instructor_module`
--

INSERT INTO `instructor_module` (`Instructor_ID`, `Module_code`, `Course_ID`) VALUES
('I1', '4CI018', 'CS101'),
('I2', '4CS001', 'CS101'),
('I3', 'IBM10101', 'IBM101'),
('I4', 'IBM10102', 'IBM101'),
('I5', '5CS037', 'CS101');

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `Student_ID` varchar(255) NOT NULL,
  `Module_code` varchar(255) NOT NULL,
  `Course_ID` varchar(255) NOT NULL,
  `Marks` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`Student_ID`, `Module_code`, `Course_ID`, `Marks`) VALUES
('S1', '4CI018', 'CS101', '90'),
('S1', '4CS001', 'CS101', '75'),
('S1', '4CS016', 'CS101', '70'),
('S1', '4CS017', 'CS101', '40'),
('S1', '5CS019', 'CS101', '80'),
('S1', '5CS020', 'CS101', '40'),
('S1', '5CS022', 'CS101', '50'),
('S1', '5CS024', 'CS101', '60'),
('S1', '5CS037', 'CS101', '90'),
('S1', '6CS005', 'CS101', '90'),
('S1', '6CS007', 'CS101', '70'),
('S1', '6CS012', 'CS101', '60'),
('S1', '6CS014', 'CS101', '50'),
('S1', '6CS030', 'CS101', '80'),
('S3', '4CI018', 'CS101', '50'),
('S3', '4CS001', 'CS101', '60'),
('S3', '4CS016', 'CS101', '80'),
('S3', '4CS017', 'CS101', '89'),
('S3', '5CS019', 'CS101', '62'),
('S3', '5CS020', 'CS101', '79'),
('S3', '5CS022', 'CS101', '89'),
('S3', '5CS024', 'CS101', '42'),
('S3', '5CS037', 'CS101', '75'),
('S3', '6CS005', 'CS101', '69'),
('S3', '6CS007', 'CS101', '49'),
('S3', '6CS012', 'CS101', '44'),
('S3', '6CS014', 'CS101', '99'),
('S3', '6CS030', 'CS101', '59'),
('S4', 'IBM10101', 'IBM101', '60'),
('S4', 'IBM10102', 'IBM101', '70'),
('S4', 'IBM10103', 'IBM101', '75'),
('S4', 'IBM10104', 'IBM101', '80'),
('S4', 'IBM10105', 'IBM101', '85'),
('S4', 'IBM10106', 'IBM101', '90'),
('S4', 'IBM10107', 'IBM101', '80'),
('S4', 'IBM10108', 'IBM101', '75'),
('S4', 'IBM10109', 'IBM101', '70'),
('S4', 'IBM10110', 'IBM101', '75'),
('S4', 'IBM10111', 'IBM101', '80'),
('S4', 'IBM10112', 'IBM101', '85'),
('S4', 'IBM10113', 'IBM101', '90'),
('S4', 'IBM10114', 'IBM101', '95'),
('S5', '4CI018', 'CS101', '50'),
('S5', '4CS001', 'CS101', '60'),
('S5', '4CS016', 'CS101', '80'),
('S5', '4CS017', 'CS101', '89'),
('S5', '5CS019', 'CS101', '62'),
('S5', '5CS020', 'CS101', '79'),
('S5', '5CS022', 'CS101', '89'),
('S5', '5CS024', 'CS101', '42'),
('S5', '5CS037', 'CS101', '75'),
('S5', '6CS005', 'CS101', '69'),
('S5', '6CS007', 'CS101', '49'),
('S5', '6CS012', 'CS101', '44'),
('S5', '6CS014', 'CS101', '99'),
('S5', '6CS030', 'CS101', '59'),
('S6', 'IBM10101', 'IBM101', '70'),
('S6', 'IBM10102', 'IBM101', '80'),
('S6', 'IBM10103', 'IBM101', '60'),
('S6', 'IBM10104', 'IBM101', '65'),
('S6', 'IBM10105', 'IBM101', '75'),
('S6', 'IBM10106', 'IBM101', '85'),
('S6', 'IBM10107', 'IBM101', '90'),
('S6', 'IBM10108', 'IBM101', '70'),
('S6', 'IBM10109', 'IBM101', '80'),
('S6', 'IBM10110', 'IBM101', '75'),
('S6', 'IBM10111', 'IBM101', '85'),
('S6', 'IBM10112', 'IBM101', '90'),
('S6', 'IBM10113', 'IBM101', '80'),
('S6', 'IBM10114', 'IBM101', '75'),
('S7', '4CI018', 'CS101', '65'),
('S7', '4CS001', 'CS101', '75'),
('S7', '4CS016', 'CS101', '95'),
('S7', '4CS017', 'CS101', '89'),
('S7', '5CS019', 'CS101', '72'),
('S7', '5CS020', 'CS101', '79'),
('S7', '5CS022', 'CS101', '89'),
('S7', '5CS024', 'CS101', '52'),
('S7', '5CS037', 'CS101', '85'),
('S7', '6CS005', 'CS101', '69'),
('S7', '6CS007', 'CS101', '49'),
('S7', '6CS012', 'CS101', '44'),
('S7', '6CS014', 'CS101', '99'),
('S7', '6CS030', 'CS101', '59'),
('S9', 'IBM10101', 'IBM101', '72'),
('S9', 'IBM10102', 'IBM101', '75'),
('S9', 'IBM10103', 'IBM101', '68'),
('S9', 'IBM10104', 'IBM101', '61'),
('S9', 'IBM10105', 'IBM101', '64'),
('S9', 'IBM10106', 'IBM101', '80'),
('S9', 'IBM10107', 'IBM101', '77'),
('S9', 'IBM10108', 'IBM101', '70'),
('S9', 'IBM10109', 'IBM101', '63'),
('S9', 'IBM10110', 'IBM101', '66'),
('S9', 'IBM10111', 'IBM101', '69'),
('S9', 'IBM10112', 'IBM101', '72'),
('S9', 'IBM10113', 'IBM101', '75'),
('S9', 'IBM10114', 'IBM101', '78');

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `Course_ID` varchar(255) NOT NULL,
  `Module_name` varchar(255) DEFAULT NULL,
  `Module_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`Course_ID`, `Module_name`, `Module_code`) VALUES
('CS101', 'Academic Skills and Team-Based Learning', '4CI018'),
('CS101', 'Introductory Programming And Problem Solving', '4CS001'),
('CS101', 'Embedded System Programming', '4CS016'),
('CS101', 'Internet Software Architecture', '4CS017'),
('CS101', 'Computational Mathematics', '4MM013'),
('CS101', 'Object-Oriented Design and Programming', '5CS019'),
('CS101', 'Human - Computer Interaction', '5CS020'),
('CS101', 'Distributed and Cloud System Programming', '5CS022'),
('CS101', 'Collaborative Development', '5CS024'),
('CS101', 'Concepts and Technologies of AI', '5CS037'),
('CS101', 'High Performance Computing', '6CS005'),
('CS101', 'Project and Professionalism', '6CS007'),
('CS101', 'Artificial Intelligence and Machine Learning', '6CS012'),
('CS101', 'Complex Systems', '6CS014'),
('CS101', 'Big Data', '6CS030'),
('IBM101', 'Introduction to International Business', 'IBM10101'),
('IBM101', 'Marketing Management', 'IBM10102'),
('IBM101', 'Global Business Environment', 'IBM10103'),
('IBM101', 'Cross-Cultural Management', 'IBM10104'),
('IBM101', 'Business Research Methods', 'IBM10105'),
('IBM101', 'International Financial Management', 'IBM10106'),
('IBM101', 'International Human Resource Management', 'IBM10107'),
('IBM101', 'International Marketing', 'IBM10108'),
('IBM101', 'International Business Law', 'IBM10109'),
('IBM101', 'International Business Strategy', 'IBM10110'),
('IBM101', 'International Business Ethics', 'IBM10111'),
('IBM101', 'International Business Negotiation', 'IBM10112'),
('IBM101', 'International Business Project', 'IBM10113'),
('IBM101', 'International Business Dissertation', 'IBM10114');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `Student_ID` varchar(255) NOT NULL,
  `Module_code` varchar(255) NOT NULL,
  `Course_ID` varchar(255) NOT NULL,
  `Marks` varchar(255) DEFAULT NULL,
  `isGenerated` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`Student_ID`, `Module_code`, `Course_ID`, `Marks`, `isGenerated`) VALUES
('S1', '4CI018', 'CS101', '100', 0),
('S1', '4CS001', 'CS101', '100', 0),
('S1', '5CS019', 'CS101', '100', 0),
('S1', '5CS020', 'CS101', '100', 0),
('S1', '5CS037', 'CS101', '100', 0),
('S3', '4CI018', 'CS101', '100', 0),
('S3', '4CS001', 'CS101', '100', 0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Student_ID` varchar(255) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `DOB` varchar(255) DEFAULT NULL,
  `Citizenship_Number` varchar(255) DEFAULT NULL,
  `Email_address` varchar(255) DEFAULT NULL,
  `College_email_address` varchar(255) DEFAULT NULL,
  `College_email_address_password` varchar(255) DEFAULT NULL,
  `Course_ID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Student_ID`, `Name`, `Address`, `DOB`, `Citizenship_Number`, `Email_address`, `College_email_address`, `College_email_address_password`, `Course_ID`) VALUES
('S1', 'Ram Sharma', '789 Elm St', '03/03/1990', '1112223333', 'ramsharma@example.com', 'ramsharma@college.com', 'password123', 'CS101'),
('S2', 'Sita Devi', '456 Park Ave', '02/02/1995', '0987654321', 'sitadevi@example.com', 'sitadevi@college.com', 'password456', 'IBM101'),
('S3', 'Hari Sharma', '123 Main St', '01/01/1995', '1112223333', 'harisharma@example.com', 'harisharma@college.com', 'password789', 'CS101'),
('S4', 'Ganga Devi', '789 Elm St', '04/04/1992', '0987654321', 'gangadevi@example.com', 'gangadevi@college.com', 'password111', 'IBM101'),
('S5', 'Krishna Pandey', '789 Elm St', '05/05/1995', '1112223333', 'krishnapandey@example.com', 'krishnapandey@college.com', 'password222', 'CS101'),
('S6', 'Saraswoti Sharma', '456 Park Ave', '06/06/1994', '0987654321', 'saraswotisharma@example.com', 'saraswotisharma@college.com', 'password321', 'IBM101'),
('S7', 'Bikram Shah', '789 Elm St', '07/07/1997', '1112223333', 'bikramshah@example.com', 'bikramshah@college.com', 'password456', 'CS101'),
('S8', 'Kamala Sharma', '123 Main St', '08/08/1996', '0987654321', 'kamalasharma@example.com', 'kamalasharma@college.com', 'password654', 'IBM101'),
('S9', 'Rajesh Pandey', '789 Elm St', '09/09/1995', '1112223333', 'rajeshpandey@example.com', 'rajeshpandey@college.com', 'password789', 'IBM101');

-- --------------------------------------------------------

--
-- Table structure for table `student_course`
--

CREATE TABLE `student_course` (
  `Student_ID` varchar(255) NOT NULL,
  `Course_ID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_course`
--

INSERT INTO `student_course` (`Student_ID`, `Course_ID`) VALUES
('S1', 'CS101'),
('S3', 'CS101'),
('S4', 'IBM101'),
('S5', 'CS101'),
('S6', 'IBM101'),
('S7', 'CS101'),
('S9', 'IBM101');

-- --------------------------------------------------------

--
-- Table structure for table `student_module`
--

CREATE TABLE `student_module` (
  `Student_ID` varchar(255) NOT NULL,
  `Module_code` varchar(255) NOT NULL,
  `Course_ID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_module`
--

INSERT INTO `student_module` (`Student_ID`, `Module_code`, `Course_ID`) VALUES
('S1', '4CI018', 'CS101'),
('S1', '4CS001', 'CS101'),
('S1', '5CS019', 'CS101'),
('S1', '5CS020', 'CS101'),
('S1', '5CS037', 'CS101'),
('S3', '4CI018', 'CS101'),
('S3', '4CS001', 'CS101'),
('S3', '5CS037', 'CS101');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`Course_ID`,`Module_code`,`Assignment_Number`),
  ADD KEY `Student_ID` (`Student_ID`),
  ADD KEY `Instructor_ID` (`Instructor_ID`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`Course_ID`);

--
-- Indexes for table `course_administrator`
--
ALTER TABLE `course_administrator`
  ADD PRIMARY KEY (`login_email`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`Instructor_ID`);

--
-- Indexes for table `instructor_course`
--
ALTER TABLE `instructor_course`
  ADD PRIMARY KEY (`Instructor_ID`,`Course_ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `instructor_module`
--
ALTER TABLE `instructor_module`
  ADD PRIMARY KEY (`Instructor_ID`,`Module_code`,`Course_ID`),
  ADD KEY `Module_code` (`Module_code`,`Course_ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`Student_ID`,`Module_code`,`Course_ID`),
  ADD KEY `Module_code` (`Module_code`,`Course_ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`Module_code`,`Course_ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`Student_ID`,`Module_code`,`Course_ID`),
  ADD KEY `Module_code` (`Module_code`,`Course_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Student_ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `student_course`
--
ALTER TABLE `student_course`
  ADD PRIMARY KEY (`Student_ID`,`Course_ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Indexes for table `student_module`
--
ALTER TABLE `student_module`
  ADD PRIMARY KEY (`Student_ID`,`Module_code`,`Course_ID`),
  ADD KEY `Module_code` (`Module_code`,`Course_ID`),
  ADD KEY `Course_ID` (`Course_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignment`
--
ALTER TABLE `assignment`
  ADD CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`Course_ID`,`Module_code`) REFERENCES `module` (`Course_ID`, `Module_code`),
  ADD CONSTRAINT `assignment_ibfk_2` FOREIGN KEY (`Student_ID`) REFERENCES `student` (`Student_ID`),
  ADD CONSTRAINT `assignment_ibfk_3` FOREIGN KEY (`Instructor_ID`) REFERENCES `instructor` (`Instructor_ID`);

--
-- Constraints for table `instructor_course`
--
ALTER TABLE `instructor_course`
  ADD CONSTRAINT `instructor_course_ibfk_1` FOREIGN KEY (`Instructor_ID`) REFERENCES `instructor` (`Instructor_ID`),
  ADD CONSTRAINT `instructor_course_ibfk_2` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);

--
-- Constraints for table `instructor_module`
--
ALTER TABLE `instructor_module`
  ADD CONSTRAINT `instructor_module_ibfk_1` FOREIGN KEY (`Instructor_ID`) REFERENCES `instructor` (`Instructor_ID`),
  ADD CONSTRAINT `instructor_module_ibfk_2` FOREIGN KEY (`Module_code`,`Course_ID`) REFERENCES `module` (`Module_code`, `Course_ID`),
  ADD CONSTRAINT `instructor_module_ibfk_3` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student` (`Student_ID`),
  ADD CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`Module_code`,`Course_ID`) REFERENCES `module` (`Module_code`, `Course_ID`),
  ADD CONSTRAINT `marks_ibfk_3` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);

--
-- Constraints for table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `module_ibfk_1` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`Student_ID`,`Module_code`,`Course_ID`) REFERENCES `student_module` (`Student_ID`, `Module_code`, `Course_ID`),
  ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`Module_code`,`Course_ID`) REFERENCES `module` (`Module_code`, `Course_ID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);

--
-- Constraints for table `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student` (`Student_ID`),
  ADD CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);

--
-- Constraints for table `student_module`
--
ALTER TABLE `student_module`
  ADD CONSTRAINT `student_module_ibfk_1` FOREIGN KEY (`Student_ID`) REFERENCES `student` (`Student_ID`),
  ADD CONSTRAINT `student_module_ibfk_2` FOREIGN KEY (`Module_code`,`Course_ID`) REFERENCES `module` (`Module_code`, `Course_ID`),
  ADD CONSTRAINT `student_module_ibfk_3` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`Course_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
