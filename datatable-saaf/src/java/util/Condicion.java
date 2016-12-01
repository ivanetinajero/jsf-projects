package util;

public class Condicion {
   private String field;
   private String operator;
   private Object value;
   private boolean mandatory;

   public Condicion(String field, String operator, Object value, boolean mandatory) {
      this.field = field;
      this.operator = operator;
      this.value = value;
      this.mandatory = mandatory;
   }

   public boolean isMandatory() {
      return mandatory;
   }

   public void setMandatory(boolean mandatory) {
      this.mandatory = mandatory;
   }

   public String getField() {
      return field;
   }

   public void setField(String field) {
      this.field = field;
   }

   public String getOperator() {
      return operator;
   }

   public void setOperator(String operator) {
      this.operator = operator;
   }

   public Object getValue() {
      return value;
   }

   public void setValue(Object value) {
      this.value = value;
   }

   @Override
   public String toString() {
      return "Condicion{" + "field=" + field + ", operator=" + operator + ", value=" + value + ", mandatory=" + mandatory + '}';
   }
   
   
}
