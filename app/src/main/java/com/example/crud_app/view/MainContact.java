package com.example.crud_app.view;

import android.view.View;

import com.example.crud_app.entity.AppDatabase;
import com.example.crud_app.entity.DataMovie;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataMovie> list);
        void editData(DataMovie item);
        void deleteData(DataMovie item);
    }

    interface presenter{
        void insertData(String title, String genre, String year, String cast, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String title, String genre, String year, String cast, int id, AppDatabase database);
        void deleteData(DataMovie dataMovie, AppDatabase appDatabase);
    }
}
