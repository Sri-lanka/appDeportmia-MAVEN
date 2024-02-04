/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import com.mycompany.appdeporttests.Conection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author USUARIO
 */

public class ConectionTest {
    
    @DisplayName("Test conection")
    @Test
    public void testConnection() {
        Conection connection = new Conection();

        // Call the connect method to establish the connection to the database.
        connection.connect();

        // Ensure that the Connection object is not null, indicating a successful connection.
        assertNotNull("The connection must not be null.", connection.con);
        
        
    }

}
