CREATE TABLE EMPLOYEE  
(  
    ID   LONG PRIMARY KEY AUTO_INCREMENT,  
    NAME VARCHAR(255)  
);
CREATE TABLE EMAIL  
(  EMAILID LONG PRIMARY KEY AUTO_INCREMENT,
   EMAIL VARCHAR(255),  
   ID LONG,  
   FOREIGN KEY (ID) REFERENCES EMPLOYEE(ID)  
);