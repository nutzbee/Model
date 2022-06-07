package com.example.model;

public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://192.168.254.112/CRUD/addEmp.php";
    public static final String URL_GET_ALL = "http://uxoricidal-image.000webhostapp.com/getAllEmp.php";
    public static final String URL_GET_AVAIL = "http://uxoricidal-image.000webhostapp.com/getAllAvail.php";
    public static final String URL_GET_OTHERS = "http://uxoricidal-image.000webhostapp.com/getAllOthers.php";
    public static final String URL_GET_USER = "http://uxoricidal-image.000webhostapp.com/view.php?username=";
    public static final String URL_GET_EMP = "http://uxoricidal-image.000webhostapp.com/getn.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.254.112/CRUD/updateEmp.php";
    public static final String URL_DELETE_EMP = "http://192.168.254.112/CRUD/deleteEmp.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_DESG = "desg";
    public static final String KEY_EMP_SAL = "salary";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_DESG = "desg";
    public static final String TAG_SAL = "salary";

    //employee id to pass with intent
    public static final String EMP_ID = "emp_id";
}
