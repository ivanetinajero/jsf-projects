package net.itinajero.dto;

public class Usuario {
   private int id;
   private String username;
   private String perfil;

   public Usuario(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPerfil() {
      return perfil;
   }

   public void setPerfil(String perfil) {
      this.perfil = perfil;
   }

   @Override
   public String toString() {
      return "Usuario{" + "id=" + id + ", username=" + username + ", perfil=" + perfil + '}';
   }
   
   
}
