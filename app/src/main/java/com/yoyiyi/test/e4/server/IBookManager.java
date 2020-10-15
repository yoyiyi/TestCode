package com.yoyiyi.test.e4.server;

import android.os.IInterface;
import android.os.RemoteException;

import com.yoyiyi.test.e4.Book;

import java.util.List;

/**
 * 类名：BookManager
 * 描述：TODO
 * 时间：2020/10/15 15:20
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public interface IBookManager extends IInterface {

    void addBook(Book book) throws RemoteException;

    List<Book> getBooks() throws RemoteException;

}
