package com.reservas.api.model.Tables;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table(name = "tables")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tables {


    public Tables(Integer numTable, Integer capacity) {
        this.numTable = numTable;
        this.capacity = capacity;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "num_table")
    private Integer numTable;

    private Integer capacity;
}