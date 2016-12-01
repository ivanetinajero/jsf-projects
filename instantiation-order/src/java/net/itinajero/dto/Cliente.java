package net.itinajero.dto;

public class Cliente {
   private int id;
   private String nombre;
   private int age;
   private String email;
   private Pais pais;

   public Cliente(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Pais getPais() {
      return pais;
   }

   public void setPais(Pais pais) {
      this.pais = pais;
   }

   @Override
   public String toString() {
      return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", age=" + age + ", email=" + email + ", pais=" + pais + '}';
   }
   
   
}
