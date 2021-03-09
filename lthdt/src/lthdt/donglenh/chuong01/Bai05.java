/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.donglenh.chuong01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author asus
 */
public class Bai05 {
    public static void main(String[] args) throws ParseException{
        //Chuyen kieu du lieu Date thanh String 
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date currentData = new Date();
        String output = df.format(currentData);
        System.out.println(output);
        
        //Chuyen kieu du lieu tu String thanh Date
        String input = "15-05-1995";
        Date ngay = df.parse(input);
        System.out.println(ngay);
        System.out.println(df.format(ngay));
    }
}
