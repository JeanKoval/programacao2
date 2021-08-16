package JeanKoval.com.github.classes;

public class Feminino extends Pessoa implements CalculoIMC {
	@Override
	public Integer getIdade() {
		return super.getIdade();
	}
	
	@Override
	public void setIdade(Integer idade) {
		super.setIdade(idade);
	}
	
	@Override
	public Float getAltura() {
		return super.getAltura();
	}
	
	@Override
	public void setAltura(Float altura) {
		super.setAltura(altura);
	}
	
	@Override
	public Float getPeso() {
		return super.getPeso();
	}
	
	@Override
	public void setPeso(Float peso) {
		super.setPeso(peso);
	}
	
	@Override
	public Float calculoIMC() {		
		return super.getPeso() / (super.getAltura() * super.getAltura());
	}
}
