package com.example.whizzz.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.whizzz.services.repository.FirebaseInstanceDatabase;
import com.google.firebase.database.DataSnapshot;

public class DatabaseViewModel extends ViewModel {
    private FirebaseInstanceDatabase instance;
    public LiveData<Boolean> successAddUserDb;
    public LiveData<DataSnapshot> fetchUserCurrentData;
    public LiveData<DataSnapshot> fetchUserNames;
    public LiveData<DataSnapshot> fetchSelectedProfileUserData;
    public LiveData<Boolean> successAddChatDb;

    public DatabaseViewModel() {
        instance = new FirebaseInstanceDatabase();
    }

    public void addUserDatabase(String userId, String userName, String emailId, String timestamp, String imageUrl) {
        successAddUserDb = instance.addUserInDatabase(userId, userName, emailId, timestamp, imageUrl);
    }

    public void fetchingUserDataCurrent() {
        fetchUserCurrentData = instance.fetchUserDataCurrent();
    }

    public void fetchUserNameAll(){
        fetchUserNames = instance.fetchAllUserNames();
    }

    public void fetchSelectedUserProfileData(String userId){
        fetchSelectedProfileUserData = instance.fetchSelectedUserIdData(userId);
    }

    public void addChatDb(String receiverId, String senderId, String message, String timestamp){
        successAddChatDb= instance.addChatsInDatabase(receiverId, senderId, message, timestamp);
    }

}