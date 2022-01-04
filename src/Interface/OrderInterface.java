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
 * @author Elife-Beja-138
 */
public interface OrderInterface <A>{
    public List<A> readALL() throws SQLException;
    public List<A> readALLdetail() throws SQLException;
}
