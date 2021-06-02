package com.example.crud_app.view;

import android.os.AsyncTask;
import android.util.Log;

import com.example.crud_app.entity.AppDatabase;
import com.example.crud_app.entity.DataMovie;

import java.util.List;

public class MainPresenter implements MainContact.presenter {
    private MainContact.view view;

    public MainPresenter(MainContact.view view){
        this.view = view;
    }

    class InsertData extends AsyncTask<Void,Void,Long> {
        private AppDatabase appDatabase;
        private DataMovie dataMovie;
        public InsertData(AppDatabase appDatabase, DataMovie dataMovie) {
            this.appDatabase = appDatabase;
            this.dataMovie = dataMovie;
        }

        protected Long doInBackground(Void... voids){
            return appDatabase.dao().insertData(dataMovie);
        }

        protected void onPostExecute(Long along){
            super.onPostExecute(along);
            view.successAdd();
        }
    }
    @Override
    public void insertData(String title, String genre, String year, String cast, AppDatabase database) {
        final DataMovie dataMovie =  new DataMovie();
        dataMovie.setTitle(title);
        dataMovie.setGenre(genre);
        dataMovie.setYear(year);
        dataMovie.setCast(cast);
        new InsertData(database,dataMovie).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List<DataMovie> list;
        list = database.dao().getData();
        view.getData(list);
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase appDatabase;
        private DataMovie dataMovie;

        public EditData(AppDatabase appDatabase, DataMovie dataMovie){
            this.appDatabase = appDatabase;
            this.dataMovie = dataMovie;
        }

        protected Integer doInBackground(Void... voids){
            return  appDatabase.dao().updateData(dataMovie);
        }

        protected void  onPostExecute(Integer integer) {
           super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute : "+integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String title, String genre, String year, String cast, int id, AppDatabase database) {
        final DataMovie dataMovie = new DataMovie();
        dataMovie.setTitle(title);
        dataMovie.setGenre(genre);
        dataMovie.setYear(year);
        dataMovie.setCast(cast);
        dataMovie.setId(id);
        new EditData(database,dataMovie).execute();
    }

    class  DeleteData extends  AsyncTask<Void,Void,Long>{
        private AppDatabase appDatabase;
        private DataMovie dataMovie;

        public DeleteData(AppDatabase appDatabase, DataMovie dataMovie){
            this.appDatabase = appDatabase;
            this.dataMovie = dataMovie;
        }

        protected Long doInBackground(Void... voids){
            appDatabase.dao().deleteData(dataMovie);
            return null;
        }

        protected void  onPostExecute(Long along) {
            super.onPostExecute(along);
            view.successDelete();
        }
    }

    @Override
    public void deleteData(DataMovie dataMovie, AppDatabase appDatabase) {
        new DeleteData(appDatabase, dataMovie).execute();
    }
}
