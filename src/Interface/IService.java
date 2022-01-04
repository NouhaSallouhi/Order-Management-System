/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hp
 */
public interface IService<A> {

    public void Add(A a) throws SQLException;

    public List<A> readALL() throws SQLException;

    public void Update(A a) throws SQLException;

    public void delete(int id) throws SQLException;
//
//    public void deleteCustomers(A a) throws SQLException;
}
