package com.yoyiyi.test.e4.proxy;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import com.yoyiyi.test.e4.Book;
import com.yoyiyi.test.e4.server.IBookManager;
import com.yoyiyi.test.e4.server.Stub;

import java.util.List;

/**
 * 类名：Proxy
 * 描述：TODO
 * 时间：2020/10/15 15:24
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public class Proxy implements IBookManager {
    private static final String DESCRIPTOR = "com.yoyiyi.test.e4.server.IBookManager";
    private IBinder remote;

    public Proxy(IBinder remote) {
        this.remote = remote;
    }

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public List<Book> getBooks() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel replay = Parcel.obtain();
        List<Book> result;

        try {
            data.writeInterfaceToken(DESCRIPTOR);
            remote.transact(Stub.TRANSAVTION_getBooks, data, replay, 0);
            replay.readException();
            result = replay.createTypedArrayList(Book.CREATOR);
        } finally {
            replay.recycle();
            data.recycle();
        }
        return result;
    }

    @Override
    public void addBook(Book book) throws RemoteException {

        Parcel data = Parcel.obtain();
        Parcel replay = Parcel.obtain();

        try {
            data.writeInterfaceToken(DESCRIPTOR);
            if (book != null) {
                data.writeInt(1);
                book.writeToParcel(data, 0);
            } else {
                data.writeInt(0);
            }
            remote.transact(Stub.TRANSAVTION_addBook, data, replay, 0);
            replay.readException();
        } finally {
            replay.recycle();
            data.recycle();
        }
    }
    @Override
    public IBinder asBinder() {
        return null;
    }
}
