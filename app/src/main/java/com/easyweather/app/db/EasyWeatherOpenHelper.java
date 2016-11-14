package com.easyweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhaikd on 2016/11/9/0009.
 */
public class EasyWeatherOpenHelper extends SQLiteOpenHelper {
    /**
     * province 表建表语句 将建表语句定义成常量，在onCreate()方法中执行创建
     */
    public static final String CREATE_PROVINCE = "create table Province "
            +"( id integer primary key autoincrement, "//id是自增长主键
            +"province_name text, " //省名
            +"province_code text )"; //省级代号
    /**
     * city
     */
    public static final String CREATE_CITY ="create table city" +
            "( id integer primary key autoincrement, " +
            "city_name text, " +
            "city_code text, " +
            "province_id integer )"; // province_id是city表关联的Province表的外键
    /**
     * Country
     */
    public static final String CREATE_COUNTY = "create table county" +
            "( id integer primary key autoincrement, " +
            "county_name text, " + //县名
            "county_code text, " +
            "city_id integer )";

    public EasyWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory
                                 factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_PROVINCE); //创建province表
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){

    }

}
