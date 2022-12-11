package com.raminabbasiiii.movies.data.network

class ResponseCode {


    companion object{
        // Api Status code
        val   SUCESS : Int = 200;
        val NO_CONTENT : Int = 200;
        val   BAD_REQUEST : Int  = 400;
        val  FORBIDDEN  : Int = 403;
        val  UNAUTHORISED : Int = 401;
        val  NOT_FOUND : Int = 404;
        val  INTERNET_SERVER_ERROR : Int  = 500;

        // local status code
        val   CONNECT_TIMEOUT : Int= -1;
        val   UNKNOWN : Int = -2;
        val   CANCEL : Int= -3;
        val  RECEIVE_TIMEOUT : Int = -4;
        val  SEND_TIMEOUT : Int= -5;
        val  CACHERROR : Int = -6;
        val  NI_INTERNET_CONNECTION : Int = -7;
    }
}

class ResponseMessage {

    companion object {
         val  SUCESS : String= "Sucess";
         val  NO_CONTENT : String= "No Content";
        val  BAD_REQUEST : String = "Bad Request , try again later ";
        val  FORBIDDEN : String = "for Bidden , try again later";
        val  UNAUTHORISED : String= "user is unAuthorised , try again later";
        val  NOT_FOUND : String= "url is not found , try again later";
        val  INTERNET_SERVER_ERROR : String= "some thing wrong , try again later";

        // local status code
        val   CONNECT_TIMEOUT : String= "time out  , try again later";
        val   UNKNOWN : String= "some thing wrong , try again later";
        val   CANCEL : String= "request was canceled , try again later";
        val  RECEIVE_TIMEOUT : String= "time out error , try again later";
        val  SEND_TIMEOUT : String= "time out error , try again later";
        val  CACHERROR : String= "time out error , try again later";
        val  NI_INTERNET_CONNECTION :String = "please check your internet connect";
    }

}

class ApiInternalStatus {
    companion object{
        val  Sucess : Int = 200;
        val  FAILURE : Int = 1;
    }

}