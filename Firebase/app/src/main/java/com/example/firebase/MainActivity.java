package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1000;
    Button btnsave;
    EditText etname;
    ListView listv;
    ArrayList<String> notes;
    FirebaseUser firebaseUser;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave =findViewById(R.id.btnDb);
        etname = findViewById(R.id.etname);
        listv = findViewById(R.id.lv);
        notes = new ArrayList<>();

       arrayAdapter = new ArrayAdapter<String>(this,
               R.layout.item_row,
               R.id.tvlist,
               notes);
       listv.setAdapter(arrayAdapter);
//       firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

       if(firebaseUser != null){
           addListener();
       }else{
           startActivityForResult(
                   AuthUI.getInstance()
                           .createSignInIntentBuilder()
                           .setIsSmartLockEnabled(false)
                           .setAvailableProviders(Arrays.asList(
                                   new AuthUI.IdpConfig.GoogleBuilder().build(),
                                   new AuthUI.IdpConfig.EmailBuilder().build(),
                                   new AuthUI.IdpConfig.PhoneBuilder().build()))
                           .build(),
                   RC_SIGN_IN);
       }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                addListener();
            } else {

                if (response == null) {
                    return;
                }
                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    return;
                }
            }
        }
    }

    public void addListener(){
        final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = etname.getText().toString();
                dbref.child("note").child(firebaseUser.getUid()).push().setValue(note);
            }
        });

        dbref.child("note").child(firebaseUser.getUid()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String s) {
                String  data = snapshot.getValue(String.class);
                notes.add(data);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
