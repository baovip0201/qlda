package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Phuc
 */
public class SessionUser {
    private static String ten;
    private static String tuoi;

    public SessionUser() {
    }
    public static void closeSession(){
        ten=null;
        tuoi=null;
    }

    public static String getTen() {
        return ten;
    }

    public static void setTen(String ten) {
        SessionUser.ten = ten;
    }

    public static String getTuoi() {
        return tuoi;
    }

    public static void setTuoi(String tuoi) {
        SessionUser.tuoi = tuoi;
    }
    
}
