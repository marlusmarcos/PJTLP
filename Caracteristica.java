import java.util.ArrayList;
public class Caracteristica {
		protected float y;
		protected  String tipo = "";
		protected float saldoDistance;
		ArrayList <Float> informacao = new ArrayList();

		public void setY(float valor) {
			y = valor;
			
		}
		public float getY () {
			return y;
		}
		
		public Float getInformacao(int i) {
			return informacao.get(i);
		}

		public void setInformacao(float f) {
			informacao.add(f);
		}

		public String getTipo() {
			return tipo;
		}
		public void setTipo (String s) {
			this.tipo = s;
		}

		public float getSaldoDistance() {
			return saldoDistance;
		}

		public void setSaldoDistance(float distance) {
			this.saldoDistance += distance;
		}
		/*
		 * Faz o calculo da distancia euclidiana
		 * o for faz o somatoiria de xi, yi
		 * aux guarda o  valor de  xi-zi ^2
		 */
		
}
