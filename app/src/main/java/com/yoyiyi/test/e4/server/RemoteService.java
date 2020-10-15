package com.yoyiyi.test.e4.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.yoyiyi.test.e4.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：RemoteService
 * 描述：TODO
 * 时间：2020/10/15 15:50
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public class RemoteService extends Service {

    private List<Book> books = new ArrayList<>();

    @Override
    public IBinder onBind(Intent intent) {
        return bookManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book();
        book.setName("三体");
        book.setPrice(88);
        books.add(book);
    }

    private final Stub bookManager = new Stub() {
        @Override
        public List<Book> getBooks() throws RemoteException {
            synchronized (this) {
                if (books != null) {
                    return books;
                }
                return new ArrayList<>();
            }
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this) {
                if (books == null) {
                    books = new ArrayList<>();
                }
                if (book == null) {
                    return;
                }
                book.setPrice(book.getPrice() * 2);
                books.add(book);
                Log.e("Server", "books: " + book.toString());
            }
        }
    };
}
