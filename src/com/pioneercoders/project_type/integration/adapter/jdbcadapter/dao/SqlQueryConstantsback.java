package com.bhaskar.project_type.integration.adapter.jdbcadapter.dao;

public class SqlQueryConstantsback {	
	


  
  public static final String EMPLOYEENAME = "SELECT EMPNAME FROM ARS_MST_EMPLOYEE WHERE EMPCODE = ?";
  public static final String ENROLL_TYPE_FLAG =  "SELECT COUNT(*) EMP_FLAG FROM ENROLLMENT_TYPE WHERE ? BETWEEN START_RANGE AND END_RANGE";
  public  static final String EMP_TOKEN_NO = "SELECT 'N-' || TO_CHAR(SYSDATE,'DDMONYYYY')|| '-' || LPAD((SELECT COUNT(*)+1 TOTAL FROM ENROLLMENT_MST WHERE ENROLLMENT_DATE = to_date(?,'dd-mm-yyyy') ),4,0) TOKEN_NO FROM DUAL" ; //"SELECT 'N-' ||TO_CHAR(SYSDATE,'DD-MON-YYYY')||  '-' || LPAD(ENROLLMENT_ID.NEXTVAL,4,0) TOKEN_NO FROM DUAL";
  public  static final String NON_EMP_TOKEN_NO = "SELECT 'E-' || TO_CHAR(SYSDATE,'DDMONYYYY')|| '-' || LPAD((SELECT COUNT(*)+1 TOTAL FROM ENROLLMENT_MST WHERE ENROLLMENT_DATE = to_date(?,'dd-mm-yyyy') ),4,0) TOKEN_NO FROM DUAL" ; // "SELECT 'E-' || TO_CHAR(SYSDATE,'DD-MON-YYYY')|| '-' || LPAD(ENROLLMENT_ID.NEXTVAL,4,0) TOKEN_NO FROM DUAL";
  public static final  String ENROLL = " INSERT INTO ENROLLMENT_MST(EMPCODE,GENERATION_DATE,TOKEN_NO,ENROLLMENT_TYPE,ENROLLMENT_DATE,ENROLLMENT_TIME,FIVEDIGIT_CARDCODE)  VALUES (?,to_date(?,'dd-mm-yyyy'),?,?,to_date(?,'dd-mm-yyyy'),?,?)";
  public static final String   ENROLLMENTCOUNTS = " SELECT COUNT(*) TOTAL_COUNT FROM ENROLLMENT_MST WHERE ENROLLMENT_DATE = to_date( ?,'dd-mm-yyyy')  AND ENROLLMENT_TYPE = ? ";
  public static final String   ENROLLMENT_TIMES = "SELECT ENROLLMENT_STARTTIME STATRTTIME,ENROLLMENT_ENDTIME ENDTIME FROM ENROLLMENT_INFO WHERE ENROLLMENT_DATE = to_date( ?,'dd-mm-yyyy') AND ENROLLMENT_TYPE = ?";
  public static final String BILL_TYPES="SELECT * FROM BILLTYPE_MST";
}
