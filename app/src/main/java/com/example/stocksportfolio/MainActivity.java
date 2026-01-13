package com.example.stocksportfolio;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String BASE = "https://yfinancerestapi.com/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mAuth = FirebaseAuth.getInstance();
    }

    public void login() {
        String email = ((EditText)findViewById(R.id.Email)).getText().toString();
        String password = ((EditText)findViewById(R.id.Password)).getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                            NavHostFragment navFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
                            navFragment.getNavController().navigate(R.id.action_logIn2_to_checkPage);

                        } else {
                            Toast.makeText(MainActivity.this, "Login fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public void register() {
        String email = ((EditText)findViewById(R.id.NewEmail)).getText().toString();
        String password = ((EditText)findViewById(R.id.NewPass)).getText().toString();
        String name = ((EditText)findViewById(R.id.Name)).getText().toString();
        String lastName = ((EditText)findViewById(R.id.LastName)).getText().toString();
        String phone = ((EditText)findViewById(R.id.Phone)).getText().toString();
        if (email.isEmpty() || password.isEmpty() || name.isEmpty() || lastName.isEmpty() || phone.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                            writeToDB(email, password, name, lastName, phone);
                            NavHostFragment navFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
                            navFragment.getNavController().navigate(R.id.action_register2_to_logIn2);
                        } else {
                            Toast.makeText(MainActivity.this, "Registration fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void writeToDB(String email, String password, String name, String lastName, String phone){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(phone);
        User user = new User(email, password, name, lastName, phone);
        myRef.setValue(user);
    }

    public void readFromDB() {
        String phone = ((EditText)findViewById(R.id.EnterPhone)).getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users").child(phone);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User value = dataSnapshot.getValue(User.class);


            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error" + error, Toast.LENGTH_LONG).show();
            }
        });
    }
}
