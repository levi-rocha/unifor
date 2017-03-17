
public class VolksBuilder extends CarroBuilder {

	@Override
	public void buildPreco() {
		carro.preco = 30000.0;
	}

	@Override
	public void buildDscMotor() {
		carro.dscMotor = "2.5L I5 20 válvulas";
	}

	@Override
	public void buildAnoDeFabricacao() {
		carro.anoDeFabricacao = 2007;
	}

	@Override
	public void buildModelo() {
		carro.modelo = "New Beetle";
	}

	@Override
	public void buildMontadora() {
		carro.montadora = "Volkswagen";
	}

}
