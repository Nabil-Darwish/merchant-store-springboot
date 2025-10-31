package application.merchantStore.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data                   // Generates getters, setters, equals, hashCode, and toString
@NoArgsConstructor       // Generates a no-args constructor
@AllArgsConstructor      // Generates a constructor with all fields
public class MerchantStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  Store ID
    private int id;
    // Store Name
    private String name;
    // Store acronym
    private String acronym;
    // Store Latitude
    private float latitude;
    // Store Longitude
    private float longitude;
    //Note: maybe implement store products later
}