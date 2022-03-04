use edusys;

delimiter //
DROP PROCEDURE IF EXISTS `getSectionProcude` //
CREATE PROCEDURE getSectionProcude()
    BEGIN
        DECLARE row_course_id VARCHAR(8);
        DECLARE  row_year  decimal(4,0);
        DECLARE row_room_number varchar(7) ;
        DECLARE DONE BOOLEAN DEFAULT 0; 

        DECLARE getSection CURSOR FOR SELECT course_id, year, room_number FROM section  ;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = 1; 
      OPEN getSection;
        REPEAT  
            FETCH getSection INTO row_course_id, row_year, row_room_number;
            IF DONE <> 1 THEN  
                SELECT row_course_id, row_year, row_room_number;
            END IF;  
        UNTIL DONE END REPEAT;  
      CLOSE getSection;
    END;
//
call getSectionProcude()
//