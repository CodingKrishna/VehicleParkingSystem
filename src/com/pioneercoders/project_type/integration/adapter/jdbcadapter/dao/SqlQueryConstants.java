package com.bhaskar.project_type.integration.adapter.jdbcadapter.dao;

public class SqlQueryConstants {	
	


  
  public static final String EMPLOYEENAME = "SELECT EMPNAME FROM ARS_MST_EMPLOYEE WHERE EMPCODE = ?";
  public static final String ENROLL_TYPE_FLAG =  "SELECT COUNT(*) EMP_FLAG FROM ENROLLMENT_TYPE WHERE ? BETWEEN START_RANGE AND END_RANGE";
  
  
  public  static final String EMP_TOKEN_NO = "SELECT 'E-' || TO_CHAR(SYSDATE,'DDMONYYYY')|| '-' || LPAD((SELECT COUNT(*)+1 TOTAL FROM ENROLLMENT_MST WHERE ENROLLMENT_DATE = to_date(?,'dd-mm-yyyy') ),4,0) TOKEN_NO FROM DUAL" ; //"SELECT 'N-' ||TO_CHAR(SYSDATE,'DD-MON-YYYY')||  '-' || LPAD(ENROLLMENT_ID.NEXTVAL,4,0) TOKEN_NO FROM DUAL";
  public  static final String NON_EMP_TOKEN_NO = "SELECT 'N-' || TO_CHAR(SYSDATE,'DDMONYYYY')|| '-' || LPAD((SELECT COUNT(*)+1 TOTAL FROM ENROLLMENT_MST WHERE ENROLLMENT_DATE = to_date(?,'dd-mm-yyyy') ),4,0) TOKEN_NO FROM DUAL" ; // "SELECT 'E-' || TO_CHAR(SYSDATE,'DD-MON-YYYY')|| '-' || LPAD(ENROLLMENT_ID.NEXTVAL,4,0) TOKEN_NO FROM DUAL";
  public static final  String ENROLL = " INSERT INTO ENROLLMENT_MST(EMPCODE,GENERATION_DATE,TOKEN_NO,ENROLLMENT_TYPE,ENROLLMENT_DATE,ENROLLMENT_TIME,FIVEDIGIT_CARDCODE)  VALUES (?,to_date(?,'dd-mm-yyyy'),?,?,to_date(?,'dd-mm-yyyy'),?,?)";
  public static final  String PHOTOGRAPHY_REGISTER = " INSERT INTO PHTOGRAPHY_INFO(PHOTGRAPY_TOKEN_NO ,EMPCODE ,DOB ,BLOOD_GROUP,DEPT ,DESIGNATION ,PHOTOGRAPY_DATE , PHOTOGRAPHY_TIME ,LOCATION ) VALUES(?,?,to_date(?,'dd-mm-yyyy'),?,?,?,to_date(?,'dd-mm-yyyy'),?,?)";
  //public static final String PHOTOGRAPHY_FLAG =  "SELECT COUNT(*) EMP_FLAG FROM ENROLLMENT_TYPE WHERE ? BETWEEN START_RANGE AND END_RANGE";
  public static final String   ENROLLMENTCOUNTS = " SELECT COUNT(*) TOTAL_COUNT FROM ENROLLMENT_MST WHERE ENROLLMENT_DATE =   ?  AND ENROLLMENT_TYPE = ? "; // to_date( ?,'dd-mm-yyyy') 
  public static final String   ENROLLMENT_TIMES = "SELECT ENROLLMENT_STARTTIME STATRTTIME,ENROLLMENT_ENDTIME ENDTIME FROM ENROLLMENT_INFO WHERE ENROLLMENT_DATE = to_date( ?,'dd-mm-yyyy') AND ENROLLMENT_TYPE = ?";
  public static final String   SEARCH_TOKEN   = "select * from enrollment_mst where token_no = ?";
  public static final String   SEARCH_TOKEN_BY_DATE   = "select * from enrollment_mst where ENROLLMENT_DATE = to_date(?,'dd-mm-yyyy')";
 // public static final String   EMPLOYEE_NAME   = "select EMPNAME from ars_mst_employee where empcode = ?";
 public static final String   ENROLL_CARD  = "INSERT INTO  ENROLLMENT_PROCESS_TRACK(TOKEN_NO ,EMPCODE ,INTERNAL_CARD_NO ,ENROLLDATE ) VALUES(?,?,?,SYSDATE)";
  public static final String PHOTOGRAPHY_LIST = "select * from PHTOGRAPHY_INFO";
  
  //BillDAO queries
  public static final String BILL_TYPES="SELECT * FROM BILLTYPE_MST";
  public static final String ADD_BILL="INSERT INTO bill_info_tr(BILLNO, BILL_AMOUNT, FROM_DATE, TO_DATE, PENDING_AMOUNT, DUE_DATE, BILLTYPE_ID) VALUES(?,?,STR_TO_DATE(?,'%d-%m-%Y'),STR_TO_DATE(?,'%d-%m-%Y'),?,STR_TO_DATE(?,'%d-%m-%Y'),?)";
  public static final String BILLS_LIST="SELECT A.BILL_ID, A.BILLNO, A.BILL_AMOUNT, DATE_FORMAT(FROM_DATE,'%d-%m-%Y')FROM_DATE, A.TO_DATE, A.PENDING_AMOUNT, A.DUE_DATE, B.DESCRIPTION FROM BILL_INFO_TR A RIGHT JOIN BILLTYPE_MST B ON B.BILLTYPE_ID=A.BILLTYPE_ID ORDER BY BILL_ID ASC";
}
