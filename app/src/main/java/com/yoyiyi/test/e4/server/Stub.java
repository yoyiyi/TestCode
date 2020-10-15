package com.yoyiyi.test.e4.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.yoyiyi.test.e4.Book;
import com.yoyiyi.test.e4.proxy.Proxy;

import java.util.List;

/**
 * 类名：Stub
 * 描述：TODO
 * 时间：2020/10/15 15:22
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public abstract class Stub extends Binder implements IBookManager {
    //binder描述符
    private static final String DESCRIPTOR = "com.yoyiyi.test.e4.server.IBookManager";

    public static final int TRANSAVTION_getBooks = IBinder.FIRST_CALL_TRANSACTION;
    public static final int TRANSAVTION_addBook = IBinder.FIRST_CALL_TRANSACTION + 1;

    public Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }


    @Override
    public IBinder asBinder() {
        return this;
    }

    public static IBookManager asInterface(IBinder binder) {
        if (binder == null) {
            return null;
        }
        IInterface iin = binder.queryLocalInterface(DESCRIPTOR);
        if (iin != null && iin instanceof IBookManager) {
            return (IBookManager) iin; //同一个进程
        }
        return new Proxy(binder); //不是同一个进程
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case INTERFACE_TRANSACTION:
                reply.writeString(DESCRIPTOR);
                return true;

            case TRANSAVTION_getBooks:
                data.enforceInterface(DESCRIPTOR);
                List<Book> result = this.getBooks();
                reply.writeNoException();
                reply.writeTypedList(result);
                return true;

            case TRANSAVTION_addBook:
                data.enforceInterface(DESCRIPTOR);
                Book book = null;
                if (data.readInt() != 0) {
                    book = Book.CREATOR.createFromParcel(data);
                }
                this.addBook(book);
                reply.writeNoException();
                return true;
        }
        return super.onTransact(code, data, reply, flags);
    }
}
