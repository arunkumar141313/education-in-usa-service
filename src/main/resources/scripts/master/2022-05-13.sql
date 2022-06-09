-- Created By: Kasee nadh Reddy
-- Created On: 2022-05-13
-- Updated On:
-- Updated By:
-- Purpose: To insert/create master data/tables
-- Affected areas: N/A

-- Row Status table

USE DEV_EducationInUSA;

CREATE TABLE IF NOT EXISTS `RowStatus` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `IDX_RowStatus_ID` (`ID` ASC) COMMENT 'For RowStatus ID' VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Row Status table raw data
INSERT INTO `RowStatus` (`ID`, `Name`) VALUES (1, 'Active');
INSERT INTO `RowStatus` (`ID`, `Name`) VALUES (2, 'In Active');
INSERT INTO `RowStatus` (`ID`, `Name`) VALUES (3, 'Deleted');

-- Lookup Configuration table
CREATE TABLE IF NOT EXISTS `LookupConfiguration` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Key` VARCHAR(256) NOT NULL,
  `Value` VARCHAR(256) NULL,
  `Description` VARCHAR(256) NULL,
  `Group` VARCHAR(256) NOT NULL,
  `RowStatus` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_LookupConfiguration_RowStatusID_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `Group_idx` (`Group` ASC) INVISIBLE,
  INDEX `Group_RowStatus_idx` (`Group` ASC, `RowStatus` ASC) INVISIBLE,
  CONSTRAINT `FK_LookupConfiguration_RowStatusID`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;


-- Lookup Configuration Raw Data
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('1', 'SUBMITTED', 'Submitted', 'VERIFICATION_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('2', 'VERIFIED', 'Verified', 'VERIFICATION_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('3', 'PARTIALLY_VERIFIED', 'Partially Verified', 'VERIFICATION_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('4', 'VISA', 'Visa Faqs', 'FAQ_TYPE', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('5', 'UNIVERSITY', 'University Faqs', 'FAQ_TYPE', '2');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('6', 'APPLICATION', 'Application Faqs', 'FAQ_TYPE', '3');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('7', 'MALE', 'Male', 'GENDER_PREFERENCE', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('8', 'FEMALE', 'Female', 'GENDER_PREFERENCE', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('9', 'BOTH', 'Both', 'GENDER_PREFERENCE', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('10', 'MALE', 'Male', 'GENDER', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('11', 'FEMALE', 'Female', 'GENDER', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('12', 'OTHER', 'Other', 'GENDER', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Description`, `Group`, `RowStatus`) VALUES ('13', 'BIOMETRIC', 'Biometric', 'OFC/VAC/Finger Print Collection Day', 'INTERVIEW_TYPE', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('14', 'VISA_INTERVIEW', 'Visa Interview', 'INTERVIEW_TYPE', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('15', 'APPROVED', 'Approved', 'INTERVIEW_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('16', 'REJECTED', 'Rejected', 'INTERVIEW_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('17', 'ADMINISTRATIVE_PROCESSING', 'Administrative Processing', 'INTERVIEW_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('18', 'NEED_TO_ATTEND', 'Need To Attend', 'INTERVIEW_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('19', 'BIOMETRICS_COMPLETED', 'Biometrics Completed', 'INTERVIEW_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('20', 'BIOMETRICS_PENDING', 'Biometrics Pending', 'INTERVIEW_STATUS', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('21', 'FALL', 'Spring', 'INTAKE', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('22', 'SUMMER', 'Summer', 'INTAKE', '1');
INSERT INTO `LookupConfiguration` (`ID`, `Key`, `Value`, `Group`, `RowStatus`) VALUES ('23', 'Spring', 'Spring', 'INTAKE', '1');

-- Users table
 CREATE TABLE IF NOT EXISTS `Users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `NickName` VARCHAR(45) NULL,
  `Email` VARCHAR(100) NOT NULL,
  `PhoneNumber` VARCHAR(15) NULL,
  `UniversityName` VARCHAR(255) NULL,
  `Major` VARCHAR(255) NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Year` VARCHAR(5) NULL,
  `IntakeID` INT,
  `SharePhoneNumber` TINYINT NOT NULL DEFAULT 0,
  `ShareOnlyNickName` TINYINT NOT NULL DEFAULT 0,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  `RowStatus` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_Users_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `FK_Users_IntakeID_idx` (`IntakeID` ASC) VISIBLE,
  INDEX `FK_Users_CreatedBy_idx` (`CreatedBy` ASC) VISIBLE,
  INDEX `FK_Users_UpdatedBy_idx` (`UpdatedBy` ASC) VISIBLE,
  INDEX `Users_Password_idx` (`Password` ASC) INVISIBLE,
  INDEX `Users_Email_idx` (`Email` ASC) INVISIBLE,
  INDEX `Users_PhoneNumber_idx` (`PhoneNumber` ASC) INVISIBLE,
  INDEX `Users_Year_idx` (`Year` ASC) INVISIBLE,
  CONSTRAINT `FK_Users_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Users_CreatedBy`
      FOREIGN KEY (`CreatedBy`)
      REFERENCES `Users` (`ID`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `FK_Users_UpdatedBy`
      FOREIGN KEY (`UpdatedBy`)
      REFERENCES `Users` (`ID`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `FK_Users_IntakeID`
    FOREIGN KEY (`IntakeID`)
    REFERENCES `LookupConfiguration` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `Users` (`ID`, `FirstName`, `LastName`, `NickName`, `Email`, `PhoneNumber`, `UniversityName`, `Major`, `Password`, `Year`, `IntakeID`, `SharePhoneNumber`, `ShareOnlyNickName`, `CreatedAt`, `UpdatedAt`, `CreatedBy`, `UpdatedBy`, `RowStatus`) VALUES ('1', 'Admin', 'Admin', 'Admin', 'admin@educationinusa.org', '+91 0999999999', 'Admin University', 'Information Technology', '$2a$10$suVvqf3u1ojh1FCUhSp2GeZxeSZJ/wTnPOkyY80XypT5rPfaH6wya', '2022', '21', '0', '0', '2022-05-25 14:06:44', '2022-05-25 14:06:44', '1', '1', '1');
INSERT INTO `Users` (`ID`, `FirstName`, `LastName`, `NickName`, `Email`, `PhoneNumber`, `UniversityName`, `Major`, `Password`, `Year`, `IntakeID`, `SharePhoneNumber`, `ShareOnlyNickName`, `CreatedAt`, `UpdatedAt`, `CreatedBy`, `UpdatedBy`, `RowStatus`) VALUES ('2', 'Guest', 'User', 'Guest User', 'guest@educationinusa.org', '+91 0888888888', 'Guest University', 'Information Technology', '$2a$10$h1qhePFWS7EN9jiU0K5RNeWbMd6Ulrrk5ha7i/x05sw9HBlx5QFZq', '2022', '21', '0', '0', '2022-05-26 05:11:59', '2022-05-26 05:11:59', '1', '1', '1');

-- Tag table
CREATE TABLE IF NOT EXISTS `Tag` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `RowStatus` INT NOT NULL DEFAULT 2,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE,
  INDEX `FK_Tag_RowStatusID_idx` (`RowStatus` ASC) VISIBLE,
  CONSTRAINT `FK_Tag_CreatedBy`
        FOREIGN KEY (`CreatedBy`)
        REFERENCES `Users` (`ID`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT `FK_Tag_UpdatedBy`
        FOREIGN KEY (`UpdatedBy`)
        REFERENCES `Users` (`ID`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
  CONSTRAINT `FK_Tag_RowStatusID`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- FAQ table
CREATE TABLE IF NOT EXISTS `Faq` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Question` VARCHAR(255) NOT NULL,
  `Answer` MEDIUMTEXT NULL,
  `SourceUrl` VARCHAR(255) NULL,
  `FaqType` INT NOT NULL,
  `VerificationStatus` INT NOT NULL DEFAULT 1,
  `RowStatus` INT NOT NULL DEFAULT 2,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_Faq_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `FK_Faq_FaqType_idx` (`FaqType` ASC) VISIBLE,
  INDEX `FK_Faq_VerificationStatus_idx` (`VerificationStatus` ASC) VISIBLE,
  UNIQUE INDEX `Question_UNIQUE` (`Question` ASC) VISIBLE,
  CONSTRAINT `FK_Faq_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Faq_FaqType`
    FOREIGN KEY (`FaqType`)
    REFERENCES `LookupConfiguration` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Faq_VerificationStatus`
    FOREIGN KEY (`VerificationStatus`)
    REFERENCES `LookupConfiguration` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- FaqTags table
CREATE TABLE IF NOT EXISTS `FaqTags` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FaqID` INT NOT NULL,
  `TagID` INT NOT NULL,
  `RowStatus` INT NOT NULL,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_FaqTags_FaqID_idx` (`FaqID` ASC) VISIBLE,
  INDEX `FK_FaqTags_TagID_idx` (`TagID` ASC) VISIBLE,
  INDEX `FK_FaqTags_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  CONSTRAINT `FK_FaqTags_FaqID`
    FOREIGN KEY (`FaqID`)
    REFERENCES `Faq` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_FaqTags_TagID`
    FOREIGN KEY (`TagID`)
    REFERENCES `Tag` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_FaqTags_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- Time Zone table
 CREATE TABLE IF NOT EXISTS `TimeZone` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `offset` FLOAT NOT NULL,
  `RowStatus` INT NOT NULL,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_TimeZone_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  CONSTRAINT `FK_TimeZone_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- TimeZone master data
INSERT INTO `TimeZone` (`ID`, `Name`, `offset`, `RowStatus`) VALUES ('1', 'Asia/Kolkata', '+5.30', '1');

-- Country Table
 CREATE TABLE IF NOT EXISTS `Country` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Url` VARCHAR(100) NOT NULL,
  `IsoCodeThree` VARCHAR(3) NOT NULL,
  `IsoCodeTwo` VARCHAR(45) NOT NULL,
  `TimeZoneID` INT NOT NULL,
  `RowStatus` INT NOT NULL,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_Country_TimeZone_idx` (`TimeZoneID` ASC) VISIBLE,
  INDEX `FK_Country_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `Country_IsoCodeThree_idx` (`IsoCodeThree` ASC) INVISIBLE,
  INDEX `Country_IsoCodeTwo_idx` (`IsoCodeTwo` ASC) VISIBLE,
  INDEX `Country_Name_idx` (`Name` ASC) VISIBLE,
  CONSTRAINT `FK_Country_TimeZone`
    FOREIGN KEY (`TimeZoneID`)
    REFERENCES `TimeZone` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Country_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- Country master data
INSERT INTO `Country` (`ID`, `Name`, `Url`, `IsoCodeThree`, `IsoCodeTwo`, `TimeZoneID`, `RowStatus`) VALUES ('1', 'India','india', 'INR', 'IN', '1', '1');

-- state table
 CREATE TABLE IF NOT EXISTS `State` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `CountryID` INT NOT NULL,
  `RowStatus` INT NOT NULL,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_State_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `FK_State_CountryID_idx` (`CountryID` ASC) VISIBLE,
  CONSTRAINT `FK_State_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_State_CountryID`
    FOREIGN KEY (`CountryID`)
    REFERENCES `Country` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- State master data
INSERT INTO `State` (`ID`, `Name`, `CountryID`, `RowStatus`) VALUES
(1, 'Andaman & Nicobar Islands',1, 1),
(2, 'Andhra Pradesh',1, 1),
(3, 'Arunachal Pradesh',1, 1),
(4, 'Assam',1, 1),
(5, 'Bihar',1, 1),
(6, 'Chandigarh',1, 1),
(7, 'Chhattisgarh',1, 1),
(8, 'Dadra & Nagar Haveli',1, 1),
(9, 'Daman & Diu',1, 1),
(10, 'Delhi',1, 1),
(11, 'Goa',1, 1),
(12, 'Gujarat',1, 1),
(13, 'Haryana',1, 1),
(14, 'Himachal Pradesh',1, 1),
(15, 'Jammu & Kashmir',1, 1),
(16, 'Jharkhand',1, 1),
(17, 'Karnataka',1, 1),
(18, 'Kerala',1, 1),
(19, 'Lakshadweep',1, 1),
(20, 'Madhya Pradesh',1, 1),
(21, 'Maharashtra',1, 1),
(22, 'Manipur',1, 1),
(23, 'Meghalaya',1, 1),
(24, 'Mizoram',1, 1),
(25, 'Nagaland',1, 1),
(26, 'Odisha',1, 1),
(27, 'Puducherry',1, 1),
(28, 'Punjab',1, 1),
(29, 'Rajasthan',1, 1),
(30, 'Sikkim',1, 1),
(31, 'Tamil Nadu',1, 1),
(32, 'Tripura',1, 1),
(33, 'Uttar Pradesh',1, 1),
(34, 'Uttarakhand',1, 1),
(35, 'West Bengal',1, 1),
(36, 'Telangana',1, 1);

-- City table
 CREATE TABLE IF NOT EXISTS `City` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `RowStatus` INT NULL,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_City_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `City_Name_idx` (`Name` ASC) VISIBLE,
  CONSTRAINT `FK_City_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Embassy Table
 CREATE TABLE IF NOT EXISTS `Embassy` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Url` VARCHAR(100) NOT NULL,
  `Latitude` VARCHAR(100) NOT NULL,
  `Longitude` VARCHAR(100) NOT NULL,
  `Address` VARCHAR(255) NOT NULL,
  `CountryID` INT NOT NULL,
  `StateID` INT NOT NULL,
  `PhoneNumber` VARCHAR(45) NULL ,
  `Website` VARCHAR(255) NULL,
  `DisplayName` VARCHAR(255) NULL,
  `IframeUrl` TINYTEXT NOT NULL ,
  `RowStatus` INT NOT NULL,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_Embassy_StateID_idx` (`StateID` ASC) VISIBLE,
INDEX `FK_Embassy_CountryID_idx` (`CountryID` ASC) VISIBLE,
  INDEX `FK_Embassy_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `Embassy_Name` (`Name` ASC) VISIBLE,
  CONSTRAINT `FK_Embassy_CountryID`
    FOREIGN KEY (`CountryID`)
    REFERENCES `Country` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Embassy_StateID`
    FOREIGN KEY (`StateID`)
    REFERENCES `State` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Embassy_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Embassy Raw data
INSERT INTO `Embassy` (`ID`, `Name`, `Url`, `Latitude`, `Longitude`, `Address`, `CountryID`, `StateID`, `RowStatus`, `CreatedAt`, `UpdatedAt`, `CreatedBy`, `UpdatedBy`, `PhoneNumber`, `Website`, `IframeUrl`, `DisplayName`)
VALUES ('1', 'New Delhi', 'new-delhi', '0.0', '0.0', 'H5XQ+264, Panchsheel Marg, Shantipath, Chanakyapuri, New Delhi, Delhi 110021', '1', '10', '1', '2022-06-01 09:09:47', '2022-06-01 09:09:47', '1', '1', '011-91-11-2419-8000', 'https://in.usembassy.gov/embassy-consulates/new-delhi/', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3503.0753120926965!2d77.18589671409522!3d28.59751739241774!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x390d1d676f4487ad%3A0xad2e642d2072c910!2sU.S.%20Embassy!5e0!3m2!1sen!2sin!4v1654101412984!5', 'U.S. Embassy New Delhi');
INSERT INTO `Embassy` (`ID`, `Name`, `Url`, `Latitude`, `Longitude`, `Address`, `CountryID`, `StateID`, `RowStatus`, `CreatedAt`, `UpdatedAt`, `CreatedBy`, `UpdatedBy`, `PhoneNumber`, `Website`, `IframeUrl`, `DisplayName`)
VALUES ('2', 'Mumbai', 'mumbai', '0.0', '0.0', 'C49, G Block Rd, G Block BKC, Bandra Kurla Complex, Bandra East, Mumbai, Maharashtra 400051, India', '1', '21', '1', '2022-06-01 09:09:48', '2022-06-01 09:09:48', '1', '1', '(91-22) 2672-4000', 'https://in.usembassy.gov/embassy-consulates/hyderabad/', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3806.380811427076!2d78.47202001385021!3d17.44147820583601!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bcb90a764cee213%3A0x73f87f029a79844b!2sUS%20Consulate%20General!5e0!3m2!1sen!2sus!4v165410', 'U.S. Consulate General Mumbai');
INSERT INTO `Embassy` (`ID`, `Name`, `Url`, `Latitude`, `Longitude`, `Address`, `CountryID`, `StateID`, `RowStatus`, `CreatedAt`, `UpdatedAt`, `CreatedBy`, `UpdatedBy`, `PhoneNumber`, `Website`, `IframeUrl`, `DisplayName`)
VALUES ('3', 'Kolkata', 'kolkata', '0.0', '0.0', '5/1, Ho Chi Minh Sarani, Kankaria Estates, Park Street area, Kolkata, West Bengal 700071, India', '1', '35', '1', '2022-06-01 09:09:48', '2022-06-01 09:09:48', '1', '1', '91-33-6827-2400', 'https://in.usembassy.gov/embassy-consulates/kolkata/', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3806.380811427076!2d78.47202001385021!3d17.44147820583601!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bcb90a764cee213%3A0x73f87f029a79844b!2sUS%20Consulate%20General!5e0!3m2!1sen!2sus!4v165410', 'U.S. Consulate General Kolkata');
INSERT INTO `Embassy` (`ID`, `Name`, `Url`, `Latitude`, `Longitude`, `Address`, `CountryID`, `StateID`, `RowStatus`, `CreatedAt`, `UpdatedAt`, `CreatedBy`, `UpdatedBy`, `PhoneNumber`, `Website`, `IframeUrl`, `DisplayName`)
VALUES ('4', 'Hyderabad', 'hyderabad', '0.0', '0.0', 'Paigah Palace, 1-8-323, Chiran Fort Club Ln, Patigadda, Begumpet, Secunderabad, Telangana 500003, India', '1', '36', '1', '2022-06-01 09:09:48', '2022-06-01 09:09:48', '1', '1', '040 40338300', 'https://in.usembassy.gov/embassy-consulates/mumbai/', 'https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15083.971670898309!2d72.863341!3d19.064049!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x3e32a8e25a189bf4!2sUS%20Consulate%20General%2C%20Mumbai!5e0!3m2!1sen!2sus!4v1654104199515!5m2!1sen!2sus', 'U.S. Consulate General Hyderabad');
INSERT INTO `Embassy` (`ID`, `Name`, `Url`, `Latitude`, `Longitude`, `Address`, `CountryID`, `StateID`, `RowStatus`, `CreatedAt`, `UpdatedAt`, `CreatedBy`, `UpdatedBy`, `PhoneNumber`, `Website`, `IframeUrl`, `DisplayName`)
VALUES ('5', 'Chennai', 'chennai', '0.0', '0.0', '3722+WQG, Gemini Flyover, Teynampet, Chennai, Tamil Nadu 600006, India', '1', '31', '1', '2022-06-01 09:09:48', '2022-06-01 09:09:48', '1', '1', '(91 44) 2811-2000', 'https://in.usembassy.gov/embassy-consulates/chennai/', 'https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15546.954320291872!2d80.251949!3d13.052305!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x1c10b6a906d183a6!2sConsulate%20General%20of%20the%20United%20States%2C%20Chennai!5e0!3m2!1sen!2sus!4v1654103555085!5m', 'U.S. Consulate General Chennai');

-- roles table
CREATE TABLE IF NOT EXISTS `Roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE,
  INDEX `Role_Name_idx` (`Name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `Roles` (`ID`, `Name`) VALUES ('1', 'ADMIN');
INSERT INTO `Roles` (`ID`, `Name`) VALUES ('2', 'GUEST');
INSERT INTO `Roles` (`ID`, `Name`) VALUES ('3', 'USER');


-- user roles table
CREATE TABLE `UserRoles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `UserID` INT NOT NULL,
  `RoleID` INT NOT NULL,
  `RowStatus` INT NOT NULL DEFAULT 2,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_UserRoles_RoleID_idx` (`RoleID` ASC) VISIBLE,
  INDEX `FK_UserRoles_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  CONSTRAINT `FK_UserRoles_UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `Users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_UserRoles_RoleID`
    FOREIGN KEY (`RoleID`)
    REFERENCES `Roles` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_UserRoles_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `UserRoles` (`ID`, `UserID`, `RoleID`, `RowStatus`) VALUES ('1', '1', '1', '1');
INSERT INTO `UserRoles` (`ID`, `UserID`, `RoleID`, `RowStatus`) VALUES ('2', '2', '2', '1');

-- INTERVIEW DETAILS TABLE
 CREATE TABLE IF NOT EXISTS `InterviewDetails` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `InterviewTypeID` INT NOT NULL,
  `EmbassyID` INT NOT NULL,
  `InterviewDate` TIMESTAMP NOT NULL,
  `RowStatus` INT NOT NULL,
  `Comments` VARCHAR(255) NULL,
  `UserID` INT NOT NULL,
  `InterviewStatusID` INT NOT NULL,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_InterviewDetails_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `FK_InterviewDetails_EmbassyID_idx` (`EmbassyID` ASC) VISIBLE,
  INDEX `FK_InterviewDetails_UserID_idx` (`UserID` ASC) VISIBLE,
  INDEX `FK_InterviewDetails_InterviewStatusID_idx` (`InterviewStatusID` ASC) VISIBLE,
  INDEX `FK_InterviewDetails_InterviewTypeID_idx` (`InterviewTypeID` ASC) VISIBLE,
  INDEX `InterviewDetails_InterviewDate` (`InterviewDate` ASC) VISIBLE,
  CONSTRAINT `FK_InterviewDetails_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_InterviewDetails_UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `Users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_InterviewDetails_InterviewStatusID`
    FOREIGN KEY (`InterviewStatusID`)
    REFERENCES `LookupConfiguration` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_InterviewDetails_InterviewTypeID`
    FOREIGN KEY (`InterviewTypeID`)
    REFERENCES `LookupConfiguration` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_InterviewDetails_EmbassyID`
    FOREIGN KEY (`EmbassyID`)
    REFERENCES `Embassy` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- interview travel partner table
 CREATE TABLE IF NOT EXISTS `InterviewTravelPartner` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TravelFromStateID` INT NOT NULL,
  `TravelFromCity` VARCHAR(255) NOT NULL,
  `TravelPartnerRequired` TINYINT NOT NULL DEFAULT 0,
  `HasTravelPartner` TINYINT NOT NULL DEFAULT 0,
  `TravelDate` TIMESTAMP NOT NULL,
  `Comments` VARCHAR(255) NULL,
  `GenderPreferenceID` INT NOT NULL,
  `RowStatus` INT NOT NULL,
  `InterviewDetailsID` INT NOT NULL,
  `UserID` INT NOT NULL,
  `CreatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `UpdatedAt` TIMESTAMP NOT NULL DEFAULT now(),
  `CreatedBy` INT NOT NULL DEFAULT 1,
  `UpdatedBy` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  INDEX `FK_InterviewTravelPartner_RowStatus_idx` (`RowStatus` ASC) VISIBLE,
  INDEX `FK_InterviewTravelPartner_TravelFromStateID_idx` (`TravelFromStateID` ASC) VISIBLE,
  INDEX `FK_InterviewTravelPartner_InterviewDetailsID_idx` (`InterviewDetailsID` ASC) VISIBLE,
  INDEX `FK_InterviewTravelPartner_UserID_idx` (`UserID` ASC) VISIBLE,
  INDEX `FK_InterviewTravelPartner_GenderPreferenceID_idx` (`GenderPreferenceID` ASC) VISIBLE,
CONSTRAINT `FK_InterviewTravelPartner_RowStatus`
    FOREIGN KEY (`RowStatus`)
    REFERENCES `RowStatus` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_InterviewTravelPartner_TravelFromStateID`
    FOREIGN KEY (`TravelFromStateID`)
    REFERENCES `State` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_InterviewTravelPartner_GenderPreferenceID`
    FOREIGN KEY (`GenderPreferenceID`)
    REFERENCES `LookupConfiguration` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_InterviewTravelPartner_InterviewDetailsID`
    FOREIGN KEY (`InterviewDetailsID`)
    REFERENCES `InterviewDetails` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_InterviewTravelPartner_UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `Users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;