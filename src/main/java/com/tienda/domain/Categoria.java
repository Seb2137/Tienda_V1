/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable; 
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    
  private static final long serialVersionUID = 1L;  //autoincremento en java
   
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name="id_categoria")
  
  private Long idCategoria;
  private String descripcion; 
  private String rutaImagen;
  private boolean activo;

@OneToMany
@JoinColumn(name = "id_categoria", updatable=false)
List<Producto> productos;

public Categoria() {   

}     

public Categoria(String categoria, boolean activo) {         
this.descripcion = categoria;         
this.activo = activo;     
}


}
