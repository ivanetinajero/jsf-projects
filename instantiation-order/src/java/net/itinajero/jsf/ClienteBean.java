package net.itinajero.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import net.itinajero.dto.Cliente;
import net.itinajero.dto.Pais;
import net.itinajero.dto.Usuario;

@ManagedBean(name="bean")
public class ClienteBean {
   
   @ManagedProperty("#{user}") // inyectada de la session
   private Usuario user;   
   
   private Cliente cliente;   
   private Pais pais;
      
   public ClienteBean() {
      System.out.println("1. Constructor ManagedBean");
   }

   @PostConstruct
   public void init() {
      pais = new Pais(0); // creamos el objeto para poder usarlo
      cliente = new Cliente(0); // creamos el objeto para poder usarlo
      System.out.println("3. En PostConstruct ya se hicieron las inyecciones: " + user);
   }

   public void setUser(Usuario user) {
      System.out.println("2. Inyeccion de dependencias <ManagedProperty>");
      this.user = user;
   }
   
   public String save(){
      System.out.println("Datos Guardados: ");
      cliente.setPais(pais);
      System.out.println("Datos del cliente: " + cliente);
      return null;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public Pais getPais() {
      return pais;
   }

   public void setPais(Pais pais) {
      this.pais = pais;
   }
         
}
