package application;

import JeanKoval.com.github.classes.Feminino;
import JeanKoval.com.github.classes.Masculino;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MainController {
	
	public RadioButton radioMasc;
	public RadioButton radioFemi;
	public TextField idade;
	public TextField altura;
	public TextField peso;
	public Float resul;
	public String msg = "";
	
	public void clickMasc() {
		radioFemi.setSelected(!radioMasc.isSelected());		
	}
	
	public void clickFemi() {
		radioMasc.setSelected(!radioFemi.isSelected());
	}
	
	public void calcular() {
		try {
			if(radioMasc.isSelected()) {
				Masculino homem = new Masculino();
				homem.setIdade(Integer.parseInt(idade.getText()));
				homem.setAltura(Float.parseFloat(altura.getText()));
				homem.setPeso(Float.parseFloat(peso.getText()));
				this.resul = homem.calculoIMC();
				this.msg += "Homem de ";
			}else {
				Feminino mulher = new Feminino();
				mulher.setIdade(Integer.parseInt(idade.getText()));
				mulher.setAltura(Float.parseFloat(altura.getText()));
				mulher.setPeso(Float.parseFloat(peso.getText()));
				this.resul = mulher.calculoIMC();
				this.msg += "Mulher de ";
			}
			
			this.msg += idade.getText() + " anos, " + altura.getText() + " de altura";
			this.msg += " e " + peso.getText() + "KG.";
			this.msg += "\nIMC de " + this.resul + ".";
			this.msg += "\nEste IMC é considerado " + classificacao();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Calculo de IMC");
			alert.setHeaderText("Informações do IMC:");
			alert.setContentText(this.msg);
			alert.show();
			
			//limpa os campos da tela para o proximo calculo
			limpaCampos();
			
		}catch(Exception e) {
			//e.toString();
			Alert alertErro = new Alert(AlertType.ERROR);
			alertErro.setContentText(e.toString());
			alertErro.show();
		}
	}
	
	//funcao que retorna qual a classificacao do imc calculado
	public String classificacao() {
		if(this.resul<18.5)
			return "Magreza.";
		else if(this.resul<24.9) 
			return "Normal.";
		else if(this.resul<30) 
			return "Sobrepeso.";
		else 
			return "Obesidade.";
	}
	
	//limpa os campos da tela para o proximo calculo
	public void limpaCampos() {
		radioFemi.setSelected(true);
		idade.setText("");
		altura.setText("");
		peso.setText("");
	}
	
}
