import java.util.ArrayList;
import java.util.Comparator;
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
		public int compareTo(Caracteristica o) {
			// TODO Auto-generated method stub
			return 0;
		}
		public static Comparator<Caracteristica> saldoDistanceComparator = new Comparator<Caracteristica>() {

			public int compare(Caracteristica irs1, Caracteristica irs2) {
				double x = irs1.getSaldoDistance() - irs2.getSaldoDistance();
				if(x > 0) {
					return 1;
				}
				else if(x == 0) {
					return 0;
				}
				else{
					return -1;
				}
			}
		};
		
}
