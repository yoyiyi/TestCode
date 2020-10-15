package com.yoyiyi.test.e4.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yoyiyi.test.R;
import com.yoyiyi.test.e4.Book;
import com.yoyiyi.test.e4.server.IBookManager;
import com.yoyiyi.test.e4.server.RemoteService;
import com.yoyiyi.test.e4.server.Stub;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ClientActivity extends AppCompatActivity {

    private IBookManager bookManager;
    private boolean isConnection = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Button btn = findViewById(R.id.bt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isConnection) {
                    attemptToBindService();
                    return;
                }
                if (bookManager == null) {
                    return;
                }
                try {
                    Book book = new Book();
                    book.setPrice(101);
                    book.setName("编码");
                    bookManager.addBook(book);
                    Log.d("ClientActivity", bookManager.getBooks().toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void attemptToBindService() {

        Intent intent = new Intent(this, RemoteService.class);
        intent.setAction("com.baronzhang.ipc.server");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isConnection = true;
            bookManager = Stub.asInterface(service);
            if (bookManager != null) {
                try {
                    List<Book> books = bookManager.getBooks();
                    Log.d("ClientActivity", books.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isConnection = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        if (!isConnection) {
            attemptToBindService();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isConnection) {
            unbindService(serviceConnection);
        }
    }
}