use edusys;
DELIMITER //
CREATE PROCEDURE  getCourses()  
  BEGIN
      SELECT *  FROM course where credits >3;
  END
//  
DELIMITER ;