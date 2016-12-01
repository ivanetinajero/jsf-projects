package net.itinajero;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;

@ManagedBean(name = "backing_hello")
public class BackingBean {

   private HtmlInputText inputText1;
   private HtmlOutputText outputText1;

   public HtmlInputText getInputText1() {
      return inputText1;
   }

   public void setInputText1(HtmlInputText inputText1) {
      this.inputText1 = inputText1;
   }

   public HtmlOutputText getOutputText1() {
      return outputText1;
   }

   public void setOutputText1(HtmlOutputText outputText1) {
      this.outputText1 = outputText1;
   }

   public String commandButton_action() {
      inputText1.setReadonly(true);
      inputText1.setTitle("Titulo");
      outputText1.setValue(inputText1.getValue());
      return "success";
   }
}
